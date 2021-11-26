package com.example.breathing_book.age11_to_12.age11Levels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.breathing_book.R;
import com.example.breathing_book.age11_to_12.age11Levels.age11_Level1Questions.age11L1_Q1;
import com.example.breathing_book.age11_to_12.age11Levels.age11_Level2Questions.age11L2_Q1;

public class age11Level2 extends AppCompatActivity {

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age11_level2);

        imageButton = (ImageButton)findViewById(R.id.age11Level1play);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age11Level2.this, age11L2_Q1.class);
                startActivity(intent);
            }
        });
    }
}