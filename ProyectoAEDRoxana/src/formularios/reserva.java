package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.Producto;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class reserva extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel label;
	private JButton button;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reserva frame = new reserva();
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
	public reserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBounds(0, 0, 753, 233);
			contentPane.add(panel);
			{
				label = new JLabel("");
				label.setIcon(new ImageIcon(reserva.class
						.getResource("/recursos/habitacion.png")));
				panel.add(label);
			}
			{
				btnNewButton = new JButton("");
				btnNewButton.addActionListener(this);
				btnNewButton.setIcon(new ImageIcon(reserva.class
						.getResource("/recursos/aceptar.png")));
				panel.add(btnNewButton);
			}
			{
				button = new JButton("");
				button.addActionListener(this);
				button.setIcon(new ImageIcon(reserva.class
						.getResource("/recursos/agregar.png")));
				panel.add(button);
			}
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 306, 662, 118);
			contentPane.add(scrollPane);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
						new Object[][] {},
						new String[] { "CODIGO", "PRODUCTO", "PRECIO", "HORAS " }));
				scrollPane.setViewportView(table);
			}
		}
		{
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"gggd", "h", "g", "g"}));
			comboBox.setBounds(10, 251, 121, 20);
			contentPane.add(comboBox);
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button) {
			buttonActionPerformed(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			btnNewButtonActionPerformed(arg0);
		}
	}

	protected void btnNewButtonActionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(this, "se grabo ok");

	}

	protected void buttonActionPerformed(ActionEvent arg0) {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		lista.add(new Producto(1, "producto a", 25, 17));
		lista.add(new Producto(2, "producto b", 15, 7));
		lista.add(new Producto(3, "producto c", 22, 11));
		lista.add(new Producto(4, "producto d", 34.90, 23));
		lista.add(new Producto(5, "producto e", 18.90, 8));

		// Para listar en una JTable
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		// Limpiar los datos que hay actualmente
		modelo.getDataVector().clear();

		// Recorrer la lista para agregar los datos a la tabla
		for (Producto producto : lista) {
			// Se crea un arreglo de objetos con los campos del producto
			Object[] p = { producto.getCodigo(), producto.getNombre(),
					producto.getPrecio(), producto.getHoras() };
			// Se agrega la fila
			modelo.addRow(p);
		}
	}
}
