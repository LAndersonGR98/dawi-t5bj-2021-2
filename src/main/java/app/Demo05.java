package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	public static void main(String[] args) {
		//1.Especificar la Conexión de BD
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		
		EntityManager em = fabrica.createEntityManager();
		
		//3.Procesos....Obtener la informacion del usuario con codigo 10
		
		Usuario u=em.find(Usuario.class, 10);
		
		if(u==null) {
			System.out.println("Usuario NO existe");
		}else {
			System.out.println("Usuario encontrado : "+u.getNombre());
			System.out.println(u);
			em.getTransaction().begin();
			em.remove(u);//eliminar
			em.getTransaction().commit();
			System.out.println("Eliminación ok");
		}
		
		em.close();
	}

}
