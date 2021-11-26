
package com.example.breathing_book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Read_Story extends AppCompatActivity {

    ImageButton imageButton;
    EditText editText;
    EditText editText1;
    TextView textView1, textView2, textView3,textView4;
    int count =0;
    String convertedText;
    int diff;

    SpeechRecognizer speechRecognizer;


    public int distance(String a, String b)
    {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++)
        {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++)
            {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]),
                        a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }


        }
        return costs[b.length()];
    }


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_story);

       // String sentence = "there was an old mother pig";
        String sentence = getIntent().getStringExtra("keySentence");


        String Recognized_sentence;
        ArrayList<String> searchWords = new ArrayList<String>();




        imageButton =findViewById(R.id.button);
       // editText = findViewById(R.id.edittext);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);



        textView1.setText(sentence);



        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},1);
        }

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

        Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        imageButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //editText.setText("");
                if (count == 0){

                    //startListening
                    speechRecognizer.startListening(speechRecognizerIntent);
                    count=1;
                }
                else{
                    //stop listening
                    speechRecognizer.stopListening();
                    count=0;
                }


            }
        });






        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle results) {

                ArrayList<String> data = results.getStringArrayList(speechRecognizer.RESULTS_RECOGNITION);
                //editText.setText(data.get(0));
                 //String Recognized_sentence = data.get(0);
                 //textView4.setText(data.get(0));
                convertedText = data.get(0).toLowerCase();
                diff = distance(sentence, convertedText);
               // textView1.setText(" " +diff);

                int p = sentence.length();
                int q = convertedText.length();

                String LCS = findLengthOfLCS(sentence, convertedText, p, q);
               // sampleTextView2.setText(LCS);

                String [] txt =LCS.split(" ");

                for(int r=0; r<txt.length;r++) {
                    searchWords.add(txt[r]);
                }

                // TextView sampleTextView = new TextView(currentContext); // currentContext = getContext();

                if (searchWords != null) {
                    Spannable newText = setSpanHighlight(sentence, searchWords);
                    textView2.setText(newText, TextView.BufferType.SPANNABLE);
                }
                else{
                    textView2.setText(sentence);
                }

                int lengthOfTranscript =sentence.length() ;
                int Result = (lengthOfTranscript - diff) *100 /lengthOfTranscript;

                if(Result >=0){
                    Result = Result;
                }
                else{
                    Result=0;
                }
                textView3.setText(" Accuracy :" +Result +"%");

            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT);
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT);
            }
        }
    }

    public String findLengthOfLCS(String str1, String str2, int p, int q) {

        // create a matrix which act as a table for LCS
        int[][] tableForLCS = new int[p + 1][q + 1];

        // fill the table in the bottom up way
        for (int i = 0; i <= p; i++) {
            for (int j = 0; j <= q; j++) {
                if (i == 0 || j == 0)
                    tableForLCS[i][j] = 0;  // Fill each cell corresponding to first row and first column with 0
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    tableForLCS[i][j] = tableForLCS[i - 1][j - 1] + 1;  // add 1 in the cell of the previous row and column and fill the current cell with it
                else
                    tableForLCS[i][j] = Math.max(tableForLCS[i - 1][j], tableForLCS[i][j - 1]); //find the maximum value from the cell of the previous row and current column and the cell of the current row and previous column
            }
        }

        int index = tableForLCS[p][q];
        int temp = index;

        char[] longestCommonSubsequence = new char[index + 1];
        longestCommonSubsequence[index] = '\0';

        int i = p, j = q;
        String lcs ="";
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                longestCommonSubsequence[index - 1] = str1.charAt(i - 1);
                i--;
                j--;
                index--;
            }
            else if (tableForLCS[i - 1][j] > tableForLCS[i][j - 1])
                i--;
            else
                j--;
        }

        for (int k = 0; k <= temp; k++)
            lcs = lcs + longestCommonSubsequence[k];

        return lcs;
    }

    private Spannable setSpanHighlight(String text, @NonNull ArrayList<String> searchWord) {
        Spannable newText = new SpannableString(text);

        if (searchWord.size() != 0) {
            for (String word : searchWord){
                if (text.contains(word)){
                    int beginIndex = text.indexOf(String.valueOf(word)); //Unnecessary 'String.valueOf()' call => if you have something else than String
                    int endIndex = beginIndex + word.length();

                    newText.setSpan(
                            new ForegroundColorSpan(Color.BLUE),
                            beginIndex,
                            endIndex,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }

            }
        }
        return newText;
    }


}