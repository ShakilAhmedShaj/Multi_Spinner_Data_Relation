package com.decima.lab.mspinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    // these are the global variables
    Spinner classSpinner, divSpinner;
    // string variable to store selected values
    String selectedClass, selectedDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classSpinner = (Spinner) findViewById(R.id.classSpinner);
        divSpinner = (Spinner) findViewById(R.id.divSpinner);

        // Class Spinner implementing onItemSelectedListener
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedClass = parent.getItemAtPosition(position).toString();
                switch (selectedClass) {

                    case "Khulna":
                        // assigning div item list defined in XML to the div Spinner
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_khulna)));
                        break;

                    case "Dhaka":
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_dhaka)));
                        break;

                }

//                Toast.makeText(MainActivity.this, "Class "+selectedClass, Toast.LENGTH_SHORT).show();

                //set divSpinner Visibility to Visible
                divSpinner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }
        });

        // Div Spinner implementing onItemSelectedListener
        divSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedDiv = parent.getItemAtPosition(position).toString();
                /*
                    Now that we have both values, lets create a Toast to
                    show the values on screen
                */
                Toast.makeText(MainActivity.this, "\n Class: \t " + selectedClass +
                        "\n Div: \t" + selectedDiv, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }

        });
    }
}