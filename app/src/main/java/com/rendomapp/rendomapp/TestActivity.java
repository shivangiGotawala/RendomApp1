package com.rendomapp.rendomapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TextView tvOne = findViewById(R.id.tv_one);
        TextView tvTwo = findViewById(R.id.tv_two);
        TextView tvMatch = findViewById(R.id.tv_match);

        if (tvTwo.length() > tvOne.length()) {
            tvMatch.setText("two is greater than one");
        } else {
            tvMatch.setText("one is greater than two");
        }
    }
}
