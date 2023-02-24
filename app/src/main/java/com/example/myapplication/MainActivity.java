package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    TextView textView;
    private ImageButton imageButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView13);

        ImageButton button = findViewById(R.id.imageButton7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                String text = ((TextView) findViewById(R.id.textView13)).getText().toString();
                intent.putExtra("text", text);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        ImageButton myButton = findViewById(R.id.imageButton5);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Log.i("MyApp", "Уведомления включены!");
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String result = data.getStringExtra("text");
            TextView textView = findViewById(R.id.textView13);
            textView.setText(result);
        }

    }
    public void onMyButtonClick(View view){
        Log.i("MyApp", "Уведомления включены!");
    }
}