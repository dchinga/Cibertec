package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import clases.Arreglo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Programa extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6355907866259101137L;

	// Declaración de variables globales

	private JPanel contentPane;
	private JButton btnListar;
	private JButton btnReportar;
	private JButton btnGenerar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	// Variable global de la clase Arreglo
	private Arreglo a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa frame = new Programa();
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
	public Programa() {
		setFont(new Font("Arial", Font.PLAIN, 10));
		setTitle("Programa: Repaso de Arreglos Unidimensionales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnListar = new JButton("Listar");
		btnListar.setBounds(70, 15, 94, 23);
		btnListar.addActionListener(this);
		contentPane.add(btnListar);

		btnReportar = new JButton("Reportar");
		btnReportar.setBounds(170, 15, 94, 23);
		btnReportar.addActionListener(this);
		contentPane.add(btnReportar);

		btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(270, 15, 94, 23);
		btnGenerar.addActionListener(this);
		contentPane.add(btnGenerar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 893, 400);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 11));
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
		if (arg0.getSource() == btnReportar) {
			actionPerformedBtnReportar(arg0);
		}
		if (arg0.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(arg0);
		}
	}

	protected void actionPerformedBtnListar(ActionEvent arg0) {
		/*
		 * Visualiza los números del arreglo
		 */
		txtS.setText("");
		// Se crea un arreglo de 15 posiciones
		a = new Arreglo(15);
		// Se generan los números aleatorios (de dos cifras)
		a.generar();

		// Metodos de impresion
		imprimircabecera();
		listar();
	}

	protected void actionPerformedBtnReportar(ActionEvent arg0) {
		/*
		 * Muestra un análisis del arreglo
		 */
		txtS.setText("");

		imprimircabecera();
		listar();
		reportarBusquedas();
		ejecutarReemplazos();
		ejecutarIntercambios();
	}

	private void ejecutarIntercambios() {
		imprimir("\n\n***** INTERCAMBIOD *****");
		imprimircabecera();
		listar();
		imprimir("\n14. El segundo número impar por el menor número par");
		a.intercambio2();
		listar();
		
		imprimir("\n15. El primer número par por el último número cuyo dígito sea cinco (5)");
		a.intercambio2();
		listar();
		
	}

	private void ejecutarReemplazos() {
		imprimir("\n\n***** REEMPLAZOS *****");
		imprimircabecera();
		listar();
		imprimir("\n12. El cuarto número par por la suma de todos los números");
		a.reemplazo1();
		listar();
		
		imprimir("\n13. El menor número impar por el producto de sus dígitos");
		a.reemplazo2();
		listar();
	}

	private void reportarBusquedas() {
		imprimir("\n\n***** REPORTE DE BUSQUEDAS *****");
		
		imprimir("01. Menor número del arreglo \t\t: " + a.menor());
		imprimir("02. Mayor número del arreglo \t\t: " + a.mayor());
		imprimir("03. Primer número múltiplo de 5\t\t: " + a.primerMultiploDe5());
		imprimir("04. Segundo número que es impar\t\t: " + a.segundoImpar());
		imprimir("05. Penúltimo número que es par\t\t: " + a.penultimoPar());
		imprimir("06. Mayor número que es impar\t\t: " + a.mayorImpar());
		imprimir("07. Tercer número que es par\t\t: " + a.tercerPar());
		imprimir("08. Menor número en posición impar\t: " + a.menorEnPosicionImpar());
		imprimir("09. Mayor número en posición par\t: " + a.mayorEnPosicionPar());
		imprimir("10. Primer número con suma dígitos >= 8\t: " + a.primerNumeroSumaDigitosMayorOIgualA8());
		imprimir("11. Antepenultimo, comienza con dos (2)\t: " + a.antepenultimoComienzaCon2());
	}

	protected void actionPerformedBtnGenerar(ActionEvent arg0) {
		/*
		 * Remplaza los números por otros aleatorios de tres cifras
		 */
		txtS.setText("");
		a.generar(10,999);
		imprimircabecera();
		listar();
	}

	// Métodos tipo void (sin parámetros)
	void imprimircabecera() {
		/*
		 * Imprime una cabecera
		 */
		if (a != null) {
			for (int i = 0; i < a.longitud(); i++) {
				txtS.append("n[" + i + "]");
				if(i < a.longitud()-1)
					txtS.append("\t");
			}
		}
		txtS.append("\n---------------------------------------------------------------------------------------------------------------------\n");
	}

	// Métodos tipo void (sin parámetros)
	void listar() {
		/*
		 * Visualiza los números del arreglo
		 */
		if(a != null){
			for (int i = 0; i < a.longitud(); i++) {
				txtS.append("" + a.obtener(i));
				if(i < a.longitud() - 1)
					txtS.append("\t");
			}
		}

	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

}
