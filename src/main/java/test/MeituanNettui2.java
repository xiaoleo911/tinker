package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeituanNettui2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inStr = "";
        inStr = sc.nextLine();
        List<Integer> in1 = new ArrayList<Integer>();
        String[] in2 = inStr.split(" ");
        for (int i = 0; i < in2.length; i++) {
            in1.add(Integer.parseInt(in2[i]));
        }


        for (int i = 0; i < in1.size(); i++) {
            System.out.println(in1.get(i));
        }

        int[] in = {1, 2, 3, 4};
        int[] result = {0, 0, 0, 0};

        for (int i = 0; i < in.length; i++) {
            int count = 0;
            for (int j = i; j < in.length; j++) {
                if (in[j] < in[i]) {
                    count++;
                }
            }
            result[i] = count;
        }

        // 输出
        for (int i = 0; i < result.length; i++) {
            if (i == 3) {
                System.out.print(result[i]);
            } else {
                System.out.print(result[i] + " ");
            }

        }

    }
}
