package com.example.android.businesscard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ReadFragment.OnFragmentInteractionListener{

    public static final int TEXT_REQUEST = 1;
    public static final String EXTRA_NAME = "com.example.android.businesscard.extra.NAME";
    public static final String EXTRA_PROFESSION = "com.example.android.businesscard.extra.PROFESSION";
    public static final String EXTRA_EMAIL = "com.example.android.businesscard.extra.EMAIL";
    public static final String EXTRA_PHONE = "com.example.android.businesscard.extra.PHONE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReadFragment mainView= ReadFragment.newInstance("bla", "bla");

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, mainView).addToBackStack(null).commit();

//        SharedPreferences data = getSharedPreferences("MY_PREFERENCES", Context.MODE_PRIVATE);
//        nameText.setText(data.getString("Name", "Nathan"));
//        professionText.setText(data.getString("Profession", "Android Developer"));
//        emailText.setText(data.getString("Email", "ncw232@gmail.com"));
//        phoneText.setText(data.getString("Phone", "804.501.9023"));
//        System.out.println("X");
    }

    public void onEdit(View view) {
        Intent intent = new Intent(this, FormActivity.class);
//        String name = nameText.getText().toString();
//        String profession = professionText.getText().toString();
//        String email = emailText.getText().toString();
//        String phone = phoneText.getText().toString();

//        intent.putExtra(EXTRA_NAME, name);
//        intent.putExtra(EXTRA_PROFESSION, profession);
//        intent.putExtra(EXTRA_EMAIL, email);
//        intent.putExtra(EXTRA_PHONE, phone);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        SharedPreferences datas = getSharedPreferences("MY_PREFERENCES", Context.MODE_PRIVATE);
//        nameText.setText(datas.getString("Name", "Nathan"));
//        professionText.setText(datas.getString("Profession", "Android Developer"));
//        emailText.setText(datas.getString("Email", "ncw232@gmail.com"));
//        phoneText.setText(datas.getString("Phone", "804.501.9023"));

//        if (requestCode == TEXT_REQUEST) {
//            if (resultCode == RESULT_OK) {
//            String name= data.getStringExtra(FormActivity.REPLY_NAME);
//            String profession= data.getStringExtra(FormActivity.REPLY_PROFESSION);
//            String email= data.getStringExtra(FormActivity.REPLY_EMAIL);
//            String phone= data.getStringExtra(FormActivity.REPLY_PHONE);
//
//            nameText.setText(name);
//            professionText.setText(profession);
//            emailText.setText(email);
//            phoneText.setText(phone);
//            }
//        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
