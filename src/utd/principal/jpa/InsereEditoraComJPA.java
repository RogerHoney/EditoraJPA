package utd.principal.jpa;

import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utd.classes.jpa.Editora;
import utd.classes.jpa.Endereco;

public class InsereEditoraComJPA {

	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("livraria-pu");
		
		EntityManager manager = factory.createEntityManager();
		Editora novaEditora = new Editora();
		Scanner entrada = new Scanner(System.in);
			System.out.println("Digite o nome da editora:");
		novaEditora.setNome(entrada.nextLine());
			System.out.println("Digite o email:");
		novaEditora.setEmail(entrada.nextLine());
		
		
		Endereco endereco = new Endereco();
		novaEditora.setEndereco(endereco);
	System.out.println("Digite o endereço do cliente: ");
	System.out.println("Digite o país: ");
		endereco.setPais(entrada.nextLine());
	System.out.println("Estado: ");
		endereco.setEstado(entrada.nextLine());
	System.out.println("Cidade: ");
		endereco.setCidade(entrada.nextLine());
	System.out.println("Logadouro: ");
		endereco.setLogadouro(entrada.nextLine());
	System.out.println("Número: ");
		endereco.setNumero(entrada.nextLine());
	System.out.println("Complemento: ");
		endereco.setComplemento(entrada.nextLine());
	System.out.println("Cep: ");
		endereco.setCep(entrada.nextLine());
		
		
		entrada.close();
		manager.persist(novaEditora);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		
		System.out.println("Editora cadastrada com id:" + novaEditora.getId());
		manager.close();
		factory.close();

	}

}
