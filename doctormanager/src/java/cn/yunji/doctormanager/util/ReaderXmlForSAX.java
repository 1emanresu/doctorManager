package cn.yunji.doctormanager.util;

import java.io.StringReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class ReaderXmlForSAX {
	/**
	 * @methodName parse
	 * @description:解析xml字符串 
	 * @param XMLStrs 
	 * @throws
	 */
public static void parse(String XMLStrs) {   
	   try {  
		   //1.创建一个SAXParserFactory对象 
           SAXParserFactory saxfac = SAXParserFactory.newInstance();
           //2.获得解析器 
           SAXParser saxparser = saxfac.newSAXParser();  
           MyHandler   dh = new MyHandler();  
          saxparser.parse(new InputSource(new StringReader(XMLStrs)),dh); 
       } catch (Exception e) {  
           e.printStackTrace();  
       }
   }  
}  

/**
 * <p>FileName: MyHandler</p>
 * @description:DefaultHandler类是SAX2事件处理程序的默认基类。它继承了EntityResolver、DTDHandler、
 *              ContentHandler和ErrorHandler这四个接口。包含这四个接口的所有方法。
 * @author king_smm
 * @version
 */
class MyHandler extends DefaultHandler{
  private StringBuffer buf;  
  private String str;  
  public MyHandler(){  
       super();  
   }  
   /**
    * @methodName startDocument
    * @description:文档的开始 
    * @throws SAXException 
    * @see org.xml.sax.helpers.DefaultHandler#startDocument()
    */
  public void startDocument() throws SAXException{  
       buf=new StringBuffer();  
   }  
    /**
     * @methodName endElement
     * @description: 元素的结束
     * @param namespaceURI
     * @param localName
     * @param fullName
     * @throws SAXException 
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
     */
  public void endElement(String namespaceURI,String localName,String fullName )throws SAXException{  
      str = buf.toString();  
      System.out.println("节点="+fullName+"\tvalue="+buf+" 长度="+buf.length());  
      System.out.println();  
       buf.delete(0,buf.length());  
    }  
    
  public void characters( char[] chars, int start, int length )throws SAXException{  
      //将元素内容累加到StringBuffer中  
       buf.append(chars,start,length);  
   }  
}  