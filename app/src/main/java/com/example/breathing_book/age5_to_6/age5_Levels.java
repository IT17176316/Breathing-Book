package com.example.breathing_book.age5_to_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.breathing_book.R;
import com.example.breathing_book.age5_to_6.age5_Level1.age5_Level1;
import com.example.breathing_book.age5_to_6.age5_Level1.age5_Level2;
import com.example.breathing_book.age5_to_6.age5_Level1.age5_Level3;

public class age5_Levels extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age5_levels);

        button1 = (Button)findViewById(R.id.age5Level1play);
        button2 = (Button)findViewById(R.id.age5Level2);
        button3 = (Button)findViewById(R.id.age5Level3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age5_Levels.this, age5_Level1.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age5_Levels.this, age5_Level2.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age5_Levels.this, age5_Level3.class);
                startActivity(intent);
            }
        });

    }
}