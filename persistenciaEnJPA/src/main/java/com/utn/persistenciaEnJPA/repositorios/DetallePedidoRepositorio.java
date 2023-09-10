package com.utn.persistenciaEnJPA.repositorios;

import com.utn.persistenciaEnJPA.entidades.Cliente;
import com.utn.persistenciaEnJPA.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, Long> {
}
