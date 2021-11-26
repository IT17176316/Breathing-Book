package com.example.breathing_book.age11_to_12.age11Levels.age11_Level3Questions;

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

public class age11L3_Q4 extends AppCompatActivity {

    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button button1;
    private Integer data;
    private TextView textView;
    CountDownTimer yourCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age11_l3_q4);

        radioButton1 =(RadioButton)findViewById(R.id.ans1);
        radioButton2 =(RadioButton)findViewById(R.id.ans2);
        radioButton3 =(RadioButton)findViewById(R.id.ans3);
        radioButton4 =(RadioButton)findViewById(R.id.ans4);
        textView = (TextView)findViewById(R.id.time);
        button1 = (Button)findViewById(R.id.confirm);

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

    private void result() {
        if (radioButton1.isChecked() || radioButton2.isChecked() || radioButton3.isChecked() || radioButton4.isChecked()){

            if (radioButton4.isChecked()){
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(age11L3_Q4.this);
                LayoutInflater inflater = age11L3_Q4.this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.correct_answer, null);
                dialogBuilder.setView(dialogView);
                dialogBuilder.setCancelable(false);

                Button button = (Button) dialogView.findViewById(R.id.goto_next);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        yourCountDownTimer.cancel();
                        Intent intent = new Intent(age11L3_Q4.this, age11L3_Q5.class);
                        intent.putExtra("correctCount", data+1);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

            }else{
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(age11L3_Q4.this);
                LayoutInflater inflater = age11L3_Q4.this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.wrong_answer, null);
                dialogBuilder.setView(dialogView);
                dialogBuilder.setCancelable(false);

                Button button = (Button) dialogView.findViewById(R.id.goto_next);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        yourCountDownTimer.cancel();
                        Intent intent = new Intent(age11L3_Q4.this, age11L3_Q5.class);
                        intent.putExtra("correctCount", data);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        }else {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(age11L3_Q4.this);
            builder1.setMessage("You must select a answer.");
            builder1.setCancelable(true);

            builder1.setNegativeButton(
                    "Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }


    }
}