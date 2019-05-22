package com.example.erasurescape;

import android.graphics.Point;
import android.util.Log;
import android.view.Display;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFormatter {

    static int maxInputStringLength = 1000;

    //Given an input string (i.e. the entire text to be displayed on the screen before blacking any words out),
    //creates text rows, populates them with buttons containing each words, stores these in an array,
    //returns that array
    public static ArrayList<TextRowLayout> formatText(String text, Point screenDimensions){
        if (text.length() > maxInputStringLength){
            //throw exception? Need error handling...
            return null;
        }
        //split() string by whitespace, store in an arraylist
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(text.split(" ")));

        //trim() each substring, delete any array elements containing anything besides alphanumeric characters
        String wordNoUnderscore = "\\S*[a-zA-Z0-9]+\\S*";
        for (int i = 0; i < words.size(); i++){
            words.get(i).trim();
            if (!words.get(i).matches(wordNoUnderscore)){
                words.remove(words.get(i));
            }
            Log.i("Word " + i + ": ", words.get(i));
        }
        //create new row, add to array
        ArrayList<TextRowLayout> textRow = new ArrayList<TextRowLayout>();
        //create new button with next word in the text (separate by spaces, any punctuation included at the end of the word

        return textRow;
    }
}
