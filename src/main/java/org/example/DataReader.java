package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DataReader implements ReadDataService {

    @Override
    public void readData() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Binance.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        List<Binance> binanceList = null;

        try {
            session.beginTransaction();

            Query<Binance> query = session.createQuery("FROM Binance", Binance.class);

            binanceList = query.getResultList();

            session.getTransaction().commit();

            System.out.println("Данные успешно взяты из бд");
        } finally {
            factory.close();
        }

        System.out.println(binanceList);
    }

    @Override
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



