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
import controladores.ControladorHospedaje;
import controladores.ControladorReserva;
import entidades.Habitacion;
import entidades.Hospedaje;
import entidades.Reserva;

import javax.swing.JTable;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.border.TitledBorder;

public class FrmIngresoHospedaje extends JFrame implements ActionListener,
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
	private JLabel lblNumero;
	private JLabel lblDescripcion;
	private JLabel lblTipo;
	private JTextField txtNumero;
	private JTextField txtCodCliente;
	private JComboBox<?> cboEstado;
	private JComboBox<?> cboReserva;
	private JComboBox<?> cboReserva_1;
	private JScrollPane scpPanel;
	private JLabel lblInfo;

	ControladorHospedaje controlador = new ControladorHospedaje();

	public static final int ACCION_AGREGAR = 1;
	public static final int ACCION_EDITAR = 2;

	int accion = 0;

	/**
	 * Variable Estática
	 */
	private static FrmIngresoHospedaje instancia = null;
	private JPanel pnlInformacion;
	private JPanel pnlBotones;
	private JLabel pnlCabecera;
	private JTable table;
	private JLabel lblMaterial;
	private JLabel lblCodRecepcionista;
	private JTextField txtCodRecep;
	private JTextField txtNumHabitacion;
	private JTextField txtFecRegistro;
	
	private JTextField txtCodReserva;

	/**
	 * Constructor privado del formulario
	 */
	private FrmIngresoHospedaje() {
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
				btnAgregar = new JButton("");
				btnAgregar.setHorizontalAlignment(SwingConstants.LEFT);
				btnAgregar.setToolTipText("Agregar");
				btnAgregar.setBackground(new Color(255, 250, 240));
				btnAgregar.setIcon(new ImageIcon(FrmIngresoHospedaje.class
						.getResource("/recursos/agregar.png")));
				pnlBotones.add(btnAgregar);
				btnEditar = new JButton("");
				btnEditar.setToolTipText("Editar");
				btnEditar.setIcon(new ImageIcon(FrmIngresoHospedaje.class
						.getResource("/recursos/editar.png")));
				pnlBotones.add(btnEditar);
				btnGuardar = new JButton("");
				btnGuardar.setToolTipText("Aceptar");
				btnGuardar.setIcon(new ImageIcon(FrmIngresoHospedaje.class
						.getResource("/recursos/aceptar.png")));
				pnlBotones.add(btnGuardar);
				btnCancelar = new JButton("");
				btnCancelar.setIcon(new ImageIcon(FrmIngresoHospedaje.class
						.getResource("/recursos/cancelar.png")));
				btnCancelar.setToolTipText("Cancelar");
				pnlBotones.add(btnCancelar);
				btnConsultar = new JButton("");
				btnConsultar.setIcon(new ImageIcon(FrmIngresoHospedaje.class
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
				lblMaterial = new JLabel("HOSPEDAJES");
				lblMaterial.setForeground(new Color(255, 250, 240));
				lblMaterial.setFont(new Font("Segoe UI Semibold", Font.PLAIN,
						44));
				lblMaterial.setBounds(10, 50, 308, 59);
				contentPane.add(lblMaterial);
			}
			{
				pnlCabecera = new JLabel("");
				pnlCabecera.setIcon(new ImageIcon(FrmIngresoHospedaje.class
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
					lblInfo = new JLabel("Informaci\u00F3n Hospedaje");
					lblInfo.setBounds(10, 10, 259, 32);
					pnlInformacion.add(lblInfo);
					lblInfo.setForeground(new Color(72, 61, 139));
					lblInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
				}
				{
					lblNumero = new JLabel("N\u00B0 HOSPEDAJE");
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
							 "Atendida","Anulada"}));
				}
				
				
				{
					cboReserva = new JComboBox();
					cboReserva.setBounds(635, 113, 150, 20);
					pnlInformacion.add(cboReserva);
					cboReserva.setModel(new DefaultComboBoxModel(new String[] {
							"Con Resrerva", "Sin Resrerva"}));
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
												new String[] { "Número","COD Cli","COD Reser", 
														"N° Habi","COD Recep", 
														"Tipo Reserva", "Fec Registro", 
														 "Estado" }));
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
				txtNumHabitacion.setBounds(457, 51, 150, 20);
				pnlInformacion.add(txtNumHabitacion);
				
				JLabel lblNHabitacion = new JLabel("N\u00B0 HABITACION");
				lblNHabitacion.setBounds(347, 54, 100, 14);
				pnlInformacion.add(lblNHabitacion);
				
				txtFecRegistro = new JTextField();
				txtFecRegistro.setBorder(new TitledBorder(null, "FECHA DE REGISTRO", TitledBorder.LEFT, TitledBorder.TOP, null, null));
				txtFecRegistro.setColumns(10);
				txtFecRegistro.setBounds(635, 35, 150, 46);
				pnlInformacion.add(txtFecRegistro);
				
				cboReserva_1 = new JComboBox();
				cboReserva_1.setModel(new DefaultComboBoxModel(new String[] {"Con Reserva", "Sin Reserva"}));
				cboReserva_1.setEnabled(false);
				cboReserva_1.setBounds(457, 113, 150, 20);
				pnlInformacion.add(cboReserva_1);
				
				JLabel lblTipoReserva = new JLabel("TIPO RESERVA");
				lblTipoReserva.setBounds(347, 116, 100, 14);
				pnlInformacion.add(lblTipoReserva);
				
				txtCodReserva = new JTextField();
				txtCodReserva.setEnabled(false);
				txtCodReserva.setColumns(10);
				txtCodReserva.setBounds(457, 85, 150, 20);
				pnlInformacion.add(txtCodReserva);
				
				JLabel lblCodReserva = new JLabel("COD RESERVA");
				lblCodReserva.setBounds(347, 88, 100, 14);
				pnlInformacion.add(lblCodReserva);
			}
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		habilitar(false);
		
		listar();
	
	}

	/**
	 * @return Única instancia del formulario
	 */
	public static FrmIngresoHospedaje getInstance() {
		if (instancia == null)
			instancia = new FrmIngresoHospedaje();

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
		txtCodCliente.setEnabled(valor);
		cboEstado.setEnabled(valor);
		txtCodReserva.setEnabled(valor);
		txtCodRecep .setEnabled(valor);
		cboReserva_1.setEnabled(valor);
		txtNumHabitacion .setEnabled(valor);
		txtFecRegistro .setEnabled(valor);
		btnGuardar.setEnabled(valor);
		btnCancelar.setEnabled(valor);

		txtNumero.setEnabled(!valor);
		btnAgregar.setEnabled(!valor);
		btnConsultar.setEnabled(!valor);
		btnEditar.setEnabled(!valor);
	}

	protected void btnAgregarActionPerformed(ActionEvent arg0) {
		habilitar(true);

		accion = ACCION_AGREGAR;
		txtNumero.setText("" + controlador.generarNumero());
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
	
	int getCodReserva() {
		return Integer.parseInt(txtCodReserva.getText());
	}
	// ---------------------------------------------------------
	int getEstado() {
		return cboEstado.getSelectedIndex();
	}

	int getReserva() {
		return cboReserva_1.getSelectedIndex();
	}

	// ---------------------------------------------------------

	
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
		Hospedaje obj = controlador.buscar(getNumero());
		if (obj != null) {
			mensaje("El numero de habitación ya existe...");
		} else {
			obj = new Hospedaje(getNumero(),getCodReserva(), getCodCliente(),
					getNumHabitacion(), getCodRecep(),getReserva(),
					getFecRegistro(),getEstado());
			controlador.adicionar(obj);
			controlador.grabar();
			borrar();
			listar();
			mensaje("Se registró la habitación");
		}
	}

	void modificar() {
		Hospedaje obj = controlador.buscar(getNumero());
		if (obj == null) {
			mensaje("No existe habitación con ese número");
		} else {
			obj = new Hospedaje(getNumero(), getCodCliente(),getCodReserva(),getNumHabitacion(),
					 getCodRecep(),getReserva(),getFecRegistro(),getEstado());
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
				Hospedaje x = controlador.obtener(i);
				Object row[] = { x.getCodigo(),x.getCodigoCliente(), x.getCodigoReserva(),
						x.getNumeroHabitacion(),
						x.getCodigoRecepcionista(),x.getTipo(),
						x.getFechaRegistro(),x.getEstado()
						 };
				model.addRow(row);
			}
			borrar();
		}
	}

	void borrar() {
		txtNumero.setText("");
		txtCodCliente.setText("");
		txtCodRecep.setText("");
		txtCodReserva.setText("");
		txtNumero.setText("");
		txtNumHabitacion.setText("");
		cboEstado.setSelectedIndex(0);
		cboReserva_1.setSelectedIndex(0);
		txtFecRegistro.setText("");
	}

	protected void btnConsultarActionPerformed(ActionEvent e) {
		Hospedaje obj = null;
		obj = controlador.buscar(getNumero());
		if (obj == null) {
			mensaje("El numero no existe...");
		} else {
			mostrarDatosHabitacion(obj);

		}
	}

	private void mostrarDatosHabitacion(Hospedaje obj) {
		txtNumero.setText("" + obj.getCodigo());
		txtCodCliente.setText(""+obj.getCodigoCliente());
		txtCodReserva.setText(""+obj.getCodigoReserva());
		txtCodRecep.setText(""+obj.getCodigoRecepcionista());
		txtNumHabitacion.setText(""+obj.getNumeroHabitacion());
		cboEstado.setSelectedIndex(obj.getEstado());
		
		cboReserva_1.setSelectedIndex(obj.getTipo());
		txtFecRegistro.setText(""+obj.getFechaRegistro());
	
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
		Hospedaje obj = controlador.obtener(table.convertRowIndexToModel(table
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
		Hospedaje obj = controlador.obtener(table.convertRowIndexToModel(table
				.getSelectedRow()));
		if (obj != null)
			mostrarDatosHabitacion(obj);
	}
}