import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BenchmarkWrite {

    public static void main(String[] args) {
        int[] sizes = {5000, 10000, 50000, 100000, 500000, 1000000, 5000000, 10000000, 50000000, 100000000, 250000000, 500000000};

        List<Long> timesSum = new ArrayList<>();

        for (int size : sizes) {
            List<Integer> numbers = generateLargeList(size);

            long startTime, endTime;
            // Measure time for _sum
            startTime = System.currentTimeMillis();
            NumberOperations.getSum(numbers);
            endTime = System.currentTimeMillis();
            timesSum.add(endTime - startTime);
        }

        writeResultsToFile(sizes, timesSum, "src/test/output/results.csv");
    }

    private static void writeResultsToFile(int[] sizes, List<Long> timesSum, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Write header
            writer.append("Size, TimeSum\n");

            // Write results for each size
            for (int i = 0; i < sizes.length; i++) {
                writer.append(String.valueOf(sizes[i]));
                writer.append(",");

                writer.append(String.valueOf(timesSum.get(i)));
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static List<Integer> generateLargeList(int size) {
        List<Integer> numbers = new ArrayList<>(size);
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            numbers.add(rand.nextInt(100) + 1);
        }
        return numbers;
    }
}