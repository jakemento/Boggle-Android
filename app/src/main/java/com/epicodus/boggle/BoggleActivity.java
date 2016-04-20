package com.epicodus.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BoggleActivity extends AppCompatActivity {
    private static final String TAG = BoggleActivity.class.getSimpleName();
    private String[] letters = new String [] {"a", "b","c", "d", "e", "f", "g", "h","i", "j", "k", "l", "m", "n", "o", "p", "q", "r","s", "t","u", "v", "w", "x", "y", "z"};
    List<String> wordList = Arrays.asList(letters);
    private ArrayList<String> shuffledArray = new ArrayList<String>();
    private ArrayList<String> wordArray = new ArrayList<String>();
    private TextView mDisplayLettersTextView;
    private EditText mUserWord;
    @Bind(R.id.submitAnswer) Button mSubmitAnswer;
    private List<String> stringArray;
    public int counter;
    private TextView mCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boggle);
        ButterKnife.bind(this);


        mDisplayLettersTextView = (TextView) findViewById(R.id.lettersArray);
        mCounter = (TextView) findViewById(R.id.counter);
        Collections.shuffle(wordList);
        for (int i=0; i < 8; i++)
        {   shuffledArray.add(letters[i]);
            Log.d(TAG, letters[i] );
            mDisplayLettersTextView.setText(TextUtils.join(" ", shuffledArray));

        }

        mUserWord = (EditText) findViewById(R.id.word);
        mSubmitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = mUserWord.getText().toString();
                stringArray = new ArrayList<>(Arrays.asList(word.split("")));
                stringArray.remove(0);
                //stringArray = mUserWord.toString().split(", ", mUserWord.length());
                Log.d(TAG, stringArray.toString());
                Log.d(TAG, shuffledArray.toString());
                counter = 0;


                for ( int i = 0; i < stringArray.size(); i++ ) {
                    for (int j = 0; j < shuffledArray.size(); j++)
                    {
                        if (stringArray.toArray()[i].equals(shuffledArray.toArray()[j]))  {
                            counter += 1;
                            Log.d(TAG, "yay");
                        } else {
                            Log.d(TAG, "boo");
                        }

                    }
            }
                mCounter.setText(String.valueOf(counter));
                    Log.d(TAG, counter + "");

            };




        });
    }
}

