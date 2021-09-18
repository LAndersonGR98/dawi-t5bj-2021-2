package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo08 {
	
	public static void main(String[] args) {
		//1.Especificar la Conexión de BD
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		
		EntityManager em = fabrica.createEntityManager();
		
		//3.Procesos....Obtener la informacion del usuario con codigo 10
		
		//Usuario u=em.find(Usuario.class, 10); //El find busca un usuario segun la llave primaria
		//Validar el usuario y clave
		String sql = "Select u from Usuario u where u.usuario = :xusr and u.clave= :xcla";

		TypedQuery<Usuario> query3 = em.createQuery(sql, Usuario.class);
		
		query3.setParameter("xusr", "admin@ciberfarma.com");
		
		query3.setParameter("xcla", "super");
		
		Usuario u=null;
		
		try {
			u=query3.getSingleResult();
			System.out.println("Usuario encontrado : "+u.getNombre());
			System.out.println(u);
		} catch (NoResultException e) {
			// TODO: handle exception
			System.out.println("Usuario NO existe");
		}
		
		em.close();
	}

}
