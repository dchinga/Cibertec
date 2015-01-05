package controladores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import entidades.Cliente;

/**
 * Clase que representa un cliente
 * 
 * @author Roxana Ramírez
 */
public class ControladorCliente {

	private String nombreArchivo = "clientes.txt";

	private ArrayList<Cliente> clientes;

	/**
	 * Constructor
	 */
	public ControladorCliente() {
		clientes = new ArrayList<Cliente>();
		cargar();
	}

	/**
	 * Adiciona un cliente a la colección
	 * 
	 * @param x
	 *            cliente
	 */
	public void adicionar(Cliente x) {
		clientes.add(x);
	}

	/**
	 * Modifica un cliente de la colección
	 * 
	 * @param e
	 *            cliente
	 */
	public void modificar(Cliente x) {
		for (int i = 0; i < tamaño(); i++) {
			Cliente x2 = obtener(i);
			if (x.getCodigo() == x2.getCodigo())
				clientes.set(i, x);
		}
	}

	/**
	 * Elimina un cliente de la colección
	 * 
	 * @param x
	 *            cliente
	 */
	public void eliminar(Cliente x) {
		clientes.remove(x);
	}

	/**
	 * Obtiene un cliente por su posición en la colección
	 * 
	 * @param pos
	 *            posición a buscar
	 * @return cliente encontrado
	 */
	public Cliente obtener(int pos) {
		return clientes.get(pos);
	}

	/**
	 * Tamaño de la colección
	 * 
	 * @return tamaño
	 */
	public int tamaño() {
		return clientes.size();
	}

	/**
	 * Busca un cliente por su código
	 * 
	 * @param numero
	 *            código de cliente
	 * @return cliente. De no encontrarse, se devuelve null
	 */
	public Cliente buscar(int codigo) {
		for (Cliente h : clientes)
			if (h.getCodigo() == codigo)
				return h;
		return null;
	}

	/**
	 * Genera el código correlativo para un nuevo cliente
	 * 
	 * @return código generado
	 */
	public int generarCodigo() {
		if (tamaño() == 0)
			return 1;
		else
			return clientes.get(tamaño() - 1).getCodigo() + 1;
	}

	/**
	 * Graba la colección a un archivo de texto
	 */
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this.nombreArchivo));
			String linea = "";

			for (Cliente x : clientes) {
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
	 * Carga los clientes del archivo a la colección
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

				Cliente x = new Cliente(codigo, apellido, nombre, telefono,
						estado);
				adicionar(x);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
