package com.example.breathing_book.age5_to_6.age5_Level1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.breathing_book.R;
import com.example.breathing_book.age5_to_6.age5_Level1.age5Level3Questions.age5L3_Q1;

public class age5_Level3 extends AppCompatActivity {

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age5_level3);

        imageButton = (ImageButton)findViewById(R.id.age5Level1play);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age5_Level3.this, age5L3_Q1.class);
                startActivity(intent);
            }
        });
    }
}