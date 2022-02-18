package com.moretti.testeagrotis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moretti.testeagrotis.entities.Laboratorio;
import com.moretti.testeagrotis.repositories.LaboratorioRepository;

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
		return rt.get();
	}

}
