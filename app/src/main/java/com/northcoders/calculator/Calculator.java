package com.northcoders.calculator;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Calculator extends BaseObservable {

    private int a;
    private int b;
    private int result;

    public Calculator(int a, int b, int result) {
        this.a = 0;
        this.b = 0;
        this.result = 0;
    }

    public Calculator() {
    }

    @Bindable
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
        notifyPropertyChanged(BR.a);
    }

    @Bindable
    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
        notifyPropertyChanged(BR.b);
    }

    @Bindable
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    public void add() {
        setResult(a + b);
    }

    public void minus() {
        setResult(a - b);
    }

    public void divide() {
        setResult(a / b);
    }

    public void multiply() {
        setResult(a * b);
    }

    public void reset() {
        setA(0);
        setB(0);
        setResult(0);
    }

}
