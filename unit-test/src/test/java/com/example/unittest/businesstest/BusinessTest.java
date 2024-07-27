package com.example.unittest.businesstest;

import com.example.unittest.business.BusinessImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BusinessTest {
    @Test
    public void calculateSumTestExpected(){
        BusinessImpl business = new BusinessImpl();
        int[] arr = {1, 2, 3, 4};
        int actualSum = business.calculateSum(arr);
        int expectedSum = 10;
        assertEquals(actualSum, expectedSum);
    }

    @Test
    public void calculateSumTestNotExpected(){
        BusinessImpl business = new BusinessImpl();
        int[] arr = {1, 2, 3, 4};
        int actualSum = business.calculateSum(arr);
        int expectedSum = 11;
        assertNotEquals(actualSum, expectedSum);
    }

    @Test
    public void calculateSumTestEmptyArray(){
        BusinessImpl business = new BusinessImpl();
        int[] arr = {};
        int actualSum = business.calculateSum(arr);
        int expectedSum = 0;
        assertEquals(actualSum, expectedSum);
    }
}
