package com.example.bmiprojectjava;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView BmiTextView;
    TextView resultTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        BmiTextView = findViewById(R.id.BmiTextView);
        resultTextView = findViewById(R.id.resultTextView);

        result();
    }

    public void result(){
        int weight = getIntent().getIntExtra("weight", 0);
        int height = getIntent().getIntExtra("height", 0);

        double Bmi = weight / Math.pow((height / 100.0),2.0);

        if(Bmi >= 35.0)
            resultTextView.setText("고도 비만");
        else if(Bmi >= 30.0)
            resultTextView.setText("중정도 비만");
        else if(Bmi >= 25.0)
            resultTextView.setText("경도 비만");
        else if(Bmi >= 23.0)
            resultTextView.setText("과체중");
        else if(Bmi >= 18.5)
            resultTextView.setText("정상체중");
        else
            resultTextView.setText("저체중");

        BmiTextView.setText(String.valueOf(Bmi));
    }
}
