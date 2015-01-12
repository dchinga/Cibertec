package controladores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import entidades.Recepcionista;

/**
 * Clase que representa un recepcionista
 * 
 * @author Roxana Ram�rez
 */
public class ControladorRecepcionista {

	private String nombreArchivo = "recepcionistas.txt";

	private ArrayList<Recepcionista> recepcionistas;

	/**
	 * Constructor
	 */
	public ControladorRecepcionista() {
		recepcionistas = new ArrayList<Recepcionista>();
		cargar();
	}

	/**
	 * Adiciona un recepcionista a la colecci�n
	 * 
	 * @param x
	 *            recepcionista
	 */
	public void adicionar(Recepcionista x) {
		recepcionistas.add(x);
	}

	/**
	 * Modifica un recepcionista de la colecci�n
	 * 
	 * @param x
	 *            recepcionista
	 */
	public void modificar(Recepcionista x) {
		for (int i = 0; i < tama�o(); i++) {
			Recepcionista x2 = obtener(i);
			if (x.getCodigo() == x2.getCodigo())
				recepcionistas.set(i, x);
		}
	}

	/**
	 * Elimina un recepcionista de la colecci�n
	 * 
	 * @param x
	 *            recepcionista
	 */
	public void eliminar(Recepcionista x) {
		recepcionistas.remove(x);
	}

	/**
	 * Obtiene un recepcionista por su posici�n en la colecci�n
	 * 
	 * @param pos
	 *            posici�n a buscar
	 * @return recepcionista encontrado
	 */
	public Recepcionista obtener(int pos) {
		return recepcionistas.get(pos);
	}

	/**
	 * Tama�o de la colecci�n
	 * 
	 * @return tama�o
	 */
	public int tama�o() {
		return recepcionistas.size();
	}

	/**
	 * Busca un recepcionista por su c�digo
	 * 
	 * @param codigo
	 *            c�digo de recepcionista
	 * @return recepcionista. De no encontrarse, se devuelve null
	 */
	public Recepcionista buscar(int codigo) {
		for (Recepcionista h : recepcionistas)
			if (h.getCodigo() == codigo)
				return h;
		return null;
	}

	/**
	 * Genera el c�digo correlativo para un nuevo recepcionista
	 * 
	 * @return c�digo generado
	 */
	public int generarCodigo() {
		if (tama�o() == 0)
			return 1;
		else
			return recepcionistas.get(tama�o() - 1).getCodigo() + 1;
	}

	/**
	 * Graba la colecci�n a un archivo de texto
	 */
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this.nombreArchivo));
			String linea = "";

			for (Recepcionista x : recepcionistas) {
				linea = x.getCodigo() + ";" + x.getApellido() + ";"
						+ x.getNombre() + ";" + x.getTelefono() + ";"
						+ x.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			mensaje("Error : " + e);
		}
	}

	/**
	 * Carga los recepcionistas del archivo a la colecci�n
	 */
	public void cargar() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					this.nombreArchivo));
			String linea, apellido, nombre, telefono;
			int codigo, estado;
			StringTokenizer st;

			while ((linea = br.readLine()) != null) {
				st = new StringTokenizer(linea, ";");

				codigo = Integer.parseInt(st.nextToken().trim());
				apellido = st.nextToken().trim();
				nombre = st.nextToken().trim();
				telefono = st.nextToken().trim();
				estado = Integer.parseInt(st.nextToken().trim());

				Recepcionista x = new Recepcionista(codigo, apellido, nombre,
						telefono, estado);
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