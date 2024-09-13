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
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;

import com.northcoders.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    Calculator calculator = new Calculator();

    Button addButton;
    Button subtractButton;
    Button multiplyButton;
    Button divideButton;
    Button resetButton;

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

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        startButtonListeners();
        activityMainBinding.setCalculator(calculator);
    }

    public void startButtonListeners() {

        addButton = findViewById(R.id.button6);
        addButton.setOnClickListener(v -> {
            calculator.add();
        });

        subtractButton = findViewById(R.id.button7);
        subtractButton.setOnClickListener(v -> calculator.minus());

        multiplyButton = findViewById(R.id.button8);
        multiplyButton.setOnClickListener(v -> calculator.multiply());

        divideButton = findViewById(R.id.button9);
        divideButton.setOnClickListener(v -> calculator.divide());

        resetButton = findViewById(R.id.button10);
        resetButton.setOnClickListener(v -> calculator.reset());
    }
}