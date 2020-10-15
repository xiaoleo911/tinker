package arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            int value = iterator.next();
            System.out.println(value);
        }
        list.add(1, 66);
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            int value = iterator.next();
            System.out.println(value);
        }


    }

}
