package com.example.trealthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String name;
        TextView tv=findViewById(R.id.welcome);


        SharedPreferences sharedPreferences=getSharedPreferences("shared-prefs", Context.MODE_PRIVATE);
        /*String username=sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "welcome "+ username, Toast.LENGTH_SHORT).show();*/
        /*SharedPreferences est une interface pour accéder et modifier les données de préférences stockées dans un fichier XML.
        getString retourne un objet donc on doit la convertir
        Si la clé "username" nexiste pas, une chaîne vide "" est retournée par défaut.*/
        CardView exit=findViewById(R.id.cardLOGOUT);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            }
            //Ce code efface toutes les données stockées dans les SharedPreferences de l'application.
        });

        CardView findDoctor=findViewById(R.id.cardFindDoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,FindDoctorActivity.class));
            }
        });

        CardView labTest=findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,LabTestActivity.class));
            }
        });
        CardView account=findViewById(R.id.cardAccount);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,AccountActivity.class));
            }
        });



    }
}