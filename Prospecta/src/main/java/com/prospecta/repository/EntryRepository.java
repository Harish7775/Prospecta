package com.prospecta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.dto.EntryDto;
import com.prospecta.models.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Integer>{

	public List<EntryDto> getEntryByCategory(String category);
}
