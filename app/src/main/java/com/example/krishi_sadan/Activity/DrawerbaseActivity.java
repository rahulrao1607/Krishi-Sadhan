package com.example.krishi_sadan.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.krishi_sadan.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class DrawerbaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerlayout;
    ImageView profile1;

    @Override
    public void setContentView(View view) {
        drawerlayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawerbase, null);
        FrameLayout container = drawerlayout.findViewById(R.id.activity_container);
        container.addView(view);
        super.setContentView(drawerlayout);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.menu_drawer_open, R.string.menu_drawer_closes);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerlayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.nav_talk:
                startActivity(new Intent(this, experTalk.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.nav_weather:
                startActivity(new Intent(this, WeatherActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.nav_log:
                Dialog dialog = new Dialog(DrawerbaseActivity.this, R.style.Dialoge);
                dialog.setContentView(R.layout.dialog_layout);

                TextView yes,no;
                yes=dialog.findViewById(R.id.yes_btn);
                no=dialog.findViewById(R.id.no_btn);

                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(DrawerbaseActivity.this,Home.class));
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
        }

        return false;
    }



    protected void allocateActivityTitle(String titleString) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titleString);
        }
    }


}
