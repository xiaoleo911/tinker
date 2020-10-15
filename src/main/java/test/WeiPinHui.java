package test;

public class WeiPinHui {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WeiPinHui wei = new WeiPinHui();
        String result = wei.test();
        System.out.println(result);

    }

    public String test() {

        try {
            return 1 + "";
        } finally {
            // TODO: handle finally clause
            return 2 + "";
        }
    }

}
