package org.example;

import jakarta.persistence.*;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@Entity
@Table(name = "Currency")
public class Binance implements Externalizable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Currency name")
    private String symbol;
    @Column(name = "Currency value")
    private Double price;
    private static final Long SERIAL_VERSION_UID = 1L;

    public Binance() {
    }

    public Binance(String symbol, Double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Binance{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getSymbol());
        out.writeObject(this.getPrice());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        symbol = (String) in.readObject();
        price = (Double) in.readObject();
    }
}
