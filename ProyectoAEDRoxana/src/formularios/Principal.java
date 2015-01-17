
package formularios;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.alee.laf.WebLookAndFeel;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream.GetField;
import java.awt.event.InputEvent;

public class Principal implements ActionListener {

	private JFrame frmSistemaDeGestin;
	private JMenu mnReportes;
	private JMenu mnHospedaje;
	private JMenu mnReserva;
	private JMenu mnMantenimiento;
	private JMenuItem mntmIngresoHospedaje;
	private JMenuItem mntmListadoHospedaje;
	private JMenuItem mntmAnulacionHospedaje;
	private JMenuItem mntmAnulacionReserva;
	private JMenuItem mntmListadoReserva;
	private JMenuItem mntmIngresoReserva;
	private JMenuItem mntmHabitacion;
	private JMenuItem mntmCliente;
	private JMenuItem mntmRecepcionista;
	private JLabel lblBackground;
	private JLabel lblSistemaDeGestin;
	private JMenuItem mntmReporteRecepcionista;
	private JMenuItem mntmReporteHabitacion;
	private JMenuItem mntmReporteReserva;
	private JMenuItem mntmReporteHospedaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					WebLookAndFeel.install();

					Principal window = new Principal();
					window.frmSistemaDeGestin.setVisible(true);
					// window.frmSistemaDeGestin
					// .setExtendedState(JFrame.MAXIMIZED_BOTH);
					// size of the screen
					/*Dimension screenSize = Toolkit.getDefaultToolkit()
							.getScreenSize();
*/
					// height of the task bar
					/*Insets scnMax = Toolkit.getDefaultToolkit()
							.getScreenInsets(
									window.frmSistemaDeGestin
											.getGraphicsConfiguration());
					int taskBarSize = scnMax.bottom;*/

					// available size of the screen
					/*window.frmSistemaDeGestin.setBounds(0, 0, screenSize.width,
							screenSize.height - taskBarSize);
					window.frmSistemaDeGestin.setAlwaysOnTop(true);*/

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeGestin = new JFrame();
		// frmSistemaDeGestin.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/recursos/img_hotel.png")));
		frmSistemaDeGestin.setTitle("Sistema de Gesti\u00F3n Hotelera - version 1.0.00");
		frmSistemaDeGestin.setResizable(false);
		frmSistemaDeGestin.setBounds(100, 100, 733, 627);
		frmSistemaDeGestin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar mnuPrincipal = new JMenuBar();
		mnuPrincipal.setBackground(new Color(255, 250, 240));
		frmSistemaDeGestin.setJMenuBar(mnuPrincipal);

		mnMantenimiento = new JMenu("Mantenimiento");
		ImageIcon iconMantenimiento = new ImageIcon(
				Principal.class.getResource("/recursos/hotel15.png"));
		int widthMantenimiento = iconMantenimiento.getIconWidth() / 32;
		mnMantenimiento.setIcon(new ImageIcon(iconMantenimiento.getImage()
				.getScaledInstance(widthMantenimiento, -1,
						java.awt.Image.SCALE_SMOOTH)));
		mnuPrincipal.add(mnMantenimiento);

		mntmHabitacion = new JMenuItem("Habitaci\u00F3n");
		mntmHabitacion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.ALT_MASK));
		mntmHabitacion.addActionListener(this);
		ImageIcon iconHabitacion = new ImageIcon(
				Principal.class.getResource("/recursos/bed6.png"));
		int widthHabitacion = iconHabitacion.getIconWidth() / 32;
		mntmHabitacion.setIcon(new ImageIcon(iconHabitacion.getImage()
				.getScaledInstance(widthHabitacion, -1,
						java.awt.Image.SCALE_SMOOTH)));
		mnMantenimiento.add(mntmHabitacion);

		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(this);
		ImageIcon iconCliente = new ImageIcon(
				Principal.class.getResource("/recursos/hotel0.jpg"));
		int widthCliente = iconCliente.getIconWidth() / 14;
		mntmCliente.setIcon(new ImageIcon(iconCliente.getImage()
				.getScaledInstance(widthCliente, -1,
						java.awt.Image.SCALE_SMOOTH)));
		mntmCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mnMantenimiento.add(mntmCliente);

		mntmRecepcionista = new JMenuItem("Recepcionista");
		mntmRecepcionista.addActionListener(this);
		ImageIcon iconRecepcionista = new ImageIcon(
				Principal.class.getResource("/recursos/hotel13.png"));
		int widthRecepcionista = iconRecepcionista.getIconWidth() / 32;
		mntmRecepcionista.setIcon(new ImageIcon(iconRecepcionista.getImage()
				.getScaledInstance(widthRecepcionista, -1,
						java.awt.Image.SCALE_SMOOTH)));
		mntmRecepcionista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mnMantenimiento.add(mntmRecepcionista);

		mnReserva = new JMenu("Reserva");
		ImageIcon iconReserva = new ImageIcon(
				Principal.class.getResource("/recursos/day5.png"));
		int widthReserva = iconReserva.getIconWidth() / 32;
		mnReserva.setIcon(new ImageIcon(iconReserva.getImage()
				.getScaledInstance(widthReserva, -1,
						java.awt.Image.SCALE_SMOOTH)));
		mnuPrincipal.add(mnReserva);

		mntmIngresoReserva = new JMenuItem("Ingreso");
		mntmIngresoReserva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mntmIngresoReserva.addActionListener(this);
		mnReserva.add(mntmIngresoReserva);

		mntmListadoReserva = new JMenuItem("Listado");
		mntmListadoReserva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mntmListadoReserva.addActionListener(this);
		mnReserva.add(mntmListadoReserva);

		mntmAnulacionReserva = new JMenuItem("Anulaci\u00F3n");
		mntmAnulacionReserva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mnReserva.add(mntmAnulacionReserva);

		mnHospedaje = new JMenu("Hospedaje");
		ImageIcon iconHospedaje = new ImageIcon(
				Principal.class.getResource("/recursos/hotel9.png"));
		int widthHospedaje = iconHospedaje.getIconWidth() / 32;
		mnHospedaje.setIcon(new ImageIcon(iconHospedaje.getImage()
				.getScaledInstance(widthHospedaje, -1,
						java.awt.Image.SCALE_SMOOTH)));
		mnuPrincipal.add(mnHospedaje);

		mntmIngresoHospedaje = new JMenuItem("Ingreso");
		mntmIngresoHospedaje.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mntmIngresoHospedaje.addActionListener(this);
		mnHospedaje.add(mntmIngresoHospedaje);

		mntmListadoHospedaje = new JMenuItem("Listado");
		mntmListadoHospedaje.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mnHospedaje.add(mntmListadoHospedaje);

		mntmAnulacionHospedaje = new JMenuItem("Anulaci\u00F3n");
		mntmAnulacionHospedaje.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mnHospedaje.add(mntmAnulacionHospedaje);

		mnReportes = new JMenu("Reportes");
		mnuPrincipal.add(mnReportes);

		mntmReporteRecepcionista = new JMenuItem(
				"Hospedajes por recepcionista");
		mntmReporteRecepcionista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, InputEvent.ALT_MASK));
		mnReportes.add(mntmReporteRecepcionista);

		mntmReporteHabitacion = new JMenuItem(
				"Historial de habitaci\u00F3n");
		mntmReporteHabitacion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mnReportes.add(mntmReporteHabitacion);

		mntmReporteReserva = new JMenuItem("Reservas por fechas");
		mntmReporteReserva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mnReportes.add(mntmReporteReserva);

		mntmReporteHospedaje = new JMenuItem("Hospedaje");
		mntmReporteHospedaje.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mnReportes.add(mntmReporteHospedaje);
		frmSistemaDeGestin.getContentPane().setLayout(null);

		lblSistemaDeGestin = new JLabel(
				"<html>Sistema de<br />Gesti\u00F3n Hotelera</html>");
		lblSistemaDeGestin.setVerticalAlignment(SwingConstants.TOP);
		lblSistemaDeGestin.setHorizontalAlignment(SwingConstants.LEFT);
		lblSistemaDeGestin.setForeground(new Color(255, 250, 240));
		lblSistemaDeGestin.setFont(new Font("Tahoma", Font.PLAIN, 66));
		lblSistemaDeGestin.setBounds(10, 411, 540, 155);
		lblSistemaDeGestin.setAlignmentX(Component.CENTER_ALIGNMENT);
		frmSistemaDeGestin.getContentPane().add(lblSistemaDeGestin);

		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 1921, 703);
		lblBackground.setHorizontalAlignment(SwingConstants.LEFT);
		lblBackground.setVerticalAlignment(SwingConstants.TOP);
		lblBackground.setIcon(new ImageIcon(Principal.class
				.getResource("/recursos/background_2.jpg")));
		frmSistemaDeGestin.getContentPane().add(lblBackground);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmCliente) {
			mntmClienteActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmHabitacion) {
			mntmHabitacionActionPerformed(arg0);
		}
		
		if (arg0.getSource() == mntmRecepcionista) {
			mntmRecepcionistaActionPerformed(arg0);
		}
		
		if (arg0.getSource() == mntmIngresoReserva) {
			mntmIngresoReservaActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmListadoReserva) {
			mntmListadoReservaActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmIngresoHospedaje) {
			mntmIngresoHospedajeActionPerformed(arg0);
		}
		
	}

	protected void mntmHabitacionActionPerformed(ActionEvent arg0) {
		FrmHabitacion frm = FrmHabitacion.getInstance();
		abrirFormulario(frm);
	}
	
	protected void mntmClienteActionPerformed(ActionEvent arg0) {
		FrmCliente frm = FrmCliente.getInstance();
		abrirFormulario(frm);
	}
	protected void mntmRecepcionistaActionPerformed(ActionEvent arg0) {
		FrmRecepcionistas frm = FrmRecepcionistas.getInstance();
		abrirFormulario(frm);
	}
	protected void mntmIngresoReservaActionPerformed(ActionEvent arg0) {
		FrmIngresoReserva frm = FrmIngresoReserva.getInstance();
		abrirFormulario(frm);
	}
	
	protected void mntmListadoReservaActionPerformed(ActionEvent arg0) {
		FrmListadoReserva frm = FrmListadoReserva.getInstance();
		abrirFormulario(frm);
	}
	
	protected void mntmIngresoHospedajeActionPerformed(ActionEvent arg0) {
		FrmIngresoHospedaje frm = FrmIngresoHospedaje.getInstance();
		abrirFormulario(frm);
	}
	void abrirFormulario(JFrame frm)
	{
		frm.setVisible(true);
		frm.setAlwaysOnTop(true);
	}

}
