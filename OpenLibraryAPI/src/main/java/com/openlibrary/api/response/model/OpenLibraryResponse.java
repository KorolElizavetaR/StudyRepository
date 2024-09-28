package com.openlibrary.api.response.model;

import java.util.List;

import lombok.Data;

@Data
public class OpenLibraryResponse {
    private List<Document> docs;
    private String q;
}
