package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DataDeserialize {

    public List<Binance> deserializeData() {
        List<Binance> binanceList = null;

        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\baskerov\\Downloads\\Hibernate\\currencies.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
             binanceList = (List<Binance>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("При десериализации произошла ошибка файл не найден");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("При десериализации произошла ошибка");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("При десериализации произошла ошибка файл не найден");
            e.printStackTrace();
        }

        return binanceList;
    }
}
