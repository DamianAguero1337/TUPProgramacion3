package com.utn.persistenciaEnJPA;

import com.utn.persistenciaEnJPA.entidades.*;
import com.utn.persistenciaEnJPA.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersistenciaEnJpaApplication {

	@Autowired
	ClienteRepositorio clienteRepositorio;
	@Autowired
	ConfiguracionGeneralRepositorio configuracionGeneralRepositorio;
	@Autowired
	DetallePedidoRepositorio detallePedidoRepositorio;
	@Autowired
	DomicilioRepositorio domicilioRepositorio;
	@Autowired
	FacturaRepositorio facturaRepositorio;
	@Autowired
	PedidoRepositorio pedidoRepositorio;
	@Autowired
	ProductoRepositorio productoRepositorio;
	@Autowired
	RubroRepositorio rubroRepositorio;
	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(PersistenciaEnJpaApplication.class, args);
	}
	@Bean
	CommandLineRunner init(ClienteRepositorio ClienteRepositorio) {
		return args -> {

			Usuario usuario1 = Usuario.builder()
					.nombre("Roberto")
					.password("tito123")
					.rol("Gerente")
					.build();

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Barcala")
					.numero(120)
					.localidad("Maipu")
					.build();

			Cliente cliente1 = Cliente.builder()
					.nombre("Damian")
					.apellido("Aguero")
					.telefono("2613836688")
					.email("aguerodamian15@gmail.com")
					.build();

			Producto producto1 = Producto.builder()
					.tipo("INSUMO")
					.tiempoEstimadoCocina(15)
					.denominacion("hamburguesa triple")
					.precioVenta(1899.99)
					.precioCompra(1199.99)
					.stockActual(10)
					.stockMinimo(7)
					.unidadMedida("unidades")
					.foto("hamburguesaTriple.jpg")
					.receta("Ingredientes:\n" +
							"\n" +
							"Para las hamburguesas:\n" +
							"\n" +
							"450 gramos de carne molida (puedes usar carne de res, cerdo, pavo o una mezcla)\n" +
							"Sal y pimienta al gusto\n" +
							"1 cucharada de aceite de cocina (para la parrilla o la sartén)\n" +
							"3 panes de hamburguesa\n" +
							"Para los ingredientes adicionales (puedes personalizarlos a tu gusto):\n" +
							"\n" +
							"3 lonchas de queso (puedes usar cheddar, suizo, o tu favorito)\n" +
							"Lechuga fresca\n" +
							"Tomate en rodajas\n" +
							"Cebolla roja en rodajas finas\n" +
							"Pepinillos en rodajas\n" +
							"Ketchup y mostaza (u otras salsas de tu elección)\n" +
							"Instrucciones:\n" +
							"\n" +
							"Precalienta tu parrilla o sartén a fuego medio-alto.\n" +
							"\n" +
							"Divide la carne molida en tres porciones iguales y forma cada porción en una hamburguesa del mismo tamaño que el pan.\n" +
							"\n" +
							"Sazona las hamburguesas con sal y pimienta al gusto.\n" +
							"\n" +
							"Agrega una cucharada de aceite a la parrilla o sartén caliente y coloca las hamburguesas en la superficie caliente.\n" +
							"\n" +
							"Cocina las hamburguesas durante aproximadamente 3-4 minutos por cada lado para lograr un término de cocción medio (ajusta el tiempo según tu preferencia de cocción).\n" +
							"\n" +
							"Durante los últimos minutos de cocción, coloca una loncha de queso sobre cada hamburguesa para que se derrita.\n" +
							"\n" +
							"Mientras las hamburguesas se cocinan, puedes tostar ligeramente los panes en la parrilla o en una tostadora.\n" +
							"\n" +
							"Cuando las hamburguesas estén listas y el queso esté derretido, retíralas de la parrilla o sartén.\n" +
							"\n" +
							"Ahora es el momento de armar tu hamburguesa triple. Coloca una hamburguesa en la parte inferior de cada pan, luego agrega tus ingredientes adicionales favoritos, como lechuga, tomate, cebolla y pepinillos. Puedes agregar ketchup y mostaza al gusto.\n" +
							"\n" +
							"Finalmente, coloca la parte superior del pan sobre los ingredientes y presiona ligeramente para que todo quede en su lugar.");

			Rubro rubro1 = Rubro.builder()
					.denominacion("gastronomia")
					.build();

			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(3799.98)
					.build();

			Factura factura1 = Factura.builder()
					.fecha("05/09/23")
					.numero(199)
					.descuento(0)
					.formaPago("EFECTIVO")
					.total(3799.98)
					.build();

			Pedido pedido1 = Pedido.builder()
					.fecha("05/09/23")
					.estado("PREPARACION")
					.horaEstimadaEntrega("21:45")
					.tipoEnvio("DELIVERY")
					.total(3799.98)
					.build();

			ConfiguracionGeneral configuracionGeneral1 = ConfiguracionGeneral.builder()
					.cantidadCocineros(1)
					.emailEmpresa("pedidosya@gmail.com")
					.tokenMercadoPago("123456789")
					.build();

			// Asociaciones
			usuario1.agregarPedido(pedido1);
			cliente1.setDomicilio(domicilio1);
			cliente1.agregarPedido(pedido1);
			detallePedido1.setProducto(producto1);
			pedido1.agregarDetallePedido(detallePedido1);
			pedido1.setDomicilio(domicilio1);
			pedido1.setFactura(factura1);
			rubro1.agregarProducto(producto1);

			// Guardar los objetos en la base de datos

			ClienteRepositorio.save(cliente1);
			ConfiguracionGeneralRepositorio.save(configuracionGeneral1);
			DetallePedidoRepositorio.save(detallePedido1);
			DomicilioRepositorio.save(domicilio1);
			FacturaRepositorio.save(factura1);
			PedidoRepositorio.save(pedido1);
			ProductoRepositorio.save(producto1);
			RubroRepositorio.save(rubro1);
			UsuarioRepositorio.save(usuario1);

			// Recuperar los objetos desde la base de datos
			Cliente clienteRecuperado = ClienteRepositorio.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null) {
				System.out.println("Objeto cliente recuperado con exito");
			}

			ConfiguracionGeneral configuracionGeneralRecuperado = ConfiguracionGeneralRepositorio.findById(configuracionGeneral1.getId()).orElse(null);
			if (configuracionGeneralRecuperado != null) {
				System.out.println("Objeto configuracionGeneral recuperado con exito");
			}

			DetallePedido detallePedidoRecuperado = DetallePedidoRepositorio.findById(detallePedido1.getId()).orElse(null);
			if (detallePedidoRecuperado != null) {
				System.out.println("Objeto detallePedido recuperado con exito");
			}

			Domicilio domicilioRecuperado = DomicilioRepositorio.findById(domicilio1.getId()).orElse(null);
			if (domicilioRecuperado != null) {
				System.out.println("Objeto domicilio recuperado con exito");
			}

			Factura facturaRecuperado = FacturaRepositorio.findById(factura1.getId()).orElse(null);
			if (facturaRecuperado != null) {
				System.out.println("Objeto factura recuperado con exito");
			}

			Pedido pedidoRecuperado = PedidoRepositorio.findById(pedido1.getId()).orElse(null);
			if (pedidoRecuperado != null) {
				System.out.println("Objeto pedido recuperado con exito");
			}

			Producto productoRecuperado = ProductoRepositorio.findById(producto1.getId()).orElse(null);
			if (productoRecuperado != null) {
				System.out.println("Objeto producto recuperado con exito");
			}

			Rubro rubroRecuperado = RubroRepositorio.findById(rubro1.getId()).orElse(null);
			if (rubroRecuperado != null) {
				System.out.println("Objeto rubro recuperado con exito");
			}

			Usuario usuarioRecuperado = UsuarioRepositorio.findById(usuario1.getId()).orElse(null);
			if (usuarioRecuperado != null) {
				System.out.println("Objeto usuario recuperado con exito");
			}

		};
	}
}

