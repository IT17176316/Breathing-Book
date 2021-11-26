package com.example.breathing_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectAge extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_age);

        button1 =(Button)findViewById(R.id.ageButton1);
        button2 =(Button)findViewById(R.id.ageButton2);
        button3 =(Button)findViewById(R.id.ageButton3);
        button4 =(Button)findViewById(R.id.ageButton4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectAge.this, com.example.breathing_book.age5_to_6.age5_Levels.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectAge.this, com.example.breathing_book.age7_to_8.age7_Levels.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectAge.this, com.example.breathing_book.age9to_10.age9_Levels.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectAge.this, com.example.breathing_book.age11_to_12.age11_Levels.class);
                startActivity(intent);
            }
        });
    }
}