package com.moretti.testeagrotis.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moretti.testeagrotis.entities.Usuario;
import com.moretti.testeagrotis.services.UsuarioService;

@RestController
@RequestMapping(value = "")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public List<Usuario> FindAll()
	{
		return service.FindAll();
	}
}
