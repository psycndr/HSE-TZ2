import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// Функция для записи данных об скорости выполнения всех функций
public class PerformanceTest {

    public static void main(String[] args) {
        int[] sizes = {10000, 100000, 500000, 1000000, 5000000, 10000000, 50000000, 100000000, 250000000, 500000000, 750000000, 1000000000};
        List<Long> timesMin = new ArrayList<>();
        List<Long> timesMax = new ArrayList<>();
        List<Long> timesSum = new ArrayList<>();
        List<Long> timesMult = new ArrayList<>();

        for (int size : sizes) {
            List<Integer> numbers = generateLargeList(size);

            long startTime, endTime;

            // Measure time for _min
            startTime = System.currentTimeMillis();
            NumberOperations._min(numbers);
            endTime = System.currentTimeMillis();
            timesMin.add(endTime - startTime);

            // Measure time for _max
            startTime = System.currentTimeMillis();
            NumberOperations._max(numbers);
            endTime = System.currentTimeMillis();
            timesMax.add(endTime - startTime);

            // Measure time for _sum
            startTime = System.currentTimeMillis();
            NumberOperations._sum(numbers);
            endTime = System.currentTimeMillis();
            timesSum.add(endTime - startTime);

            // Measure time for _mult
            startTime = System.currentTimeMillis();
            NumberOperations._mult(numbers);
            endTime = System.currentTimeMillis();
            timesMult.add(endTime - startTime);
        }

        writeResultsToFile(sizes, timesMin, timesMax, timesSum, timesMult, "src/test/output/results.csv");
    }

    private static void writeResultsToFile(int[] sizes, List<Long> timesMin, List<Long> timesMax, List<Long> timesSum, List<Long> timesMult, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Write header
            writer.append("Size,TimeMin,TimeMax,TimeSum,TimeMult\n");

            // Write results for each size
            for (int i = 0; i < sizes.length; i++) {
                writer.append(String.valueOf(sizes[i]));
                writer.append(",");
                writer.append(String.valueOf(timesMin.get(i)));
                writer.append(",");
                writer.append(String.valueOf(timesMax.get(i)));
                writer.append(",");
                writer.append(String.valueOf(timesSum.get(i)));
                writer.append(",");
                writer.append(String.valueOf(timesMult.get(i)));
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
