package com.example.android.businesscard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private SharedPreferences data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_update_form);
        data = getSharedPreferences("MY_PREFERENCES", Context.MODE_PRIVATE);
        nameField = findViewById(R.id.name_field);
        nameField.setText(data.getString("Name", "Nathan"));
        professionField = findViewById(R.id.profession_field);
        professionField.setText(data.getString("Profession", "Android Developer"));
        emailField= findViewById(R.id.email_field);
        emailField.setText(data.getString("Email", "ncw232@gmail.com"));
        phoneField = findViewById(R.id.phone_field);
        phoneField.setText(data.getString("Phone", "804.501.9023"));
    }


    public void saveForm(View view) {
        // Get text values of edit fields
        String name= nameField.getText().toString();
        String profession = professionField.getText().toString();
        String email = emailField.getText().toString();
        String phone = phoneField.getText().toString();

        //saved data to shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("MY_PREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.name_label), name);
        editor.putString(getString(R.string.profession_label), profession);
        editor.putString(getString(R.string.email_label), email);
        editor.putString(getString(R.string.phone_label), phone);

        editor.apply();

        //send data back to parent in intent
//        Intent intent= new Intent();
//        intent.putExtra(REPLY_NAME, name);
//        intent.putExtra(REPLY_PROFESSION, profession);
//        intent.putExtra(REPLY_EMAIL, email);
//        intent.putExtra(REPLY_PHONE, phone);
//        setResult(RESULT_OK, intent);
        finish();
    }
}
