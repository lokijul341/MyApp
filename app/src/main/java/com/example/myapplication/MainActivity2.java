package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        EditText editText = findViewById(R.id.editTextNumber);
        editText.setText(text);

        Button closeButton = findViewById(R.id.button2);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = ((EditText) findViewById(R.id.editTextNumber)).getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("text", text);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}