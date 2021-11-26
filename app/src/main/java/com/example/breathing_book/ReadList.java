package com.example.breathing_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ReadList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_list);


        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("Exercise-01");
        list.add("Exercise-02");
        list.add("Exercise-03");
        list.add("Exercise-04");


        ArrayAdapter <String> arrayAdapter = new ArrayAdapter <>(this, android.R.layout.simple_expandable_list_item_1,list);


        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    //clicked apple

                    //startActivity(new Intent(ReadList.this,Read_Story.class));
                    String sentence = "a lion was once sleeping in the jungle when a mouse started running up ";
                    Intent intent = new Intent(ReadList.this,Read_Story.class);
                    intent.putExtra("keySentence", sentence);
                    startActivity(intent);

                }else if(position==1){
                    //clicked orange
                  //  startActivity(new Intent(MainActivity.this,OrangeActivity.class));

                    String sentence = "for a long time he lived in the toy cupboard or on the nursery floor ";
                    Intent intent = new Intent(ReadList.this,Read_Story.class);
                    intent.putExtra("keySentence", sentence);
                    startActivity(intent);


                }else if(position==2){

                    String sentence = "they lived with their mother in a sand bank ";
                    Intent intent = new Intent(ReadList.this,Read_Story.class);
                    intent.putExtra("keySentence", sentence);
                    startActivity(intent);
                    //For a long time he lived in the toy cupboard or on the nursery floor

                }else if(position==3){

                    String sentence = "as soon as he saw her the prince fell in love with the beautiful girl ";
                    Intent intent = new Intent(ReadList.this,Read_Story.class);
                    intent.putExtra("keySentence", sentence);
                    startActivity(intent);
                }

            }
        });

    }
}