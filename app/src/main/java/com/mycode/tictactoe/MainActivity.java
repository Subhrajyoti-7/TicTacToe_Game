package com.mycode.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    TextView textView;
    ImageView restart;
    int flag = 1;
    int count = 0;
    boolean lock = true;    // After win no input will allowed

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restart = findViewById(R.id.restart);
        restart.setOnClickListener(v -> restart());

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);

        textView = findViewById(R.id.textViewResult);
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view) {
        Button button = (Button) view;

        if (button.getText().toString().equals("") && lock) {
            count++;

            // Alternating Players
            if (flag == 1) {
                button.setText("X");
                flag = 0;
            } else {
                button.setText("O");
                flag = 1;
            }

            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();

            // Checking winning condition
            if (count >= 5) {
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    Toast.makeText(this, b1 + " wins", Toast.LENGTH_SHORT).show();
                    textView.setText(b1 + " wins");
                    lock = false;
                    reset();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    Toast.makeText(this, b4 + " wins", Toast.LENGTH_SHORT).show();
                    textView.setText(b4 + " wins");
                    lock = false;
                    reset();
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    Toast.makeText(this, b7 + " wins", Toast.LENGTH_SHORT).show();
                    textView.setText(b7 + " wins");
                    lock = false;
                    reset();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    Toast.makeText(this, b1 + " wins", Toast.LENGTH_SHORT).show();
                    textView.setText(b1 + " wins");
                    lock = false;
                    reset();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    Toast.makeText(this, b2 + " wins", Toast.LENGTH_SHORT).show();
                    textView.setText(b2 + " wins");
                    lock = false;
                    reset();
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    Toast.makeText(this, b3 + " wins", Toast.LENGTH_SHORT).show();
                    textView.setText(b3 + " wins");
                    lock = false;
                    reset();
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    Toast.makeText(this, b1 + " wins", Toast.LENGTH_SHORT).show();
                    textView.setText(b1 + " wins");
                    lock = false;
                    reset();
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    Toast.makeText(this, b3 + " wins", Toast.LENGTH_SHORT).show();
                    textView.setText(b3 + " wins");
                    lock = false;
                    reset();
                } else if (count >= 9) {
                    Toast.makeText(this, "Match Drawn", Toast.LENGTH_SHORT).show();
                    textView.setTextSize(45);
                    textView.setPadding(0, 60,0,100);
                    textView.setText("Match Drawn");
                    reset();
                }
            }
        }
    }

    public void restart() {

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        count = 0;
        lock = true;
    }

    public void reset() {

        new Handler().postDelayed(() -> {

            textView.setText("");
            textView.setTextSize(70);
            textView.setPadding(0,0,0,50);

            btn1.setText("");
            btn2.setText("");
            btn3.setText("");
            btn4.setText("");
            btn5.setText("");
            btn6.setText("");
            btn7.setText("");
            btn8.setText("");
            btn9.setText("");

            count = 0;
            lock = true;
        }, 3000);
    }
}