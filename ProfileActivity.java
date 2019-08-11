package com.lavish.smartbin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
private ImageView profilepic;
private TextView name;
private TextView aadharnum,email;
private Button edit;
private FirebaseAuth firebaseAuth;
private FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profilepic=(ImageView)findViewById(R.id.ivprofilepic);
        name=findViewById(R.id.tvprofileneme);
        aadharnum=findViewById(R.id.tvprofileid);
        edit=findViewById(R.id.btnprofileupdate);
        email=findViewById(R.id.tvprofileemail);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference(firebaseAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Userprofile userprofile=dataSnapshot.getValue(Userprofile.class);
                name.setText("Name: "+userprofile.getUsername());
                email.setText("Email: "+userprofile.getEmail());
                aadharnum.setText("Aadhar Number"+userprofile.getAadharnum());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ProfileActivity.this,databaseError.getCode(),Toast.LENGTH_SHORT);         }
        });
    }
}
