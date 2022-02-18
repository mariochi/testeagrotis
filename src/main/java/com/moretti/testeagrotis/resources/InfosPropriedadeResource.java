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

import com.moretti.testeagrotis.entities.InfosPropriedade;
import com.moretti.testeagrotis.services.InfosPropriedadeService;

@RestController
@RequestMapping(value = "/infos")
public class InfosPropriedadeResource {
	@Autowired
	private InfosPropriedadeService service;
	@GetMapping
	public ResponseEntity<List<InfosPropriedade>> ListAll()
	{
		List<InfosPropriedade> list = service.FindAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<InfosPropriedade> GetById(@PathVariable Long id)	{
		InfosPropriedade ip = service.FindById(id);
		return ResponseEntity.ok().body(ip);
	}
	
	@PostMapping
	public ResponseEntity<InfosPropriedade> Insert(@RequestBody InfosPropriedade ip ){
		InfosPropriedade rt = service.Insert(ip);
		URI uri = ServletUriComponentsBuilder.
				  fromCurrentRequest().
				  path("/{id}").
				  buildAndExpand(rt.getId()).toUri();
		return ResponseEntity.created(uri).body(rt);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<InfosPropriedade> Update(@PathVariable Long id, @RequestBody InfosPropriedade ip){
		InfosPropriedade rt = service.Update(id, ip);
		return ResponseEntity.ok().body(rt);
	}
	

}
