package com.example.android.businesscard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    private EditText nameField;
    private EditText professionField;
    private EditText emailField;
    private EditText phoneField;

    public static final String REPLY_NAME = "com.example.android.businesscard.extra.REPLY_NAME";
    public static final String REPLY_PROFESSION = "com.example.android.businesscard.extra.REPLY_PROFESSION";
    public static final String REPLY_EMAIL = "com.example.android.businesscard.extra.REPLY_EMAIL";
    public static final String REPLY_PHONE = "com.example.android.businesscard.extra.REPLY_PHONE";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_update_form);
        Intent intent = getIntent();
        nameField = findViewById(R.id.name_field);
        nameField.setText(intent.getStringExtra(MainActivity.EXTRA_NAME));
        professionField = findViewById(R.id.profession_field);
        professionField.setText(intent.getStringExtra(MainActivity.EXTRA_PROFESSION));
        emailField= findViewById(R.id.email_field);
        emailField.setText(intent.getStringExtra(MainActivity.EXTRA_EMAIL));
        phoneField = findViewById(R.id.phone_field);
        phoneField.setText(intent.getStringExtra(MainActivity.EXTRA_PHONE));
    }


    public void saveForm(View view) {
        Intent intent= new Intent();
        String name= nameField.getText().toString();
        String profession = professionField.getText().toString();
        String email = emailField.getText().toString();
        String phone = phoneField.getText().toString();

        intent.putExtra(REPLY_NAME, name);
        intent.putExtra(REPLY_PROFESSION, profession);
        intent.putExtra(REPLY_EMAIL, email);
        intent.putExtra(REPLY_PHONE, phone);
        setResult(RESULT_OK, intent);
        finish();
    }
}
