package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;


public class DataSaver implements SaveDataService {

    @Override
    public void saveDataToDB(List<Binance> binanceList) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Binance.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            binanceList.stream()
                    .forEach(binance -> session.save(binance));

            session.getTransaction().commit();

            System.out.println("Данные успешно сохранены в базе данных");
        } finally {
            factory.close();
        }
    }

    @Override
    public void serializerData(Binance dataToSerialize) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\baskerov\\Downloads\\Hibernate\\currencies.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(dataToSerialize);

        } catch (FileNotFoundException e) {
            System.out.println("При сериализации произошла ошибка файл не найден");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("При сериализации произошла ошибка");
            e.printStackTrace();
        }
    }
}
