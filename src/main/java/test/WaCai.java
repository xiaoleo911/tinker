package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class WaCai {

    /*
     * 统计英文词频
     * 含有  空格  ，  。
     *
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String result = wordFrequency("a a, a. b ,b");
        System.out.println(result);
    }

    public static String wordFrequency(String str) {

        StringBuffer sb = new StringBuffer();
        HashMap<String, Integer> hash = new HashMap<>();

        String str1 = str.replace(",", " ");
        str1 = str1.replace(".", " ");
        String[] listStr = str1.split(" ");
        for (int i = 0; i < listStr.length; i++) {
            if (!hash.containsKey(listStr[i])) {
                hash.put(listStr[i], 1);
            } else {
                int count = hash.get(listStr[i]);
                hash.put(listStr[i], ++count);
            }
        }

        Iterator<Entry<String, Integer>> ite = hash.entrySet().iterator();
        while (ite.hasNext()) {
            Entry<String, Integer> entry = ite.next();
            String word = entry.getKey();
            int count = entry.getValue();
            sb.append("单词：").append(word).append(" 次数：").append(count).append("\n");
        }
        return sb.toString();
    }

}
