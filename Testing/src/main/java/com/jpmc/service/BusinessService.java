package com.jpmc.service;

import com.jpmc.repository.DataRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    DataRepository dataService;

    public BusinessService(DataRepository dataService) {
        this.dataService = dataService;
    }

    int findTheGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int greatest = Integer.MIN_VALUE;

        for(int value : data) {
            if (value > greatest) {
                greatest = value;
            }
        }
        return greatest;
    }
}
