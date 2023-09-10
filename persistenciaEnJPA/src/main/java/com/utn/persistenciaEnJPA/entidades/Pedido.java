package com.utn.persistenciaEnJPA.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntidad{
    private String fecha;
    private enum estado{
        INICIADO, PREPARACION, ENTREGADO
    }
    private String horaEstimadaEntregada;
    private enum tipoEnvio{
        DELIVERY, ENTREGA
    }
    private Double total;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "factura_id")

    @Builder.Default

    private Factura factura;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilio_id")

    @Builder.Default

    private Domicilio domicilio;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")

    @Builder.Default
    private List<DetallePedido> detallesPedido = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido detalleNuevo){
        detallesPedido.add(detalleNuevo);
    }

}
