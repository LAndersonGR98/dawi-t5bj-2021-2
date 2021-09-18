package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	public static void main(String[] args) {
		//1.Especificar la Conexión de BD
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		
		EntityManager em = fabrica.createEntityManager();
		
		//3.Procesos....actualizar un nuevo usuario
		
		Usuario u=new Usuario();
		
		u.setCodigo(10);
		u.setNombre("Anderson");
		u.setApellido("Galvan");
		u.setUsuario("Anderson@gmail.com");
		u.setClave("945665829");
		u.setFnacim("1998/04/05");
		u.setEstado(1);
		u.setTipo(1);
		
		//Registro, Actualización, Eliminación--> Transacciones
		em.getTransaction().begin();
		em.merge(u);//actualizar -- si existe lo actualiza / si no exista el codigo lo crea (EL "merge" hace un actualización o un registro)
		em.getTransaction().commit();
		System.out.println("Actualización ok");
		
		em.close();
	}
}
