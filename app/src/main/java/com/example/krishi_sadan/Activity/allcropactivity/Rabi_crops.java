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

public class Rabi_crops extends AppCompatActivity {

    RecyclerView rabi_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabi_crops);

        rabi_recycle = findViewById(R.id.rabi_recycle);
        rabi_recycle.setHasFixedSize(true);
        rabi_recycle.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));

        List<kharifRecycle> rabiRecycles = new ArrayList<>();

        rabiRecycles.add(new kharifRecycle(R.drawable.rabi , "Wheat \n How to do framing of wheat"));
        rabiRecycles.add(new kharifRecycle(R.drawable.vegii , "Vegetable \n How to do framing of wheat"));
        rabiRecycles.add(new kharifRecycle(R.drawable.flower , "Flower \n How to do framing of wheat"));
        rabiRecycles.add(new kharifRecycle(R.drawable.fruit , "Fruit \n How to do framing of wheat"));
        rabiRecycles.add(new kharifRecycle(R.drawable.rabi , "Rabi \n How to do framing of wheat"));


        KharifAdapter kharifAdapter = new KharifAdapter(rabiRecycles);
        rabi_recycle.setAdapter(kharifAdapter);
    }
}