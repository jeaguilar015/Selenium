package psslai.utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import psslai.utility.*;

public class RiskProfilling {
	
	public String riskRatingSubmission(String token, String appNo, String username) {
		String message ="";
		String endpoint = ConstantsVariable.URL + "/ms-coral-portfolio/risk-profiling";
		SimpleDateFormat riskRatingDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(endpoint);
		
		/*
		 * {
				"newMember":"Y",
				"applicationId":"{ApplicationNumber}",
				"userName":"SXIUSER",
				"riskScore":"LOW",
				"blacklisted":"N",
				"blacklistType":"OFAC",
				"pep":"N"
				"riskRatingDate":"{CurrentDate}"
				}
		 * 
		 */
		String request = "{"
				+ "\"newMember\" : \"Y\","
				+ "\"applicationID\" : " + appNo + "\","
				+ "\"userName\" : \"SXI\","
				+ "\"riskScore\" : \"HIGH\","
				+ "\"blacklisted\" : \"Y\","
				+ "\"blacklistType\" : \"OFAC\","
				+ "\"pep\" : \"N\","
				+ "\"riskRatingDate\" : " + riskRatingDate.format(new Date()) + ""
				+ "}";
		
		return message;
	}
}
