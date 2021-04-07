package test;

import beans.*;
//PROBANDO COMO SE ENVIAN LISTS DESDE C#
import service.Huron_Azul_Service;

public class Prueba02 {

	public static void main(String[] args) {
		BeanPedidoDetalle[] ped_det_listado = new BeanPedidoDetalle[] { new BeanPedidoDetalle("6", "1", "1", "17.00"),
				new BeanPedidoDetalle("6", "2", "1", "17.00") };

		BeanPedido[] ped_cab_listado_1 = new BeanPedido[] {};

		BeanPedido[] ped_cab_listado_2 = new BeanPedido[] { new BeanPedido() };

		BeanPedido[] ped_cab_listado_3 = new BeanPedido[] { null, new BeanPedido(),
				new BeanPedido("1", "2018-1-10", "1", "1", "1", "25.00") };

		new Huron_Azul_Service().listaBeanPedidoDetalle(ped_det_listado);

		System.out.println("***************Lista vacia**********************");
		new Huron_Azul_Service().listaBeanPedido(ped_cab_listado_1);
		System.out.println("***************Lista con bean vacio***********************");
		new Huron_Azul_Service().listaBeanPedido(ped_cab_listado_2);
		System.out.println("***************Lista con un bean null y un bean vacio*****************************");
		new Huron_Azul_Service().listaBeanPedido(ped_cab_listado_3);

	}

}
