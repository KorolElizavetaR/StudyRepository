package rest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Consumer {
	public static void main(String[] args) {
		lemmetru();
	}
	
	public static void REQRES()
	{
		RestTemplate restTemp = new RestTemplate();
		String url = "https://reqres.in/api/users/2";
		// get-запрос
		System.out.println(restTemp.getForObject(url, String.class));
		// 
		Map <String, String> json = new HashMap<>();
		json.put("name", "John");
		json.put("lastname", "White");
		HttpEntity<Map <String, String>> request = new HttpEntity<>(json);
		System.out.println(restTemp.postForObject(url, request, String.class));
	}
	
	// https://www.youtube.com/watch?v=MdIfZJ08g2I
	// https://openweathermap.org/api
	public static void WEATHER() throws IOException
	{
		RestTemplate restTemp = new RestTemplate();
		String url 
			= "https://api.openweathermap.org/data/2.5/forecast?lat=53&lon=27&units=metric&appid=2ac5fc20916e32a7e3599b234116d5cd";
		String responce = restTemp.getForObject(url, String.class);
		System.out.println(responce);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode obj = mapper.readTree(responce);
		System.out.println(obj.get("main.temp")); // не фурыче ((
	}
	
	private static void lemmetru() {
		RestTemplate restTemp = new RestTemplate();
		String url = "http://localhost:8080/api/hello";
		System.out.println(restTemp.getForObject(url, String.class));
	}
}
	