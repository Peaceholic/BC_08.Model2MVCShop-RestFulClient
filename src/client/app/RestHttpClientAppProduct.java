package client.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;

public class RestHttpClientAppProduct {

	// main Method
	public static void main(String[] args) throws Exception {

//		RestHttpClientAppProduct.updateProductView_JsonSimple();
//		RestHttpClientAppProduct.updateProductView_Codehaus();
//
//		RestHttpClientAppProduct.updateProduct_JsonSimple();
//		RestHttpClientAppProduct.updateProduct_Codehaus();
//
//		RestHttpClientAppProduct.addProduct_JsonSimple();
//		RestHttpClientAppProduct.addProduct_Codehaus();
//
//		RestHttpClientAppProduct.getProduct_JsonSimple();
//		RestHttpClientAppProduct.getProduct_Codehaus();
//
		RestHttpClientAppProduct.listProduct_JsonSimple();
		RestHttpClientAppProduct.listProduct_Codehaus();

	}

	public static void addProduct_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// [ ��� 1 : String ���]
		// String data = "{\"userId\":\"admin\",\"password\":\"1234\"}";
		// HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

		// [ ��� 2 : JSONObject ���]
		JSONObject json = new JSONObject();
		json.put("prodName", "�ϳ�11");
		json.put("prodDetail", "�ϳ��ϳ�11");
		json.put("manuDate", "20010101");
		json.put("price", 100);

		HttpEntity httpEntity = new StringEntity(json.toString(), "utf-8");

		httpPost.setEntity(httpEntity);
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response Ȯ��
		System.out.println("httpResponse : " + httpResponse);
		System.out.println();
		
	}

	public static void addProduct_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		Product product = new Product();
		product.setProdName("��22");
		product.setProdDetail("�ѵ�22");
		product.setManuDate("20010202");
		product.setPrice(100);
		
		ObjectMapper objectMapper01 = new ObjectMapper();
		// Object ==> JSON Value �� ��ȯ
		String jsonValue = objectMapper01.writeValueAsString(product);
		HttpEntity httpEntity01 = new StringEntity(jsonValue, "utf-8");

		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response Ȯ��
		System.out.println("httpResponse : " + httpResponse);
		System.out.println();
		
	}

	public static void getProduct_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/getProduct/10000";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);

		// ==> Response Ȯ��
		System.out.println("httpResponse : " + httpResponse);
		System.out.println();

		// ==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println("Server : " + serverData);

		// ==> �����б�(JSON Value Ȯ��)
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("JSON : " + jsonobj);
	}

	public static void getProduct_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/getProduct/10000";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);

		// ==> Response Ȯ��
		System.out.println("httpResponse : " + httpResponse);
		System.out.println();

		// ==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		// ==> �ٸ� ������� serverData ó��
		// System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		// String serverData = br.readLine();
		// System.out.println(serverData);

		// ==> API Ȯ�� : Stream ��ü�� ���� ����
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println("JSON : " + jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println("Product : " + product);

	}

	public static void updateProductView_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/updateProductView/10000";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);

		// ==> Response Ȯ��
		System.out.println("httpResponse : " + httpResponse);
		System.out.println();

		// ==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println("Server : " + serverData);

		// ==> �����б�(JSON Value Ȯ��)
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("JSON : " + jsonobj);

	}

	public static void updateProductView_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/getProduct/10000";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);

		// ==> Response Ȯ��
		System.out.println("httpResponse : " + httpResponse);
		System.out.println();

		// ==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		// ==> �ٸ� ������� serverData ó��
		// System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		// String serverData = br.readLine();
		// System.out.println(serverData);

		// ==> API Ȯ�� : Stream ��ü�� ���� ����
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println("JSON : " + jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println("Product : " + product);

	}

	public static void updateProduct_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/updateProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// [ ��� 1 : String ���]
		// String data = "{\"userId\":\"admin\",\"password\":\"1234\"}";
		// HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

		// [ ��� 2 : JSONObject ���]
		JSONObject json = new JSONObject();
		json.put("prodNo",10000);
		json.put("prodName", "�ϳ�11");
		json.put("prodDetail", "�ϳ��ϳ�11");
		json.put("manuDate", "20010101");
		json.put("price", 100);

		HttpEntity httpEntity = new StringEntity(json.toString(), "utf-8");

		httpPost.setEntity(httpEntity);
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response Ȯ��
		System.out.println("httpResponse : " + httpResponse);
		System.out.println();

	}

	public static void updateProduct_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/updateProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		Product product = new Product();
		product.setProdNo(10002);
		product.setProdName("��23");
		product.setProdDetail("�ѵ�23");
		product.setManuDate("20010203");
		product.setPrice(100);
		
		ObjectMapper objectMapper01 = new ObjectMapper();
		// Object ==> JSON Value �� ��ȯ
		String jsonValue = objectMapper01.writeValueAsString(product);
		HttpEntity httpEntity01 = new StringEntity(jsonValue, "utf-8");

		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response Ȯ��
		System.out.println("httpResponse : " + httpResponse);
		System.out.println();

	}

	public static void listProduct_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/listProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// [ ��� 1 : String ���]
		// String data = "{\"userId\":\"admin\",\"password\":\"1234\"}";
		// HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

		// [ ��� 2 : JSONObject ���]
		JSONObject json = new JSONObject();
		json.put("currentPage", "1");
		json.put("pageSize", "3");
		json.put("searchCondition", "");
		json.put("searchKeyword", "");

		HttpEntity httpEntity01 = new StringEntity(json.toString(), "utf-8");

		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response Ȯ��
		System.out.println("httpResponse : " + httpResponse);
		System.out.println();

		// ==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println("Server : " + serverData);

		// ==> �����б�(JSON Value Ȯ��)
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("JSON : " + jsonobj);

	}

	public static void listProduct_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/listProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		Search search = new Search();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonValue = objectMapper.writeValueAsString(search);

		HttpEntity httpEntity01 = new StringEntity(jsonValue, "utf-8");
		httpPost.setEntity(httpEntity01);

		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response Ȯ��
		System.out.println("httpResponse : " + httpResponse);
		System.out.println();

		// ==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println("Server : " + serverData);

	}

}