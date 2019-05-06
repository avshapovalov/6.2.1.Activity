package com.example.a621activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView picture;
    private TextView link;
    private int ActivityNumber = 0;
    public static final String ACTIVITY_KEY = "ActivityNumber";
    private static final int ACTIVITY_REQUEST_CODE = 1;

    private void openNewPage() {
        Intent intent = new Intent(this , this.getClass());
        setResult(RESULT_OK, intent);
        startActivityForResult(intent, ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picture = findViewById(R.id.picture);
        link = findViewById(R.id.link);

        if (ActivityNumber == 0) {
            Random random = new Random();
            ActivityNumber = random.nextInt(100);
        }


        link.setText("ActivityNumber = " + ActivityNumber);
        Log.d("Lifecycle", ActivityNumber + " onCreate");

        Button forward = findViewById(R.id.forward);
        Button backward = findViewById(R.id.backward);

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewPage();
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", ActivityNumber + " onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", ActivityNumber + " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", ActivityNumber + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", ActivityNumber + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", ActivityNumber + " onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Lifecycle", ActivityNumber + " onSaveInstanceState");
        outState.putInt(ACTIVITY_KEY, ActivityNumber);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            ActivityNumber = savedInstanceState.getInt(ACTIVITY_KEY);
            Log.d("Lifecycle", ActivityNumber + " onSaveInstanceState");
        }
    }


}
