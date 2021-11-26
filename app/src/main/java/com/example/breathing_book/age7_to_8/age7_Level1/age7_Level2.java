package com.example.breathing_book.age7_to_8.age7_Level1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.breathing_book.R;
import com.example.breathing_book.age7_to_8.age7_Level1.age7_Level1Questions.age7L1_Q1;
import com.example.breathing_book.age7_to_8.age7_Level1.age7_Level2Questions.age7L2_Q1;

public class age7_Level2 extends AppCompatActivity {

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age7_level2);

        imageButton = (ImageButton)findViewById(R.id.age7Level1play);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age7_Level2.this, age7L2_Q1.class);
                startActivity(intent);
            }
        });
    }
}