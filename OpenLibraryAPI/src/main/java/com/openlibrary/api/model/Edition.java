package com.openlibrary.api.model;

import java.util.List;

import lombok.Data;

@Data
public class Edition {
	private List<String> publisher;
    private List<String> isbn;
    private List<String> language;
    private List<String> publisher_facet;
}
