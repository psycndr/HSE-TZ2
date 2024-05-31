import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import java.util.Random;
import java.util.ArrayList;

public class NumberOperationsTest {

    @Test
    public void testMin() {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 4);
        assertEquals(1, NumberOperations.getMin(numbers));

        // Test with negative numbers
        numbers = Arrays.asList(-3, -5, -1, -2, -4);
        assertEquals(-5, NumberOperations.getMin(numbers));

        // Test with mixed numbers
        numbers = Arrays.asList(-3, 5, -1, 2, -4);
        assertEquals(-4, NumberOperations.getMin(numbers));

        // Test with single number
        numbers = Arrays.asList(42);
        assertEquals(42, NumberOperations.getMin(numbers));

        // Test with large numbers
        numbers = Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        assertEquals(Integer.MIN_VALUE, NumberOperations.getMin(numbers));
    }

    @Test
    public void testMax() {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 4);
        assertEquals(5, NumberOperations.getMax(numbers));

        // Test with negative numbers
        numbers = Arrays.asList(-3, -5, -1, -2, -4);
        assertEquals(-1, NumberOperations.getMax(numbers));

        // Test with mixed numbers
        numbers = Arrays.asList(-3, 5, -1, 2, -4);
        assertEquals(5, NumberOperations.getMax(numbers));

        // Test with single number
        numbers = Arrays.asList(42);
        assertEquals(42, NumberOperations.getMax(numbers));

        // Test with large numbers
        numbers = Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        assertEquals(Integer.MAX_VALUE, NumberOperations.getMax(numbers));
    }

    @Test
    public void testSum() {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 4);
        assertEquals(15, NumberOperations.getSum(numbers));

        // Test with negative numbers
        numbers = Arrays.asList(-3, -5, -1, -2, -4);
        assertEquals(-15, NumberOperations.getSum(numbers));

        // Test with mixed numbers
        numbers = Arrays.asList(-3, 5, -1, 2, -4);
        assertEquals(-1, NumberOperations.getSum(numbers));

        // Test with single number
        numbers = Arrays.asList(42);
        assertEquals(42, NumberOperations.getSum(numbers));

        // Test with large numbers
        numbers = Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        assertEquals(-1, NumberOperations.getSum(numbers));
    }

    @Test
    public void testMult() {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 4);
        assertEquals(120, NumberOperations.getMult(numbers));

        // Test with negative numbers
        numbers = Arrays.asList(-3, -5, -1, -2, -4);
        assertEquals(-120, NumberOperations.getMult(numbers));

        // Test with mixed numbers
        numbers = Arrays.asList(-3, 5, -1, 2, -4);
        assertEquals(-120, NumberOperations.getMult(numbers));

        // Test with single number
        numbers = Arrays.asList(42);
        assertEquals(42, NumberOperations.getMult(numbers));
    }

    @Test
    public void testReadNumbersFromFile() {
        // Test reading numbers from file
        List<Integer> numbers = NumberOperations.readNumbersFromFile("test_numbers.txt");
        List<Integer> excepted = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(excepted, numbers);
    }

    @Test
    public void testPerformance() {
        int[] sizes = {5000, 10000, 100000, 500000, 1000000, 5000000, 10000000, 50000000, 100000000, 250000000, 500000000};

        for (int size : sizes) {
            List<Integer> numbers = generateLargeList(size);

            long startTime, endTime;

            // Measure time for min
            startTime = System.currentTimeMillis();
            NumberOperations.getMin(numbers);
            endTime = System.currentTimeMillis();
            System.out.println("Size: " + size + ", Time for _min: " + (endTime - startTime) + " ms");

            // Measure time for max
            startTime = System.currentTimeMillis();
            NumberOperations.getMax(numbers);
            endTime = System.currentTimeMillis();
            System.out.println("Size: " + size + ", Time for _max: " + (endTime - startTime) + " ms");

            // Measure time for sum
            startTime = System.currentTimeMillis();
            NumberOperations.getSum(numbers);
            endTime = System.currentTimeMillis();
            System.out.println("Size: " + size + ", Time for _sum: " + (endTime - startTime) + " ms");

            // Measure time for mult
            startTime = System.currentTimeMillis();
            NumberOperations.getMult(numbers);
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
