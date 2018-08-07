package com.example.a17045679.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1;
    Spinner spinner2;
    Button go;

    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        go = findViewById(R.id.Go);


        //Initialise the ArrayList
        alNumbers = new ArrayList<>();

        //Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter (this,android.R.layout.simple_spinner_dropdown_item, alNumbers);


        //Bind the ArrayList to the spinner
        spinner2.setAdapter(aaNumbers);


        //the spinner1 (the thing that control and move what's below)
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Category));
        spinnerArrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner1.setAdapter(spinnerArrayAdapter1);




        //Auto update the both Spinner
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i) {
                    case 0:
                        //Your code for item 1 selected
                        //Get the string-array and store as an Array
                        final String[] strNumbers = getResources().getStringArray(R.array.SubCategoryRP);
                        alNumbers.clear();
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        aaNumbers.notifyDataSetChanged();
                        break;
                    case 1:
                        //Your code for item 2 selected
                        //Get the string-array and store as an Array
                        final String[] strNumbers1 = getResources().getStringArray(R.array.SubCategorySOI);
                        alNumbers.clear();
                        alNumbers.addAll(Arrays.asList(strNumbers1));
                        aaNumbers.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bring over to Main2Activity Page
                Intent intent = new Intent(getBaseContext(), Main2Activity.class);
                intent.putExtra("Category", spinner1.getSelectedItemPosition());
                intent.putExtra("Site", spinner2.getSelectedItemPosition());
                startActivity(intent);

            }
        });




    }
}
