package nurseryinfo;


public class CodeMaster {

	public static String RestAPI_uri[][] ={
											{"arcode","20","b8334802665d4721943efc2bb978fe74&arname="},
											{"������ȸ","21","c3cba6259e9943a9948d86dcf1194653&arcode="}
											};
	
	public static String[][] stcd={
									{"����","01"},
									{"�λ�","02"},
									{"�뱸","03"},
									{"��õ","04"},
									{"����","05"},
									{"����","06"},
									{"���","07"},
									{"����","08"},
									{"���","09"},
									{"����","10"},
									{"��û�ϵ�","11"},
									{"��û����","12"},
									{"����ϵ�","13"},
									{"���󳲵�","14"},
									{"���ϵ�","15"},
									{"��󳲵�","16"},
									{"����","17"}
							};
	public static String URLPTN="http://api.childcare.go.kr/mediate/rest/cpmsapi0[apinum]/cpmsapi0[apinum]/request?key=[key]";
	public static String URLPTN2="http://apis.daum.net/local/geo/addr2coord?apikey=3040786d24ff62912403dcb6fd87524367ad7055&q=[addr]&output=xml";
	
	public static String URLForce="http://info.childcare.go.kr/info/pnis/search/preview/BasisPresentConditionSlPu.jsp?flag=GH&STCODE_POP=";
	
	public static String chiefOfNursery_keys="<a href=\"#none\" title=\"����� �ݱ�\" class=\"close\"><img src=\"http://img.childcare.go.kr/info/btn/btn_close1.gif\" alt=\"�ݱ�\" /></a>\n							</span>\n						</span>\n					</th>\n					<td>";
	public static String chiefOfNursery_keye="</td>\n					<th>\n						<span class=\"tool_tip\">\n							<a href=\"#none\" title=\"����� ����";
	//{[ID],[��ٿ� ���ڼ�],[���۹�������],[���Ṯ������],[��������]}
	public static String [][] pharseS_E={
			{"����","5","<a href=\"#none\" title=\"����� �ݱ�\" class=\"close\"><img src=\"http://img.childcare.go.kr/info/btn/btn_close1.gif\" alt=\"�ݱ�\" /></a>\n							</span>\n						</span>\n					</th>\n					<td>",
			"</td>\n					<th>\n						<span class=\"tool_tip\">\n							<a href=\"#none\" title=\"����� ����"
				,""},
			{"�����Լ�","2","<td class=\"color_02\">","</td>\n                        <td>",""},
			{"�����Ǽ�/����","3","<th>����</th>\n						<th>��Ÿ</th>\n					</tr>\n				</thead>\n				<tbody>\n					<tr>\n						<td>",
			"m<sup>2</sup></td>","</td>\n						<td>"	}
			
		};
	
	
}
