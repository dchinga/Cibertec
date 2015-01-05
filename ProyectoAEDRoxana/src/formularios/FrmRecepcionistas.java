package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import controladores.ControladorRecepcionista;
import entidades.Recepcionista;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class FrmRecepcionistas extends JFrame implements ActionListener,
		MouseListener, KeyListener {

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
	private JTable table;

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
				lblCabecera.setIcon(new ImageIcon(FrmRecepcionistas.class
						.getResource("/recursos/recepcionista.png")));
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
			btnListar.setBounds(427, 323, 89, 23);
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
			table = new JTable();
			table.addKeyListener(this);
			table.addMouseListener(this);
			table.setForeground(new Color(148, 0, 211));
			table.setBackground(new Color(255, 250, 240));
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Código", "Apellido", "Nombre", "Teléfono",
							"Estado" }));
			scpPanel = new JScrollPane(table);
			scpPanel.setBackground(new Color(255, 250, 240));
			scpPanel.setBounds(10, 357, 734, 132);
			contentPane.add(scpPanel);
			{
				scpPanel.setViewportView(table);
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
		habilitar(false);
		listar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			btnAgregarActionPerformed(e);
		}
		if (e.getSource() == btnEditar) {
			btnEditarActionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			btnEliminarActionPerformed(e);
		}
		if (e.getSource() == btnGuardar) {
			btnGuardarActionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			btnCancelarActionPerformed(e);
		}
		if (e.getSource() == btnConsultar) {
			btnConsultarActionPerformed(e);
		}
		if (e.getSource() == btnListar) {
			btnListarActionPerformed(e);
		}
	}

	// Inicio: Eventos de los botones

	protected void btnAgregarActionPerformed(ActionEvent arg0) {
		habilitar(true);

		accion = ACCION_AGREGAR;
		txtCodigo.setText("" + controlador.generarCodigo());
	}

	protected void btnEditarActionPerformed(ActionEvent arg0) {
		habilitar(true);

		accion = ACCION_EDITAR;
	}

	protected void btnEliminarActionPerformed(ActionEvent e) {
		eliminar();
	}

	protected void btnGuardarActionPerformed(ActionEvent arg0) {
		habilitar(false);

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
		habilitar(false);
	}

	protected void btnConsultarActionPerformed(ActionEvent e) {
		consultar();
	}

	protected void btnListarActionPerformed(ActionEvent e) {
		listar();
	}

	// Fin: Eventos de los botones

	// Inicio: Métodos de lectura de datos

	/**
	 * Obtiene el código
	 * 
	 * @return código de recepcionista
	 */
	int getCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	/**
	 * Obtiene el apellido del recepcionista
	 * 
	 * @return apellido
	 */
	String getApellido() {
		return txtApellido.getText();
	}

	/**
	 * Obtiene el nombre del recepcionista
	 * 
	 * @return nombre
	 */
	String getNombre() {
		return txtNombre.getText();
	}

	/**
	 * Obtiene el teléfono del recepcionista
	 * 
	 * @return teléfono
	 */
	String getTelefono() {
		return txtTelefono.getText();
	}

	/**
	 * Obtiene el estado del recepcionista
	 * 
	 * @return estado
	 */
	int getEstado() {
		return cboEstado.getSelectedIndex();
	}

	// Fin: Métodos de lectura de datos

	// Inicio: Métodos del mantenimiento

	/**
	 * Ingresa un recepcionista evitando que el código se repita
	 */
	void ingresar() {
		Recepcionista obj = controlador.buscar(getCodigo());
		if (obj != null) {
			mensaje("El código de recepcionista ya existe.");
		} else {
			obj = new Recepcionista(getCodigo(), getApellido(), getNombre(),
					getTelefono(), getEstado());
			controlador.adicionar(obj);
			controlador.grabar();
			borrar();
			listar();
			mensaje("Se registró el recepcionista");
		}
	}

	/**
	 * Modifica los datos de un recepcionista
	 */
	void modificar() {
		Recepcionista obj = controlador.buscar(getCodigo());
		if (obj == null) {
			mensaje("No existe recepcionista con ese código");
		} else {
			obj = new Recepcionista(getCodigo(), getApellido(), getNombre(),
					getTelefono(), getEstado());
			controlador.modificar(obj);
			controlador.grabar();
			borrar();
			listar();
			mensaje("Se actualizaron los datos del recepcionista");
		}
	}

	/**
	 * Elimina un recepcionista por el código
	 */
	void eliminar() {
		Recepcionista obj = controlador.buscar(getCodigo());
		if (obj != null) {
			if (JOptionPane.showConfirmDialog(this,
					"Se eliminará el recepcionista. ¿Desea continuar?",
					"Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				controlador.eliminar(obj);
				controlador.grabar();
				borrar();
				listar();
			}
		} else {
			mensaje("No existe recepcionista con ese código");
		}
	}

	/**
	 * Consulta los datos de un recepcionista por su código
	 */
	private void consultar() {
		Recepcionista obj = null;
		obj = controlador.buscar(getCodigo());
		if (obj == null) {
			mensaje("No existe recepcionista con ese código");
		} else {
			mostrarDatosRecepcionista(obj);
		}
	}

	/**
	 * Lista todas los recepcionistas
	 */
	void listar() {
		if (controlador.tamaño() > 0) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().clear();

			for (int i = 0; i < controlador.tamaño(); i++) {
				Recepcionista x = controlador.obtener(i);
				Object row[] = { x.getCodigo(), x.getApellido(), x.getNombre(),
						x.getTelefono(), x.getNombreEstado() };
				model.addRow(row);
			}
			borrar();
		}
	}

	// Fin: Métodos del mantenimiento

	// Inicio: Métodos adicionales

	/**
	 * @return Única instancia del formulario
	 */
	public static FrmRecepcionistas getInstance() {
		if (instancia == null)
			instancia = new FrmRecepcionistas();
		return instancia;
	}

	/**
	 * Muestra un mensaje
	 * 
	 * @param m
	 */
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	/**
	 * Metodo que habilita o inhabilita los controles
	 * 
	 * @param valor
	 *            boolean que indica que se debe habilitar
	 */
	void habilitar(boolean valor) {
		txtApellido.setEnabled(valor);
		txtNombre.setEnabled(valor);
		txtTelefono.setEnabled(valor);
		cboEstado.setEnabled(valor);
		btnGuardar.setEnabled(valor);
		btnCancelar.setEnabled(valor);

		txtCodigo.setEnabled(!valor);
		btnAgregar.setEnabled(!valor);
		btnConsultar.setEnabled(!valor);
		btnEditar.setEnabled(!valor);
		btnEliminar.setEnabled(!valor);
		btnListar.setEnabled(!valor);
		table.setEnabled(!valor);
	}

	/**
	 * Borra los datos
	 */
	void borrar() {
		txtCodigo.setText("");
		txtApellido.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		cboEstado.setSelectedIndex(0);
	}

	/**
	 * Muestra los datos de un recepcionista en los controles
	 * 
	 * @param obj
	 */
	private void mostrarDatosRecepcionista(Recepcionista obj) {
		txtCodigo.setText("" + obj.getCodigo());
		txtApellido.setText(obj.getApellido());
		txtNombre.setText(obj.getNombre());
		txtTelefono.setText(obj.getTelefono());
		cboEstado.setSelectedIndex(obj.getEstado());
	}

	// Fin: Métodos adicionales

	// Inicio: Eventos

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			tableMouseClicked(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void tableMouseClicked(MouseEvent e) {
		Recepcionista obj = controlador.obtener(table
				.convertRowIndexToModel(table.getSelectedRow()));
		if (obj != null)
			mostrarDatosRecepcionista(obj);
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == table) {
			tableKeyReleased(arg0);
		}
	}

	public void keyTyped(KeyEvent arg0) {
	}

	protected void tableKeyReleased(KeyEvent arg0) {
		Recepcionista obj = controlador.obtener(table
				.convertRowIndexToModel(table.getSelectedRow()));
		if (obj != null)
			mostrarDatosRecepcionista(obj);
	}
}
