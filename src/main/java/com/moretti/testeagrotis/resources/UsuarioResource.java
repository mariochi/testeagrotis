package com.moretti.testeagrotis.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.moretti.testeagrotis.entities.Usuario;
import com.moretti.testeagrotis.services.UsuarioService;

@RestController
@RequestMapping(value = "")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> FindAll()
	{
		return ResponseEntity.ok().body(service.FindAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> FindById(@PathVariable Long id)
	{
		Usuario u = service.FindById(id);
		return ResponseEntity.ok().body(u);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> Insert(@RequestBody Usuario u)
	{
		Usuario rt = service.Insert(u);
		URI uri = ServletUriComponentsBuilder.
				  fromCurrentRequest().
				  path("/{id}").
				  buildAndExpand(rt.getId()).toUri();
		return ResponseEntity.created(uri).body(rt);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Long id){
		service.Delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> Update(@PathVariable Long id, @RequestBody Usuario u)
	{
		Usuario rt = service.Update(id, u);
		return ResponseEntity.ok().body(rt);
	}
}
