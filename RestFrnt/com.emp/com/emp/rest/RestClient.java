package com.emp.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.emp.bean.Employee;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClient {

	private static CloseableHttpClient CLIENT = HttpClients.createDefault();
	private static List<Employee> eList;

	public static List<Employee> getEmp() {
		CLIENT = HttpClients.createDefault();
		HttpGet request = new HttpGet("http://localhost:8080/RestBack/webapi/myresource/getEmp");
		request.addHeader("content-type", "application/json;charset=UTF-8");
		request.addHeader("charset", "UTF-8");
		HttpResponse response;

		try {

			response = (HttpResponse) CLIENT.execute(request);
			HttpEntity entity = response.getEntity();
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
			Employee[] model = mapper.readValue((EntityUtils.toString(entity)), Employee[].class);
			eList = new ArrayList<>();
			for (Employee item : model) {
				eList.add(item);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return eList;
	}
	
	public static List<Employee> getAllEmp() {
		CLIENT = HttpClients.createDefault();
		HttpGet request = new HttpGet("http://localhost:8080/RestBack/webapi/myresource/getAllEmp");
		request.addHeader("content-type", "application/json;charset=UTF-8");
		request.addHeader("charset", "UTF-8");
		HttpResponse response;

		try {

			response = (HttpResponse) CLIENT.execute(request);
			HttpEntity entity = response.getEntity();
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
			Employee[] model = mapper.readValue((EntityUtils.toString(entity)), Employee[].class);
			eList = new ArrayList<>();
			for (Employee item : model) {
				eList.add(item);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return eList;
	}
}
