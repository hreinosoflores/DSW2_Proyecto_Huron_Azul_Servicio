package test;

import java.util.ArrayList;
import java.util.List;

import beans.*;
import service.Huron_Azul_Service;


public class Prueba01 {

	public static void main(String[] args) {
		System.out.println("\n");
		System.out.println("************CATEGORIA*******************");
		BeanCategoriaProd[] cat_listado = new Huron_Azul_Service().cat_listar();
		for (BeanCategoriaProd c : cat_listado) System.out.println(c);
		
		
		System.out.println("\n");
		System.out.println("**************CITA*********************");
		BeanCita ci_reg = new BeanCita("1","1","2019-11-16 15:00:00","1");
		System.out.println(new Huron_Azul_Service().ci_registrar(ci_reg));
		BeanCitaTuneado[] ci_tun_listado = new Huron_Azul_Service().ci_listar(null);
		for (BeanCitaTuneado c : ci_tun_listado) System.out.println(c);
		System.out.println(new Huron_Azul_Service().ci_cancelar("1"));
		System.out.println(new Huron_Azul_Service().ci_detalle("1"));
		
		
		System.out.println("\n");
		System.out.println("**************PEDIDO*******************");
		BeanPedido ped_cab_reg = new BeanPedido("4","2019-4-9 12:30:00","1","1","1","34.00");
		List<BeanPedidoDetalle> ped_det_listado = new ArrayList<BeanPedidoDetalle>();
		BeanPedidoDetalle ped_det_reg_1 = new BeanPedidoDetalle("6","1","1","17.00");
		BeanPedidoDetalle ped_det_reg_2 = new BeanPedidoDetalle("6","2","1","17.00");
		ped_det_listado.add(ped_det_reg_1);
		ped_det_listado.add(ped_det_reg_2);
		System.out.println(new Huron_Azul_Service().ped_registrar(ped_cab_reg, ped_det_listado.toArray(new BeanPedidoDetalle[] {})));
		BeanPedidoTuneado[]  ped_tun_listado = new Huron_Azul_Service().ped_listar(null);		
		for (BeanPedidoTuneado p : ped_tun_listado) System.out.println(p);
		System.out.println(new Huron_Azul_Service().ped_detalle("1"));
		
		System.out.println("\n");
		System.out.println("**************PRODUCTO******************");
		BeanProducto pro_reg = new BeanProducto("GALLETITAS DE PESCADO 2","27.50","156","","1");
		BeanProducto pro_edi = new BeanProducto("9","GALLETITAS DE PESCADO 2","28.50","120","","1");		
		System.out.println(new Huron_Azul_Service().pro_registrar(pro_reg));
		System.out.println(new Huron_Azul_Service().pro_editar(pro_edi));
		BeanProducto[] pro_listado = new Huron_Azul_Service().pro_listar("1","1","misco");		
		for (BeanProducto p : pro_listado) 	System.out.println(p);
		System.out.println(new Huron_Azul_Service().pro_inactivar("1"));
		System.out.println(new Huron_Azul_Service().pro_autogenera());
		
		System.out.println("\n");
		System.out.println("*****************SEDE*******************");
		BeanSede[] s_listado = new Huron_Azul_Service().s_listar();
		for (BeanSede s : s_listado) System.out.println(s);
		
		
		System.out.println("\n");
		System.out.println("**************USUARIO*******************");
		BeanUsuario u_reg = new BeanUsuario("Armando","Elescano","Av Cantolao 320","45162356","1","1993-7-8","","","Armando","1234567890");
		BeanUsuario u_edi = new BeanUsuario("5", "Av Cantolao 320", "aelescano@gmail.com", "", "Armando","1234567890");		
		System.out.println(new Huron_Azul_Service().u_registrar(u_reg));
		System.out.println(new Huron_Azul_Service().u_editar(u_edi));
		System.out.println(new Huron_Azul_Service().u_logueo("AEROMAN", "0123456789"));
		
		
		

	}

}
