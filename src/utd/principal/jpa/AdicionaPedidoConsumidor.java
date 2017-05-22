package utd.principal.jpa;

import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utd.classes.jpa.Consumidor;
import utd.classes.jpa.Pedido;

public class AdicionaPedidoConsumidor {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-utd");
		EntityManager manager = factory.createEntityManager();
		
		Scanner entrada = new Scanner(System.in);
		Consumidor consumidor = new Consumidor();
		System.out.println("Digite o nome do consumidor ");
		consumidor.setNome(entrada.nextLine());
		Pedido pedido = new Pedido();
		pedido.setData(Calendar.getInstance());
		pedido.setConsumidor(consumidor);
		
		entrada.close();
		manager.persist(consumidor);
		manager.persist(pedido);
		System.out.println("Consumidor cadastrado com id "+ consumidor.getId());
		System.out.println("Pedido cadstrado com id " + pedido.getId());
		manager.getTransaction().commit();
		manager.close();
		factory.close ();
	}

}
