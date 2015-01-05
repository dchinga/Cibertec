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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import controladores.ControladorHabitacion;
import entidades.Habitacion;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class FrmHabitacion extends JFrame implements ActionListener,
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
	private JLabel lblNumero;
	private JLabel lblDescripcion;
	private JLabel lblTipo;
	private JLabel lblUbicacion;
	private JLabel lblCosto;
	private JTextField txtNumero;
	private JTextField txtDescripcion;
	private JComboBox<?> cboTipo;
	private JComboBox<?> cboUbicacion;
	private JTextField txtCosto;
	private JScrollPane scpPanel;
	private JLabel lblInfo;

	ControladorHabitacion controlador = new ControladorHabitacion();

	public static final int ACCION_AGREGAR = 1;
	public static final int ACCION_EDITAR = 2;

	int accion = 0;

	/**
	 * Variable Estática
	 */
	private static FrmHabitacion instancia = null;
	private JPanel pnlInformacion;
	private JPanel pnlBotones;
	private JLabel pnlCabecera;
	private JTable table;
	private JLabel lblMaterial;

	/**
	 * Constructor privado del formulario
	 */
	private FrmHabitacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				FrmHabitacion.class.getResource("/recursos/bed6.png")));
		setResizable(false);
		setTitle("Sistema de Gesti\u00F3n Hotelera - Mantenimiento de Habitaciones");

		setBounds(100, 100, 805, 529);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			{
				pnlBotones = new JPanel();
				pnlBotones.setBackground(new Color(255, 250, 240));
				pnlBotones.setBounds(0, 120, 800, 67);
				contentPane.add(pnlBotones);
				pnlBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				btnAgregar = new JButton("");
				btnAgregar.setHorizontalAlignment(SwingConstants.LEFT);
				btnAgregar.setToolTipText("Agregar");
				btnAgregar.setBackground(new Color(255, 250, 240));
				btnAgregar.setIcon(new ImageIcon(FrmHabitacion.class
						.getResource("/recursos/agregar.png")));
				pnlBotones.add(btnAgregar);
				btnEditar = new JButton("");
				btnEditar.setToolTipText("Editar");
				btnEditar.setIcon(new ImageIcon(FrmHabitacion.class
						.getResource("/recursos/editar.png")));
				pnlBotones.add(btnEditar);
				btnEliminar = new JButton("");
				btnEliminar.setIcon(new ImageIcon(FrmHabitacion.class
						.getResource("/recursos/eliminar.png")));
				btnEliminar.setToolTipText("Eliminar");
				pnlBotones.add(btnEliminar);
				btnGuardar = new JButton("");
				btnGuardar.setToolTipText("Aceptar");
				btnGuardar.setIcon(new ImageIcon(FrmHabitacion.class
						.getResource("/recursos/aceptar.png")));
				pnlBotones.add(btnGuardar);
				btnCancelar = new JButton("");
				btnCancelar.setIcon(new ImageIcon(FrmHabitacion.class
						.getResource("/recursos/cancelar.png")));
				btnCancelar.setToolTipText("Cancelar");
				pnlBotones.add(btnCancelar);
				btnConsultar = new JButton("");
				btnConsultar.setIcon(new ImageIcon(FrmHabitacion.class
						.getResource("/recursos/consultar.png")));
				btnConsultar.setToolTipText("Consultar");
				pnlBotones.add(btnConsultar);
				{
					btnListar = new JButton("");
					btnListar.addActionListener(this);
					btnListar.setIcon(new ImageIcon(FrmHabitacion.class
							.getResource("/recursos/refrescar.png")));
					btnListar.setToolTipText("Refrescar lista");
					pnlBotones.add(btnListar);
				}
				btnConsultar.addActionListener(this);
				btnCancelar.addActionListener(this);
				btnGuardar.addActionListener(this);
				btnEliminar.addActionListener(this);
				btnEditar.addActionListener(this);
				btnAgregar.addActionListener(this);
			}
			{
				lblMaterial = new JLabel("Habitaciones");
				lblMaterial.setForeground(new Color(255, 250, 240));
				lblMaterial.setFont(new Font("Segoe UI Semibold", Font.PLAIN,
						44));
				lblMaterial.setBounds(10, 10, 308, 59);
				contentPane.add(lblMaterial);
			}
			{
				pnlCabecera = new JLabel("");
				pnlCabecera.setIcon(new ImageIcon(FrmHabitacion.class
						.getResource("/recursos/habitacion.png")));
				pnlCabecera.setBounds(0, 0, 800, 120);
				contentPane.add(pnlCabecera);
			}
			{
				pnlInformacion = new JPanel();
				pnlInformacion.setBackground(new Color(255, 250, 240));
				pnlInformacion.setBounds(0, 187, 800, 313);
				contentPane.add(pnlInformacion);
				pnlInformacion.setLayout(null);
				{
					lblInfo = new JLabel("Informaci\u00F3n B\u00E1sica");
					lblInfo.setBounds(10, 10, 259, 32);
					pnlInformacion.add(lblInfo);
					lblInfo.setForeground(new Color(72, 61, 139));
					lblInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
				}
				{
					lblNumero = new JLabel("N\u00FAmero");
					lblNumero.setBounds(10, 54, 100, 14);
					pnlInformacion.add(lblNumero);
				}
				{
					txtNumero = new JTextField();
					txtNumero.setBounds(120, 51, 150, 20);
					pnlInformacion.add(txtNumero);
					txtNumero.setColumns(10);
				}
				{
					lblUbicacion = new JLabel("Ubicaci\u00F3n");
					lblUbicacion.setBounds(365, 54, 100, 14);
					pnlInformacion.add(lblUbicacion);
				}
				{
					cboUbicacion = new JComboBox();
					cboUbicacion.setBounds(475, 51, 150, 20);
					pnlInformacion.add(cboUbicacion);
					cboUbicacion.setModel(new DefaultComboBoxModel(
							new String[] { "1er Piso", "2do Piso", "3er Piso",
									"4to Piso", "5to Piso", "6to Piso",
									"7mo Piso" }));
				}
				{
					lblTipo = new JLabel("Tipo");
					lblTipo.setBounds(10, 109, 100, 14);
					pnlInformacion.add(lblTipo);
				}
				{
					lblCosto = new JLabel("Costo");
					lblCosto.setBounds(365, 82, 100, 14);
					pnlInformacion.add(lblCosto);
				}
				{
					txtDescripcion = new JTextField();
					txtDescripcion.setBounds(120, 79, 150, 20);
					pnlInformacion.add(txtDescripcion);
					txtDescripcion.setColumns(10);
				}
				{
					cboTipo = new JComboBox();
					cboTipo.setBounds(120, 106, 150, 20);
					pnlInformacion.add(cboTipo);
					cboTipo.setModel(new DefaultComboBoxModel(new String[] {
							"Simple", "Doble", "Matrimonial", "Suite Junior",
							"Presidencial" }));
				}
				{
					txtCosto = new JTextField();
					txtCosto.setBounds(475, 79, 150, 20);
					pnlInformacion.add(txtCosto);
					txtCosto.setColumns(10);
				}
				{
					lblDescripcion = new JLabel("Descripci\u00F3n");
					lblDescripcion.setBounds(10, 82, 100, 14);
					pnlInformacion.add(lblDescripcion);
				}
				{
					table = new JTable();
					table.addKeyListener(this);
					table.addMouseListener(this);
					table.setForeground(new Color(148, 0, 211));
					table.setBackground(new Color(255, 250, 240));
					table.setModel(new DefaultTableModel(new Object[][] {},
							new String[] { "Número", "Descripción", "Tipo",
									"Ubicación", "Costo" }));
					scpPanel = new JScrollPane(table);
					scpPanel.setBackground(new Color(255, 250, 240));
					scpPanel.setBounds(10, 144, 780, 158);
					pnlInformacion.add(scpPanel);
					{
						scpPanel.setViewportView(table);
					}

				}
			}
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
		txtNumero.setText("" + controlador.generarNumero());
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
	 * Obtiene el numero
	 * 
	 * @return numero de habitacion
	 */
	int getNumero() {
		return Integer.parseInt(txtNumero.getText());
	}

	/**
	 * Obtiene la descripción de la habitación
	 * 
	 * @return descripción
	 */
	String getDescripcion() {
		return txtDescripcion.getText();
	}

	/**
	 * Obtiene el tipo de la habitación
	 * 
	 * @return tipo
	 */
	int getTipo() {
		return cboTipo.getSelectedIndex();
	}

	/**
	 * Obtiene la ubicación de la habitación
	 * 
	 * @return ubicación
	 */
	int getUbicacion() {
		return cboUbicacion.getSelectedIndex();
	}

	/**
	 * Obtiene el costo de la habitación
	 * 
	 * @return costo
	 */
	double getCosto() {
		return Double.parseDouble(txtCosto.getText());
	}

	// Fin: Métodos de lectura de datos

	// Inicio: Métodos del mantenimiento

	/**
	 * Ingresa una habitacion evitando que el numero se repita
	 */
	void ingresar() {
		Habitacion obj = controlador.buscar(getNumero());
		if (obj != null) {
			mensaje("El número de habitación ya existe.");
		} else {
			obj = new Habitacion(getNumero(), getDescripcion(), getTipo(),
					getUbicacion(), getCosto());
			controlador.adicionar(obj);
			controlador.grabar();
			borrar();
			listar();
			mensaje("Se registró la habitación");
		}
	}

	/**
	 * Modifica los datos de una habitación
	 */
	void modificar() {
		Habitacion obj = controlador.buscar(getNumero());
		if (obj == null) {
			mensaje("No existe habitación con ese número");
		} else {
			obj = new Habitacion(getNumero(), getDescripcion(), getTipo(),
					getUbicacion(), getCosto());
			controlador.modificar(obj);
			controlador.grabar();
			borrar();
			listar();
			mensaje("Se actualizaron los datos de la habitación");
		}
	}

	/**
	 * Elimina una habitación por el número
	 */
	void eliminar() {
		Habitacion obj = controlador.buscar(getNumero());
		if (obj != null) {
			if (JOptionPane.showConfirmDialog(this,
					"Se eliminará la habitación. ¿Desea continuar?",
					"Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				controlador.eliminar(obj);
				controlador.grabar();
				borrar();
				listar();
			}
		} else {
			mensaje("No existe habitación con ese número");
		}
	}

	/**
	 * Consulta los datos de una habitación por su número
	 */
	private void consultar() {
		Habitacion obj = null;
		obj = controlador.buscar(getNumero());
		if (obj == null) {
			mensaje("No existe habitación con ese número");
		} else {
			mostrarDatosHabitacion(obj);
		}
	}

	/**
	 * Lista todas las habitaciones
	 */
	void listar() {
		if (controlador.tamaño() > 0) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().clear();

			for (int i = 0; i < controlador.tamaño(); i++) {
				Habitacion x = controlador.obtener(i);
				Object row[] = { x.getNumero(), x.getDescripcion(),
						x.getNombreTipo(), x.getNombreUbicacion(), x.getCosto() };
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
	public static FrmHabitacion getInstance() {
		if (instancia == null)
			instancia = new FrmHabitacion();
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
		txtDescripcion.setEnabled(valor);
		cboTipo.setEnabled(valor);
		cboUbicacion.setEnabled(valor);
		txtCosto.setEnabled(valor);
		btnGuardar.setEnabled(valor);
		btnCancelar.setEnabled(valor);

		txtNumero.setEnabled(!valor);
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
		txtNumero.setText("");
		txtDescripcion.setText("");
		cboTipo.setSelectedIndex(0);
		cboUbicacion.setSelectedIndex(0);
		txtCosto.setText("");
	}

	/**
	 * Muestra los datos de una habitación en los controles
	 * 
	 * @param obj
	 */
	private void mostrarDatosHabitacion(Habitacion obj) {
		txtNumero.setText("" + obj.getNumero());
		txtDescripcion.setText(obj.getDescripcion());
		cboTipo.setSelectedIndex(obj.getTipo());
		cboUbicacion.setSelectedIndex(obj.getUbicacion());
		txtCosto.setText("" + obj.getCosto());
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
		Habitacion obj = controlador.obtener(table.convertRowIndexToModel(table
				.getSelectedRow()));
		if (obj != null)
			mostrarDatosHabitacion(obj);
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
		Habitacion obj = controlador.obtener(table.convertRowIndexToModel(table
				.getSelectedRow()));
		if (obj != null)
			mostrarDatosHabitacion(obj);
	}

	// Fin: Eventos

}