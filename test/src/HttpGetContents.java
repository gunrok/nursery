import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;

import nurseryinfo.CodeMaster;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpGetContents {
	private URI uri = null;
	private String strContents =null;
	private CloseableHttpClient httpclient=null;
	private HttpGet httpget=null;
	
	
	public void setURI(URI xuri){
		this.uri=xuri;
	}
	
	public void  setURI(String apinum,String key,String option){
		
		String strUri=CodeMaster.URLPTN.replace("[apinum]", apinum);
		strUri=strUri.replace("[key]", key);
		strUri=strUri.concat(option);
	    try{
	    	this.uri=new URI(strUri);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	    
	}
	
	public void close(){
		try {
			this.httpget.completed();
			this.httpclient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void requestContents () throws Exception{
		this.strContents=new String();
		this.httpclient = HttpClients.createDefault();    	
		this.httpget = new HttpGet(this.uri);
		
		 ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
		 	
		     public String handleResponse(
		             final HttpResponse response) throws ClientProtocolException, IOException {
		     	/*try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		         int status = response.getStatusLine().getStatusCode();
		         if (status >= 200 && status < 300) {
		             HttpEntity entity = response.getEntity();
		             
		             return entity != null ? EntityUtils.toString(entity,"UTF-8") : null;
		     } else {
		         throw new ClientProtocolException("Unexpected response status: " + status);
		         }
		     }
		
		 };		 
		 
		this.strContents= httpclient.execute(httpget, responseHandler);
		
		
		
	}
	
	public String getContents(){
		return this.strContents;
	}
	
	public String[] getOthers(){
		String x[]=new String[CodeMaster.pharseS_E.length];
		int is=0,ie=0;
		
		for (int i=0; i<x.length;i++){
			is=this.strContents.indexOf(CodeMaster.pharseS_E[i][2])+CodeMaster.pharseS_E[i][2].length();
			ie=this.strContents.indexOf(CodeMaster.pharseS_E[i][3]);
			if (is==-1 && ie > 0) is=ie-new Integer(CodeMaster.pharseS_E[i][1]);
			if (ie==-1 && is > 0) ie=is+new Integer(CodeMaster.pharseS_E[i][1]);
			
			//System.out.println("s:"+is+"  e:"+ie);
			
			
			x[i]=this.strContents.substring(is,ie);
		
			x[i]=x[i].replace(CodeMaster.pharseS_E[i][4], "");
			
			
		}
		
		return x;
	}
	
	public String getCols(String[] records,String spt){
		String otherscol = new String ();
		for(int i=0;i<records.length;i++){
			otherscol += records[i] ;
			if (i<records.length-1){
				otherscol += spt;
			}
		}
		return otherscol;
	}
	
	
	
	public static void main(String[] args) throws JAXBException  {
		// TODO Test
		HttpGetContents ci=new HttpGetContents();
		/*String chiefOfNursery=new String();
		String chiefOfNursery_keys="<a href=\"#none\" title=\"설명글 닫기\" class=\"close\"><img src=\"http://img.childcare.go.kr/info/btn/btn_close1.gif\" alt=\"닫기\" /></a>\n							</span>\n						</span>\n					</th>\n					<td>";
		
		String chiefOfNursery_keye="</td>\n					<th>\n						<span class=\"tool_tip\">\n							<a href=\"#none\" title=\"설명글 열기";
		int is=0,ie=0;
		*/
		try {
			ci.setURI(new URI("http://info.childcare.go.kr/info/pnis/search/preview/BasisPresentConditionSlPu.jsp?flag=GH&STCODE_POP=11110000021"));
			ci.requestContents();
			System.out.println(ci.getContents());
			
			
			/*is=chiefOfNursery.indexOf(chiefOfNursery_keys)+chiefOfNursery_keys.length();
			ie=chiefOfNursery.indexOf(chiefOfNursery_keye);
			
			System.out.println("s:"+is+"  e:"+ie);
			*/
			System.out.println("test:"+ci.getCols(ci.getOthers(),","));
			
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally{
			  ci.close();
		}
			
    }
	

}
