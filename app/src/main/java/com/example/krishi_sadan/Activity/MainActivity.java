package com.example.krishi_sadan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.krishi_sadan.R;

public class MainActivity extends AppCompatActivity {
 //FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        auth=FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(MainActivity.this,Home.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}