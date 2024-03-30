package com.example.rmp7773.Data.Layer.DataSource;

import com.example.rmp7773.Data.Layer.model.Rabbit;

import java.util.ArrayList;
import java.util.List;

public class RabbitDataSource{
    private List<Rabbit> rabbitList = new ArrayList<>();
    public RabbitDataSource() {
        rabbitList.add(new Rabbit("bob","black","15","3 years"));
        rabbitList.add(new Rabbit("tom","brown","21","6 years"));
        rabbitList.add(new Rabbit("rik","white","7","1 year"));
    }
    public List<Rabbit> getRabbits() {
        return rabbitList;
    }
    public void addRabbit(Rabbit rabbit) {
        rabbitList.add(rabbit);
    }
    public void deleteRabbit() {
        rabbitList.remove(rabbitList.size()-1);
    }
}