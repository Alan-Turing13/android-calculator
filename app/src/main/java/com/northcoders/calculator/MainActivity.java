package com.northcoders.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        startButtonListeners();
        outputBox = findViewById(R.id.result_box);
    }

    private void startButtonListeners() {
        inputBox1 = findViewById(R.id.number_a);
        inputBox1.setOnClickListener(v -> {
                inputHandlerNumberA();
        });

        inputBox2 = findViewById(R.id.number_b);
        inputBox2.setOnClickListener(v -> {
                inputHandlerNumberB();
        });

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

    private int inputHandlerNumberA() {
        String inputBoxOneData = String.valueOf(inputBox1).trim().replaceAll("[^0-9]", "");
        return Integer.parseInt(inputBoxOneData);
    }

    private int inputHandlerNumberB() {
        String inputBoxTwoData = String.valueOf(inputBox2).trim().replaceAll("[^0-9]", "");
        return Integer.parseInt(inputBoxTwoData);
    }

    private void add() {
        result = a + b;
        outputBox.setText(result);
    }

    private void minus() {
        result = a - b;
        outputBox.setText(result);
    }

    private void divide() {
        result = a / b;
        outputBox.setText(result);
    }

    private void multiply() {
        result = a * b;
        outputBox.setText(result);
    }

    private void reset() {
        a = 0;
        b = 0;
        result = 0;
        outputBox.setText(result);
    }
}