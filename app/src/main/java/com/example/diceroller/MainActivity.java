package com.example.diceroller;

import static com.example.diceroller.R.drawable.dice1;
import static com.example.diceroller.R.drawable.dice2;
import static com.example.diceroller.R.drawable.dice3;
import static com.example.diceroller.R.drawable.dice4;
import static com.example.diceroller.R.drawable.dice5;
import static com.example.diceroller.R.drawable.dice6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TextView Number1,Number2,Calculation;
    CardView RollDice;
    ImageView Dice1,Dice2;

    int images[] = {dice1,dice2,dice3,dice4,dice5,dice6};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Number1 = findViewById(R.id.Number1);
        Number2 = findViewById(R.id.Number2);
        Calculation = findViewById(R.id.Calculation);
        RollDice = findViewById(R.id.RollDice);
        Dice1 = findViewById(R.id.Dice1);
        Dice2 = findViewById(R.id.Dice2);

        RollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                int num = random.nextInt(6);
                int num1 = random.nextInt(6);
                setDice1(num);
                setDice2(num1);
                Log.e(TAG, "onClick: =============="+num);
                Log.e(TAG, "onClick: =============="+num1);
                int calculate = num+num1;
                Log.e(TAG, "onClick: =============="+calculate);
                Calculation.setText("Calculation of two dice : "+(calculate+2));
            }
            private void setDice1(int num) {
                Dice1.setImageResource(images[num]);
                Number1.setText("Dice1 Number is : "+(num+1));
            }
            private void setDice2(int num1) {
                Dice2.setImageResource(images[num1]);
                Number2.setText("Dice2 Number is : "+(num1+1));
            }
        });
    }
}