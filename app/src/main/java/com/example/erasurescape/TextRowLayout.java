package com.example.erasurescape;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class TextRowLayout {
    LinearLayout linearLayout;

    public TextRowLayout(LinearLayout rootVertLayout, Context context){
        linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);

        //should add the newly created horizontal layout as a child of the root vertical layout
        if (rootVertLayout != null){
            rootVertLayout.addView(linearLayout);
        }
    }

    public LinearLayout getLinearLayout(){
        return linearLayout;
    }

    public void addWordButton(){

    }

}
