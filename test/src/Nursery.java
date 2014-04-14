import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.StringReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import nurseryinfo.CodeMaster;
import nurseryinfo.NurseryInfo;
import nurseryinfo.SidoInfo;
import nurseryinfo.SidoInfo.Item;



public class Nursery {

	public static void main(String[] args) {
		//StringBuffer sb= new StringBuffer();
		//boolean startflag=false;
		boolean startflag=true;
		HttpGetContents ci=new HttpGetContents();
		try {
			//BufferedWriter out = new BufferedWriter(new FileWriter("d:/work/kuniv/nursery.csv",true));
			BufferedWriter out = new BufferedWriter(new FileWriter("d:/work/kuniv/nursery.csv"));
			
			JAXBContext context = JAXBContext.newInstance(SidoInfo.class);
			Unmarshaller um = context.createUnmarshaller();
			JAXBContext contextNursery = JAXBContext.newInstance(NurseryInfo.class);
            Unmarshaller umNursery = contextNursery.createUnmarshaller();
           
			 for (int i=0;i<CodeMaster.stcd.length;i++){
				 
		        	System.out.println(CodeMaster.stcd[i][0]);
			
		        	ci.setURI(CodeMaster.RestAPI_uri[0][1],CodeMaster.RestAPI_uri[0][2],CodeMaster.stcd[i][0]);
		        	ci.requestContents();
					
				//	System.out.println("contents:"+ ci.getContents());
					
					 
		            SidoInfo  dataRoot = (SidoInfo) um.unmarshal( new StringReader(ci.getContents() ));
		            ArrayList<Item>  alIt=(ArrayList<Item>) dataRoot.getItem();
		            
		            
		            HttpGetContents nci=new HttpGetContents();
		            
		             
		            for(int x=0; x<alIt.size();x++){
		            	Item it=alIt.get(x);
		            	String descrpt=it.getSidoname()+it.getSigunname()+it.getArcode();
		            	System.out.println("\ntest : "+descrpt);
		            	
		            	//if (it.getArcode().equals("41130")) startflag=true; 
		            	
		            	if(startflag){
			            	nci.setURI(CodeMaster.RestAPI_uri[1][1],CodeMaster.RestAPI_uri[1][2],it.getArcode());
			            	nci.requestContents();
							
			                NurseryInfo  dataRootNursery = (NurseryInfo) umNursery.unmarshal( new StringReader(nci.getContents() ));
				            List<NurseryInfo.Item>  alItNur=dataRootNursery.getItem();
				            //String chiefOfNursery="";
				            //int is=0,ie=0;
				            for(int y=0;y<alItNur.size();y++){
				            	NurseryInfo.Item itNur=alItNur.get(y);
				            	//String nurseryinfo = itNur.getCrname()+itNur.getCraddr();
				            	//System.out.println("x:"+nurseryinfo);
				            	
				            	HttpGetContents fnci=new HttpGetContents();
				            	fnci.setURI(new URI(CodeMaster.URLForce+itNur.getStcode()));
				            	fnci.requestContents();
				            	
				            	
				            	//chiefOfNursery=fnci.getContents();
				    			
				            	/*is=chiefOfNursery.indexOf(CodeMaster.chiefOfNursery_keys)+CodeMaster.chiefOfNursery_keys.length();
				    			ie=chiefOfNursery.indexOf(CodeMaster.chiefOfNursery_keye);
				    			if (ie<0) ie=is+4;
				    			//System.out.println("s:"+is+"  e:"+ie);
				    			chiefOfNursery=chiefOfNursery.substring(is,ie);
				    			*/
				    			//sb.append(it.getSidoname()+","+it.getSigunname()+","+it.getArcode()+","+itNur.getCrname()+","¿øÀå","ÃÑ¼±»ý´Ô¼ö","+itNur.getCraddr()+","+itNur.getCrhome()+","+itNur.getCrcapat()+","+itNur.getCrtel()+","+itNur.getCrfax()+","+itNur.getStcode()+"\n");			    			
				    			
				            	out.write(it.getSidoname()+","+it.getSigunname()+","+it.getArcode()+","+itNur.getStcode()+","+itNur.getCrname()+","+fnci.getCols(fnci.getOthers(),",")+","+itNur.getCraddr()+","+itNur.getCrhome()+","+itNur.getCrcapat()+","+itNur.getCrtel()+","+itNur.getCrfax()); 
				    			out.newLine();
				    			//System.out.println("xx:"+chiefOfNursery);
				    			
				    			
				            	fnci.close();
				            	
				            }
				            nci.close();
		            	}
		            	
		            }
		            ci.close();
		            
		            
			 }
			 out.close();
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

}
