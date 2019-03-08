package com.jpmc.service;

import org.springframework.stereotype.Service;

import java.util.AbstractList;

@Service
public class MyList extends AbstractList<String> {

    @Override
    public String get(final int index)
    {
        return null;
    }

    @Override
    public int size() {
        return 1;
    }
}
