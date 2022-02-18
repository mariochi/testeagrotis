package com.moretti.testeagrotis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moretti.testeagrotis.entities.InfosPropriedade;
import com.moretti.testeagrotis.repositories.InfosPropriedadeRepository;

@Service
public class InfosPropriedadeService {

	@Autowired
	private InfosPropriedadeRepository repository;
	
	
	public List<InfosPropriedade> FindAll()
	{
		return repository.findAll();
	}
	
	public InfosPropriedade FindById(Long id)
	{
		Optional<InfosPropriedade> rt = repository.findById(id);
		return rt.get();
	}
}
