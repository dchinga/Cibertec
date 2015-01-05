package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controladores.ControladorCliente;
import controladores.ControladorHabitacion;
import controladores.ControladorRecepcionista;
import entidades.Cliente;
import entidades.Habitacion;
import entidades.Recepcionista;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class FrmRecepcionistas extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4700913660323757406L;
	private JPanel contentPane;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnConsultar;
	private JButton btnListar;
	private JLabel lblDatosBasicos;
	private JLabel lblCodigo;
	private JLabel lblApellido;
	private JLabel lblEstado;
	private JTextField txtCodigo;
	private JTextField txtApellido;
	private JScrollPane scpPanel;
	private JTextArea txtS;
	private JLabel lblOpciones;

	ControladorRecepcionista controlador = new ControladorRecepcionista();

	public static final int ACCION_AGREGAR = 1;
	public static final int ACCION_EDITAR = 2;

	int accion = 0;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JComboBox cboEstado;

	/**
	 * Variable Estática
	 */
	private static FrmRecepcionistas instancia = null;
	private JLabel lblCabecera;

	/**
	 * Constructor privado del formulario
	 */
	private FrmRecepcionistas() {
		setResizable(false);
		setTitle("Sistema de Gesti\u00F3n Hotelera - Mantenimiento de recepcionistas");

		setBounds(100, 100, 805, 529);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnAgregar = new JButton("Agregar");
			btnAgregar.addActionListener(this);
			{
				lblCabecera = new JLabel("");
				lblCabecera.setIcon(new ImageIcon(FrmRecepcionistas.class.getResource("/recursos/recepcionista.png")));
				lblCabecera.setBounds(0, 0, 800, 150);
				contentPane.add(lblCabecera);
			}
			btnAgregar.setBounds(524, 218, 89, 23);
			contentPane.add(btnAgregar);
		}
		{
			btnEditar = new JButton("Editar");
			btnEditar.addActionListener(this);
			btnEditar.setBounds(524, 248, 89, 23);
			contentPane.add(btnEditar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(524, 273, 89, 23);
			contentPane.add(btnEliminar);
		}
		{
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(this);
			btnGuardar.setBounds(524, 298, 89, 23);
			contentPane.add(btnGuardar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(524, 323, 89, 23);
			contentPane.add(btnCancelar);
		}
		{
			btnConsultar = new JButton("Consultar");
			btnConsultar.addActionListener(this);
			btnConsultar.setBounds(307, 223, 89, 23);
			contentPane.add(btnConsultar);
		}
		{
			btnListar = new JButton("Listar");
			btnListar.setBounds(524, 357, 89, 23);
			contentPane.add(btnListar);
		}
		{
			lblDatosBasicos = new JLabel("Datos Basicos");
			lblDatosBasicos.setForeground(new Color(72, 61, 139));
			lblDatosBasicos.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDatosBasicos.setBounds(10, 184, 138, 23);
			contentPane.add(lblDatosBasicos);
		}
		{
			lblCodigo = new JLabel("C\u00F3digo");
			lblCodigo.setBounds(10, 227, 89, 14);
			contentPane.add(lblCodigo);
		}
		{
			lblApellido = new JLabel("Apellido");
			lblApellido.setBounds(10, 252, 89, 14);
			contentPane.add(lblApellido);
		}
		{
			lblEstado = new JLabel("Estado");
			lblEstado.setBounds(10, 329, 89, 14);
			contentPane.add(lblEstado);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setBounds(109, 224, 188, 20);
			contentPane.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBounds(109, 249, 188, 20);
			contentPane.add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			scpPanel = new JScrollPane();
			scpPanel.setBounds(10, 384, 481, 105);
			contentPane.add(scpPanel);
			{
				txtS = new JTextArea();
				scpPanel.setViewportView(txtS);
			}
		}
		{
			lblOpciones = new JLabel("Opciones Generales");
			lblOpciones.setForeground(new Color(72, 61, 139));
			lblOpciones.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblOpciones.setBounds(475, 184, 138, 23);
			contentPane.add(lblOpciones);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(10, 279, 89, 14);
			contentPane.add(lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setEnabled(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(109, 276, 188, 20);
			contentPane.add(txtNombre);
		}
		{
			lblTelefono = new JLabel("Tel\u00E9fono");
			lblTelefono.setBounds(10, 304, 89, 14);
			contentPane.add(lblTelefono);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setEnabled(false);
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(109, 301, 188, 20);
			contentPane.add(txtTelefono);
		}
		{
			cboEstado = new JComboBox();
			cboEstado.setModel(new DefaultComboBoxModel(new String[] {
					"Activo", "Inactivo" }));
			cboEstado.setBounds(109, 324, 188, 20);
			contentPane.add(cboEstado);
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		habilitar();
	}

	/**
	 * @return Única instancia del formulario
	 */
	public static FrmRecepcionistas getInstance() {
		if (instancia == null)
			instancia = new FrmRecepcionistas();

		return instancia;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			btnEliminarActionPerformed(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			btnConsultarActionPerformed(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			btnCancelarActionPerformed(arg0);
		}
		if (arg0.getSource() == btnGuardar) {
			btnGuardarActionPerformed(arg0);
		}
		if (arg0.getSource() == btnEditar) {
			btnEditarActionPerformed(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			btnAgregarActionPerformed(arg0);
		}
	}

	void habilitar() {
		txtCodigo.setEnabled(true);
		txtApellido.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);

		btnAgregar.setEnabled(true);
		btnConsultar.setEnabled(true);
		btnEditar.setEnabled(true);
		btnEliminar.setEnabled(true);
		btnListar.setEnabled(true);
	}

	protected void btnAgregarActionPerformed(ActionEvent arg0) {
		txtCodigo.setEnabled(false);
		txtApellido.setEnabled(true);
		txtNombre.setEnabled(true);
		txtTelefono.setEnabled(true);
		cboEstado.setEnabled(true);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);

		btnAgregar.setEnabled(false);
		btnConsultar.setEnabled(false);
		btnEditar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnListar.setEnabled(false);

		accion = ACCION_AGREGAR;
		txtCodigo.setText("" + controlador.generarCodigo());
	}

	protected void btnEditarActionPerformed(ActionEvent arg0) {
		txtCodigo.setEnabled(false);
		txtApellido.setEnabled(true);
		txtNombre.setEnabled(true);
		txtTelefono.setEnabled(true);
		cboEstado.setEnabled(true);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);

		btnAgregar.setEnabled(false);
		btnConsultar.setEnabled(false);
		btnEditar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnListar.setEnabled(false);

		accion = ACCION_EDITAR;
	}

	protected void btnGuardarActionPerformed(ActionEvent arg0) {
		txtCodigo.setEnabled(true);
		txtApellido.setEnabled(false);
		txtNombre.setEnabled(false);
		txtTelefono.setEnabled(false);
		cboEstado.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);

		btnAgregar.setEnabled(true);
		btnConsultar.setEnabled(true);
		btnEditar.setEnabled(true);
		btnEliminar.setEnabled(true);
		btnListar.setEnabled(true);

		switch (accion) {
		case ACCION_AGREGAR:
			ingresar();
			break;
		case ACCION_EDITAR:
			modificar();
			break;
		default:
			break;
		}
	}

	protected void btnCancelarActionPerformed(ActionEvent arg0) {
		txtCodigo.setEnabled(true);
		txtApellido.setEnabled(false);
		txtNombre.setEnabled(false);
		txtTelefono.setEnabled(false);
		cboEstado.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);

		btnAgregar.setEnabled(true);
		btnConsultar.setEnabled(true);
		btnEditar.setEnabled(true);
		btnEliminar.setEnabled(true);
		btnListar.setEnabled(true);
	}

	// ---------------------------------------------------------
	int getCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	// ---------------------------------------------------------
	String getApellido() {
		return txtApellido.getText();
	}

	// ---------------------------------------------------------
	String getNombre() {
		return txtNombre.getText();
	}

	String getTelefono() {
		return txtTelefono.getText();
	}

	// ---------------------------------------------------------
	int getEstado() {
		return cboEstado.getSelectedIndex();
	}

	// ---------------------------------------------------------
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	// Ingresa un celular evitando que el numero se repita
	void ingresar() {
		Recepcionista obj = controlador.buscar(getCodigo());
		if (obj != null) {
			mensaje("El numero de habitación ya existe...");
		} else {
			obj = new Recepcionista(getCodigo(), getApellido(), getNombre(),
					getTelefono(), getEstado());
			controlador.adicionar(obj);
			borrar();
			listar();
			mensaje("Se registró el cliente");
		}
	}

	void modificar() {
		Recepcionista obj = controlador.buscar(getCodigo());
		if (obj == null) {
			mensaje("No existe cliente con ese codigo");
		} else {
			obj = new 		Recepcionista(getCodigo(), getApellido(), getNombre(),
					getTelefono(), getEstado());
			controlador.modificar(obj);
			borrar();
			listar();
			mensaje("Se actualizó el cliente");
		}
	}

	void eliminar() {

		Recepcionista obj = controlador.buscar(getCodigo());
		if (obj != null) {
			controlador.eliminar(obj);
			listar();
		} else
			mensaje("No existe el codigo ingresado");

	}

	// Muestra el listado solicitado
	void listar() {
		if (controlador.tamaño() > 0) {
			txtS.setText("");
			imprimir("Código\tApellidos\tNombre\tTeléfono\tEstado");
			for (int i = 0; i < controlador.tamaño(); i++) {
				Recepcionista x = controlador.obtener(i);
				imprimir(x.getCodigo() + "\t" + x.getApellido() + "\t"
						+ x.getNombre() + "\t" + x.getTelefono() + "\t"
						+ x.getEstado());
			}
			imprimir("");
		} else
			imprimir("No hay registros...");

	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	void borrar() {
		txtCodigo.setText("");
		txtApellido.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		cboEstado.setSelectedIndex(0);
	}

	protected void btnConsultarActionPerformed(ActionEvent arg0) {
Recepcionista obj = null;
		obj = controlador.buscar(getCodigo());
		if (obj == null) {
			mensaje("El codigo no existe...");
		} else {
			txtCodigo.setText("" + obj.getCodigo());
			txtApellido.setText(obj.getApellido());
			txtNombre.setText(obj.getNombre());
			txtTelefono.setText(obj.getTelefono());
			cboEstado.setSelectedIndex(obj.getEstado());
		}
	}

	protected void btnEliminarActionPerformed(ActionEvent arg0) {
		eliminar();
	}
}
