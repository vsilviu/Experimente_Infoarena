//package experimente.cmmdc_1_star;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner reader = new Scanner(new FileInputStream("cmmdc.in"));

        int a = reader.nextInt();
        int b = reader.nextInt();

        while (a != b) {
            if (a > b) a -= b;
            else b -= a;
        }

        if(a == 1) a = 0;

        BufferedWriter writer = new BufferedWriter(new FileWriter("cmmdc.out"));
        writer.write(String.valueOf(a));
        writer.close();
        reader.close();
    }

}
