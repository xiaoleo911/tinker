package test;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ShengDa1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double duration = sc.nextDouble();
            double cost = 0;
            System.out.println();
            if (duration >= 0 && duration <= 3) {
                cost = 5;
            } else if (duration > 3) {
                cost = 5 + (duration - 3) * 2;
            }
            if (cost > 50) {
                cost = 50;
            }

            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(df.format(cost));

        }
    }

}
