package com.example.breathing_book.age5_to_6.age5_Level1.age5Questions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.breathing_book.R;

public class age5Q7 extends AppCompatActivity {

    private RadioButton radioButton;
    private Button button1;
    private TextView textView;
    private Integer data;
    CountDownTimer yourCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age5_q7);

        radioButton =(RadioButton)findViewById(R.id.age5Q1radioBrown);
        button1 = (Button)findViewById(R.id.age5Q1confirm);
        textView = (TextView)findViewById(R.id.time);

        data = getIntent().getExtras().getInt("correctCount");
        System.out.println("Wtest"+data);

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

    private void result(){
        if (radioButton.isChecked()){
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(age5Q7.this);
            LayoutInflater inflater = age5Q7.this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.correct_answer, null);
            dialogBuilder.setView(dialogView);
            dialogBuilder.setCancelable(false);

            Button button = (Button) dialogView.findViewById(R.id.goto_next);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(age5Q7.this, age5Q8.class);
                    intent.putExtra("correctCount", data+1);
                    startActivity(intent);
                }
            });
            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();

        }else{
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(age5Q7.this);
            LayoutInflater inflater = age5Q7.this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.wrong_answer, null);
            dialogBuilder.setView(dialogView);
            dialogBuilder.setCancelable(false);

            Button button = (Button) dialogView.findViewById(R.id.goto_next);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(age5Q7.this, age5Q8.class);
                    intent.putExtra("correctCount", data);
                    startActivity(intent);
                }
            });
            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();
        }
    }
}