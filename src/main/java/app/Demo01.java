package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
	public static void main(String[] args) {
		//1.Especificar la Conexión de BD
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		
		EntityManager em = fabrica.createEntityManager();
		
		//3.Procesos....registrar un nuevo usuario
		
		Usuario u=new Usuario();
		
		u.setCodigo(10);
		u.setNombre("Luis");
		u.setApellido("Galvan Romero");
		u.setUsuario("Anderson@gmail.com");
		u.setClave("123456");
		u.setFnacim("2021/08/27");
		u.setEstado(1);
		u.setTipo(1);
		
		//Registro, Actualización, Eliminación--> Transacciones
		em.getTransaction().begin();
		em.persist(u);//registrar
		em.getTransaction().commit();
		System.out.println("Registro ok");
		
		em.close();
	}
}
