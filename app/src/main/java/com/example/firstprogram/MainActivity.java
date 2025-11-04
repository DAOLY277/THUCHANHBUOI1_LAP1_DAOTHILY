package com.example.firstprogram;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText edtNumber1, edtNumber2;
    TextView tvResult;
    Button btnAdd, btnSub, btnMul, btnDiv, btnMod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }

    private void initControl() {
        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnMod = findViewById(R.id.btnMod);

        btnAdd.setOnClickListener(v -> calculate('+'));
        btnSub.setOnClickListener(v -> calculate('-'));
        btnMul.setOnClickListener(v -> calculate('*'));
        btnDiv.setOnClickListener(v -> calculate('/'));
        btnMod.setOnClickListener(v -> calculate('%'));
    }

    private void calculate(char op) {
        String s1 = edtNumber1.getText().toString().trim();
        String s2 = edtNumber2.getText().toString().trim();

        if (s1.isEmpty() || s2.isEmpty()) {
            tvResult.setText("⚠️ Nhập đủ hai số!");
            return;
        }

        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        double result = 0;

        switch (op) {
            case '+': result = n1 + n2; break;
            case '-': result = n1 - n2; break;
            case '*': result = n1 * n2; break;
            case '/':
                if (n2 == 0) {
                    tvResult.setText("❌ Không thể chia cho 0!");
                    return;
                }
                result = n1 / n2;
                break;
            case '%': result = n1 % n2; break;
        }

        tvResult.setText("Kết quả: " + result);
    }
}
