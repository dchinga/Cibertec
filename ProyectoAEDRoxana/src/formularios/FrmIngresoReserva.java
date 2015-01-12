package formularios;

import java.awt.EventQueue;

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
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import controladores.ControladorHabitacion;
import controladores.ControladorReserva;
import entidades.Habitacion;
import entidades.Reserva;

import javax.swing.JTable;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class FrmIngresoReserva extends JFrame implements ActionListener,
		MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4700913660323757406L;
	private JPanel contentPane;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnConsultar;
	private JLabel lblCodigo;
	private JLabel lblCliente;
	private JLabel lblEstado;
	private JLabel lblFechaIngreso;
	private JTextField txtCodigo;
	private JTextField txtCodCliente;
	private JComboBox<?> cboEstado;
	private JTextField txtFechaIngreso;
	private JScrollPane scpPanel;
	private JLabel lblInfo;

	ControladorReserva controlador = new ControladorReserva();

	public static final int ACCION_AGREGAR = 1;
	public static final int ACCION_EDITAR = 2;

	int accion = 0;

	/**
	 * Variable Estática
	 */
	private static FrmIngresoReserva instancia = null;
	private JPanel pnlInformacion;
	private JPanel pnlBotones;
	private JLabel pnlCabecera;
	private JTable table;
	private JLabel lblMaterial;
	private JLabel lblRecepcionista;
	private JTextField txtCodRecepcionista;
	private JTextField txtNumHabitacion;
	private JTextField txtFechaSalida;
	private JTextField txtFechaRegistro;
	private JLabel lblFechaRegistro;
	private JTextField txtNombreCliente;
	private JTextField txtNombreRecepcionista;
	private JTextField txtDatosHabitacion;
	private JButton btnBuscarCliente;
	private JButton btnBuscarRecepcionista;
	private JButton btnBuscarHabitacion;

	/**
	 * Constructor privado del formulario
	 */
	private FrmIngresoReserva() {
		setResizable(false);
		setTitle("Sistema de Gesti\u00F3n Hotelera");

		setBounds(100, 100, 805, 575);
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
				btnAgregar.setIcon(new ImageIcon(FrmIngresoReserva.class
						.getResource("/recursos/agregar.png")));
				pnlBotones.add(btnAgregar);
				btnEditar = new JButton("");
				btnEditar.setToolTipText("Editar");
				btnEditar.setIcon(new ImageIcon(FrmIngresoReserva.class
						.getResource("/recursos/editar.png")));
				pnlBotones.add(btnEditar);
				btnGuardar = new JButton("");
				btnGuardar.setToolTipText("Aceptar");
				btnGuardar.setIcon(new ImageIcon(FrmIngresoReserva.class
						.getResource("/recursos/aceptar.png")));
				pnlBotones.add(btnGuardar);
				btnCancelar = new JButton("");
				btnCancelar.setIcon(new ImageIcon(FrmIngresoReserva.class
						.getResource("/recursos/cancelar.png")));
				btnCancelar.setToolTipText("Cancelar");
				pnlBotones.add(btnCancelar);
				btnConsultar = new JButton("");
				btnConsultar.setIcon(new ImageIcon(FrmIngresoReserva.class
						.getResource("/recursos/consultar.png")));
				btnConsultar.setToolTipText("Consultar");
				pnlBotones.add(btnConsultar);
				btnConsultar.addActionListener(this);
				btnCancelar.addActionListener(this);
				btnGuardar.addActionListener(this);
				btnEditar.addActionListener(this);
				btnAgregar.addActionListener(this);
			}
			{
				lblMaterial = new JLabel("Reservas");
				lblMaterial.setForeground(new Color(255, 250, 240));
				lblMaterial.setFont(new Font("Segoe UI Semibold", Font.PLAIN,
						44));
				lblMaterial.setBounds(10, 50, 308, 59);
				contentPane.add(lblMaterial);
			}
			{
				pnlCabecera = new JLabel("");
				pnlCabecera.setIcon(new ImageIcon(FrmIngresoReserva.class
						.getResource("/recursos/habitacion.png")));
				pnlCabecera.setBounds(0, 0, 800, 120);
				contentPane.add(pnlCabecera);
			}
			{
				pnlInformacion = new JPanel();
				pnlInformacion.setBackground(new Color(255, 250, 240));
				pnlInformacion.setBounds(0, 187, 800, 348);
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
					lblCodigo = new JLabel("C\u00F3digo de Reserva");
					lblCodigo.setBounds(10, 57, 132, 14);
					pnlInformacion.add(lblCodigo);
				}
				{
					txtCodigo = new JTextField();
					txtCodigo.setBounds(152, 54, 50, 20);
					pnlInformacion.add(txtCodigo);
					txtCodigo.setColumns(10);
				}
				{
					lblEstado = new JLabel("Estado");
					lblEstado.setBounds(512, 129, 100, 14);
					pnlInformacion.add(lblEstado);
				}
				{
					lblFechaIngreso = new JLabel("Fecha de Ingreso");
					lblFechaIngreso.setBounds(512, 81, 100, 14);
					pnlInformacion.add(lblFechaIngreso);
				}
				{
					txtCodCliente = new JTextField();
					txtCodCliente.setEnabled(false);
					txtCodCliente.setBounds(152, 78, 50, 20);
					pnlInformacion.add(txtCodCliente);
					txtCodCliente.setColumns(10);
				}
				{
					cboEstado = new JComboBox();
					cboEstado.setBounds(640, 126, 150, 20);
					pnlInformacion.add(cboEstado);
					cboEstado.setModel(new DefaultComboBoxModel(new String[] {
							"Iniciada", "Anulada", "Atendida" }));
				}
				{
					txtFechaIngreso = new JTextField();
					txtFechaIngreso.setBounds(640, 78, 150, 20);
					pnlInformacion.add(txtFechaIngreso);
					txtFechaIngreso.setColumns(10);
				}
				{
					lblCliente = new JLabel("Cliente");
					lblCliente.setBounds(10, 81, 100, 14);
					pnlInformacion.add(lblCliente);
				}
				{
					{
						{
							{
								{
									{
										table = new JTable();
										table.addKeyListener(this);
										table.addMouseListener(this);
										table.setForeground(new Color(148, 0,
												211));
										table.setBackground(new Color(255, 250,
												240));
										table.setModel(new DefaultTableModel(
												new Object[][] {},
												new String[] { "Número",
														"COD Cli", "COD Recep",
														"N° Habi",
														"Fec Registro",
														"Fec Ingreso",
														"Fec SAlida", "Estado" }));
										scpPanel = new JScrollPane(table);
										scpPanel.setBackground(new Color(255,
												250, 240));
										scpPanel.setBounds(10, 221, 780, 116);
										pnlInformacion.add(scpPanel);
										{

											scpPanel.setViewportView(table);
										}
									}
								}
							}
						}
					}
				}
				{
					lblRecepcionista = new JLabel("Recepcionista");
					lblRecepcionista.setBounds(10, 105, 126, 14);
					pnlInformacion.add(lblRecepcionista);
				}

				txtCodRecepcionista = new JTextField();
				txtCodRecepcionista.setEnabled(false);
				txtCodRecepcionista.setColumns(10);
				txtCodRecepcionista.setBounds(152, 102, 50, 20);
				pnlInformacion.add(txtCodRecepcionista);

				txtNumHabitacion = new JTextField();
				txtNumHabitacion.setEnabled(false);
				txtNumHabitacion.setColumns(10);
				txtNumHabitacion.setBounds(152, 126, 50, 20);
				pnlInformacion.add(txtNumHabitacion);

				JLabel lblHabitacion = new JLabel("Habitaci\u00F3n");
				lblHabitacion.setBounds(10, 129, 100, 14);
				pnlInformacion.add(lblHabitacion);

				txtFechaSalida = new JTextField();
				txtFechaSalida.setEnabled(false);
				txtFechaSalida.setColumns(10);
				txtFechaSalida.setBounds(640, 102, 150, 20);
				pnlInformacion.add(txtFechaSalida);

				JLabel lblFechaSalida = new JLabel("Fecha de Salida");
				lblFechaSalida.setBounds(512, 105, 100, 14);
				pnlInformacion.add(lblFechaSalida);

				txtFechaRegistro = new JTextField();
				txtFechaRegistro.setEnabled(false);
				txtFechaRegistro.setColumns(10);
				txtFechaRegistro.setBounds(640, 54, 150, 20);
				pnlInformacion.add(txtFechaRegistro);
				{
					lblFechaRegistro = new JLabel("Fecha de Registro");
					lblFechaRegistro.setBounds(512, 57, 100, 14);
					pnlInformacion.add(lblFechaRegistro);
				}
				{
					txtNombreCliente = new JTextField();
					txtNombreCliente.setEnabled(false);
					txtNombreCliente.setColumns(10);
					txtNombreCliente.setBounds(207, 78, 210, 20);
					pnlInformacion.add(txtNombreCliente);
				}
				{
					txtNombreRecepcionista = new JTextField();
					txtNombreRecepcionista.setEnabled(false);
					txtNombreRecepcionista.setColumns(10);
					txtNombreRecepcionista.setBounds(207, 102, 210, 20);
					pnlInformacion.add(txtNombreRecepcionista);
				}
				{
					txtDatosHabitacion = new JTextField();
					txtDatosHabitacion.setEnabled(false);
					txtDatosHabitacion.setColumns(10);
					txtDatosHabitacion.setBounds(207, 126, 210, 20);
					pnlInformacion.add(txtDatosHabitacion);
				}
				{
					btnBuscarCliente = new JButton("...");
					btnBuscarCliente.setBounds(420, 78, 20, 20);
					pnlInformacion.add(btnBuscarCliente);
				}
				{
					btnBuscarRecepcionista = new JButton("...");
					btnBuscarRecepcionista.setBounds(420, 102, 20, 20);
					pnlInformacion.add(btnBuscarRecepcionista);
				}
				{
					btnBuscarHabitacion = new JButton("...");
					btnBuscarHabitacion.setBounds(420, 126, 20, 20);
					pnlInformacion.add(btnBuscarHabitacion);
				}
			}
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		habilitar(false);

		listar();

	}

	/**
	 * @return Única instancia del formulario
	 */
	public static FrmIngresoReserva getInstance() {
		if (instancia == null)
			instancia = new FrmIngresoReserva();

		return instancia;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			btnConsultarActionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			btnCancelarActionPerformed(e);
		}
		if (e.getSource() == btnGuardar) {
			btnGuardarActionPerformed(e);
		}
		if (e.getSource() == btnEditar) {
			btnEditarActionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			btnAgregarActionPerformed(e);
		}
	}

	/**
	 * Metodo que habilita o inhabilita los controles
	 * 
	 * @param valor
	 *            boolean que indica que se debe habilitar
	 */
	void habilitar(boolean valor) {
		btnBuscarCliente.setEnabled(valor);
		btnBuscarRecepcionista.setEnabled(valor);
		btnBuscarHabitacion.setEnabled(valor);
		txtFechaIngreso.setEnabled(valor);
		txtFechaSalida.setEnabled(valor);
		btnGuardar.setEnabled(valor);
		btnCancelar.setEnabled(valor);

		txtCodigo.setEnabled(!valor);
		btnAgregar.setEnabled(!valor);
		btnConsultar.setEnabled(!valor);
		btnEditar.setEnabled(!valor);
	}

	protected void btnAgregarActionPerformed(ActionEvent arg0) {
		habilitar(true);

		accion = ACCION_AGREGAR;
		txtCodigo.setText("" + controlador.generarCodigo());
		txtFechaRegistro.setText(new Date().toString());
		cboEstado.setSelectedIndex(0);
	}

	protected void btnEditarActionPerformed(ActionEvent arg0) {
		habilitar(true);

		accion = ACCION_EDITAR;
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

	// ---------------------------------------------------------
	int getNumero() {
		return Integer.parseInt(txtCodigo.getText());
	}

	// ---------------------------------------------------------
	int getCodCliente() {
		return Integer.parseInt(txtCodCliente.getText());
	}

	int getNumHabitacion() {
		return Integer.parseInt(txtNumHabitacion.getText());
	}

	int getCodRecep() {
		return Integer.parseInt(txtCodRecepcionista.getText());
	}

	// ---------------------------------------------------------
	int getEstado() {
		return cboEstado.getSelectedIndex();
	}

	// ---------------------------------------------------------
	String getFecIngreso() {
		return txtFechaIngreso.getText();
	}

	String getFecSalida() {
		return txtFechaSalida.getText();
	}

	String getFecRegistro() {
		return txtFechaRegistro.getText();
	}

	// ---------------------------------------------------------
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	/**
	 * Ingresa una habitacion evitando que el numero se repita
	 */
	void ingresar() {
		Reserva obj = controlador.buscar(getNumero());
		if (obj != null) {
			mensaje("El numero de habitación ya existe...");
		} else {
			obj = new Reserva(getNumero(), getCodCliente(), getCodRecep(),
					getNumHabitacion(), getFecRegistro(), getFecIngreso(),
					getFecSalida(), getEstado());
			controlador.adicionar(obj);
			controlador.grabar();
			borrar();
			listar();
			mensaje("Se registró la habitación");
		}
	}

	void modificar() {
		Reserva obj = controlador.buscar(getNumero());
		if (obj == null) {
			mensaje("No existe habitación con ese número");
		} else {
			obj = new Reserva(getNumero(), getCodCliente(), getCodRecep(),
					getNumHabitacion(), getFecRegistro(), getFecIngreso(),
					getFecSalida(), getEstado());
			controlador.modificar(obj);
			controlador.grabar();
			borrar();
			listar();
			mensaje("Se actualizó la habitación");
		}
	}

	/*
	 * void eliminar() { Habitacion obj = controlador.buscar(getNumero()); if
	 * (obj != null) { if (JOptionPane.showConfirmDialog(this,
	 * "Se eliminará la Reserva. ¿Desea continuar?", "Confirmación",
	 * JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
	 * controlador.eliminar(obj); controlador.grabar(); borrar(); listar(); } }
	 * else mensaje("No existe el número ingresado"); }
	 */

	// Muestra el listado solicitado
	void listar() {
		if (controlador.tamaño() > 0) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().clear();

			for (int i = 0; i < controlador.tamaño(); i++) {
				Reserva x = controlador.obtener(i);
				Object row[] = { x.getCodigo(), x.getCodigoCliente(),
						x.getCodigoRecepcionista(), x.getNumeroHabitacion(),
						x.getFechaRegistro(), x.getFechaIngreso(),
						x.getFechaSalida(), x.getEstado() };
				model.addRow(row);
			}
			borrar();
		}
	}

	void borrar() {
		txtCodigo.setText("");
		txtCodCliente.setText("");
		cboEstado.setSelectedIndex(0);

		txtFechaIngreso.setText("");
	}

	protected void btnConsultarActionPerformed(ActionEvent e) {
		Reserva obj = null;
		obj = controlador.buscar(getNumero());
		if (obj == null) {
			mensaje("El numero no existe...");
		} else {
			mostrarDatosHabitacion(obj);

		}
	}

	private void mostrarDatosHabitacion(Reserva obj) {
		txtCodigo.setText("" + obj.getCodigo());
		txtCodCliente.setText("" + obj.getCodigoCliente());
		txtCodRecepcionista.setText("" + obj.getCodigoRecepcionista());
		txtNumHabitacion.setText("" + obj.getNumeroHabitacion());
		cboEstado.setSelectedIndex(obj.getEstado());

		txtFechaIngreso.setText("" + obj.getFechaIngreso());
		txtFechaRegistro.setText("" + obj.getFechaRegistro());
		txtFechaSalida.setText("" + obj.getFechaSalida());
	}

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
		Reserva obj = controlador.obtener(table.convertRowIndexToModel(table
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
		Reserva obj = controlador.obtener(table.convertRowIndexToModel(table
				.getSelectedRow()));
		if (obj != null)
			mostrarDatosHabitacion(obj);
	}
}