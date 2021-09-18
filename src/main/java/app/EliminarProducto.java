package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class EliminarProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em=fabrica.createEntityManager();
		
		Producto p= em.find(Producto.class, "P0032");
		
		if(p==null) {
			System.out.println("Producto No Existe");
		}else {
			System.out.println("Producto encontrado : "+p.getDescrip());
			System.out.println(p);
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			System.out.println("Eliminación OK");
		}
		em.close();
	}

}
