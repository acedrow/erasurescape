package com.example.erasurescape;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class WordButton {
    Button button;
    String buttonText;
    boolean erased = false;

    public WordButton(final String bt, LinearLayout linearLayout, Context context){
        button = new Button(context);
        this.buttonText = bt;
        button.setText(bt);
        button.setLayoutParams(new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setBackgroundColor(Color.WHITE);

        //set the onclicklistener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a toast is a small message popup
                //Toast.makeText(MainActivity.this, R.string.welcome_message, Toast.LENGTH_LONG).show();
                if (!erased){
                    erased = true;
                    button.setText("");
                } else {
                    erased = false;
                    button.setText(buttonText);
                }


                //mediaPlayer.start();

            }
        });
        //add the button to the linearLayout
        if (linearLayout != null){
            linearLayout.addView(button);
        }
    }

    public Button getButton(){
        return button;
    }

}
