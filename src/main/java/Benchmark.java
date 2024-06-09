import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Benchmark {
    public static void main(String[] args) {
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
