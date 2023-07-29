package org.example.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotepadWriter {
    public static final String filePath ="E:\\JobOffers\\OfferList.txt";

    public static void writeOffersIntoFile(List<String> offerUrls) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String element : offerUrls) {
                writer.write(element);
                writer.newLine();
            }
            System.out.println("Файл успешно перезаписан.");
        } catch (IOException e) {
            System.err.println("Ошибка при перезаписи файла: " + filePath);
            e.printStackTrace();
        }
    }
}
