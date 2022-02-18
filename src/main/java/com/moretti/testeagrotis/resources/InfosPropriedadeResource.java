package com.moretti.testeagrotis.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<InfosPropriedade> GetById(@PathVariable Long id)
	{
		try 
		{
			InfosPropriedade ip = service.FindById(id);
			return ResponseEntity.ok().body(ip);
		}
		catch (Exception ex)
		{
			return ResponseEntity.badRequest().body(null);
		}
	}
	

}
