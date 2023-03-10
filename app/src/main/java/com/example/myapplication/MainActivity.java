package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    TextView textView;
    private ImageButton imageButton ;

    ActivityResultLauncher<Intent> activityLauncher;

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
                activityLauncher.launch(intent);
            }
        });

        ImageButton myButton = findViewById(R.id.imageButton5);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Log.i("MyApp", "Уведомления включены!");
            }
        });
        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            String resultText = data.getStringExtra("text");
                            textView.setText(resultText);
                        }
                    }
                });
    }

    public void onMyButtonClick(View view){
        Log.i("MyApp", "Уведомления включены!");
    }
}