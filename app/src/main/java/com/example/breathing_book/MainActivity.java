package com.example.breathing_book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    private CardView profile,listen,read,game,progress,ar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_lite);

//        textView = (TextView)findViewById(R.id.textview);
//        Button button1,button2;
//
//        button1 = (Button) findViewById(R.id.button);
//        button2 = (Button) findViewById(R.id.button3);
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(MainActivity.this,ReadList.class);
//                startActivity(intent2);
//            }
//        });
//
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(MainActivity.this,ListenList.class);
//                startActivity(intent1);
//            }
//        });


        listen = findViewById(R.id.listen);
        listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Exercise Loading...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ListenList.class);
                startActivity(intent);
            }
        });


        read = findViewById(R.id.read);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Exercise Loading...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ReadList.class);
                startActivity(intent);
            }
        });


        game = findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Game Loading...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SelectAge.class);
                startActivity(intent);
            }
        });

        progress = findViewById(R.id.progress);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Progress Loading...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
                startActivity(intent);
            }
        });

        ar = findViewById(R.id.augmentbutton);
        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Augmented Reality Loading...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, augment_mainActivity.class);
                startActivity(intent);
            }
        });

    }

}