package com.example.bmiprojectjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText heightEditText;

    EditText weightEditText;

    AppCompatButton resultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightEditText =
                findViewById(R.id.heightEditText);
        weightEditText =
                findViewById(R.id.weightEditText);
        resultButton =
                findViewById(R.id.resultButton);
        start();
    }

    public void start(){
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //빈 값 입력시 Toast 출력 후 onClick메소드 종료
                if(heightEditText.getText().toString().isEmpty() || weightEditText.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int height = Integer.parseInt(heightEditText.getText().toString());
                int weight = Integer.parseInt(weightEditText.getText().toString());
                //Log.d("MainActivity", String.format("%d %d", height,weight)); 값 확인

                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

                intent.putExtra("height",height);
                intent.putExtra("weight",weight);
                startActivity(intent);
            }
        });
    }
}