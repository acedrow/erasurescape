package com.example.erasurescape;

import android.graphics.Paint;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.Button;
import android.widget.LinearLayout;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button testButton;
    MediaPlayer mediaPlayer;
    LinearLayout rootVertLayout; //the 'parent' linear layout, holds each horizontal linar layout representing a row of text
    ArrayList<TextRowLayout> textRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textRow = new ArrayList<TextRowLayout>();
        rootVertLayout = findViewById(R.id.rootVertLayout);

        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Aliquam nec aliquam ex. Morbi a vulputate turpis. " +
                "Pellentesque varius at purus non volutpat. " +
                "Vestibulum ante ipsum primis in faucibus orci " +
                "luctus et ultrices posuere cubilia Curae " +
                "Quisque turpis velit, dignissim eget malesuada nec, " +
                "blandit vel magna. Donec ornare aliquam porta.";

        Log.i("lorem ipsum length","" + loremIpsum.length());

        TextFormatter.formatText(loremIpsum, getScreenSize());

        //try programatically creating rows and buttons
        TextRowLayout testRow = createTextRowLayout(rootVertLayout);

        createWordButton("testbutton", testRow);
        createWordButton("button2", testRow);

        //instantiate mediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.pc_says);

        //testing some paint/typography
        //Paint paint = new Paint();
        //Paint.FontMetrics metrics = paint.getFontMetrics()

        Paint paint = new Paint();
        String text = "This";
        float tLength = paint.measureText(loremIpsum);
        Log.i("textLength", "" + tLength);


    }

    public TextRowLayout createTextRowLayout (LinearLayout textColumnLayout){
        TextRowLayout textRowLayout = new TextRowLayout(rootVertLayout, this);
        return textRowLayout;
    }

    //creates a word button programatically, should have this in its own class for good CODEZ
    public WordButton createWordButton(String buttonText, LinearLayout ll){
        WordButton wordButton = new WordButton(buttonText, ll, this);
        return wordButton;
    }

    public WordButton createWordButton(String buttonText, TextRowLayout textRowLayout){
        WordButton wordButton = new WordButton(buttonText, textRowLayout.getLinearLayout(), this);
        return wordButton;
    }

    public Point getScreenSize(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size;
    }
}


