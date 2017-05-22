package utd.principal.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utd.classes.jpa.Revista;

public class AdicionaRevista {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("editorautd");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		for(int i = 0; i < 10; i++){
			Revista revista = new Revista();
			revista.setNome("Revista "+(i+1));
			revista.setPreco(10.0*(i + 1));
			manager.persist(revista);
		}
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		

	}

}
