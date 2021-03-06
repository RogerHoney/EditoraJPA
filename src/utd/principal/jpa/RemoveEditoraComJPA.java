package utd.principal.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utd.classes.jpa.Editora;

public class RemoveEditoraComJPA {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");
		EntityManager manager = factory.createEntityManager();
		
		Scanner entrada =new Scanner(System.in);
		
		System.out.println("Digite o id da editora que deseja remover: ");
		Long id = Long.parseLong(entrada.nextLine());
		
		entrada.close();
		
		Editora e = manager.find(Editora.class, id);
		manager.remove (e);
		manager.getTransaction (). begin ();
		manager.getTransaction (). commit ();
		manager.close ();
		factory.close ();


	}

}
