package utd.principal.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utd.classes.jpa.Autor;
import utd.classes.jpa.Livro;

public class AdicionaLivroAutor {

	public static void main(String[] args) {
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory ("editorautd");
				EntityManager manager = factory.createEntityManager();
				manager.getTransaction().begin();
				Scanner entrada = new Scanner(System.in) ;
				Autor a = new Autor ();
				System.out.println("Digite o nome do autor: ");
				a.setNome (entrada.nextLine());
				Livro l = new Livro();
				System.out.println("Digite o nome do livro: ");
				l.setNome (entrada.nextLine());
				System.out.println("Digite o gênero do livro: ");
				l.setGenero (entrada.nextLine());
				a.getLivros().add(l);
				entrada.close();
				manager.persist(a);
				manager.persist(l);
				System.out.println ("Autor cadastrado com id " +a.getId());
				System.out.println ("Livro cadastrado com id " +l.getId());
				manager.getTransaction().commit();
				manager.close();
				factory.close();
	}

}
