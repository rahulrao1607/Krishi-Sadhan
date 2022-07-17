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

public class Animal_crop extends AppCompatActivity {
    RecyclerView animal_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_crop);


        animal_recycle = findViewById(R.id.animal_recycle);
        animal_recycle.setHasFixedSize(true);
        animal_recycle.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));

        List<kharifRecycle> animalRecycles = new ArrayList<>();

        animalRecycles.add(new kharifRecycle(R.drawable.animal , "Wheat \n How to do framing of wheat"));
        animalRecycles.add(new kharifRecycle(R.drawable.vegii , "Vegetable \n How to do framing of wheat"));
        animalRecycles.add(new kharifRecycle(R.drawable.flower , "Flower \n How to do framing of wheat"));
        animalRecycles.add(new kharifRecycle(R.drawable.fruit , "Fruit \n How to do framing of wheat"));
        animalRecycles.add(new kharifRecycle(R.drawable.rabi , "Rabi \n How to do framing of wheat"));


        KharifAdapter kharifAdapter = new KharifAdapter(animalRecycles);
        animal_recycle.setAdapter(kharifAdapter);

    }
}