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

public class Decrotive_Crops extends AppCompatActivity {
    RecyclerView decorative_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrotive__crops);


        decorative_recycle = findViewById(R.id.decorative_recycle);
        decorative_recycle.setHasFixedSize(true);
        decorative_recycle.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));

        List<kharifRecycle> flowerRecycles = new ArrayList<>();

        flowerRecycles.add(new kharifRecycle(R.drawable.flower , "Wheat \n How to do framing of wheat"));
        flowerRecycles.add(new kharifRecycle(R.drawable.vegii , "Vegetable \n How to do framing of wheat"));
        flowerRecycles.add(new kharifRecycle(R.drawable.flower , "Flower \n How to do framing of wheat"));
        flowerRecycles.add(new kharifRecycle(R.drawable.fruit , "Fruit \n How to do framing of wheat"));
        flowerRecycles.add(new kharifRecycle(R.drawable.rabi , "Rabi \n How to do framing of wheat"));


        KharifAdapter kharifAdapter = new KharifAdapter(flowerRecycles);
        decorative_recycle.setAdapter(kharifAdapter);
    }
}