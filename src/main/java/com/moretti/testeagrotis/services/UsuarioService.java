package com.moretti.testeagrotis.services;

import java.util.List;

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
}
