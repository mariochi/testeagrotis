package com.moretti.testeagrotis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moretti.testeagrotis.entities.Laboratorio;
import com.moretti.testeagrotis.repositories.LaboratorioRepository;
import com.moretti.testeagrotis.services.exceptions.ResourceNotFoundException;

@Service
public class LaboratorioService {
	
	@Autowired
	private LaboratorioRepository repository;
	
	public List<Laboratorio> FindAll()
	{
		List<Laboratorio> rt = repository.findAll();
		return rt;
		
	}
	
	public Laboratorio FindById(Long id)
	{
		Optional<Laboratorio> rt = repository.findById(id);
		return rt.orElseThrow(() -> new ResourceNotFoundException(id)) ;
	}
	
	public Laboratorio Insert (Laboratorio l)
	{
		if(l.getNome() != null) {
			return repository.save(l);
		}
		throw new IllegalArgumentException();
		//return null;
	}
	
	public Laboratorio Update (Long id, Laboratorio l)
	{
		if(l.getNome() != null) {
			Laboratorio old = repository.getReferenceById(id);
			old.setNome(l.getNome());
			return repository.save(old);
		}
		throw new IllegalArgumentException();
	}

}
