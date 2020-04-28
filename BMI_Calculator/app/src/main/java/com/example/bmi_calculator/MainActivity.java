//Allen Andrews and Brian Tran
package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning components to variables
        final Button button_calc = (Button) findViewById(R.id.button_calc);
        final Button button_advice = (Button) findViewById(R.id.button_advice);
        final RadioGroup unitsGroup = (RadioGroup) findViewById(R.id.unitsGroup);
        final RadioButton metricButton = (RadioButton) findViewById(R.id.metricButton);
        final RadioButton englishButton = (RadioButton) findViewById(R.id.englishButton);
        final EditText field_weight = (EditText) findViewById(R.id.field_Weight);
        final EditText field_height = (EditText) findViewById(R.id.field_Height);
        final TextView view_result = (TextView) findViewById(R.id.view_result);
        final TextView view_msg = (TextView) findViewById(R.id.view_msg);

        metricButton.setChecked(true);

        //Changing hint text based on metric vs english units
        metricButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                field_weight.setHint("Enter in kg");
                field_height.setHint("Enter in m");
            }
        });

        englishButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                field_weight.setHint("Enter in lbs");
                field_height.setHint("Enter in inches");
            }
        });


        //Calculating BMI on button press
        button_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weight;
                double height;
                double bmi = 0;
                String m = "";

                if(field_height.getText().toString().equals("") || field_weight.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "Missing values for height or weight", Toast.LENGTH_LONG).show();

                }else{

                    weight = Double.parseDouble(field_weight.getText().toString());
                    height = Double.parseDouble(field_height.getText().toString());

                    if (englishButton.isChecked()) {
                        bmi = (weight * 703) / (height * height);
                        bmi = Math.round(bmi * 100.0) / 100.0;
                    } else if (metricButton.isChecked()) {
                        bmi = (weight) / (height * height);
                        bmi = Math.round(bmi * 100.0) / 100.0;
                    }

                    view_result.setText(String.valueOf(bmi));

                    if (bmi < 18.5) {
                        m = "Underweight";
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        m = "Normal";
                    } else if (bmi >= 25 && bmi <= 29.9) {
                        m = "Overweight";
                    } else if (bmi >= 30) {
                        m = "Obese";
                    }

                    view_msg.setText(m);

                }


            }
        });


        //Creating new activity for advice on button press
        button_advice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if(view_msg.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "Calculate BMI first", Toast.LENGTH_LONG).show();

                }else {

                    Intent adviceActivity = new Intent(MainActivity.this, AdviceActivity.class);
                    adviceActivity.putExtra("Health_Level", view_msg.getText().toString());
                    startActivity(adviceActivity);
                }
            }
        });

    }
}
