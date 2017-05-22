package utd.principal.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import utd.classes.jpa.Revista;

public class Consultas {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("editorautd");
		EntityManager manager = factory.createEntityManager();
		
		/*Recuperando a quaqntidade de revista*/
		String jpql = "SELECT COUNT ( x ) FROM Revista x";
		TypedQuery <Long> consulta1 = manager.createQuery(jpql,Long.class);
		Long contador = consulta1.getSingleResult();
		System.out.println("Há" +contador +" revistas. \n");

		/*Recuperando a quaqntidade de revista com o preço acima de 100*/
		jpql = "SELECT COUNT (x) FROM Revista x WHERE x . preco >100";
		TypedQuery <Long> consulta2 = manager.createQuery(jpql,Long.class);
		contador = consulta2.getSingleResult();
		System.out.println("Há" +contador +" revista com o preço acima de 100. \n");
		
		/*Somando o preços das revista*/
		jpql = "SELECT SUM (x.preco) FROM Revista x";
		TypedQuery <Double> consulta3 = manager.createQuery(jpql,Double.class);
		Double soma = consulta3.getSingleResult();
		System.out.println("A soma dos preços da revista é " +soma+ "\n ");
		
		/*recuperando o preço da revista mais cara */
		jpql = "SELECT MAX (x.preco) FROM Revista x";
		TypedQuery <Double> consulta4 = manager.createQuery(jpql,Double.class);
		Double precoMaximo = consulta4.getSingleResult();
		System.out.println("O preço da revista mais cara é: " +precoMaximo+ "\n");
		
		/*recuperando a média dos preços da revista*/
		jpql = "SELECT AVG (x.preco) FROM Revista";
		TypedQuery <Double> consulta5 = manager.createQuery(jpql,Double.class);
		Double media = consulta5.getSingleResult();
		System.out.println("Recuperando a média dos preços da revista" +media+ "\n");
		
		/*recuperando todas revista*/
		jpql = "SELECT x FROM Revista x";
		TypedQuery <Revista> consulta6 = manager.createQuery(jpql,Revista.class);
		List <Revista> revistas = consulta6.getResultList();
		System.out.println("Todas revista: ");
		for(Revista revista : revistas){
			System.out.println("ID : "+ revista.getId());
			System.out.println("Nome : "+ revista.getNome());
			System.out.println("Preço : "+ revista.getPreco());
			System.out.println("--------------------------------");
		}
		
		/*recuperando todas revista com preço acima de 100*/
		jpql = "SELECT x FROM Revista x WHERE x.preco >100";
		TypedQuery <Revista> consulta7 = manager.createQuery(jpql,Revista.class);
		revistas = consulta7.getResultList();
		System.out.println("Revista com preço acima de 100: ");
		for(Revista revista : revistas){
			System.out.println("ID : "+ revista.getId());
			System.out.println("Nome : "+ revista.getNome());
			System.out.println("Preço : "+ revista.getPreco());
			System.out.println("--------------------------------");
		}
		
		manager.close();
		factory.close();
	}

}
