package utd.principal.jpa;

import javax.persistence.Query;

import utd.classes.jpa.Editora;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListaEditorasComJPA {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-utd");
		
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery ("SELECT e FROM Editora e");
		List<Editora> editoras = query.getResultList();
		for(Editora e :editoras){
			System.out.println("Editora: "+ e.getNome() + "-" + e.getEmail() );
			manager.close();
			factory.close();
		}
	}

}
