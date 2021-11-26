package com.example.breathing_book.age11_to_12.age11Levels.age11_Level3Questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.breathing_book.R;
import com.example.breathing_book.SelectAge;
import com.example.breathing_book.age11_to_12.age11Levels.age11Level2;
import com.example.breathing_book.age11_to_12.age11Levels.age11Level3;
import com.example.breathing_book.age11_to_12.age11Levels.age11_Level2Questions.age11L2_results;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class age11L3_results extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private ImageView imageView1;
    private ImageView imageView2;
    private KonfettiView konfettiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age11_l3_results);

        textView1 = (TextView)findViewById(R.id.age11_result);
        textView2 = (TextView)findViewById(R.id.age11_result_outof);
        imageView1 = (ImageView) findViewById(R.id.age11PlayAgain);
        imageView2 = (ImageView) findViewById(R.id.age11GoHome);
        konfettiView = (KonfettiView)findViewById(R.id.viewKonfetti);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age11L3_results.this, age11Level3.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(age11L3_results.this, SelectAge.class);
                startActivity(mainIntent);
                age11L3_results.this.finish();
            }
        });

        int data = getIntent().getExtras().getInt("correctCount");

        if (data >= 8){
            textView1.setText("A");
            textView2.setText("You got "+data+" marks out of 10");

            konfettiView.build()
                    .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                    .setDirection(359.0, 359.0)
                    .setSpeed(1f, 5f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(2000L)
                    .addShapes(Shape.RECT, Shape.CIRCLE)
                    .addSizes(new Size(12, 5))
                    .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                    .streamFor(300, 5000L);

        }else if(data <= 7 && data >= 5){
            textView1.setText("B");
            textView2.setText("You got "+data+" marks out of 10");
            konfettiView.build()
                    .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                    .setDirection(0.0, 359.0)
                    .setSpeed(1f, 5f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(2000L)
                    .addShapes(Shape.RECT, Shape.CIRCLE)
                    .addSizes(new Size(12, 5))
                    .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                    .streamFor(300, 5000L);

        }else {
            textView1.setText("C");
            textView2.setText("You got "+data+" marks out of 10");
        }
    }
}