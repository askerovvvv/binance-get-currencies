package org.example;

import java.util.List;

public interface SaveDataService {
    void saveDataToDB(List<Binance> binanceList);
    void serializerData(Binance dataToSerialize);
}
