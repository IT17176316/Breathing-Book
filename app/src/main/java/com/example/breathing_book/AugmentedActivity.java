package com.example.breathing_book;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class AugmentedActivity extends AppCompatActivity {

    //EditText editText;
    TextView textView;
    ImageButton btn;
    TextToSpeech textToSpeech;
    String text;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_augmented);

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("Book");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                text = snapshot.child("text").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn = findViewById(R.id.playBtn);

        textToSpeech = new TextToSpeech(AugmentedActivity.this, new TextToSpeech.OnInitListener() {
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

                //convert text to speech
                textToSpeech.setSpeechRate(0.6f);
                textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
            }
        });



        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        value = value.toLowerCase();
        Button p1_button = (Button)findViewById(R.id.downloadBtn);

        //p1_button.setText("" + value + ".glb");


        FirebaseApp.initializeApp(this);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference modelRef = storage.getReference().child("" + value + ".glb");


        ArFragment arFragment = (ArFragment) getSupportFragmentManager()
                .findFragmentById(R.id.arFragment);
        //arFragment.getPlaneDiscoveryController().hide();
        //arFragment.getPlaneDiscoveryController().setInstructionView(null);
        findViewById(R.id.downloadBtn)
                .setOnClickListener(v -> {

                    try {
                        File file = File.createTempFile("+ value + ", "glb");

                        modelRef.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            @Override
                            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                                buildModel(file);

                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                });

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {

            AnchorNode anchorNode = new AnchorNode(hitResult.createAnchor());
            //anchorNode.setRenderable(renderable);
            anchorNode.setParent(arFragment.getArSceneView().getScene());
            //arFragment.getArSceneView().getScene().addChild(anchorNode);

            TransformableNode n = new TransformableNode(arFragment.getTransformationSystem());
            n.setRenderable(renderable);

            n.getScaleController().setMinScale(0.14f);
            n.getScaleController().setMaxScale(0.15f);



// Set Node's local scale before setting its Parent
            n.setLocalScale(new Vector3(1.23f, 1.23f, 1.23f));

            n.setParent(anchorNode);
            n.select();

            Node TitleNode = new Node();
            TitleNode.setParent(n);
            TitleNode.setEnabled(false);
            TitleNode.setLocalPosition(new Vector3(0.0f, 1.75f, 0.0f));
            
            ViewRenderable.builder()
                    .setView(this, R.layout.card_view)
                    .build()
                    .thenAccept(
                            (renderable) -> {

                                TitleNode.setRenderable(renderable);
                                TextView tv1 = (TextView) renderable.getView();
                                tv1.setText(text);
                                TitleNode.setEnabled(true);
                            })
                    .exceptionally(
                            (throwable) -> {
                                throw new AssertionError("Could not load card view.", throwable);
                            }
                    );
        });

    }

    //text to speech
    @Override
    protected void onPause() {
        if(textToSpeech!=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }

    private ModelRenderable renderable;


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void buildModel(File file) {


        RenderableSource renderableSource = RenderableSource
                .builder()
                .setSource(this, Uri.parse(file.getPath()), RenderableSource.SourceType.GLB)
                .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                .build();

        ModelRenderable
                .builder()
                .setSource(this, renderableSource)
                .setRegistryId(file.getPath())
                .build()
                .thenAccept(modelRenderable -> {
                    Toast.makeText(this, "Model built", Toast.LENGTH_SHORT).show();;
                    renderable = modelRenderable;
                });



    }


}


