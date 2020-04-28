//Allen Andrews and Brian Tran
package com.example.bmi_calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AdviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);

        //Transferring BMI level through intent
        String health = getIntent().getStringExtra("Health_Level");
        if(health == null){
            health = "empty string";
        }

        //Assigning components to variables
        final TextView advice_title = (TextView) findViewById(R.id.advice_title);
        final TextView advice_text = (TextView) findViewById(R.id.advice_text);
        final ImageView bmi_image = (ImageView) findViewById(R.id.bmi_image);
        final Button backButton = (Button) findViewById(R.id.backButton);

        //Setting advice based on BMI level
        advice_title.setText(health);
        if(health.equals("Underweight")){
            advice_text.setText("You likely have a higher metabolism. Healthy ways to put on more weight include lifting weight and increasing calorie intake.");
            bmi_image.setImageResource(R.drawable.underweightpic);
        }
        else if(health.equals("Normal")){
            advice_text.setText("You are at a healthy bmi. No action should be taken");
            bmi_image.setImageResource(R.drawable.normalweightpic);
        }
        else if(health.equals("Overweight")){
            advice_text.setText("You are considered overweight. Healthy ways to bring down weight include moderately lowering calorie intake and doing cardio");
            bmi_image.setImageResource(R.drawable.overweightpic);
        }
        else if(health.equals("Obese")){
            advice_text.setText("You are considered obese. Healthy ways to bring down weight include lowering calories intake significantly and doing cardio");
            bmi_image.setImageResource(R.drawable.obesepic);
        }


        //Returning to main activity on back button click
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent mainActivity = new Intent(AdviceActivity.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });



    }
}
