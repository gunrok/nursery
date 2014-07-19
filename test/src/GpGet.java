import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


public class GpGet {
	public static void main(String[] args){
		try {
			GpGet gps = new GpGet();
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public GpGet() throws IOException, ParserConfigurationException, SAXException
	{
		//��ũ �ּ� �����
		String requestUrl = "http://apis.daum.net/local/geo/addr2coord";
		requestUrl += "?apikey=" + "3040786d24ff62912403dcb6fd87524367ad7055"; //�߱޵� Ű
        requestUrl += "&q=" + "��â�� 290����"; //�˻���
        requestUrl += "&output=" + "xml";
		URL url = new URL(requestUrl);

		//API ��û �� ��ȯ
		URLConnection conn = url.openConnection();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(conn.getInputStream());

		//channel��带 ��üȭ �ϱ�
		Node node = doc.getElementsByTagName("channel").item(0);
		for (int i=0 ;i< node.getChildNodes().getLength();i++) {
			Node channelNode = node.getChildNodes().item(i);
			String nodeName= channelNode.getNodeName();

			//item ������ ���
			if ("item".equals(nodeName)) 
			{
				//item����� �ڽĳ�带 �˻�
				for (int j=0 ;j< channelNode.getChildNodes().getLength();j++) 
				{
					Node itemNode = channelNode.getChildNodes().item(j);
					//title��� �� ��� ���
					if("title".equals(itemNode.getNodeName()))
						System.out.println("itemNode.getTextContent()");
				}
			}
		}
	}
}