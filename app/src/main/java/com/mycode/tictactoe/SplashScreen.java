package com.mycode.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textView = findViewById(R.id.textTitle);
        imageView = findViewById(R.id.hashSymbol);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.translate);
        textView.startAnimation(animation);
        imageView.startAnimation(animation1);

        Intent intent = new Intent(this, MainActivity.class);
        //  Lamda expression
        new Handler().postDelayed(() -> {
            startActivity(intent);
            finish();
        }, 5000);
    }
}