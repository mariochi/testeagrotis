package com.moretti.testeagrotis.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.moretti.testeagrotis.entities.InfosPropriedade;
import com.moretti.testeagrotis.entities.Laboratorio;
import com.moretti.testeagrotis.entities.Usuario;
import com.moretti.testeagrotis.repositories.InfosPropriedadeRepository;
import com.moretti.testeagrotis.repositories.LaboratorioRepository;
import com.moretti.testeagrotis.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private InfosPropriedadeRepository inforepository;
	@Autowired
	private LaboratorioRepository  labrepository;
	@Autowired
	private UsuarioRepository usurepository;

	@Override
	public void run(String... args) throws Exception {
		InfosPropriedade i1 = new InfosPropriedade(null,"Nome Exemplo da fazenda");
		inforepository.save(i1);
		
		Laboratorio l1 = new Laboratorio(null,"Nome exemplo do laboratório");
		labrepository.save(l1);
		
		Usuario u1 = new Usuario(null, Instant.now(), Instant.now().plus(1, ChronoUnit.DAYS),i1, "XXX.XXX.XXX/0001.XXX",l1,"Teste");
		usurepository.save(u1);
	}
}
