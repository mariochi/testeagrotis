package com.moretti.testeagrotis.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moretti.testeagrotis.entities.Laboratorio;
import com.moretti.testeagrotis.services.LaboratorioService;

@RestController
@RequestMapping(value = "/labs")
public class LaboratorioResource {
	
	@Autowired
	private LaboratorioService service;
	
	@GetMapping
	public ResponseEntity<List<Laboratorio>> ListAll()
	{
		List<Laboratorio> l = service.FindAll();
		return ResponseEntity.ok().body(l);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Laboratorio> GetById(@PathVariable Long id)
	{
		try 
		{
			Laboratorio l = service.FindById(id);
			return ResponseEntity.ok().body(l);
		}
		catch (Exception ex)
		{
			return ResponseEntity.badRequest().body(null);
		}
	}
}


