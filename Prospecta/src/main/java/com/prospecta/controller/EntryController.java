package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.dto.EntryDto;
import com.prospecta.exceptions.EntryException;
import com.prospecta.models.Entry;
import com.prospecta.service.EntryService;

@RestController
public class EntryController {

	@Autowired
	private EntryService entryService;
	
	@PostMapping("/entries")
    public ResponseEntity<Entry> addtheEntryHandler(){
        Entry entry = entryService.addtheEntry();
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @GetMapping("/entries/{category}")
    public ResponseEntity<List<EntryDto>> getEntryByCategoryHandler(@PathVariable("category") String category) throws EntryException{
        List<EntryDto> listOfEntryDtos= entryService.getEntryByCategory(category);
        return new ResponseEntity<>(listOfEntryDtos,HttpStatus.OK);
    }
}
