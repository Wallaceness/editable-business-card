package com.example.android.businesscard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;

    private TextView nameText;
    private TextView professionText;
    private TextView contactText;
    private TextView emailText;
    private TextView phoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText= findViewById(R.id.name_text);
        professionText = findViewById(R.id.profession_text);
        contactText = findViewById(R.id.contact_text);
        emailText = findViewById(R.id.email_text);
        phoneText= findViewById(R.id.phone_text);
    }

    public void onEdit(){
        Intent intent=new Intent(this, FormActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
