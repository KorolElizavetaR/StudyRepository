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
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.openlibrary.api.model.Document;
import com.openlibrary.api.response.model.OpenLibraryResponse;

public class Main {
	
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		String fullUrl = "https://openlibrary.org/search.json?q=harry&"
				+ "fields=cover_i,key,title,author_name,editions,editions.publisher,"
				+ "editions.language,editions.isbn&limit=10";
        
		HttpRequest getRequest = HttpRequest.
			newBuilder().
			uri(new URI(fullUrl)).GET().header("Accept", "application/json").build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(getRequest, BodyHandlers.ofString());
		
		JsonElement jsonElement = JsonParser.parseString(response.body());
        JsonArray docsArray = jsonElement.getAsJsonObject().getAsJsonArray("docs");

        Gson gson = new GsonBuilder().create();
        List<Document> documents = new ArrayList<>();

        // Deserialize each document in the docs array
        for (JsonElement docElement : docsArray) {
            Document document = gson.fromJson(docElement, Document.class);
            documents.add(document);
        }
        
        documents.stream().forEach(System.out::println);
	}
	
}
