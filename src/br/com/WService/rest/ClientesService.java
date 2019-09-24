package br.com.WService.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.WService.dao.ClienteDAO;
import br.com.WService.entidade.Cliente;

@Path("/clientes")
public class ClientesService {

	private ClienteDAO clienteDAO;
	private Cliente cliente;
	private static final String CHARSET_UTF8 = "charset_UTF8";
	
	public ClientesService() {
		clienteDAO = new ClienteDAO();
		cliente = new Cliente();
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> getClientes() {
		List<Cliente> l = new ArrayList<>();

		cliente = null;

		try {
			l = clienteDAO.getClientes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteCliente(@PathParam("id") int idCliente) {
		String msg = null;

		try {
			clienteDAO.deleteCliente(idCliente);
			msg = "Cliente removido com sucesso.";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Problemas para remover cliente";
		}
		return msg;
	}
	
	@GET
	@Path("/get/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente getCliente(@PathParam("id") int idCliente) {
	
		cliente = null;

		try {
			cliente = clienteDAO.getCliente(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String  editCliente(Cliente c, @PathParam("id") int idCliente) {
		String msg = "";
		try {
			clienteDAO.editCliente(c, idCliente);
			msg = "Cliente editado com sucesso.";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao editar cliente.";
		}
		return msg;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String  addCliente(Cliente c) {
		String msg = "";
		try {
			clienteDAO.addCliente(c);
			msg = "Cliente adicionado com sucesso.";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao adicionar cliente.";
		}
		return msg;
	}

	
}
