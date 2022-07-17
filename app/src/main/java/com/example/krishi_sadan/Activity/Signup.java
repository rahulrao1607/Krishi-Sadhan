package com.example.krishi_sadan.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.krishi_sadan.Model.Users;
import com.example.krishi_sadan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class Signup extends AppCompatActivity {
    Button btn1, reg;
    EditText reg_name, uemail, upass, cofpass, phno, degination;
    FirebaseAuth auth;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    CircleImageView profimg;
    Uri imageUri;
    FirebaseDatabase database;
    DatabaseReference reference;
   StorageReference sreference;
    FirebaseStorage storage;
    String imageURI;
   // ProgressDialog progressDialog;


    // if error come in real time data base remove this process dialog shittttttttttt


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Please wait...........");
//        progressDialog.setCancelable(false);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();

        btn1 = findViewById(R.id.button4);
        reg_name = findViewById(R.id.textView4);
        uemail = findViewById(R.id.editTextTextEmailAddress);
        upass = findViewById(R.id.editTextTextPassword);
        cofpass = findViewById(R.id.editTextTextPassword3);
        reg = findViewById(R.id.button2);
        phno = findViewById(R.id.phone);
        degination = findViewById(R.id.deg);
        profimg = findViewById(R.id.profile_image);



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // progressDialog.show();
                String name = reg_name.getText().toString();
                String email1 = uemail.getText().toString();
                String pass2 = upass.getText().toString();
                String pass3 = cofpass.getText().toString();
                String phoneno = phno.getText().toString();
                String status = "Hey there I am a qualified Agriculture expert";


                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email1) || TextUtils.isEmpty(pass2) || TextUtils.isEmpty(pass3)) {
                    //progressDialog.dismiss();
                    Toast.makeText(Signup.this, "Enter all Credential", Toast.LENGTH_SHORT).show();
                } else if (!email1.matches(emailPattern)) {
                    //progressDialog.dismiss();
                    Toast.makeText(Signup.this, "Enter valid Email address", Toast.LENGTH_SHORT).show();
                } else if (phoneno.length() < 10) {
                    upass.setError("Invalid phone number");
                    Toast.makeText(Signup.this, "Enter the correct phone number", Toast.LENGTH_SHORT).show();
                } else if (pass2.length() < 6) {
                    //progressDialog.dismiss();
                    upass.setError("Invali password");
                    Toast.makeText(Signup.this, "Enter Strong password", Toast.LENGTH_SHORT).show();
                } else if (!pass2.equals(pass3)) {
                    //progressDialog.dismiss();
                    Toast.makeText(Signup.this, "passwords donot matches", Toast.LENGTH_SHORT).show();
                } else {
                    auth.createUserWithEmailAndPassword(email1, pass2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                String degination1 = degination.getText().toString();
                                if (degination1.equals("expert")) {
                                    reference = database.getReference().child("user");
                                }
                                else if (degination1.equals("user")) {
                                    reference = database.getReference().child("users");
                                }
                                 sreference = storage.getReference("Storage").child("upload");
                                if (imageUri != null) {
                                    sreference.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                            if (task.isSuccessful()) {
                                                // progressDialog.dismiss();
                                                sreference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                    @Override
                                                    public void onSuccess(Uri uri) {
                                                        imageURI = uri.toString();
                                                        Users users = new Users(auth.getUid(), name, email1, phoneno, imageURI, status);
                                                        // the auth.getuid() may be null so it cant be set as branch node so we have to take phoneno. as input so it can be unique for every one
                                                        // reference.child(email1).setValue(users);
                                                        reference.child(phoneno).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if (task.isSuccessful()) {
                                                                  //  progressDialog.dismiss();
                                                                    startActivity(new Intent(Signup.this, Dashboard.class));
                                                                } else {
                                                                    Toast.makeText(Signup.this, "Error in creating user", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                        });

                                                    }
                                                });
                                            }
                                        }
                                    });
                                } else {
                                    String status = "Hey there I am a qualified Agriculture expert";
                                    imageURI = "https://firebasestorage.googleapis.com/v0/b/krishi-c8460.appspot.com/o/kri2.PNG?alt=media&token=d2203ffc-b971-4052-94f4-0d0580870583";
                                    Users users = new Users(auth.getUid(), name, email1, phoneno, imageURI, status);
                                    reference.child(phoneno).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(Signup.this, "User created2", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(Signup.this, Dashboard.class));
                                            } else {
                                                Toast.makeText(Signup.this, "Error in creating user", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }

                                Toast.makeText(Signup.this, "User created1", Toast.LENGTH_SHORT).show();
                            } else {
                                //progressDialog.dismiss();
                                Toast.makeText(Signup.this, "Something get wrong", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        profimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "select Picture"), 10);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup.this, Home.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            if (data != null) {
                imageUri = data.getData();
                profimg.setImageURI(imageUri);
            }
        }
    }

}
