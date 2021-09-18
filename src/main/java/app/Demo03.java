package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	public static void main(String[] args) {
		//1.Especificar la Conexión de BD
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		
		EntityManager em = fabrica.createEntityManager();
		
		//3.Procesos....eliminar un nuevo usuario
		
		Usuario u=new Usuario();
		
		u.setCodigo(10);
		//u.setNombre
		
		//Registro, Actualización, Eliminación--> Transacciones
		
		try {
		em.getTransaction().begin();
		em.remove(u);//eliminar
		em.getTransaction().commit();
		System.out.println("Eliminación ok");
		}catch(Exception e) {
			System.out.println("ERROR :"+e.getClass().getName());
		}
		em.close();
	}

}
