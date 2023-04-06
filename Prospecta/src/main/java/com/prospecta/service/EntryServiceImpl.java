package com.prospecta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.dto.AllEntrys;
import com.prospecta.dto.EntryDto;
import com.prospecta.exceptions.EntryException;
import com.prospecta.models.Entry;
import com.prospecta.repository.EntryRepository;

@Service
public class EntryServiceImpl implements EntryService{
	
	@Autowired
	private EntryRepository entryRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Entry addtheEntry() {
		// TODO Auto-generated method stub
		String api = "https://api.publicapis.org/random";

        ResponseEntity<AllEntrys> allEntriesResponseEntity = restTemplate.getForEntity(api, AllEntrys.class);

        Entry entry = allEntriesResponseEntity.getBody().getEntries().get(0);

        return entryRepository.save(entry);
	}
	
	@Override
	public List<EntryDto> getEntryByCategory(String category) throws EntryException {
		// TODO Auto-generated method stub
		String api = "https://api.publicapis.org/entries";

        ResponseEntity<AllEntrys> allEntryResponseEntity = restTemplate.getForEntity(api, AllEntrys.class);

        System.out.println(allEntryResponseEntity.getBody().getEntries());
        
        List<EntryDto> listOfEntryDtos = new ArrayList<>();

        for(Entry entry: allEntryResponseEntity.getBody().getEntries()){
        	
            if(category.equals(entry.getCategory())){
            	
                listOfEntryDtos.add(new EntryDto(entry.getTitle(),entry.getDescription()));
                
            }
            System.out.println(listOfEntryDtos);
        }

        if(listOfEntryDtos.size()==0) {
        	 throw new EntryException("There is no Entry of category : "+category);
        }
           

        return listOfEntryDtos;
	}

	

}
