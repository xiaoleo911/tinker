package xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxXML {


    public static void main(String[] args) {

        //创建解析的XML 文档对象
        File xmlFile = new File("src/SaxXML/music.xml");
        //创建一个SAXParserFactory 对象 ，通过单例模式创建
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            //创建SAXParser 对象
            SAXParser parser = factory.newSAXParser();
            // 解析文件，定义解析时的事件处理
            parser.parse(xmlFile, new MySaxHandler());

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


    }

}
