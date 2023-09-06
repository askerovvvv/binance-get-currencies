package org.example;

import java.util.List;

public interface ReadDataService {
    void readData();
    List<Binance> deserializeData();
}
