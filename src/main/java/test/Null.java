package test;

public class Null {

    public static void print() {
        System.out.println("MTDP");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            ((Null) null).print();
        } catch (NullPointerException e) {
            // TODO Auto-generated catch block
            System.out.println("NullPointerException");
        }
    }

}
