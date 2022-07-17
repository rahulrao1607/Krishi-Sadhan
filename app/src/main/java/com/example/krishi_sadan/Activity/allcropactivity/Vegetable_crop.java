package com.example.krishi_sadan.Activity.allcropactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishi_sadan.KharifAdapter;
import com.example.krishi_sadan.Model.kharifRecycle;
import com.example.krishi_sadan.R;

import java.util.ArrayList;
import java.util.List;

public class Vegetable_crop extends AppCompatActivity {

    RecyclerView vegetable_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable_crop);




        vegetable_recycle = findViewById(R.id.vegetable_recycle);
        vegetable_recycle.setHasFixedSize(true);
        vegetable_recycle.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));

        List<kharifRecycle> vegisRecycles = new ArrayList<>();

        vegisRecycles.add(new kharifRecycle(R.drawable.vegii , "Wheat \n How to do framing of wheat"));
        vegisRecycles.add(new kharifRecycle(R.drawable.vegii , "Vegetable \n How to do framing of wheat"));
        vegisRecycles.add(new kharifRecycle(R.drawable.flower , "Flower \n How to do framing of wheat"));
        vegisRecycles.add(new kharifRecycle(R.drawable.fruit , "Fruit \n How to do framing of wheat"));
        vegisRecycles.add(new kharifRecycle(R.drawable.rabi , "Rabi \n How to do framing of wheat"));


        KharifAdapter kharifAdapter = new KharifAdapter(vegisRecycles);
        vegetable_recycle.setAdapter(kharifAdapter);

    }
}