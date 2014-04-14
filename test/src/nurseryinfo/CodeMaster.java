package nurseryinfo;


public class CodeMaster {

	public static String RestAPI_uri[][] ={
											{"arcode","20","b8334802665d4721943efc2bb978fe74&arname="},
											{"전국조회","21","c3cba6259e9943a9948d86dcf1194653&arcode="}
											};
	
	public static String[][] stcd={
									{"서울","01"},
									{"부산","02"},
									{"대구","03"},
									{"인천","04"},
									{"광주","05"},
									{"대전","06"},
									{"울산","07"},
									{"세종","08"},
									{"경기","09"},
									{"강원","10"},
									{"충청북도","11"},
									{"충청남도","12"},
									{"전라북도","13"},
									{"전라남도","14"},
									{"경상북도","15"},
									{"경상남도","16"},
									{"제주","17"}
							};
	public static String URLPTN="http://api.childcare.go.kr/mediate/rest/cpmsapi0[apinum]/cpmsapi0[apinum]/request?key=[key]";
	public static String URLForce="http://info.childcare.go.kr/info/pnis/search/preview/BasisPresentConditionSlPu.jsp?flag=GH&STCODE_POP=";
	
	public static String chiefOfNursery_keys="<a href=\"#none\" title=\"설명글 닫기\" class=\"close\"><img src=\"http://img.childcare.go.kr/info/btn/btn_close1.gif\" alt=\"닫기\" /></a>\n							</span>\n						</span>\n					</th>\n					<td>";
	public static String chiefOfNursery_keye="</td>\n					<th>\n						<span class=\"tool_tip\">\n							<a href=\"#none\" title=\"설명글 열기";
	//{[ID],[어바웃 글자수],[시작문자패턴],[종료문자패턴],[삭제패턴]}
	public static String [][] pharseS_E={
			{"원장","5","<a href=\"#none\" title=\"설명글 닫기\" class=\"close\"><img src=\"http://img.childcare.go.kr/info/btn/btn_close1.gif\" alt=\"닫기\" /></a>\n							</span>\n						</span>\n					</th>\n					<td>",
			"</td>\n					<th>\n						<span class=\"tool_tip\">\n							<a href=\"#none\" title=\"설명글 열기"
				,""},
			{"선생님수","2","<td class=\"color_02\">","</td>\n                        <td>",""},
			{"보육실수/면적","3","<th>대지</th>\n						<th>기타</th>\n					</tr>\n				</thead>\n				<tbody>\n					<tr>\n						<td>",
			"m<sup>2</sup></td>","</td>\n						<td>"	}
			
		};
	
	
}
