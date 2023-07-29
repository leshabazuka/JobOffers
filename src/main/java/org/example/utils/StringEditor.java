package org.example.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringEditor {
    public static int getDaysFreshness(String rowText) {
        Pattern pattern = Pattern.compile("\\b\\d+\\b"); // Ищем одно или несколько цифр, окруженных границами слова
        Matcher matcher = pattern.matcher(rowText);

        return matcher.find()?Integer.parseInt(matcher.group()):0;
    }
}
