package com.example.breathing_book.age5_to_6.age5_Level1.age5_Level2Questions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.breathing_book.R;
import com.example.breathing_book.age5_to_6.age5_Level1.age5Questions.age5Q1;
import com.example.breathing_book.age5_to_6.age5_Level1.age5Questions.age5Q2;
import com.example.breathing_book.age7_to_8.age7_Level1.age7_Level1Questions.age7L1_Q1;
import com.example.breathing_book.age7_to_8.age7_Level1.age7_Level1Questions.age7L1_Q2;

public class age5L2_Q1 extends AppCompatActivity {
    
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    Integer correctAnsCount = 0;
    private TextView textView;
    CountDownTimer yourCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age5_l2_q1);
        
        imageView1 = (ImageView)findViewById(R.id.age5_img1);
        imageView2 = (ImageView)findViewById(R.id.age5_img2);
        imageView3 = (ImageView)findViewById(R.id.age5_img3);
        imageView4 = (ImageView)findViewById(R.id.age5_img4);
        textView = (TextView)findViewById(R.id.time);

        yourCountDownTimer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textView.setText("Time Out!!!");
                result();
            }

        }.start();
        
    result();

    }

    private void wrongAnswer() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(age5L2_Q1.this);
        LayoutInflater inflater = age5L2_Q1.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.wrong_answer, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);

        Button button = (Button) dialogView.findViewById(R.id.goto_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(age5L2_Q1.this, age5L_Q2.class);
                intent.putExtra("correctCount", correctAnsCount);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

    }

    private void result() {
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wrongAnswer();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wrongAnswer();
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wrongAnswer();
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(age5L2_Q1.this);
                LayoutInflater inflater = age5L2_Q1.this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.correct_answer, null);
                dialogBuilder.setView(dialogView);
                dialogBuilder.setCancelable(false);

                Button button = (Button) dialogView.findViewById(R.id.goto_next);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(age5L2_Q1.this, age5L_Q2.class);
                        intent.putExtra("correctCount", correctAnsCount+1);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });
    }

}