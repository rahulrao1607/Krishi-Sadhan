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

public class Fruit_crop extends AppCompatActivity {
    RecyclerView fruit_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_crop);

        fruit_recycle = findViewById(R.id.fruit_recycle);
        fruit_recycle.setHasFixedSize(true);
        fruit_recycle.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));

        List<kharifRecycle> fruitRecycles = new ArrayList<>();

        fruitRecycles.add(new kharifRecycle(R.drawable.fruit , "Wheat \n How to do framing of wheat"));
        fruitRecycles.add(new kharifRecycle(R.drawable.vegii , "Vegetable \n How to do framing of wheat"));
        fruitRecycles.add(new kharifRecycle(R.drawable.flower , "Flower \n How to do framing of wheat"));
        fruitRecycles.add(new kharifRecycle(R.drawable.fruit , "Fruit \n How to do framing of wheat"));
        fruitRecycles.add(new kharifRecycle(R.drawable.rabi , "Rabi \n How to do framing of wheat"));


        KharifAdapter kharifAdapter = new KharifAdapter(fruitRecycles);
        fruit_recycle.setAdapter(kharifAdapter);
    }
}