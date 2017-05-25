package utd.principal.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import utd.classes.jpa.Autor;
import utd.classes.jpa.Livro;

public class TesteNamedQuery {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory ("editorautd");
				EntityManager manager = factory.createEntityManager ();
				
				Query query = manager.createNamedQuery ("Autor.findAll");
				List <Autor> autores = query.getResultList();
				
				for (Autor autor:autores) {
				System.out.println ("Autor: " +autor.getNome());
				Collection <Livro> livros = autor.getLivros();
				
				for (Livro livro : livros) {
				System.out.println ("Livro: " +livro.getNome ());
				System.out.println ("Livro: " +livro.getGenero ());
				System.out.println ();
				 }
				 System.out.println ();
				 }
				
				manager.close();
				factory.close();

	}

}
