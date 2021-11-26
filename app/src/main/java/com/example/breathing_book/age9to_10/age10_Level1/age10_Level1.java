package com.example.breathing_book.age9to_10.age10_Level1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.breathing_book.R;
import com.example.breathing_book.age7_to_8.age7_Level1.age7_Level1;
import com.example.breathing_book.age7_to_8.age7_Level1.age7_Level1Questions.age7L1_Q1;
import com.example.breathing_book.age9to_10.age10_Level1.age10_Level1Questions.age10L1_Q1;

public class age10_Level1 extends AppCompatActivity {

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age10_level1);

        imageButton = (ImageButton)findViewById(R.id.age10Level1play);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age10_Level1.this, age10L1_Q1.class);
                startActivity(intent);
            }
        });
    }
}