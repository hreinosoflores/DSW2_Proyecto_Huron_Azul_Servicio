package service;

import beans.*;
import dao.*;
import test.PruebasDAO;

public class Huron_Azul_Service {

	CategoriaDAO cat_dao = new CategoriaDAO();
	CitaDAO ci_dao = new CitaDAO();
	PedidoDAO ped_dao = new PedidoDAO();
	ProductoDAO pro_dao = new ProductoDAO();
	SedeDAO s_dao = new SedeDAO();
	UsuarioDAO u_dao = new UsuarioDAO();
	PruebasDAO test_dao = new PruebasDAO();

	public BeanCategoriaProd[] cat_listar() {
		return cat_dao.listar();
	}

	public String ci_registrar(BeanCita c) {
		return ci_dao.registrar(c);
	}

	public BeanCitaTuneado[] ci_listar(String usuario) {
		return ci_dao.listar(usuario);
	}

	public BeanCitaTuneado ci_detalle(String nrocita) {
		return ci_dao.detalle(nrocita);
	}

	public String ci_cancelar(String nrocita) {
		return ci_dao.cancelar(nrocita);
	}

	public String ped_registrar(BeanPedido p, BeanPedidoDetalle[] lista_detalle) {
		return ped_dao.registrar(p, lista_detalle);
	}

	public BeanPedidoTuneado[] ped_listar(String usuario) {
		return ped_dao.listar(usuario);
	}

	public BeanPedidoTuneado ped_detalle(String codpedido) {
		return ped_dao.detalle(codpedido);
	}

	public BeanProducto[] pro_listar(String TIPO_USUARIO, String P_CATPROD, String P_DESCPROD) {
		return pro_dao.listar(TIPO_USUARIO, P_CATPROD, P_DESCPROD);
	}

	public String pro_registrar(BeanProducto p) {
		return pro_dao.registrar(p);
	}

	public String pro_editar(BeanProducto p) {
		return pro_dao.editar(p);
	}

	public String pro_inactivar(String codprod) {
		return pro_dao.inactivar(codprod);
	}

	public String pro_autogenera() {
		return pro_dao.autogenera();
	}

	public BeanSede[] s_listar() {
		return s_dao.listar();
	}

	public String u_registrar(BeanUsuario u) {
		return u_dao.registrar(u);
	}

	public String u_editar(BeanUsuario u) {
		return u_dao.editar(u);
	}

	public BeanUsuario u_logueo(String id, String pass) {
		return u_dao.logueo(id, pass);
	}

	/* Pruebas */
	public void listaBeanPedidoDetalle(BeanPedidoDetalle[] lista_detalle) {
		test_dao.listaBeanPedidoDetalle(lista_detalle);
	}

	public void listaBeanProducto(BeanProducto[] lista_prod) {
		test_dao.listaBeanProducto(lista_prod);
	}

	public void listaBeanPedido(BeanPedido[] lista_pedido) {
		test_dao.listaBeanPedido(lista_pedido);
	}
}
