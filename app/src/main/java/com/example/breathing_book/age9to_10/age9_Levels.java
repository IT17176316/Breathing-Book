package com.example.breathing_book.age9to_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.breathing_book.R;
import com.example.breathing_book.age7_to_8.age7_Level1.age7_Level1;
import com.example.breathing_book.age7_to_8.age7_Level1.age7_Level2;
import com.example.breathing_book.age7_to_8.age7_Level1.age7_Level3;
import com.example.breathing_book.age7_to_8.age7_Levels;
import com.example.breathing_book.age9to_10.age10_Level1.age10_Level1;
import com.example.breathing_book.age9to_10.age10_Level1.age10_Level2;
import com.example.breathing_book.age9to_10.age10_Level1.age10_Level3;

public class age9_Levels extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age9_levels);

        button1 = (Button)findViewById(R.id.age10Level1);
        button2 = (Button)findViewById(R.id.age10Level2);
        button3 = (Button)findViewById(R.id.age10Level3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age9_Levels.this, age10_Level1.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age9_Levels.this, age10_Level2.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age9_Levels.this, age10_Level3.class);
                startActivity(intent);
            }
        });
    }
}