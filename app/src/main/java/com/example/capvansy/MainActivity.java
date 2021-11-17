package com.example.capvansy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;


public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private  List<String> list;
    private  Spinner spinner1;
    private  List<String> list1;
    private  Spinner spinner2;
    private  List<String> list2;
    public static final String EXTRA_MESSAGE = "com.example.capvansy.MESSAGE";
    public static final String EXTRA_MESSAGE1 = "com.example.capvansy.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.capvansy.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.capvansy.MESSAGE3";
    public static final String EXTRA_MESSAGE4 = "com.example.capvansy.MESSAGE4";
    public static final String EXTRA_MESSAGE5 = "com.example.capvansy.MESSAGE5";
    public static final String EXTRA_MESSAGE6 = "com.example.capvansy.MESSAGE6";
    public static final String EXTRA_MESSAGE7 = "com.example.capvansy.MESSAGE7";
    public static final String EXTRA_MESSAGE8 = "com.example.capvansy.MESSAGE8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add("Select Type...");
        list.add("House");
        list.add("Flat");
        list.add("Bungalow");
        spinner = (Spinner) findViewById(R.id.id_spinner);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);

        spinner.setAdapter(spinnerAdapter);


        list1 = new ArrayList<>();
        list1.add("Select Address...");
        list1.add("HCM");
        list1.add("BRVT");
        list1.add("Nha Trang");
        list1.add("Bình Định");
        list1.add("Đồng nai");
        spinner1 = (Spinner) findViewById(R.id.id_spinner1);
        ArrayAdapter spinnerAdapter1 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list1);

        spinner1.setAdapter(spinnerAdapter1);

        list2 = new ArrayList<>();
        list2.add("Select Furniture...");
        list2.add("Furnished");
        list2.add("UnFurnished");
        spinner2 = (Spinner) findViewById(R.id.id_spinner2);
        ArrayAdapter spinnerAdapter2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list2);

        spinner2.setAdapter(spinnerAdapter2);

        // Get the button "btn_submit".
        Button btn_submit = (Button) findViewById(R.id.button);
        // Create a click event for the button "btn_submit".
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);


                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd-MMM-yyyy");
                String dateTime = simpleDateFormat.format(calendar.getTime());

                EditText PropertyName = (EditText) findViewById(R.id.PropertyName);
                EditText Price = (EditText) findViewById(R.id.Price);
                EditText Bedroom = (EditText) findViewById(R.id.Bedroom);
                EditText Note = (EditText) findViewById(R.id.Note);
                EditText Reporter = (EditText) findViewById(R.id.Reporter);





//

                // Get the content of the textbox.
                String sy = PropertyName.getText().toString();
                String sy1 = Price.getText().toString();
                String sy2 = Bedroom.getText().toString();
                String sy3 = Note.getText().toString();
                String sy4 = Reporter.getText().toString();


                String state = spinner.getSelectedItem().toString();
                String state1 = spinner1.getSelectedItem().toString();
                String state2 = spinner2.getSelectedItem().toString();

//                //show message if textbox invalid
                if (TextUtils.isEmpty(sy)){
                    PropertyName.setError("Please Enter PropertyName");
                }
                if (spinner.getSelectedItem() == "Select Type..."){
                    TextView errorTextview = (TextView) spinner.getSelectedView();
                    errorTextview.setError("Please Enter Type");
                    errorTextview.setTextColor(Color.RED);
                }
                if (spinner1.getSelectedItem() == "Select Address..."){
                    TextView errorTextview = (TextView) spinner1.getSelectedView();
                    errorTextview.setError("Please Enter Address");
                    errorTextview.setTextColor(Color.RED);
                }
                if (TextUtils.isEmpty(sy1)){
                    Price.setError("Please Enter Price");
                }
                if (TextUtils.isEmpty(sy2)){
                    Bedroom.setError("Please Enter Bedroom");
                }
                if (TextUtils.isEmpty(sy4)){
                    Reporter.setError("Please Enter Reporter");
                }
                else {
                    intent.putExtra(EXTRA_MESSAGE, sy);
                    intent.putExtra(EXTRA_MESSAGE1, sy1);
                    intent.putExtra(EXTRA_MESSAGE2, sy2);
                    intent.putExtra(EXTRA_MESSAGE3, sy3);
                    intent.putExtra(EXTRA_MESSAGE4, sy4);
                    intent.putExtra(EXTRA_MESSAGE5, state);
                    intent.putExtra(EXTRA_MESSAGE6, state1);
                    intent.putExtra(EXTRA_MESSAGE7, state2);
                    intent.putExtra(EXTRA_MESSAGE8, dateTime);

                    startActivity(intent);

                }

            }
        });
    }
}