package com.example.breathing_book.age9to_10.age10_Level1.age10_Level2Questions;

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
import com.example.breathing_book.age9to_10.age10_Level1.age10_Level1Questions.age10L1_Q1;
import com.example.breathing_book.age9to_10.age10_Level1.age10_Level1Questions.age10L1_Q2;

public class age10L2_Q1 extends AppCompatActivity {

    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button button1;
    private Integer correctAnsCount = 0;
    private TextView textView;
    CountDownTimer yourCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age10_l2_q1);

        radioButton1 =(RadioButton)findViewById(R.id.ans1);
        radioButton2 =(RadioButton)findViewById(R.id.ans2);
        radioButton3 =(RadioButton)findViewById(R.id.ans3);
        radioButton4 =(RadioButton)findViewById(R.id.ans4);
        textView = (TextView)findViewById(R.id.time);
        button1 = (Button)findViewById(R.id.confirm);

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

            if (radioButton2.isChecked()){
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(age10L2_Q1.this);
                LayoutInflater inflater = age10L2_Q1.this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.correct_answer, null);
                dialogBuilder.setView(dialogView);
                dialogBuilder.setCancelable(false);

                Button button = (Button) dialogView.findViewById(R.id.goto_next);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(age10L2_Q1.this, age10L2_Q2.class);
                        intent.putExtra("correctCount", correctAnsCount+1);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

            }else{
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(age10L2_Q1.this);
                LayoutInflater inflater = age10L2_Q1.this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.wrong_answer, null);
                dialogBuilder.setView(dialogView);
                dialogBuilder.setCancelable(false);

                Button button = (Button) dialogView.findViewById(R.id.goto_next);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(age10L2_Q1.this, age10L2_Q2.class);
                        intent.putExtra("correctCount", correctAnsCount);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        }else {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(age10L2_Q1.this);
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