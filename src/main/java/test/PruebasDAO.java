package test;

import beans.BeanPedido;
import beans.BeanPedidoDetalle;
import beans.BeanProducto;

public class PruebasDAO {

	public void listaBeanPedidoDetalle(BeanPedidoDetalle[] lista_detalle) {
		for (BeanPedidoDetalle bd : lista_detalle) {
			System.out.println(bd);
		}
	}

	public void listaBeanProducto(BeanProducto[] lista_prod) {
		for (BeanProducto beanProducto : lista_prod) {
			System.out.println(beanProducto);
		}
	}

	public void listaBeanPedido(BeanPedido[] lista_pedido) {
		for (BeanPedido beanPedido : lista_pedido) {
			System.out.println(beanPedido);
		}
	}

}
