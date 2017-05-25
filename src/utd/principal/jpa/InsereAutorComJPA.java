package utd.principal.jpa;

import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utd.classes.jpa.Autor;
import utd.classes.jpa.Editora;

public class InsereAutorComJPA {

	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("editorautd");
		
		EntityManager manager = factory.createEntityManager();
		Autor novoAutor = new Autor();
		Scanner entrada = new Scanner(System.in);
			System.out.println("Digite o nome da autor:");
		novoAutor.setNome(entrada.nextLine());
		
		entrada.close();
		
		manager.persist(novoAutor);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		
		System.out.println("Editora cadastrada com id:" + novoAutor.getId());
		manager.close();
		factory.close();

	}

}
