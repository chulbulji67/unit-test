package com.example.unittest.assertion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertTest {

    @Test
    void learning(){
        List<Integer> numbers = Arrays.asList(12, 14, 15);

        assertThat(numbers).hasSize(3);
        assertThat(numbers).contains(12);
    }
}
