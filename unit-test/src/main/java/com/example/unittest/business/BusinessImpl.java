package com.example.unittest.business;

import java.util.Arrays;

public class BusinessImpl {

    DataService dataService;

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public int calculateSum(int[] data){
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
//        int sum = 0;
//        for(int value: data){
//            sum+= value;
//        }
//        return sum;
    }
    public int calculateSumUsingDataService(){

        int[] data = dataService.retriveAllData();
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);

    }
}
