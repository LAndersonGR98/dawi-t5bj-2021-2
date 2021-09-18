package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class ListarProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em = fabrica.createEntityManager();
		
		Producto p=em.find(Producto.class, "P0031");
		
		if(p==null) {
			System.out.println("Producto no Existe");
		}else {
			System.out.println("Producto Encontrado : "+p.getDescrip());
			System.out.println(p);
		}
		em.close();

	}

}
