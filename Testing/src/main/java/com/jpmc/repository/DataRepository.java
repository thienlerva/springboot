package com.jpmc.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }


}
