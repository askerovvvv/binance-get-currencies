package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonMapper implements JsonMapperService{

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Binance> mapToJavaObject(String data, int from, int to) {
        List<Binance> binanceList = null;

        try {
            binanceList = mapper.readValue(data, new TypeReference<List<Binance>>(){});
        } catch (JsonMappingException e) {
            System.out.println("Не удалось прочитать данные с бд");
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            System.out.println("Не удалось прочитать данные с бд");
            e.printStackTrace();
        }

        return binanceList.subList(from, to);
    }
}
