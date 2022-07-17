package com.example.krishi_sadan.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.krishi_sadan.R;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {


    TextView address, wstatus, temp, temp_min, temp_max, sunrise, sunset, wind, pressure, humid;
    ImageView info;

//    LocationManager mlocationManager;
//    LocationListener mlocationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        address = findViewById(R.id.address);
        wstatus = findViewById(R.id.wstatus);
        temp = findViewById(R.id.temp);
        temp_min = findViewById(R.id.temp_min);
        temp_max = findViewById(R.id.temp_max);
        sunrise = findViewById(R.id.sunrise);
        sunset = findViewById(R.id.sunset);
        wind = findViewById(R.id.wind);
        pressure = findViewById(R.id.pressure);
        humid = findViewById(R.id.humid);
        info =findViewById(R.id.info1);



        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findWeather();
            }
        });
    }


    public void findWeather() {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=London&callback=test&appid=3290c4822433eab9ebce43151b04b993&units=metric";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,(Response.Listener<String>) response -> {

            try {
                //find temperature
                JSONObject jsonObject = new JSONObject(response);
                JSONObject object = jsonObject.getJSONObject("main");
                double temp1 = object.getDouble("temp");
                temp.setText((int)temp1);

                //find country
                JSONObject object8 = jsonObject.getJSONObject("sys");
                String count = object8.getString("country");
                address.setText(count); //find country

                //find humidity
                JSONObject object4 = jsonObject.getJSONObject("main");
                int humidity_find = object4.getInt("humidity");
                humid.setText((int)humidity_find);

                //find sunrise
                JSONObject object5 = jsonObject.getJSONObject("sys");
                String sunrise_find = object5.getString("sunrise");
                sunrise.setText(sunrise_find);

                //find sunrise
                JSONObject object6 = jsonObject.getJSONObject("sys");
                String sunset_find = object6.getString("sunset");
                sunset.setText(sunset_find);

                //find pressure
                JSONObject object7 = jsonObject.getJSONObject("main");
                String pressure_find = object7.getString("pressure");
                pressure.setText(pressure_find);

                //find wind speed
                JSONObject object9 = jsonObject.getJSONObject("wind");
                String wind_find = object9.getString("speed");
                wind.setText(wind_find);

                //find min temperature
                JSONObject object10 = jsonObject.getJSONObject("main");
                double mintemp = object10.getDouble("temp_min");
                temp_min.setText((int) mintemp);

                //find max temperature
                JSONObject object12 = jsonObject.getJSONObject("main");
                double maxtemp = object12.getDouble("temp_max");
                temp_max.setText((int) maxtemp);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, (Response.ErrorListener) error -> Toast.makeText(WeatherActivity.this, "eroorrr encountere", Toast.LENGTH_SHORT).show());

        RequestQueue requestQueue = Volley.newRequestQueue(WeatherActivity.this);
        requestQueue.add(stringRequest);

    }
}