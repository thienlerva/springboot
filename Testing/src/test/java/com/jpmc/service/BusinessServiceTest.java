package com.jpmc.service;

import com.jpmc.repository.DataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceTest {

    @Mock
    DataRepository dataServiceMock;

    @InjectMocks
    BusinessService businessImpl;

    @Test
    public void shouldFindTheGreatestFromAllData() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,14,3});
        assertThat(businessImpl.findTheGreatestFromAllData(), is(24));
    }

}