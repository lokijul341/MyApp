package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton myButton = findViewById(R.id.imageButton5);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Log.i("MyApp", "Программный способ");
            }
        });

    }

    public void onMyButtonClick(View view){
        Log.i("MyApp", "Декларативный способ");
    }
}