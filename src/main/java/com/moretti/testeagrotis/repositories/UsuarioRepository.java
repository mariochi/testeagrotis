package com.moretti.testeagrotis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moretti.testeagrotis.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
