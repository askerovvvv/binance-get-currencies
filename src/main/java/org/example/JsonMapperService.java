package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface JsonMapperService {
    List<Binance> mapToJavaObject(String data, int from, int to);
}
