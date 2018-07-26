package File;

import java.io.File;

public class ListDir {
    public static void main(String[] args) {
        showDirectory(new File("D:/game/test"));
    }

    public static void showDirectory(File f) {
        _walkDirectory(f);
    }

    private static void _walkDirectory(File f) {
        if(f.isDirectory()) {
            for(File temp : f.listFiles()) {
                _walkDirectory(temp);
            }
        }
        else {
            System.out.println(f.getName());
        }
    }
}
