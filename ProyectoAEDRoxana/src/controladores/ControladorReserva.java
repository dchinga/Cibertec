package controladores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import entidades.Reserva;

/**
 * Clase que representa una reserva
 * 
 * @author Roxana Ramírez
 */
public class ControladorReserva {

	private String nombreArchivo = "reservas.txt";

	private ArrayList<Reserva> reservas;

	/**
	 * Constructor
	 */
	public ControladorReserva() {
		reservas = new ArrayList<Reserva>();
		cargar();
	}

	/**
	 * Adiciona una reserva a la colección
	 * 
	 * @param x
	 *            reserva
	 */
	public void adicionar(Reserva x) {
		reservas.add(x);
	}

	/**
	 * Modifica una reserva de la colección
	 * 
	 * @param x
	 *            reserva
	 */
	public void modificar(Reserva x) {
		for (int i = 0; i < tamaño(); i++) {
			Reserva x2 = obtener(i);
			if (x.getCodigo() == x2.getCodigo())
				reservas.set(i, x);
		}
	}

	/**
	 * Elimina una reserva de la colección
	 * 
	 * @param x
	 *            reserva
	 */
	public void eliminar(Reserva x) {
		reservas.remove(x);
	}

	/**
	 * Obtiene una reserva por su posición en la colección
	 * 
	 * @param pos
	 *            posición a buscar
	 * @return reserva encontrado
	 */
	public Reserva obtener(int pos) {
		return reservas.get(pos);
	}

	/**
	 * Tamaño de la colección
	 * 
	 * @return tamaño
	 */
	public int tamaño() {
		return reservas.size();
	}

	/**
	 * Busca una reserva por su código
	 * 
	 * @param codigo
	 *            código de reserva
	 * @return reserva. De no encontrarse, se devuelve null
	 */
	public Reserva buscar(int codigo) {
		for (Reserva h : reservas)
			if (h.getCodigo() == codigo)
				return h;
		return null;
	}

	/**
	 * Genera el código correlativo para una nueva reserva
	 * 
	 * @return código generado
	 */
	public int generarCodigo() {
		if (tamaño() == 0)
			return 1;
		else
			return reservas.get(tamaño() - 1).getCodigo() + 1;
	}

	/**
	 * Graba la colección a un archivo de texto
	 */
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this.nombreArchivo));
			String linea = "";

			for (Reserva x : reservas) {
				linea = x.getCodigo() + ";" + x.getCodigoCliente() + ";"
						+ x.getCodigoRecepcionista() + ";"
						+ x.getNumeroHabitacion() + ";" + x.getFechaRegistro()
						+ ";" + x.getFechaIngreso() + ";" + x.getFechaSalida()
						+ ";" + x.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			mensaje("Error : " + e);
		}
	}

	/**
	 * Carga las reservas del archivo a la colección
	 */
	public void cargar() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					this.nombreArchivo));
			String linea, fechaRegistro, fechaIngreso, fechaSalida;
			int codigo, codigoCliente, codigoRecepcionista, numeroHabitacion, estado;
			StringTokenizer st;

			while ((linea = br.readLine()) != null) {
				st = new StringTokenizer(linea, ";");

				codigo = Integer.parseInt(st.nextToken().trim());
				codigoCliente = Integer.parseInt(st.nextToken().trim());
				codigoRecepcionista = Integer.parseInt(st.nextToken().trim());
				numeroHabitacion = Integer.parseInt(st.nextToken().trim());
				fechaRegistro = st.nextToken().trim();
				fechaIngreso = st.nextToken().trim();
				fechaSalida = st.nextToken().trim();
				estado = Integer.parseInt(st.nextToken().trim());

				Reserva x = new Reserva(codigo, codigoCliente,
						codigoRecepcionista, numeroHabitacion, fechaRegistro,
						fechaIngreso, fechaSalida, estado);
				adicionar(x);
			}
			br.close();
		} catch (Exception e) {
			mensaje("Error : " + e);
		}
	}

	/**
	 * Muestra un mensaje
	 * 
	 * @param s
	 *            mensaje a mostrar
	 */
	private void mensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
}