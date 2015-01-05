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

import javax.swing.border.TitledBorder;

public class FrmListadoReserva extends JFrame implements ActionListener,
		MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4700913660323757406L;
	private JPanel contentPane;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnConsultar;
	private JButton btnListar;
	private JLabel lblNumero;
	private JLabel lblDescripcion;
	private JLabel lblTipo;
	private JLabel lblCosto;
	private JTextField txtNumero;
	private JTextField txtCodCliente;
	private JComboBox<?> cboEstado;
	private JTextField txtFecIngreso;
	private JScrollPane scpPanel;
	private JLabel lblInfo;

	ControladorReserva controlador = new ControladorReserva();

	public static final int ACCION_AGREGAR = 1;
	public static final int ACCION_EDITAR = 2;

	int accion = 0;

	/**
	 * Variable Estática
	 */
	private static FrmListadoReserva instancia = null;
	private JPanel pnlInformacion;
	private JPanel pnlBotones;
	private JLabel pnlCabecera;
	private JTable table;
	private JLabel lblMaterial;
	private JLabel lblCodRecepcionista;
	private JTextField txtCodRecep;
	private JTextField txtNumHabitacion;
	private JTextField txtFecSalida;
	private JTextField txtFecRegistro;

	/**
	 * Constructor privado del formulario
	 */
	private FrmListadoReserva() {
		setResizable(false);
		setTitle("Sistema de Gesti\u00F3n Hotelera");

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
				btnGuardar = new JButton("");
				btnGuardar.setToolTipText("Aceptar");
				btnGuardar.setIcon(new ImageIcon(FrmListadoReserva.class
						.getResource("/recursos/aceptar.png")));
				pnlBotones.add(btnGuardar);
				btnCancelar = new JButton("");
				btnCancelar.setIcon(new ImageIcon(FrmListadoReserva.class
						.getResource("/recursos/cancelar.png")));
				btnCancelar.setToolTipText("Cancelar");
				pnlBotones.add(btnCancelar);
				btnConsultar = new JButton("");
				btnConsultar.setIcon(new ImageIcon(FrmListadoReserva.class
						.getResource("/recursos/consultar.png")));
				btnConsultar.setToolTipText("Consultar");
				pnlBotones.add(btnConsultar);
				{
					btnListar = new JButton("");
					btnListar.addActionListener(this);
					btnListar.setIcon(new ImageIcon(FrmListadoReserva.class
							.getResource("/recursos/refrescar.png")));
					btnListar.setToolTipText("Refrescar lista");
					pnlBotones.add(btnListar);
				}
				btnConsultar.addActionListener(this);
				btnCancelar.addActionListener(this);
				btnGuardar.addActionListener(this);
			}
			{
				lblMaterial = new JLabel("Listado Reservas");
				lblMaterial.setForeground(new Color(255, 250, 240));
				lblMaterial.setFont(new Font("Segoe UI Semibold", Font.PLAIN,
						44));
				lblMaterial.setBounds(10, 50, 416, 59);
				contentPane.add(lblMaterial);
			}
			{
				pnlCabecera = new JLabel("");
				pnlCabecera.setIcon(new ImageIcon(FrmListadoReserva.class
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
					lblNumero = new JLabel("N\u00B0 RESERVA");
					lblNumero.setBounds(10, 54, 100, 14);
					pnlInformacion.add(lblNumero);
				}
				{
					txtNumero = new JTextField();
					txtNumero.setBounds(152, 51, 150, 20);
					pnlInformacion.add(txtNumero);
					txtNumero.setColumns(10);
				}
				{
					lblTipo = new JLabel("ESTADO");
					lblTipo.setBounds(635, 88, 100, 14);
					pnlInformacion.add(lblTipo);
				}
				{
					lblCosto = new JLabel("FEC REGISTRO");
					lblCosto.setBounds(347, 85, 100, 14);
					pnlInformacion.add(lblCosto);
				}
				{
					txtCodCliente = new JTextField();
					txtCodCliente.setBounds(152, 82, 150, 20);
					pnlInformacion.add(txtCodCliente);
					txtCodCliente.setColumns(10);
				}
				{
					cboEstado = new JComboBox();
					cboEstado.setBounds(635, 113, 150, 20);
					pnlInformacion.add(cboEstado);
					cboEstado.setModel(new DefaultComboBoxModel(new String[] {
							"Iniciada", "Anulada", "Atendida"}));
				}
				{
					txtFecIngreso = new JTextField();
					txtFecIngreso.setBounds(475, 79, 150, 20);
					pnlInformacion.add(txtFecIngreso);
					txtFecIngreso.setColumns(10);
				}
				{
					lblDescripcion = new JLabel("COD CLIENTE");
					lblDescripcion.setBounds(10, 82, 100, 14);
					pnlInformacion.add(lblDescripcion);
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
														"Descripción", "Tipo",
														"Ubicación", "Costo" }));
										scpPanel = new JScrollPane(table);
										scpPanel.setBackground(new Color(255,
												250, 240));
										scpPanel.setBounds(10, 144, 780, 158);
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
					lblCodRecepcionista = new JLabel("COD RECEPCIONISTA");
					lblCodRecepcionista.setBounds(10, 109, 126, 14);
					pnlInformacion.add(lblCodRecepcionista);
				}
				
				txtCodRecep = new JTextField();
				txtCodRecep.setEnabled(false);
				txtCodRecep.setColumns(10);
				txtCodRecep.setBounds(152, 106, 150, 20);
				pnlInformacion.add(txtCodRecep);
				
				txtNumHabitacion = new JTextField();
				txtNumHabitacion.setEnabled(false);
				txtNumHabitacion.setColumns(10);
				txtNumHabitacion.setBounds(475, 48, 150, 20);
				pnlInformacion.add(txtNumHabitacion);
				
				JLabel lblNHabitacion = new JLabel("N\u00B0 HABITACION");
				lblNHabitacion.setBounds(347, 54, 100, 14);
				pnlInformacion.add(lblNHabitacion);
				
				txtFecSalida = new JTextField();
				txtFecSalida.setEnabled(false);
				txtFecSalida.setColumns(10);
				txtFecSalida.setBounds(475, 106, 150, 20);
				pnlInformacion.add(txtFecSalida);
				
				JLabel lblFecSalida = new JLabel("FEC SALIDA");
				lblFecSalida.setBounds(347, 110, 100, 14);
				pnlInformacion.add(lblFecSalida);
				
				txtFecRegistro = new JTextField();
				txtFecRegistro.setBorder(new TitledBorder(null, "FECHA DE REGISTRO", TitledBorder.LEFT, TitledBorder.TOP, null, null));
				txtFecRegistro.setColumns(10);
				txtFecRegistro.setBounds(635, 35, 150, 46);
				pnlInformacion.add(txtFecRegistro);
			}
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		habilitar(false);
		listar();
	}

	/**
	 * @return Única instancia del formulario
	 */
	public static FrmListadoReserva getInstance() {
		if (instancia == null)
			instancia = new FrmListadoReserva();

		return instancia;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			do_btnListar_actionPerformed(e);
		}
		if (e.getSource() == btnConsultar) {
			btnConsultarActionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			btnCancelarActionPerformed(e);
		}
		if (e.getSource() == btnGuardar) {
			btnGuardarActionPerformed(e);
		}
	}

	/**
	 * Metodo que habilita o inhabilita los controles
	 * 
	 * @param valor
	 *            boolean que indica que se debe habilitar
	 */
	void habilitar(boolean valor) {
		txtCodCliente.setEnabled(valor);
		cboEstado.setEnabled(valor);
		txtFecIngreso.setEnabled(valor);
		txtCodRecep .setEnabled(valor);
		txtNumHabitacion .setEnabled(valor);
		txtFecRegistro .setEnabled(valor);
		txtFecSalida .setEnabled(valor);
		btnGuardar.setEnabled(valor);
		btnCancelar.setEnabled(valor);

		txtNumero.setEnabled(!valor);
		btnConsultar.setEnabled(!valor);
		btnListar.setEnabled(!valor);
		
		controlador.cargar();
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
		return Integer.parseInt(txtNumero.getText());
	}

	// ---------------------------------------------------------
	int getCodCliente() {
		return Integer.parseInt(txtCodCliente.getText());
	}
	int getNumHabitacion() {
		return Integer.parseInt(txtNumHabitacion.getText());
	}

	int getCodRecep() {
		return Integer.parseInt(txtCodRecep.getText());
	}
	// ---------------------------------------------------------
	int getEstado() {
		return cboEstado.getSelectedIndex();
	}

	

	// ---------------------------------------------------------
	String getFecIngreso() {
		return txtFecIngreso.getText();
	}
	String getFecSalida() {
		return txtFecSalida.getText();
	}
	
	String getFecRegistro() {
		return txtFecRegistro.getText();
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
			obj = new Reserva(getNumero(), getCodCliente(), getCodRecep(),getNumHabitacion(),
					getFecRegistro(),getFecIngreso(),getFecSalida(),getEstado());
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
			obj = new Reserva(getNumero(), getCodCliente(), getCodRecep(),getNumHabitacion(),
					getFecRegistro(),getFecIngreso(),getFecSalida(),getEstado());
			controlador.modificar(obj);
			controlador.grabar();
			borrar();
			listar();
			mensaje("Se actualizó la habitación");
		}
	}

	/*void eliminar() {
		Habitacion obj = controlador.buscar(getNumero());
		if (obj != null) {
			if (JOptionPane.showConfirmDialog(this,
					"Se eliminará la Reserva. ¿Desea continuar?",
					"Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				controlador.eliminar(obj);
				controlador.grabar();
				borrar();
				listar();
			}
		} else
			mensaje("No existe el número ingresado");
	}*/

	// Muestra el listado solicitado
	void listar() {
		if (controlador.tamaño() > 0) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().clear();
			

			for (int i = 0; i < controlador.tamaño(); i++) {
				Reserva x = controlador.obtener(i);
				Object row[] = { x.getCodigo(),x.getCodigoCliente(), x.getCodigoRecepcionista(),
						x.getFechaRegistro(),x.getFechaIngreso(),x.getFechaSalida(),x.getEstado()
						 };
				model.addRow(row);
			}
			borrar();
		}
	}

	void borrar() {
		txtNumero.setText("");
		txtCodCliente.setText("");
		cboEstado.setSelectedIndex(0);
		
		txtFecIngreso.setText("");
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
		txtNumero.setText("" + obj.getCodigo());
		txtCodCliente.setText(""+obj.getCodigoCliente());
		
		cboEstado.setSelectedIndex(obj.getEstado());
		
		txtFecIngreso.setText("" + obj.getFechaIngreso());
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
	protected void do_btnListar_actionPerformed(ActionEvent e) {
		
		
		listar() ;
	}
	
	
}