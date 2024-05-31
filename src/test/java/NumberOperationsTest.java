import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import java.util.Random;
import java.util.ArrayList;

public class NumberOperationsTest {

    @Test
    public void testMin() {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 4);
        assertEquals(1, NumberOperations._min(numbers));

        // Test with negative numbers
        numbers = Arrays.asList(-3, -5, -1, -2, -4);
        assertEquals(-5, NumberOperations._min(numbers));

        // Test with mixed numbers
        numbers = Arrays.asList(-3, 5, -1, 2, -4);
        assertEquals(-4, NumberOperations._min(numbers));

        // Test with single number
        numbers = Arrays.asList(42);
        assertEquals(42, NumberOperations._min(numbers));

        // Test with large numbers
        numbers = Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        assertEquals(Integer.MIN_VALUE, NumberOperations._min(numbers));
    }

    @Test
    public void testMax() {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 4);
        assertEquals(5, NumberOperations._max(numbers));

        // Test with negative numbers
        numbers = Arrays.asList(-3, -5, -1, -2, -4);
        assertEquals(-1, NumberOperations._max(numbers));

        // Test with mixed numbers
        numbers = Arrays.asList(-3, 5, -1, 2, -4);
        assertEquals(5, NumberOperations._max(numbers));

        // Test with single number
        numbers = Arrays.asList(42);
        assertEquals(42, NumberOperations._max(numbers));

        // Test with large numbers
        numbers = Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        assertEquals(Integer.MAX_VALUE, NumberOperations._max(numbers));
    }

    @Test
    public void testSum() {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 4);
        assertEquals(15, NumberOperations._sum(numbers));

        // Test with negative numbers
        numbers = Arrays.asList(-3, -5, -1, -2, -4);
        assertEquals(-15, NumberOperations._sum(numbers));

        // Test with mixed numbers
        numbers = Arrays.asList(-3, 5, -1, 2, -4);
        assertEquals(-1, NumberOperations._sum(numbers));

        // Test with single number
        numbers = Arrays.asList(42);
        assertEquals(42, NumberOperations._sum(numbers));

        // Test with large numbers
        numbers = Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        assertEquals(-1, NumberOperations._sum(numbers));
    }

    @Test
    public void testMult() {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 4);
        assertEquals(120, NumberOperations._mult(numbers));

        // Test with negative numbers
        numbers = Arrays.asList(-3, -5, -1, -2, -4);
        assertEquals(-120, NumberOperations._mult(numbers));

        // Test with mixed numbers
        numbers = Arrays.asList(-3, 5, -1, 2, -4);
        assertEquals(120, NumberOperations._mult(numbers));

        // Test with single number
        numbers = Arrays.asList(42);
        assertEquals(42, NumberOperations._mult(numbers));

        // Test with large numbers
        numbers = Arrays.asList(1, -1, 1);
        assertEquals(-1, NumberOperations._mult(numbers));
    }

    @Test
    public void testMixedNumbers() {
        List<Integer> numbers = Arrays.asList(-3, 5, -1, 2, -4);
        assertEquals(-4, NumberOperations._min(numbers));
        assertEquals(5, NumberOperations._max(numbers));
        assertEquals(-1, NumberOperations._sum(numbers));
        assertEquals(-120, NumberOperations._mult(numbers));
    }

    @Test
    public void testPerformance() {
        int[] sizes = {1000, 10000, 100000, 500000, 1000000, 5000000, 10000000, 50000000, 100000000};

        for (int size : sizes) {
            List<Integer> numbers = generateLargeList(size);

            long startTime, endTime;

            // Measure time for min
            startTime = System.currentTimeMillis();
            NumberOperations._min(numbers);
            endTime = System.currentTimeMillis();
            System.out.println("Size: " + size + ", Time for _min: " + (endTime - startTime) + " ms");

            // Measure time for max
            startTime = System.currentTimeMillis();
            NumberOperations._max(numbers);
            endTime = System.currentTimeMillis();
            System.out.println("Size: " + size + ", Time for _max: " + (endTime - startTime) + " ms");

            // Measure time for sum
            startTime = System.currentTimeMillis();
            NumberOperations._sum(numbers);
            endTime = System.currentTimeMillis();
            System.out.println("Size: " + size + ", Time for _sum: " + (endTime - startTime) + " ms");

            // Measure time for mult
            startTime = System.currentTimeMillis();
            NumberOperations._mult(numbers);
            endTime = System.currentTimeMillis();
            System.out.println("Size: " + size + ", Time for _mult: " + (endTime - startTime) + " ms");
        }
    }

    // generator of large data sets
    private static List<Integer> generateLargeList(int size) {
        List<Integer> numbers = new ArrayList<>(size);
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            numbers.add(rand.nextInt(100) + 1);
        }
        return numbers;
    }
}
