package com.openlibrary.api.response.model;

import java.util.List;

import lombok.Data;

@Data
public class Document {
	private List<String> author_name;
    private int cover_i;
    private String title;
}
