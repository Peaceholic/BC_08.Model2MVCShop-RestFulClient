package client.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;

public class RestHttpClientAppPurchase {

	// main Method
	public static void main(String[] args) throws Exception {

		// RestHttpClientAppPurchase.addPurchaseView_JsonSimple();
		// RestHttpClientAppPurchase.addPurchaseView_Codehaus();

		// RestHttpClientAppPurchase.addPurchase_JsonSimple();
		// RestHttpClientAppPurchase.addPurchase_Codehaus();

		// RestHttpClientAppPurchase.listPurchase_JsonSimple();
		// RestHttpClientAppPurchase.listPurchase_Codehaus();

		 RestHttpClientAppPurchase.getPurchase_JsonSimple();
		 RestHttpClientAppPurchase.getPurchase_Codehaus();

		// RestHttpClientAppPurchase.updatePurchaseView_JsonSimple();
		// RestHttpClientAppPurchase.updatePurchaseView_Codehaus();

		// RestHttpClientAppPurchase.updatePurchase_JsonSimple();
		// RestHttpClientAppPurchase.updatePurchase_Codehaus();

		// RestHttpClientAppPurchase.updateTranCodeByProd_JsonSimple();
		// RestHttpClientAppPurchase.updateTranCodeByProd_Codehaus();

		// RestHttpClientAppPurchase.updateTranCodeByTran_JsonSimple();
		// RestHttpClientAppPurchase.updateTranCodeByTran_Codehaus();

	}

	public static void addPurchaseView_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}

	public static void addPurchaseView_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}

	public static void addPurchase_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}

	public static void addPurchase_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}

	public static void listPurchase_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/purchase/json/listPurchase";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// [ ��� 1 : String ���]
		// String data = "{\"userId\":\"admin\",\"password\":\"1234\"}";
		// HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

		// [ ��� 2 : JSONObject ���]

		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("");
		search.setSearchKeyword("");

		User user = new User();
		user.setUserId("user01");

		JSONObject json = new JSONObject();
		json.put("search", search);
		json.put("user", user);

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

	public static void listPurchase_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/purchase/json/listPurchase";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("");
		search.setSearchKeyword("");

		User user = new User();
		user.setUserId("user01");

		Map<String, Object> inputParam = new HashMap<String, Object>();

		inputParam.put("search", search);
		inputParam.put("user", user);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonValue = objectMapper.writeValueAsString(inputParam);

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

	public static void getPurchase_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/purchase/json/getPurchase/10000";

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

	public static void getPurchase_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/purchase/json/getPurchase/10000";

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
		Purchase purchase = objectMapper.readValue(jsonobj.toString(), Purchase.class);
		System.out.println("purchase : " + purchase);

	}

	public static void updatePurchaseView_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}

	public static void updatePurchaseView_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}

	public static void updatePurchase_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}

	public static void updatePurchase_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}

	public static void updateTranCodeByProd_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}

	public static void updateTranCodeByProd_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}

	public static void updateTranCodeByTran_JsonSimple() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("JsonSimple : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}

	public static void updateTranCodeByTran_Codehaus() throws Exception {

		System.out.println("\n------------------------------------------------");
		System.out.println("Codehaus : " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}
}