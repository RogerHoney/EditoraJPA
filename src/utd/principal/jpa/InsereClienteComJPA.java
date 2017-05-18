package utd.principal.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utd.classes.jpa.Cliente;
import utd.classes.jpa.Endereco;

public class InsereClienteComJPA {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("editorautd");
		EntityManager manager = factory.createEntityManager();
		
		Cliente c = new Cliente();
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o nome do cliente: ");
			c.setNome(entrada.nextLine());
		System.out.println("Digite o cpf do cliente: ");
			c.setCpf(entrada.nextLine());
			
			Endereco endereco = new Endereco();
			c.setEndereco(endereco);
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
		manager.persist(c);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		System.out.println("Cliente cadastro com id: " + c.getId());
		manager.close();
		factory.close();
	}

}
