package file;

import java.io.*;
import java.nio.channels.FileChannel;

public class CopyFile {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File s = new File("D:/game/a.txt");
        File t = new File("D:/game/b.txt");
//		fileChannelCopy(s,t);
        fileBufferCopy(s, t);
    }

    public static void fileChannelCopy(File s, File t) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(s);
            fo = new FileOutputStream(t);
            in = fi.getChannel();// 得到对应的文件通道
            out = fo.getChannel();// 得到对应的文件通道
            in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void fileBufferCopy(File s, File t) {
        InputStream fis = null;
        OutputStream fos = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(s));
            fos = new BufferedOutputStream(new FileOutputStream(t));
            byte[] buf = new byte[4096];
            int i;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }


    }

}
