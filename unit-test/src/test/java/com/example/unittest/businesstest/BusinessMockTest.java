package com.example.unittest.businesstest;

import com.example.unittest.business.BusinessImpl;
import com.example.unittest.business.DataService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BusinessMockTest {

    @InjectMocks
    BusinessImpl business;
    @Mock
    DataService dataServiceMock;


    @Test
    public void calculateSumUsingDataServiceTestExpected(){

        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{1, 3, 4, 2});

        int actualSum = business.calculateSumUsingDataService();
        int expectedSum = 10;
        assertEquals(actualSum, expectedSum);
    }

    @Test
    public void calculateSumTestNotExpected(){

        when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1, 2, 3, 4});

        int actualSum = business.calculateSumUsingDataService();
        int expectedSum = 11;
        assertNotEquals(actualSum, expectedSum);
    }

    @Test
    public void calculateSumTestEmptyArray(){

        when(dataServiceMock.retriveAllData()).thenReturn(new int[] {});

        int actualSum = business.calculateSumUsingDataService();
        int expectedSum = 0;
        assertEquals(actualSum, expectedSum);
    }
}
