package br.com.WService.soap;

import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.com.WService.entidade.Produto;

public class ProdutoClient {
	public static void main(String args[]) throws Exception {
		// URL do meu web service
		URL url = new URL("http://localhost:9877/produto?wsdl");

		QName qname = new QName("http://soap.WService.com.br/", "ProdutoServerImpService");

		Service ws = Service.create(url, qname);
		System.out.println(ws.getServiceName());
		ProdutoServer cli = ws.getPort(ProdutoServer.class);

		System.out.println("CONSULTA TODOS");
		Produto[] p = cli.getProdutos();
		System.out.println(p[0].getDescricao());
		System.out.println("-----------------");

//		System.out.println("CONSULTA POR CNPJ");
//		System.out.println((cli.getProduto(2).getDescricao()));
//		System.out.println("-----------------");

//		System.out.println("INSERE");
//		System.out.println(cli.addProduto("Banco", 390.00, 8));		
//		System.out.println("-----------------");

//		System.out.println("ALTERA");
//		System.out.println(cli.editProduto(34,"Cadeira", 145,22));
//		System.out.println("-----------------");

//		System.out.println("EXCLUI");
//		System.out.println(cli.deleteProduto(35));
//		System.out.println("-----------------");
	}
}
