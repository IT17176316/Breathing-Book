package com.example.breathing_book.age5_to_6.age5_Level1.age5Questions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.breathing_book.R;
import com.example.breathing_book.age5_to_6.age5_Level1.age5Level3Questions.age5L3_Q1;
import com.example.breathing_book.age5_to_6.age5_Level1.age5Level3Questions.age5L3_Q2;
import com.example.breathing_book.age5_to_6.age5_Level1.age5_Level1;

public class age5Q1 extends AppCompatActivity {

    private RadioButton radioButton3;
    private Button button1;
    Integer correctAnsCount = 0;
    private TextView textView;
    CountDownTimer yourCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age5_q1);

        radioButton3 =(RadioButton)findViewById(R.id.age5Q1radioRed);
        textView = (TextView)findViewById(R.id.time);
        button1 = (Button)findViewById(R.id.age5Q1confirm);

        yourCountDownTimer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textView.setText("Time Out!!!");
                result();
            }

        }.start();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                result();

            }
        });

    }
    private void result() {
        if (radioButton3.isChecked()){
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(age5Q1.this);
            LayoutInflater inflater = age5Q1.this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.correct_answer, null);
            dialogBuilder.setView(dialogView);
            dialogBuilder.setCancelable(false);

            Button button = (Button) dialogView.findViewById(R.id.goto_next);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(age5Q1.this, age5Q2.class);
                    intent.putExtra("correctCount", correctAnsCount+1);
                    startActivity(intent);
                }
            });
            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();

        }else{
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(age5Q1.this);
            LayoutInflater inflater = age5Q1.this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.wrong_answer, null);
            dialogBuilder.setView(dialogView);
            dialogBuilder.setCancelable(false);

            Button button = (Button) dialogView.findViewById(R.id.goto_next);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(age5Q1.this, age5Q2.class);
                    intent.putExtra("correctCount", correctAnsCount);
                    startActivity(intent);
                }
            });
            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();
        }
    }
}