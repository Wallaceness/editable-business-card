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

public class MainActivity extends AppCompatActivity implements ReadFragment.OnFragmentInteractionListener, EditFragment.OnFragmentInteractionListener{

    public static final int TEXT_REQUEST = 1;
    public static final String EXTRA_NAME = "com.example.android.businesscard.extra.NAME";
    public static final String EXTRA_PROFESSION = "com.example.android.businesscard.extra.PROFESSION";
    public static final String EXTRA_EMAIL = "com.example.android.businesscard.extra.EMAIL";
    public static final String EXTRA_PHONE = "com.example.android.businesscard.extra.PHONE";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("MY_PREFERENCES", Context.MODE_PRIVATE);
        String savedName=sharedPreferences.getString("Name", "Nathan");
        String savedProfession =sharedPreferences.getString("Profession", "Android Developer");
        String savedEmail = sharedPreferences.getString("Email", "ncw232@gmail.com");
        String savedPhone = sharedPreferences.getString("Phone", "804.501.9023");


        ReadFragment mainView= ReadFragment.newInstance(savedName, savedProfession, savedEmail, savedPhone);



        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, mainView).addToBackStack(null).commit();

    }

    public void onEdit(View view) {
        String savedName=sharedPreferences.getString("Name", "Nathan");
        String savedProfession =sharedPreferences.getString("Profession", "Android Developer");
        String savedEmail = sharedPreferences.getString("Email", "ncw232@gmail.com");
        String savedPhone = sharedPreferences.getString("Phone", "804.501.9023");

        FragmentManager manager = getSupportFragmentManager();

        ReadFragment fragment = (ReadFragment) manager.findFragmentById(R.id.fragment_container);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment).commit();

        EditFragment mainView= EditFragment.newInstance(savedName, savedProfession, savedEmail, savedPhone);

        FragmentTransaction newtransaction = manager.beginTransaction();
        newtransaction.add(R.id.fragment_container, mainView).addToBackStack(null).commit();
    }

    public void saveData(String name, String prof, String email, String phone){
        //saved data to shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.name_label), name);
        editor.putString(getString(R.string.profession_label), prof);
        editor.putString(getString(R.string.email_label), email);
        editor.putString(getString(R.string.phone_label), phone);

        editor.apply();

        String savedName=sharedPreferences.getString("Name", "Nathan");
        String savedProfession =sharedPreferences.getString("Profession", "Android Developer");
        String savedEmail = sharedPreferences.getString("Email", "ncw232@gmail.com");
        String savedPhone = sharedPreferences.getString("Phone", "804.501.9023");

        FragmentManager manager = getSupportFragmentManager();
        EditFragment currentFragment = (EditFragment) manager.findFragmentById(R.id.fragment_container);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(currentFragment).commit();

        ReadFragment mainView = ReadFragment.newInstance(savedName, savedProfession, savedEmail, savedPhone);
        FragmentTransaction newTransaction = manager.beginTransaction();
        newTransaction.add(R.id.fragment_container, mainView).addToBackStack(null).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
