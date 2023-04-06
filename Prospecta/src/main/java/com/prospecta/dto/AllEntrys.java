package com.prospecta.dto;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.prospecta.models.Entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class AllEntrys {


	@JsonProperty("count")
	private Integer count;

	@JsonProperty("entries")
	private List<Entry> entries;

}
