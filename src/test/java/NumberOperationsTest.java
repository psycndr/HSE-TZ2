import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

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
}
