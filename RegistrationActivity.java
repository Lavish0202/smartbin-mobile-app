package com.lavish.smartbin;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {
    private EditText userName, userPassword, userEmail,userId;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    private ImageView userprofilepic;
    String name,email,password,uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setUIViews();
        firebaseAuth=FirebaseAuth.getInstance();
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //upload to database
                    String user_email=userEmail.getText().toString().trim();
                    String password=userPassword.getText().toString().trim();
                   firebaseAuth.createUserWithEmailAndPassword(user_email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {

                           if(task.isSuccessful())
                     {
                         sendUserdata();
    Toast.makeText(RegistrationActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
                       }
                       else {
    Toast.makeText(RegistrationActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
}
                       }
                   });


                }

            }
        });
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
            }
        });
    }
    private void setUIViews(){

        userName=(EditText)findViewById(R.id.etUserName);
        userPassword=(EditText)findViewById(R.id.etUserPassword);
        userEmail=(EditText)findViewById(R.id.etUserEmail);
        userId=(EditText)findViewById(R.id.etUserId);
        regButton=(Button)findViewById(R.id.btnRegister);
        userLogin=(TextView)findViewById(R.id.tvUserLogin) ;
        userprofilepic=(ImageView)findViewById(R.id.ivprofile);
    }
    private Boolean validate(){
Boolean result=false;
 name=userName.getText().toString();
 password=userPassword.getText().toString();
 uid=userId.getText().toString();
 email=userEmail.getText().toString();
if(name.isEmpty() || password.isEmpty() || uid.isEmpty() || email.isEmpty()){
    Toast.makeText(this,"Please fill up all the details to register",Toast.LENGTH_SHORT).show();
}
else{
    result=true;
}
return result;
    }
private void sendUserdata(){

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
    Userprofile userprofile=new Userprofile(name,uid,email);
myRef.setValue(userprofile);
}
}

