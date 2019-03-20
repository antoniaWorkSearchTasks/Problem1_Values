package com.exercisel.utilities;

import com.exercisel.pages.CalculatorPage;

public class Pages {
    private CalculatorPage calculatorPage;

    public CalculatorPage calculatorPage() {
        if (calculatorPage == null) {
            calculatorPage = new CalculatorPage();
        }
        return calculatorPage;
    }
}


