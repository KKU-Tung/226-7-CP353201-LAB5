package sqa.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

import sqa.main.ShippingVehicle;

class CategoryPtest {
    ShippingVehicle shipcal = new ShippingVehicle();

    static Stream<Arguments> categoryPartitionInput() {
        return Stream.of(
            Arguments.of(0, 0, 0, Arrays.asList(0,0,0)),
            Arguments.of(500, 0, 0, Arrays.asList(0,0,500)),
            Arguments.of(0, 200, 0, Arrays.asList(0,200,0)),
            Arguments.of(0, 0, 100, Arrays.asList(100,0,0)),
            Arguments.of(499, 0, 0, Arrays.asList(0,0,499)),
            Arguments.of(0, 199, 0, Arrays.asList(0,199,0)),
            Arguments.of(0, 0, 99, Arrays.asList(99,0,0)),
            Arguments.of(497, 1, 0, Arrays.asList(0,1,497)),
            Arguments.of(0, 197, 1, Arrays.asList(1,197,0)),
            Arguments.of(0, 2, 98, Arrays.asList(98,2,0)),
            Arguments.of(10, 10, 80, Arrays.asList(80,10,10)),
            Arguments.of(-1, 0, 0, Arrays.asList(-1)),
            Arguments.of(0, -1, 0, Arrays.asList(-1)),
            Arguments.of(0, 0, -1, Arrays.asList(-1)),
            Arguments.of(-1, -1, 0, Arrays.asList(-1)),
            Arguments.of(0, -1,-1, Arrays.asList(-1)),
            Arguments.of(-1, 0, -1, Arrays.asList(-1)),
            Arguments.of(-1, -1, -1, Arrays.asList(-1)),
            Arguments.of(501, 0, 0, Arrays.asList(-1)),
            Arguments.of(0, 201, 0, Arrays.asList(-1)),
            Arguments.of(0, 0, 101, Arrays.asList(-1))
        );
    }

    @ParameterizedTest
    @MethodSource("categoryPartitionInput")
    void categoryPartitionTest(int smallSize, int mediumSize, int largeSize, List<Integer> expectedResult) {
        List<Integer> actual = shipcal.calculate(smallSize, mediumSize, largeSize);
        assertEquals(expectedResult, actual);
    }
}