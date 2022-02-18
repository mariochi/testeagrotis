package com.moretti.testeagrotis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moretti.testeagrotis.entities.Usuario;
import com.moretti.testeagrotis.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	
	public List<Usuario> FindAll()
	{
		List<Usuario> l = repository.findAll();
		return l;
	}
	
	public Usuario FindById(Long id)
	{
		Optional<Usuario> rt = repository.findById(id);
		return rt.get();
	}
	
	public Usuario Insert(Usuario u)
	{
		if(u.getLaboratorio() == null || u.getInfoPropriedade() == null) 
		{
			throw new IllegalArgumentException("lab and info cannot be null");
		}
		Usuario rt = repository.save(u);
		return rt;
	}
}
