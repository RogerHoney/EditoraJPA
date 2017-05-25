package utd.principal.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import utd.classes.jpa.Livro;

public class TesteParametros {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence				
				.createEntityManagerFactory ("editorautd");
				EntityManager manager = factory.createEntityManager () ;
				Query query = manager.createNamedQuery ("Livro.findByGenero") ;
				query.setParameter ("genero", "Fantasia");
				
				List <Livro> livros = query.getResultList() ;
				
				for (Livro livro:livros) {
				
				System.out.println("Nome: "+livro.getNome()) ;
				System.out.println("Gênero: " +livro.getGenero()) ;
				}
				
				manager.close();
				factory.close();


	}

}
