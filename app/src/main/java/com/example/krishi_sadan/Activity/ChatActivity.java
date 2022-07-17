package com.example.krishi_sadan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishi_sadan.Model.Messages;
import com.example.krishi_sadan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {

    String ReciverImage, Reciverphn, ReciverName, Senderphn;
    CircleImageView profileImage;
    TextView receiverName;
    FirebaseDatabase database;
    FirebaseAuth firebaseAuth;
    ImageView backbtn;
    public static String sImage;
    public static String rImage;


    CardView sendBtn;
    EditText editMessage;

    String senderRoom, reciverRoom;
    RecyclerView messagead;
    ArrayList<Messages> messagesArrayList;

    MessagesAdapter adapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        database = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        ReciverName = getIntent().getStringExtra("name");
        ReciverImage = getIntent().getStringExtra("ReciverImage");
        Reciverphn = getIntent().getStringExtra("uid");

        messagesArrayList = new ArrayList<>();

        profileImage = findViewById(R.id.profile_image);


        messagead = findViewById(R.id.messagead);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        messagead.setLayoutManager(linearLayoutManager);
        adapter1 = new MessagesAdapter(ChatActivity.this, messagesArrayList);
        messagead.setAdapter(adapter1);

       backbtn=findViewById(R.id.backbutton);


        sendBtn = findViewById(R.id.sendbtn);
        editMessage = findViewById(R.id.editMessage);
        Picasso.get().load(ReciverImage).into(profileImage);
        receiverName = findViewById(R.id.receiverName);
        receiverName.setText("" + ReciverName);


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ChatActivity.this,experTalk.class);
                startActivity(intent);
            }
        });


        //Senderphn=getIntent().getStringExtra("phn");
        Senderphn = firebaseAuth.getUid();

        senderRoom = Senderphn + Reciverphn;
        reciverRoom = Reciverphn + Senderphn;


        DatabaseReference reference = database.getReference().child("user").child(Reciverphn);
        DatabaseReference chatReference = database.getReference().child("chats").child(senderRoom).child("messages");


        chatReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                messagesArrayList.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Messages messages = dataSnapshot.getValue(Messages.class);
                    messagesArrayList.add(messages);

                }

                adapter1.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                sImage = "https://firebasestorage.googleapis.com/v0/b/krishi-c8460.appspot.com/o/kri2.PNG?alt=media&token=d2203ffc-b971-4052-94f4-0d0580870583";
                //sImage=snapshot.child("ImageUri").getValue().toString();
                rImage = ReciverImage;


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editMessage.getText().toString();
                if (message.isEmpty()) {
                    Toast.makeText(ChatActivity.this, "enter the valid meaasge", Toast.LENGTH_SHORT).show();
                    return;
                }
                editMessage.setText("");
                Date date = new Date();
                Messages messages = new Messages(message, Senderphn, date.getTime());

                database = FirebaseDatabase.getInstance();
                database.getReference().child("chats")
                        .child(senderRoom)
                        .child("messages")
                        .push().setValue(messages).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        database.getReference().child("chats")
                                .child(reciverRoom)
                                .child("messages")
                                .push().setValue(messages).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });


                    }
                });
            }
        });

    }
}