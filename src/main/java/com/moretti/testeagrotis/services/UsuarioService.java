package com.moretti.testeagrotis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moretti.testeagrotis.entities.Usuario;
import com.moretti.testeagrotis.repositories.UsuarioRepository;
import com.moretti.testeagrotis.services.exceptions.ResourceNotFoundException;

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
		return rt.orElseThrow(() -> new ResourceNotFoundException(id) );
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
	
	public void Delete(Long id) {
		repository.deleteById(id);
	}
	
	public Usuario Update(Long id, Usuario obj) {
		if(obj.getLaboratorio() == null || obj.getInfoPropriedade() == null) 
		{
			throw new IllegalArgumentException("lab and info cannot be null");
		}
		Usuario old = repository.getReferenceById(id);
		UpdateUser(old,obj);
		return repository.save(old);
	}

	private void UpdateUser(Usuario old, Usuario obj) {
		old.setNome(obj.getNome());
		old.setDataInicial(obj.getDataInicial());
		old.setDataFinal(obj.getDataFinal());
		old.setCnpj(obj.getCnpj());
		old.setInfoPropriedade(obj.getInfoPropriedade());
		old.setLaboratorio(obj.getLaboratorio());
		old.setObservacoes(obj.getObservacoes());
		
	}
}
