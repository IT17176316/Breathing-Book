package com.example.breathing_book.age5_to_6.age5_Level1.age5_Level2Questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.breathing_book.MainActivity;
import com.example.breathing_book.R;
import com.example.breathing_book.SelectAge;
import com.example.breathing_book.age5_to_6.age5_Level1.age5Questions.age5_results;
import com.example.breathing_book.age5_to_6.age5_Level1.age5_Level1;
import com.example.breathing_book.age5_to_6.age5_Level1.age5_Level2;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class age5L2_result extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private ImageView imageView1;
    private ImageView imageView2;
    private KonfettiView konfettiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age5_l2_result);

        textView1 = (TextView)findViewById(R.id.age5_result);
        textView2 = (TextView)findViewById(R.id.age5_result_outof);
        imageView1 = (ImageView) findViewById(R.id.age5PlayAgain);
        imageView2 = (ImageView) findViewById(R.id.age5GoHome);
        konfettiView = (KonfettiView)findViewById(R.id.viewKonfetti);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age5L2_result.this, age5_Level2.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(age5L2_result.this, SelectAge.class);
                startActivity(mainIntent);
                age5L2_result.this.finish();
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