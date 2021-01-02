package com.example.sean_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public static String ipBaseAddress ="mdad.atspace.co.uk";

    //#1 Declare Class variables
    Button btnStart;
    TextView tvTitle, tvMessage, tvWelcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        //#2 Binding Java to XML
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        btnStart = (Button) findViewById(R.id.btnStart);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        tvWelcomeMessage = (TextView) findViewById(R.id.tvWelcomeMessage);

        //#3 ClickListener for btnStart

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_LONG). show();
            }
        });
    }
}