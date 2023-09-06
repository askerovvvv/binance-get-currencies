package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String uri = "https://www.binance.com/api/v3/ticker/price";
        JsonMapper jsonMapper = new JsonMapper();
//        DataBase dataBase = null;
        HttpClient client = new HttpClient();
        String data = client.getCurrentData(uri);

        List<Binance> list = jsonMapper.mapToJavaObject(data, 11, 15);




//        dataBase.readData();
    }
}