package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class RegistrarProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.Especificar la Conexión de BD
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		
		EntityManager em=fabrica.createEntityManager();
		
		//3.Procesos....registrar un nuevo producto
		
		Producto p=new Producto();
		
		p.setIdProd("P0032");
		p.setDescrip("Jarabe para Gripe");
		p.setStock(10);
		p.setPrecio(12.5);
		p.setIdCategoria(2);
		p.setEstado(1);
		
		//Registro, Actualización, Eliminación--> Transacciones
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Registro OK");
		
		em.close();
	}

}
