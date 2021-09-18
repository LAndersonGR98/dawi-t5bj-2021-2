package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Entity
@Table(name="tb_productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
	
	@Id
	@Column(name = "idprod")
	private String idProd;
	
	@Column(name = "descripcion")
	private String descrip;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "precio")
	private  double precio;
	
	@Column(name = "idcategoria")
	private int idCategoria;
	
	@Column(name = "estado")
	private int estado;
	

}
