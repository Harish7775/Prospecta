package com.prospecta.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Entry {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer entryId;
	 @JsonProperty("API")
	 private String title;
	 @JsonProperty("Description")
	 private String description;
	 @JsonProperty("Auth")
	 private String auth;
	 @JsonProperty("HTTPS")
	 private boolean https;
	 @JsonProperty("Cors")
	 private String cors;
	 @JsonProperty("Link")
	 private String link;
	 @JsonProperty("Category")
	 private String category;
}
