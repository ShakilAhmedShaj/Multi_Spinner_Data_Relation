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
    Spinner divSpinner, citySpinner;
    // string variable to store selected values
    String selectedDivision, selectedCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        divSpinner = (Spinner) findViewById(R.id.classSpinner);
        citySpinner = (Spinner) findViewById(R.id.divSpinner);

        // Class Spinner implementing onItemSelectedListener
        divSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedDivision = parent.getItemAtPosition(position).toString();


                if (selectedDivision.equalsIgnoreCase("Select Division")) {


                } else if (selectedDivision.equalsIgnoreCase("Khulna")) {
                    citySpinner.setVisibility(View.VISIBLE);
                    citySpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.items_div_khulna)));

                }
            else if (selectedDivision.equalsIgnoreCase("Dhaka")) {
                citySpinner.setVisibility(View.GONE);

                    Toast.makeText(MainActivity.this, "Delivery to Dhaka is currently not Available", Toast.LENGTH_SHORT).show();
            }


//                Toast.makeText(MainActivity.this, "Class "+selectedDivision, Toast.LENGTH_SHORT).show();

                //set citySpinner Visibility to Visible
//                citySpinner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }
        });

        // Div Spinner implementing onItemSelectedListener
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCity = parent.getItemAtPosition(position).toString();
                /*
                    Now that we have both values, lets create a Toast to
                    show the values on screen
                */
                Toast.makeText(MainActivity.this, "Division: \t " + selectedDivision +
                        "\nCity: \t" + selectedCity, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }

        });
    }
}