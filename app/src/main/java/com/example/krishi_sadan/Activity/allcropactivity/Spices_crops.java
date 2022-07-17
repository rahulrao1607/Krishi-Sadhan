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

public class Spices_crops extends AppCompatActivity {

    RecyclerView spices_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spices_crops);


        spices_recycle = findViewById(R.id.spices_recycle);
        spices_recycle.setHasFixedSize(true);
        spices_recycle.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));

        List<kharifRecycle> spicesRecycles = new ArrayList<>();

        spicesRecycles.add(new kharifRecycle(R.drawable.spices , "Wheat \n How to do framing of wheat"));
        spicesRecycles.add(new kharifRecycle(R.drawable.vegii , "Vegetable \n How to do framing of wheat"));
        spicesRecycles.add(new kharifRecycle(R.drawable.flower , "Flower \n How to do framing of wheat"));
        spicesRecycles.add(new kharifRecycle(R.drawable.fruit , "Fruit \n How to do framing of wheat"));
        spicesRecycles.add(new kharifRecycle(R.drawable.rabi , "Rabi \n How to do framing of wheat"));


        KharifAdapter kharifAdapter = new KharifAdapter(spicesRecycles);
        spices_recycle.setAdapter(kharifAdapter);
    }
}