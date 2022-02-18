package com.moretti.testeagrotis.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Laboratorio> Insert(@RequestBody Laboratorio lab ){
		Laboratorio rt = service.Insert(lab);
		URI uri = ServletUriComponentsBuilder.
				  fromCurrentRequest().
				  path("/{id}").
				  buildAndExpand(rt.getId()).toUri();
		return ResponseEntity.created(uri).body(rt);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Laboratorio> Update(@PathVariable Long id, @RequestBody Laboratorio lab){
		Laboratorio rt = service.Update(id, lab);
		return ResponseEntity.ok().body(rt);
	}
}


