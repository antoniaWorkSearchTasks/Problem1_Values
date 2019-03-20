package com.exercisel.step_definitions;

import com.exercisel.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ValuesDefinitions {

    private Pages pages = new Pages();

    @Given("^Number of values should be \"([^\"]*)\"$")
    public void number_of_values_should_be(String arg1) {
        int NumberOfValues = Integer.parseInt(arg1);
        Assert.assertEquals(NumberOfValues, pages.calculatorPage().valuesTexts.size());
    }

    @Then("^Each value are greater than \"([^\"]*)\"$")
    public void each_value_are_greater_than(String arg1) {
        List<WebElement> valuesNumbers = new ArrayList<WebElement>();
        valuesNumbers.add(pages.calculatorPage().value1Number);
        valuesNumbers.add(pages.calculatorPage().value2Number);
        valuesNumbers.add(pages.calculatorPage().value3Number);
        valuesNumbers.add(pages.calculatorPage().value4Number);
        valuesNumbers.add(pages.calculatorPage().value5Number);
        for (WebElement valueNumber : valuesNumbers) {
            Assert.assertTrue(Double.parseDouble(valueNumber.getText().replace("$", "").replace(",", "")) > Double.parseDouble(arg1));
        }
    }

    @Then("^Total balance is correct$")
    public void total_balance_is_correct() {
        List<WebElement> valuesNumbers = new ArrayList<WebElement>();
        valuesNumbers.add(pages.calculatorPage().value1Number);
        valuesNumbers.add(pages.calculatorPage().value2Number);
        valuesNumbers.add(pages.calculatorPage().value3Number);
        valuesNumbers.add(pages.calculatorPage().value4Number);
        valuesNumbers.add(pages.calculatorPage().value5Number);
        double RealSumValues = 0.00;
        for (WebElement valueNumber : valuesNumbers) {
            RealSumValues += Double.parseDouble(valueNumber.getText().replace("$", "").replace(",", ""));
        }
        double delta = 0.01;
        Assert.assertEquals(RealSumValues, Double.parseDouble(pages.calculatorPage().TotalBalance.getText().replace("$", "").replace(",", "")), delta);
    }

    @Then("^Values are formated$")
    public void values_are_formated() {
        List<WebElement> numbersToCheck = new ArrayList<WebElement>();
        numbersToCheck.add(pages.calculatorPage().value1Number);
        numbersToCheck.add(pages.calculatorPage().value2Number);
        numbersToCheck.add(pages.calculatorPage().value3Number);
        numbersToCheck.add(pages.calculatorPage().value4Number);
        numbersToCheck.add(pages.calculatorPage().value5Number);
        numbersToCheck.add(pages.calculatorPage().TotalBalance);
        for (WebElement numberToCheck : numbersToCheck) {
            String textToCheck = numberToCheck.getText();
            Assert.assertTrue(isFormated(textToCheck));
        }
    }

    public static boolean isFormated(String number) {
        if (number.startsWith("$")) {
            number = number.substring(1);
        }
        if (number.startsWith("-")) {
            number = number.substring(1);
        }
        int lengthNumber = number.length();
        boolean formated = true;
        double doubleNumber = 0.0;
        if (number.startsWith("0") || number.startsWith(",")) {
            formated = false;
        }
        try {
            doubleNumber = Double.parseDouble(number.replace(",", ""));
        } catch (Exception e) {
            formated = false;
        }

        if (doubleNumber == 0.0) {
            formated = number.equals("0.00");
        } else if (lengthNumber <= 3 || number.charAt(lengthNumber - 3) != '.' || !number.contains(".") || !Character.isDigit(number.charAt(lengthNumber - 2)) || !Character.isDigit(number.charAt(lengthNumber - 1))) {
            formated = false;
        } else {
            String gigitsWithoutDot = number.substring(0, number.length() - 3);
            String[] allRestChars = gigitsWithoutDot.split("");
            int k = 3;
            for (int i = 0; i < allRestChars.length; i++) {
                if (i != k) {
                    if (!Character.isDigit(allRestChars[allRestChars.length - 1 - i].charAt(0))) {
                        formated = false;
                        break;
                    }
                } else {
                    if (!allRestChars[allRestChars.length - 1 - i].equals(",")) {
                        formated = false;
                        break;
                    }
                    k += 4;
                }
            }
        }
        return formated;
    }
}
