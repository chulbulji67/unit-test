package com.example.unittest.businesstest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);
    @Test
    public void returnSize(){

        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues(){

        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters(){
        when(mock.get(0)).thenReturn("1");
        assertEquals("1", mock.get(0));
    }

    @Test
    public void returnWithGenereicParameters(){
        when(mock.get(anyInt())).thenReturn("1");
        assertEquals("1", mock.get(1));
    }

    @Test
    public void verificationBasics(){
        //SUT
        String value1 = mock.get(0);
        String value = mock.get(1);

        //verify
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock , times(1)).get(0);

    }

    //Spy
    @Test
    public void spying(){
        List list = mock(ArrayList.class);

        list.get(0);
        list.size();
        list.add("Iest");
        list.add("Test 2");
        list.size();
        when(list.size()).thenReturn(2);
        assertEquals(2, list.size());
    }
}
