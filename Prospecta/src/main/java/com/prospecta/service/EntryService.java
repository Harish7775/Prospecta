package com.prospecta.service;

import java.util.List;

import com.prospecta.dto.EntryDto;
import com.prospecta.exceptions.EntryException;
import com.prospecta.models.Entry;

public interface EntryService {
	
	public Entry addtheEntry();

	public List<EntryDto> getEntryByCategory(String category)throws EntryException;

	
}
