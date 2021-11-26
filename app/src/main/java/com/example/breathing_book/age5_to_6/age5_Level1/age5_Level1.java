package com.example.breathing_book.age5_to_6.age5_Level1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.breathing_book.R;
import com.example.breathing_book.age5_to_6.age5_Levels;

public class age5_Level1 extends AppCompatActivity {

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age5_level1);

        imageButton = (ImageButton)findViewById(R.id.age5Level1play);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age5_Level1.this, com.example.breathing_book.age5_to_6.age5_Level1.age5Questions.age5Q1.class);
                startActivity(intent);
            }
        });

    }
}