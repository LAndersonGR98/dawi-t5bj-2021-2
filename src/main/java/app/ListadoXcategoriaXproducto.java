package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Producto;

public class ListadoXcategoriaXproducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em = fabrica.createEntityManager();
		
		TypedQuery<Producto> query=em.createQuery("Select p from Producto p",Producto.class);
		
		List<Producto> lstProducto=query.getResultList();
		
		System.out.println("Cantidad de Productos "+lstProducto.size());
		
		if(lstProducto.size()==0) {
			System.out.println("Listado Vacio");
		}else {
			System.out.println("Listado de Productos");
			
			for(Producto p: lstProducto) {
				
				System.out.println(">>> "+p);
				
			}
		}
		
		List<Producto> lstProducto2=em.createQuery("Select p from Producto p",Producto.class).getResultList();
		
		System.out.println("Cantidad de Productos "+lstProducto2.size());
		
		if(lstProducto2.size()==0) {
			System.out.println("Listado Vacio");
		}else {
			System.out.println("Listado de Productos");
			
			for(Producto p: lstProducto2) {
				
				System.out.println(">>> "+p);
				
			}
		}
		// Listado con parametros -->Listado de los usuarios x tipo
		// con el singo de dos puntos haces referencia a un parametro
		// select * from tb_usuarios where idtipo=?
		
		String sql="Select p from Producto p where p.idCategoria = :xtipoCate";
		
		TypedQuery<Producto> qery2=em.createQuery(sql,Producto.class);
		
		qery2.setParameter("xtipoCate", 2);
		
		List<Producto> lstProducto3=qery2.getResultList();
		
		System.out.println("Cantidad de Productos : "+lstProducto3.size());
		
		if(lstProducto3.size()==0) {
			
			System.out.println("Listado Vacio");
			
		}else {
			
			System.out.println("--Listado de Producto x Categoria 2--");
			
			for(Producto p: lstProducto3) {
				
				System.out.println(">>> "+p);
				
			}
		}
		em.close();
		
	}

}
