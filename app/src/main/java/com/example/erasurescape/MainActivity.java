package com.example.erasurescape;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     Button testButton;
     MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate button object
        testButton = (Button) findViewById(R.id.testButton);
        wordButtonAddOnClick(testButton);

        //instantiate mediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.pc_says);

    }

    public void wordButtonAddOnClick(Button button){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                testButton.setText("");
                mediaPlayer.start();
            }
        });
    }
}


