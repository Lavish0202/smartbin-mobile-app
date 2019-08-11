package com.lavish.smartbin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Contact extends AppCompatActivity {
private TextView thank,phone,email,website;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        thank=findViewById(R.id.tvty);
        phone=findViewById(R.id.tvphone);
        email=findViewById(R.id.tvcontactemail);
        website=findViewById(R.id.tvwebsite);
    }

}

