package com.example.firstprogram;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class RandomNumberActivity extends AppCompatActivity {

    TextView tvNumber;
    Button btnRandom;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number); // phải khớp với tên layout

        tvNumber = findViewById(R.id.tvNumber);
        btnRandom = findViewById(R.id.btnRandom);

        btnRandom.setOnClickListener(v -> {
            int number = random.nextInt(100); // random 0–99
            tvNumber.setText(String.valueOf(number));
        });
    }
}
