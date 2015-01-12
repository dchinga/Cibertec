package controladores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import entidades.Habitacion;

/**
 * Clase que representa una habitación
 * 
 * @author Roxana Ramírez
 */
public class ControladorHabitacion {

	private String nombreArchivo = "habitaciones.txt";

	private ArrayList<Habitacion> habitaciones;

	/**
	 * Constructor
	 */
	public ControladorHabitacion() {
		habitaciones = new ArrayList<Habitacion>();
		cargar();
	}

	/**
	 * Adiciona una habitación a la colección
	 * 
	 * @param x
	 *            habitación
	 */
	public void adicionar(Habitacion x) {
		habitaciones.add(x);
	}

	/**
	 * Modifica una habitación de la colección
	 * 
	 * @param x
	 *            habitación
	 */
	public void modificar(Habitacion x) {
		for (int i = 0; i < tamaño(); i++) {
			Habitacion x2 = obtener(i);
			if (x.getNumero() == x2.getNumero())
				habitaciones.set(i, x);
		}
	}

	/**
	 * Elimina una habitación de la colección
	 * 
	 * @param x
	 *            habitación
	 */
	public void eliminar(Habitacion x) {
		habitaciones.remove(x);
	}

	/**
	 * Obtiene una habitación por su posición en la colección
	 * 
	 * @param pos
	 *            posición a buscar
	 * @return habitación encontrada
	 */
	public Habitacion obtener(int pos) {
		return habitaciones.get(pos);
	}

	/**
	 * Tamaño de la colección
	 * 
	 * @return tamaño
	 */
	public int tamaño() {
		return habitaciones.size();
	}

	/**
	 * Busca una habitación por su número
	 * 
	 * @param numero
	 *            numero de habitación
	 * @return habitación. De no encontrarse, se devuelve null
	 */
	public Habitacion buscar(int numero) {
		for (Habitacion h : habitaciones)
			if (h.getNumero() == numero)
				return h;
		return null;
	}

	/**
	 * Genera el número correlativo para una nueva habitación
	 * 
	 * @return número generado
	 */
	public int generarNumero() {
		if (tamaño() == 0)
			return 1;
		else
			return habitaciones.get(tamaño() - 1).getNumero() + 1;
	}

	/**
	 * Graba la colección a un archivo de texto
	 */
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this.nombreArchivo));
			String linea = "";

			for (Habitacion x : habitaciones) {
				linea = x.getNumero() + ";" + x.getDescripcion() + ";"
						+ x.getTipo() + ";" + x.getUbicacion() + ";"
						+ x.getCosto();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			mensaje("Error : " + e);
		}
	}

	/**
	 * Carga las habitaciones del archivo a la colección
	 */
	public void cargar() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					this.nombreArchivo));
			String linea, descripcion;
			int numero, tipo, ubicacion;
			double costo;
			StringTokenizer st;

			while ((linea = br.readLine()) != null) {
				st = new StringTokenizer(linea, ";");

				numero = Integer.parseInt(st.nextToken().trim());
				descripcion = st.nextToken().trim();
				tipo = Integer.parseInt(st.nextToken().trim());
				ubicacion = Integer.parseInt(st.nextToken().trim());
				costo = Double.parseDouble(st.nextToken().trim());

				Habitacion x = new Habitacion(numero, descripcion, tipo,
						ubicacion, costo);
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
