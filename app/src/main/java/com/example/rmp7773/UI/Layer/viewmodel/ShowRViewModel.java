package com.example.rmp7773.UI.Layer.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rmp7773.Data.Layer.model.Rabbit;
import com.example.rmp7773.Data.Layer.DataSource.RabbitDataSource;
import com.example.rmp7773.Data.Layer.Repository.RabbitRepository;

public class ShowRViewModel extends ViewModel {
    private MutableLiveData<RabbitRepository> rabbitListLiveData = new MutableLiveData<>();
    public LiveData<RabbitRepository> getRabbitListLiveData() {
        return rabbitListLiveData;
    }
    public ShowRViewModel() {
        rabbitListLiveData.setValue(new RabbitRepository(new RabbitDataSource()));
    }
    public void addRabbitToList(String name,String color,String earlength,String age) {
        RabbitRepository rabbitRepository = rabbitListLiveData.getValue();
        if (rabbitRepository != null) {
            rabbitRepository.addRabbit(new Rabbit(name, color, earlength, age));
            rabbitListLiveData.setValue(rabbitRepository);
        }
    }
    public void deleteRabbitFromList() {
        RabbitRepository rabbitRepository = rabbitListLiveData.getValue();
        if (rabbitRepository != null) {
            rabbitRepository.deleteRabbit();
            rabbitListLiveData.setValue(rabbitRepository);
        }
    }
}