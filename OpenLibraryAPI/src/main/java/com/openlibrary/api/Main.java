package com.openlibrary.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.openlibrary.api.response.model.OpenLibraryResponse;

public class Main {
	
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		String fullUrl = "https://openlibrary.org/search.json?q=star%20rover&fields=cover_i,title,author_name&limit=1";
		HttpRequest getRequest = HttpRequest.
			newBuilder().
			uri(new URI(fullUrl)).GET().build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(getRequest, BodyHandlers.ofString());
		Gson gson = new GsonBuilder().create();
		
		OpenLibraryResponse book = gson.fromJson(response.body(), OpenLibraryResponse.class);
		System.out.println(book);
	}
	
}
