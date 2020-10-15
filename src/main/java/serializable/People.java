package serializable;

import java.io.*;

public class People implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 547133570244211667L;
    private String name;
    private int age;

    public People() {
        this.name = "lili";
        this.age = 20;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        People p = new People();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        FileOutputStream fos;
        FileOutputStream fos1;
        try {
            fos = new FileOutputStream("people.out");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
            oos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        People p1;
        try {
            FileInputStream fis = new FileInputStream("people.out");
            ois = new ObjectInputStream(fis);
            p1 = (People) ois.readObject();
            System.out.println("name:" + p1.getName());
            System.out.println("age:" + p1.getAge());
            ois.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
