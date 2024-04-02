package com.example.ni_escobar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void jogar(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void developer(View view){
        Intent i = new Intent(this,DeveloperActivity.class);
        startActivity(i);
    }
}