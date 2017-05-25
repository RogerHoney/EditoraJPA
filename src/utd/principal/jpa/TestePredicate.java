package utd.principal.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import utd.classes.jpa.Livro;

public class TestePredicate {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory ("editorautd");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder criteriabuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Livro> criteriaQuery = criteriabuilder.createQuery(Livro.class);
		Root <Livro> livro = criteriaQuery.from(Livro.class);
		
		criteriaQuery.select(livro);
		Predicate predicate = criteriabuilder.equal(livro.get("nome"), "Programando com JPA");
		criteriaQuery.where(predicate);
		TypedQuery<Livro>query = manager.createQuery(criteriaQuery);
		List<Livro> livros = query.getResultList();
		for(Livro livrox : livros){
			System.out.println("Id: "+livrox.getId());
			System.out.println("Nome: "+livrox.getNome());
			System.out.println("Gênero: "+livrox.getGenero());
		}

	}

}
