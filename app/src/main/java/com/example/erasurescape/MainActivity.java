package com.example.erasurescape;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Button testButton;
     MediaPlayer mediaPlayer;
     LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate the linearLayout as defined in activity_main.xml
        linearLayout = findViewById(R.id.rootContainer);

        //try programatically creating button
        createWordButton("button");

        //instantiate mediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.pc_says);

        //testing some paint/typography
        //Paint paint = new Paint();
        //Paint.FontMetrics metrics = paint.getFontMetrics()

        Paint paint = new Paint();
        String text = "This";
        float tLength = paint.measureText(text, 0, text.length());
        Log.i("textLength", "" + tLength);


    }

    //creates a word button programatically, should have this in its own class for good CODEZ
    public Button createWordButton(String buttonText){
        WordButton wordButton = new WordButton("button", linearLayout, this);
        /*

        button.setText(buttonText);
        button.setLayoutParams(new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setBackgroundColor(Color.WHITE);

        //set the onclicklistener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a toast is a small message popup
                Toast.makeText(MainActivity.this, R.string.welcome_message, Toast.LENGTH_LONG).show();
                testButton.setText("");
                mediaPlayer.start();

            }
        });
        //add the button to the linearLayout
        if (linearLayout != null){
            linearLayout.addView(button);
        }
        */
        return wordButton.getButton();
    }
}


