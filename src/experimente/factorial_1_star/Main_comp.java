//package experimente.factorial_1_star;
//
//import experimente.DecimalBigInt;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
///**
// * Created by vlasceanusilviu on 12/5/16.
// */
//public class Main_comp {
//
//    public static void main3(String[] args) throws IOException {
//
//        showNandP();
//
//        Scanner reader = new Scanner(Main.class.getResourceAsStream("fact.in"));
//
//        int p = 62;
//        int N = -2;
//
//        if (p == 0) N = 1;
//        else if (p <= 4) N = p * 5;
//        else if (p == 5) N = -1;
//        else {
//            int seed = 6;
//            int seedPos = 1;
//            int nextSeed;
//
//            while (seed < Math.pow(10, 8)) {
//                nextSeed = seed * 5 + 1;
//                ++seedPos;
//
//                if (seed == p) {
//                    N = (int) Math.pow(5, seedPos);
//                    break;
//                } else if (seed < p && p < nextSeed - seedPos) {
//
//                    int copy = p;
//                    int index = seedPos;
//                    int seedCopy = seed;
//
//                    while (copy >= 5) {
//                        if (copy % seedCopy == 0) {
//                            N = (int) Math.pow(5, index) * copy / seedCopy;
//                            break;
//                        } else {
//                            copy -= seedCopy;
//                            if (copy < seedCopy) {
//                                seedCopy = (seedCopy - 1) / 5;
//                                --index;
//                            }
//                        }
//                    }
//
//                    if (copy == 5) N = -1;
//                    else if (copy < 5) N = copy * 5;
//                    break;
//
//                } else if (nextSeed - seedPos <= p && p < nextSeed) {
//                    N = -1;
//                    break;
//                }
//                seed = nextSeed;
//            }
//        }
//
//        System.out.println(N);
//
//        BufferedWriter writer = new BufferedWriter(new FileWriter("fact.out"));
//        writer.write(String.valueOf(N));
//        writer.close();
//        reader.close();
//    }
//
//    private static void showSeedVector() {
//        int seed = 6;
//        int poz = 1;
//        while (seed < Math.pow(10, 8)) {
//            System.out.println("seed[" + poz + "] = " + seed);
//            seed = seed * 5 + 1;
//            ++poz;
//        }
//    }
//
//    private static void showNandP() {
//        for (int i = 0; i < 1000; i += 5) {
//            int newP = DecimalBigInt.countOfZeroesInFactorial(i);
//            System.out.println("n = " + i + " => p = " + newP + " potential n1 = " + (newP - newP / 5) * 5 + " potential n2 = " + (newP - newP / 5 + 1) * 5);
//        }
//    }
//
//}
