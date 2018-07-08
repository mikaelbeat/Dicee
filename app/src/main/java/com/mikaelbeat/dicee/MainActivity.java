package com.mikaelbeat.dicee;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    
    MediaPlayer backgroundMusic;
    MediaPlayer rollButtonSound;
    MediaPlayer doubleNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundMusic = MediaPlayer.create(getApplicationContext(),R.raw.bluegrass);
        backgroundMusic.start();

        rollButtonSound = MediaPlayer.create(getApplicationContext(),R.raw.money);

        doubleNumbers = MediaPlayer.create(getApplicationContext(), R.raw.fanfare);

        Button rollButton;
        rollButton = findViewById(R.id.rollbutton);

        final ImageView leftDice = findViewById(R.id.image_left_dice);
        final ImageView rightDice = findViewById(R.id.image_right_dice);

       final int[] diceArray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rollButtonSound.start();

                Log.d("Dicee","The  button has been pressed");

                Random randomNumberGenerator = new Random();

                int leftDiceNumber = randomNumberGenerator.nextInt(6);
                int rightDiceNumber = randomNumberGenerator.nextInt(6);

                if ((leftDiceNumber) == (rightDiceNumber)){
                    doubleNumbers.start();
                }

                Log.d("Dicee", "The random number in left dice is: " + leftDiceNumber);
                Log.d("Dicee", "The random number in right dice is: " + rightDiceNumber);

                leftDice.setImageResource(diceArray[leftDiceNumber]);
                rightDice.setImageResource(diceArray[rightDiceNumber]);

            }
        });

    }

    @Override
    protected void onPause(){
        super.onPause();
        backgroundMusic.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        backgroundMusic.start();
    }

}