package br.com.WService.soap;

import javax.xml.ws.Endpoint;
public class ProdutoPublish {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9877/produto", new ProdutoServerImp());
	}

}
