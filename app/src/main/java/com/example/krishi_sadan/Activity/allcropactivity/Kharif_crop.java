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

public class Kharif_crop extends AppCompatActivity {

    RecyclerView kharif_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kharif_crop);
      //  allocateActivityTitle("kharif crop");


        kharif_recycle = findViewById(R.id.kharif_recycle);
        kharif_recycle.setHasFixedSize(true);
        kharif_recycle.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));

        List<kharifRecycle> kharifRecycles = new ArrayList<>();

        kharifRecycles.add(new kharifRecycle(R.drawable.kharif , "Wheat \n How to do framing of wheat"));
        kharifRecycles.add(new kharifRecycle(R.drawable.vegii , "Vegetable \n How to do framing of wheat"));
        kharifRecycles.add(new kharifRecycle(R.drawable.flower , "Flower \n How to do framing of wheat"));
        kharifRecycles.add(new kharifRecycle(R.drawable.fruit , "Fruit \n How to do framing of wheat"));
        kharifRecycles.add(new kharifRecycle(R.drawable.rabi , "Rabi \n How to do framing of wheat"));


       KharifAdapter kharifAdapter = new KharifAdapter(kharifRecycles);
        kharif_recycle.setAdapter(kharifAdapter);


    }
}