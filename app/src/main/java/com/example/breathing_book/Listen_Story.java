package com.example.breathing_book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Listen_Story extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button btn;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_story);

        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.button2);
       // editText = findViewById(R.id.editText);
       // editText.setText("");
        textView.setText(" ");

        String sentence = getIntent().getStringExtra("keySentence");
      //  editText.setText(sentence);
        textView.setText(sentence);

        textToSpeech = new TextToSpeech(Listen_Story.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                //if there is no error set language
                if(status!= TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get text
                String text = textView.getText().toString();


                //convert text to speech
                textToSpeech.setSpeechRate(0.6f);
                textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
            }
        });


    }

    @Override
    protected void onPause() {
        if(textToSpeech!=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }
}