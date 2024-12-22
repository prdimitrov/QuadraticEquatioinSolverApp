package com.example.quadraticequatioinsolverapp.model;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticequatioinsolverapp.BR;
import com.example.quadraticequatioinsolverapp.databinding.ActivityMainBinding;

public class Equation extends BaseObservable {
    private String a;
    private String b;
    private String c;
    ActivityMainBinding binding;

    public Equation(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public Equation() {
    }

    public Equation(String a, String b, String c, ActivityMainBinding binding) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.binding = binding;
    }

    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
        notifyPropertyChanged(BR.a);
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
        notifyPropertyChanged(BR.b);
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
        notifyPropertyChanged(BR.c);
    }

    public void solveEquation(View view) {
        //Convert Strings to integer
        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        //Calculate the Discriminant
        double discriminant = b * b - 4 * a * c;

        double firstX, secondX;
        if (discriminant > 0) {
            // Two real distinct roots
            firstX = (-b + Math.sqrt(discriminant)) / (2 * a);
            secondX = (-b - Math.sqrt(discriminant)) / (2 * a);

            // Display the results in the textView
            binding.myTextView.setText("X1 = " + firstX + " X2 = " + secondX);
        } else if (discriminant < 0) {
            //No real roots
            binding.myTextView.setText("No real roots (complex roots)");
        } else {
            // One real solution (double root)
            firstX = -b / (2 * a);
            binding.myTextView.setText("X = " + firstX);
        }
    }
}
