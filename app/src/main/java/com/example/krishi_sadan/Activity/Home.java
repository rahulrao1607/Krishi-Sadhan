package com.example.krishi_sadan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.krishi_sadan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    EditText txt_email,txt_pass;
    Button btn,btn_login;
    FirebaseAuth auth;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth=FirebaseAuth.getInstance();

        setContentView(R.layout.activity_home);
        btn = findViewById(R.id.button);
        btn_login=findViewById(R.id.button3);
        txt_email=findViewById(R.id.editTextTextEmailAddress2);
        txt_pass=findViewById(R.id.editTextTextPassword2);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txt_email.getText().toString();
                String pass=txt_pass.getText().toString();

                if(TextUtils.isEmpty(email)|| TextUtils.isEmpty(pass))
                {

                    Toast.makeText(Home.this,"Enter Valid Data",Toast.LENGTH_SHORT).show();
                }
                else if(!email.matches(emailPattern))
                {
                    txt_email.setError("Invali Email");
                    Toast.makeText(Home.this,"Enter Valid Email Address",Toast.LENGTH_SHORT).show();

                }
                else if(pass.length()<6)
                {
                    txt_pass.setError("Invali password");
                    Toast.makeText(Home.this,"Enter Strong password",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {
                                startActivity(new Intent(Home.this,Dashboard.class));
                            }
                            else
                            {
                                Toast.makeText(Home.this,"Error in Login",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(Home.this,Signup.class);
                startActivity(intent);
                finish();

            }
        });
    }
}