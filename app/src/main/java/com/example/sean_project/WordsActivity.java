package com.example.sean_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class WordsActivity extends AppCompatActivity {

    public static String ipBaseAddress = "http://mdad.atspace.co.uk";
    Button btnViewWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        Log.i("---Ip address", ipBaseAddress);
        // Buttons
        btnViewWords = (Button) findViewById(R.id.btnViewWords);

        btnViewWords.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching All products Activity
                Intent i = new Intent(getApplicationContext(), AllWordsActivity.class);
                startActivity(i);

            }
        });
    }
}