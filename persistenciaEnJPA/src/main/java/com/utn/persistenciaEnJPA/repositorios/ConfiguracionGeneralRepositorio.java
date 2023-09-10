package com.utn.persistenciaEnJPA.repositorios;

import com.utn.persistenciaEnJPA.entidades.Cliente;
import com.utn.persistenciaEnJPA.entidades.ConfiguracionGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionGeneralRepositorio extends JpaRepository<ConfiguracionGeneral, Long> {
}
