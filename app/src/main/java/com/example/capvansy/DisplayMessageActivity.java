package com.example.capvansy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String sy = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String sy1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String sy2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        String sy3 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        String sy4 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE4);
        String state = intent.getStringExtra(MainActivity.EXTRA_MESSAGE5);
        String state1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE6);
        String state2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE7);
        String dateTime = intent.getStringExtra(MainActivity.EXTRA_MESSAGE8);



        TextView address = findViewById(R.id.address);
        TextView furniture = findViewById(R.id.furniture);
        TextView price = findViewById(R.id.price);
        TextView bedroom = findViewById(R.id.bedroom);
        TextView propertyname = findViewById(R.id.propertyname);
        TextView type = findViewById(R.id.type);
        TextView reporter = findViewById(R.id.reporter);
        TextView note = findViewById(R.id.note);
        TextView textView18 = findViewById(R.id.textView18);



        propertyname.setText(sy);
        address.setText(state1);
        price.setText(sy1);
        bedroom.setText(sy2);
        furniture.setText(state2);
        type.setText(state);
        reporter.setText(sy4);
        note.setText(sy3);
        textView18.setText(dateTime);
    }
}