package br.com.WService.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding.Style;
import br.com.WService.entidade.Produto;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ProdutoServer {
	
	@WebMethod(operationName = "getProduto")
	@WebResult(name = "retorno")
	Produto getProduto(@WebParam(name = "id") int id);
	
	@WebMethod(operationName = "deleteProduto")
	@WebResult(name = "retorno")
	String deleteProduto(@WebParam(name = "id") int id);
	
	@WebMethod(operationName = "list")
	@WebResult(name = "retorno")
	Produto[] getProdutos();

	@WebMethod(operationName = "edit")
	String editProduto(@WebParam(name = "id")int id, @WebParam(name = "descricao")String descricao, @WebParam(name = "valor")double valor, @WebParam(name = "quantidade_estoque")int quantidade_estoque);
	
	@WebMethod(operationName = "addProduto")
	String addProduto(@WebParam(name = "descricao")String descricao, @WebParam(name = "valor")double valor, @WebParam(name = "quantidade_estoque")int quantidade_estoque);
}