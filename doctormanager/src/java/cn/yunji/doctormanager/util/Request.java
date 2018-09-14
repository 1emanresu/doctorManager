package cn.yunji.doctormanager.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Request {

	
	public static String request(String url,Map<String, String> params) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		//header��3������
		String appKey = "3479a88fac4280cc7f6579737351ca5d";
		String appSecret = "cde23ba2e8d0";
		String nonce = "123456";
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);// �ο�
		//���������header
		httpPost.addHeader("AppKey", appKey);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		//��������Ĳ���
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (Entry<String, String> entry : params.entrySet()) {  
		    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}  
		//ִ�н��
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			// ִ������
			HttpResponse response = httpClient.execute(httpPost);
			// ��ӡִ�н��
			return EntityUtils.toString(response.getEntity(), "utf-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
