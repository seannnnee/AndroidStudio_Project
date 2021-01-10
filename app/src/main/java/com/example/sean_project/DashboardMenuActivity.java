package com.example.sean_project;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardMenuActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etSpelling;
    Button btnSpelling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        findViews();
    }

    private void findViews() {
        etSpelling = (EditText) findViewById(R.id.etSpelling);
        btnSpelling = (Button) findViewById(R.id.btnSpelling);

        //#2 ClickListener for btnEnglish
        btnSpelling.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSpelling) {
            //Handle clicks for btnEnglish
            Toast.makeText(this, "Spelling", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, WordsActivity.class);
            startActivity(intent);
        }
    }
}