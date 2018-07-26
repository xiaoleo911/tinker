package xml;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySaxHandler extends DefaultHandler {

	static DateFormat dateFormat= new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// 格式化内容  
	private String content;
	
	/*
	 * 事件发生时元素中的字符   
	 * (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		content=new String(ch,start,length);
	}
	
	/**
	 * 当解析到元素大的开始标签时发生  
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if("music".equals(qName)){
			System.out.println("\r\n找到一首歌.所属分类："+attributes.getValue("category")+".");
		}
	}
	
	
	/**
	 * 当解析到元素的结束标签时发生  
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		  if("name".equals(qName)){
			   System.out.println("歌名："+content);
		   }else if("author".equals(qName)){
			   System.out.println("歌手："+content);
		   }else if("county".equals(qName)){
			   System.out.println("国家："+content);
		   }else if("date".equals(qName)){
			   System.out.println("发布日期："+content);
		   }else if("music".equals(qName)){
			   System.out.println("fupeng："+content);
		   }
			
	}
	
	
	
	
	
	
	
	
	
}