package AlgorithmAISD;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static java.io.File.separator;

public class GeneratorForSetOfElements {
    GeneratorForSetOfElements(){}
        public void generator() throws FileNotFoundException {
            for(int i = 100; i <= 10000; i+=100) {
                new File("C:/Users/user/Desktop/data/Test" + i + ".txt");
                OutputStream out = new FileOutputStream("C:/Users/user/Desktop/data/Test" + i + ".txt", false);
                PrintStream printer = new PrintStream(out, false, StandardCharsets.UTF_8);
                printer.println(i);
                for (int j = 0; j < i; j++) {
                    printer.println( (int) (Math.random() * (2000000000 + 1) - 1000000000) );
                }
                printer.println();
            }
        }
}
