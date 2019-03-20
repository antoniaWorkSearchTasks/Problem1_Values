package com.exercisel.pages;

import com.exercisel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPage {
    public CalculatorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(),'Value')]")
    public List<WebElement> valuesTexts;

    @FindBy(id = "txt_val_1")
    public WebElement value1Number;

    @FindBy(id = "txt_val_2")
    public WebElement value2Number;

    @FindBy(id = "txt_val_4")
    public WebElement value3Number;

    @FindBy(id = "txt_val_5")
    public WebElement value4Number;

    @FindBy(id = "txt_val_6")
    public WebElement value5Number;

    @FindBy(id = "txt_tti_val")
    public WebElement TotalBalance;
}
