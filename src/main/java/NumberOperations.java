import java.io.*;
import java.util.*;

public class NumberOperations {

    public static void main(String[] args) {
        String fileName = "numbers.txt";
        List<Integer> numbers = readNumbersFromFile(fileName);

        if (numbers.isEmpty()) {
            System.out.println("Файл пустой или содержит некорректные данные.");
            return;
        }

        System.out.println("Минимальное число: " + getMin(numbers));
        System.out.println("Максимальное число: " + getMax(numbers));
        System.out.println("Сумма всех чисел: " + getSum(numbers));
        System.out.println("Произведение всех чисел: " + getMult(numbers));
    }

    public static List<Integer> readNumbersFromFile(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        ClassLoader classLoader = NumberOperations.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            if (inputStream == null) {
                System.err.println("Файл не найден: " + fileName);
                return numbers;
            }

            String line = br.readLine();
            if (line != null) {
                String[] numberStrings = line.split(" ");
                for (String numberString : numberStrings) {
                    try {
                        numbers.add(Integer.parseInt(numberString));
                    } catch (NumberFormatException e) {
                        System.err.println("Некорректное число: " + numberString);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return numbers;
    }

    public static int getMin(List<Integer> numbers) {
        int min = numbers.get(0);
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public static int getMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static long getSum(List<Integer> numbers) {
        long sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static long getMult(List<Integer> numbers) {
        long mult = 1;
        for (int number : numbers) {
            mult *= number;
        }
        return mult;
    }
}
