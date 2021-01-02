package com.example.sean_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardMenuActivity extends AppCompatActivity {
    EditText etLanguages;
    Button btnEnglish, btnJapanese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        etLanguages = (EditText) findViewById(R.id.etLanguages);
        btnEnglish = (Button) findViewById(R.id.btnEnglish);
        btnJapanese = (Button) findViewById(R.id.btnJapanese);

        //#2 ClickListener for btnEnglish
        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_LONG).show();
            }
        });
    }
}