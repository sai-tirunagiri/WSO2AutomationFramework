package com.quinnox.testautomation.genericlib;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONException;

public class CommonLib {
	public int getApiStatus(String Resturl) throws IOException,NoSuchAlgorithmException, KeyManagementException {
		// configure the SSLContext with a TrustManager

		URL url = new URL(Resturl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("GET");

		con.addRequestProperty("Authorization", "Basic key");
		int responseCode = con.getResponseCode();

		return responseCode;

	}

	public static HttpResponse sendJSon(String url, String json) throws ClientProtocolException, IOException, JSONException {
		HttpPost request = new HttpPost(url);
		StringEntity entity = new StringEntity(json);
		entity.setContentType("application/json;charset=UTF-8");
		entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
		request.addHeader("Authorization", "Basic "); 
		// if we need// authorization
		request.setEntity(entity);
		HttpResponse response = null;
		HttpClient httpclient = HttpClientBuilder.create().build();
		try {
			response = httpclient.execute(request);
			return response;
		} 
		catch (SocketException se) {
			throw se;
		}
	}
}
