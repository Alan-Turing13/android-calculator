package com.northcoders.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView inputBox1;
    TextView inputBox2;
    TextView outputBox;

    private int a;
    private int b;
    private int result;

    Button addButton;
    Button subtractButton;
    Button multiplyButton;
    Button divideButton;
    Button resetButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listeners();

        outputBox = findViewById(R.id.result_box);

        reset();

    }

    private void inputHandler() {

        inputBox1 = findViewById(R.id.number_a);
        String inputBoxOneData = String.valueOf(inputBox1).trim().replaceAll("[^0-9]", "");

        inputBox2 = findViewById(R.id.number_b);
        String inputBoxTwoData = String.valueOf(inputBox2).trim().replaceAll("[^0-9]", "");
    }

    private void add() {
        inputHandler();

        result = a + b;
        outputBox.setText(result);

    }

    private void minus() {
        inputHandler();

        result = a - b;
        outputBox.setText(result);
    }

    private void divide() {
        inputHandler();

        result = a / b;
        outputBox.setText(result);
    }

    private void multiply() {
        inputHandler();

        result = a * b;
        outputBox.setText(result);
    }

    private void listeners() {
        addButton = findViewById(R.id.button6);
        addButton.setOnClickListener(v -> {
            add();
        });

        subtractButton = findViewById(R.id.button7);
        subtractButton.setOnClickListener(v -> {
            minus();
        });

        multiplyButton = findViewById(R.id.button8);
        multiplyButton.setOnClickListener(v -> {
            multiply();
        });

        divideButton = findViewById(R.id.button9);
        divideButton.setOnClickListener(v -> {
            divide();
        });

        resetButton = findViewById(R.id.button10);
        resetButton.setOnClickListener(v -> {
            reset();
        });


    }

    private void reset() {
        outputBox.setText(result);

        a = 0;
        b = 0;
        result = 0;

    }
}