package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class ActualizarProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em= fabrica.createEntityManager();
		
		Producto p=new Producto();
		
		p.setIdProd("P0032");
		p.setDescrip("Jarabe para Fiebre");
		p.setStock(15);
		p.setPrecio(18.5);
		p.setIdCategoria(2);
		p.setEstado(1);
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		System.out.println("Actualización OK");

	}

}
