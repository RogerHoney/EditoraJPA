package utd.principal.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import utd.classes.jpa.Livro;

public class TesteCriteria {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("editorautd");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder criteriabuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Livro> criteriaQuery = criteriabuilder.createQuery(Livro.class);
		Root <Livro> livro = criteriaQuery.from(Livro.class);
		criteriaQuery.select(livro);
		
		TypedQuery<Livro> query = manager.createQuery(criteriaQuery);
		List<Livro>livros = query.getResultList();
		for(Livro livrox:livros){
			System.out.println(livrox.getNome());
			System.out.println(livrox.getGenero());
		}
	}

}
