package AlgorithmAISD;
import java.io.*;
import java.nio.charset.StandardCharsets;

import static java.io.File.separator;

public class Main {
    public static void main(String[] args) throws IOException {
        int counter = 0;
        new GeneratorForSetOfElements().generator();
        for(int i = 100; i <= 10000; i += 100) {
            InputStream inputStream = new FileInputStream("C:/Users/user/Desktop/data/Test" + i + ".txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            int sizeOfArrays = Integer.parseInt(reader.readLine());
            Integer[] arrayOfNum = new Integer[sizeOfArrays];
            for (int j = 0; j < arrayOfNum.length; j++) {
                arrayOfNum[j] = Integer.parseInt(reader.readLine());
            }

            long startTime = System.nanoTime();
            //начало алгоритма
            for (int k = (arrayOfNum.length/2); k > 0; k /= 2) {
                for (int j = k; j < arrayOfNum.length; j++) {
                    for (int repl = j - k; ((repl >= 0) && (arrayOfNum[repl] > arrayOfNum[repl + k])); repl -= k) {

                        int temp = arrayOfNum[repl];
                        arrayOfNum[repl] = arrayOfNum[repl + k];
                        arrayOfNum[repl + k] = temp;
                        counter++;
                    }
                }
            }
            //конец алгоритма
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            boolean check = true;
            if (i == 100)
                check = false;
            OutputStream output = new FileOutputStream("C:/Users/user/Desktop/Results.txt/", check);
            PrintStream print = new PrintStream(output, false, StandardCharsets.UTF_8);
            print.println(time);

        }
    }
}
