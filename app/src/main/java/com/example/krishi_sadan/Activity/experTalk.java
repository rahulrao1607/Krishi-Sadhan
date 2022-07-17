package com.example.krishi_sadan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishi_sadan.Model.Users;
import com.example.krishi_sadan.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class experTalk extends DrawerbaseActivity {

    RecyclerView main_userRecylerview;
    UserAdapter adapter;
    FirebaseAuth auth;
    FirebaseDatabase database;
    ArrayList<Users> usersArrayList;
    ImageView profilesetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exper_talk);

        //this code is used to show the drawer base bur i don,t want it as im giving profile change here
//        activityExperTalkBinding = ActivityExperTalkBinding.inflate(getLayoutInflater());
//        setContentView(activityExperTalkBinding.getRoot());



        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


        profilesetting =findViewById(R.id.profilesetting);
        profilesetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(experTalk.this, settingProf.class);
                startActivity(intent);
            }
        });

        usersArrayList =new ArrayList<>();

        DatabaseReference reference =database.getReference().child("user");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    Users users= dataSnapshot.getValue(Users.class);
                    usersArrayList.add(users);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

       main_userRecylerview =findViewById(R.id.main_userRecylerview);
       main_userRecylerview.setLayoutManager(new LinearLayoutManager(this));
       adapter=new UserAdapter(experTalk.this,usersArrayList);

        main_userRecylerview.setAdapter(adapter);



    }

}