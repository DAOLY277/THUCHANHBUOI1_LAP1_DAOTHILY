package com.example.firstprogram;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;

public class DiceActivity extends AppCompatActivity {

    ImageView imgDice;
    Button btnRollDice;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        imgDice = findViewById(R.id.imgDice);
        btnRollDice = findViewById(R.id.btnRollDice);

        btnRollDice.setOnClickListener(v -> {
            // Animation xoay xúc xắc
            Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
            imgDice.startAnimation(rotate);

            // Sinh mặt xúc xắc ngẫu nhiên
            int number = random.nextInt(6) + 1;
            int resId = getResources().getIdentifier(
                    "dice_" + number, "drawable", getPackageName());
            imgDice.setImageResource(resId);
        });
    }
}
