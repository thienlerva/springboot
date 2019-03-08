package com.jpmc.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository {
    int[] retrieveAllData() ;


}
