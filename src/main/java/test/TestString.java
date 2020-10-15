package test;

import java.util.Scanner;

public class TestString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        for (int i = str.length; i > 0; i--) {
            System.out.print(str[i - 1] + " ");
        }
    }

}
