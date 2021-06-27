package com.training.trainingdealine.service;

import com.training.trainingdealine.entity.HomeEntity;
import com.training.trainingdealine.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl{

    @Autowired
    private HomeRepository homeRepository;

//    public HomeService(HomeRepository homeRepository) {
//        this.homeRepository = homeRepository;
//    }

    public List<HomeEntity> listAll() {
        return homeRepository.findAll();
    }

    public void save(HomeEntity homeEntity) {
        homeRepository.save(homeEntity);
    }

    public HomeEntity get(Long Id) {
        return homeRepository.findById(Id).get();
    }

    public void delete(Long id) {
        homeRepository.deleteById(id);
    }

    public void search(Long id) {
        homeRepository.findById(id);
    }
}
