package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ComboTipoProducto;
import model.Producto;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox cboCategorias;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JTextField txtEstado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);
		
		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);
		
		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);
		
		JLabel lblNewLabel = new JLabel("Estado:");
		lblNewLabel.setBounds(236, 134, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(299, 131, 86, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		llenaCombo();
	}

	void llenaCombo() {
		
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("mysql");
		
		//2.Obtener el DAO
		
		EntityManager em=fabrica.createEntityManager();
		
		TypedQuery<ComboTipoProducto> query =em.createQuery("Select u from tb_categorias u",ComboTipoProducto.class);
		
		List<ComboTipoProducto> listCategoria=query.getResultList();
		
		for(ComboTipoProducto c: listCategoria) {
			
			cboCategorias.addItem(c.getDescrip());
			
		}
	}
		
	void listado() {
		
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em= fabrica.createEntityManager();
		
		String sql="Select p from Producto p where p.idCategoria = :xtipoCate";
		
		TypedQuery<Producto> query=em.createQuery(sql,Producto.class);
		
		query.setParameter("xtipoCate", 2);
		
		List<Producto> lstProducto=query.getResultList();
		
		
		if(lstProducto.size()==0) {
			
			System.out.println("Producto no existe");
			
		}else {
			
			txtSalida.setText("Listado de todos los productos"+"\n");
			
			for(Producto p: lstProducto) {
				
				txtSalida.append(p.toString()+"\n");
				
			}
			txtSalida.append("Cantidad de Productos" + lstProducto.size());
				
		}
		em.close();
	}
	
	void registrar() {
		
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em=fabrica.createEntityManager();
		
		Producto p= new Producto();
		
		p.setIdProd(txtCódigo.getText());
		
		p.setDescrip(txtDescripcion.getText());
		
		p.setStock(Integer.parseInt(txtStock.getText()));
		
		p.setPrecio(Double.parseDouble(txtPrecio.getText()));
	
		p.setIdCategoria(cboCategorias.getSelectedIndex());
		
		p.setEstado(Integer.parseInt(txtEstado.getText()));
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Registro OK");
		
		em.close();
	}
}