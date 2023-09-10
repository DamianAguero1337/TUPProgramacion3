package com.utn.persistenciaEnJPA.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad{
    private String fecha;
    private int numero;
    private Double descuento;
    private enum formaPago{
        EFECTIVO, TARJETA_CREDITO, TARJETA_DEBITO, MERCADO_PAGO
    }
    private int total;
}
