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
 * Clase que representa una habitaci�n
 * 
 * @author Roxana Ram�rez
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
	 * Adiciona una habitaci�n a la colecci�n
	 * 
	 * @param x
	 *            habitaci�n
	 */
	public void adicionar(Habitacion x) {
		habitaciones.add(x);
	}

	/**
	 * Modifica una habitaci�n de la colecci�n
	 * 
	 * @param x
	 *            habitaci�n
	 */
	public void modificar(Habitacion x) {
		for (int i = 0; i < tama�o(); i++) {
			Habitacion x2 = obtener(i);
			if (x.getNumero() == x2.getNumero())
				habitaciones.set(i, x);
		}
	}

	/**
	 * Elimina una habitaci�n de la colecci�n
	 * 
	 * @param x
	 *            habitaci�n
	 */
	public void eliminar(Habitacion x) {
		habitaciones.remove(x);
	}

	/**
	 * Obtiene una habitaci�n por su posici�n en la colecci�n
	 * 
	 * @param pos
	 *            posici�n a buscar
	 * @return habitaci�n encontrada
	 */
	public Habitacion obtener(int pos) {
		return habitaciones.get(pos);
	}

	/**
	 * Tama�o de la colecci�n
	 * 
	 * @return tama�o
	 */
	public int tama�o() {
		return habitaciones.size();
	}

	/**
	 * Busca una habitaci�n por su n�mero
	 * 
	 * @param numero
	 *            numero de habitaci�n
	 * @return habitaci�n. De no encontrarse, se devuelve null
	 */
	public Habitacion buscar(int numero) {
		for (Habitacion h : habitaciones)
			if (h.getNumero() == numero)
				return h;
		return null;
	}

	/**
	 * Genera el n�mero correlativo para una nueva habitaci�n
	 * 
	 * @return n�mero generado
	 */
	public int generarNumero() {
		if (tama�o() == 0)
			return 1;
		else
			return habitaciones.get(tama�o() - 1).getNumero() + 1;
	}

	/**
	 * Graba la colecci�n a un archivo de texto
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
	 * Carga las habitaciones del archivo a la colecci�n
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
