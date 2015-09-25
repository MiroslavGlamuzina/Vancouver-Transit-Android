package com.example.mapview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.os.AsyncTask;

public class HandleHTML extends AsyncTask<String, Void, String> {

	public String fulltext = "";

	@Override
	protected  String doInBackground(String... params) {
		// TODO Auto-generated method stub
		try {
			HttpParams httpParameters = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParameters, 3000); // 3s
																				// max
																				// for
																				// connection
			HttpConnectionParams.setSoTimeout(httpParameters, 4000); // 4s max
																		// to
																		// get
																		// data
			HttpClient httpclient = new DefaultHttpClient(httpParameters);

			HttpGet httpget = new HttpGet(params[0]); // Set the
																// action you
																// want to do
			HttpResponse response = httpclient.execute(httpget); // Executeit
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent(); // Create an InputStream with
													// the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null)
				// Read line by line
				sb.append(line + "\n");

			fulltext = sb.toString(); // Result is here

			is.close(); // Close the stream
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
		return fulltext;

	}

}
