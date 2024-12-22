package com.example.quadraticequatioinsolverapp.model;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticequatioinsolverapp.databinding.ActivityMainBinding;

public class Equation extends BaseObservable {
    private String aSide;
    private String bSide;
    private String cSide;
    ActivityMainBinding binding;

    public Equation(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public Equation() {
    }

    @Bindable
    public String getaSide() {
        return aSide;
    }

    public void setaSide(String aSide) {
        this.aSide = aSide;

    }

    @Bindable
    public String getbSide() {
        return bSide;
    }

    public void setbSide(String bSide) {
        this.bSide = bSide;
    }

    @Bindable
    public String getcSide() {
        return cSide;
    }

    public void setcSide(String cSide) {
        this.cSide = cSide;
    }

    public void solveEquation(View view) {
        //Convert Strings to integer
        int a = Integer.parseInt(getaSide());
        int b = Integer.parseInt(getbSide());
        int c = Integer.parseInt(getcSide());

        //Calculate the Discriminant
        double discriminant = b * b - 4 * a * c;

        double firstX, secondX;
        if (discriminant > 0) {
            // Two real distinct roots
            firstX = (-b + Math.sqrt(discriminant)) / a * a;
            secondX = (-b - Math.sqrt(discriminant)) / a * a;

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
