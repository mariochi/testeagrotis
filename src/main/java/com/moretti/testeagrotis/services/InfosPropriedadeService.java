package com.moretti.testeagrotis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moretti.testeagrotis.entities.InfosPropriedade;
import com.moretti.testeagrotis.repositories.InfosPropriedadeRepository;
import com.moretti.testeagrotis.services.exceptions.ResourceNotFoundException;

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
		return rt.orElseThrow(() -> new ResourceNotFoundException(id)) ;
	}
	
	public InfosPropriedade Insert(InfosPropriedade ip)
	{
		if(ip.getNome() != null) {
			return repository.save(ip);
		}
		throw new IllegalArgumentException();
	}
	public InfosPropriedade Update(Long id, InfosPropriedade ip){
		if(ip.getNome() != null) {
			InfosPropriedade old = repository.getReferenceById(id);
			old.setNome(ip.getNome());
			return repository.save(old);
		}
		throw new IllegalArgumentException();
	}
}
