package com.example.unittest.businesstest;

import com.example.unittest.business.BusinessImpl;
import com.example.unittest.business.DataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class SomeDataServiceStub implements DataService{

    @Override
    public int[] retriveAllData() {
        return new int[] {1 , 2, 3, 4};
    }
}
public class BusinessStubTest {
    @Test
    public void calculateSumUsingDataServiceTestExpected(){
        BusinessImpl business = new BusinessImpl();
        business.setDataService(new SomeDataServiceStub());

        int actualSum = business.calculateSumUsingDataService();
        int expectedSum = 10;
        assertEquals(actualSum, expectedSum);
    }

    @Test
    public void calculateSumTestNotExpected(){
        BusinessImpl business = new BusinessImpl();

        int actualSum = business.calculateSumUsingDataService();
        int expectedSum = 11;
        assertNotEquals(actualSum, expectedSum);
    }

    @Test
    public void calculateSumTestEmptyArray(){
        BusinessImpl business = new BusinessImpl();

        int actualSum = business.calculateSumUsingDataService();
        int expectedSum = 0;
        assertEquals(actualSum, expectedSum);
    }
}
