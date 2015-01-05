package controladores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import entidades.Habitacion;

public class ControladorHabitacion {
	private String nombreArchivo = "habitaciones.txt";

	private ArrayList<Habitacion> habitaciones;

	public ControladorHabitacion() {
		habitaciones = new ArrayList<Habitacion>();
		cargar();
	}

	public void adicionar(Habitacion x) {
		habitaciones.add(x);
	}

	public void modificar(Habitacion e) {
		for (int i = 0; i < tamaño(); i++) {
			Habitacion e2 = obtener(i);
			if (e.getNumero() == e2.getNumero())
				habitaciones.set(i, e);
		}
	}

	public void eliminar(Habitacion x) {
		habitaciones.remove(x);
	}

	public Habitacion obtener(int pos) {
		return habitaciones.get(pos);
	}

	public int tamaño() {
		return habitaciones.size();
	}

	public Habitacion buscar(int numero) {
		for (Habitacion h : habitaciones)
			if (h.getNumero() == numero)
				return h;
		return null;
	}

	public int generarNumero() {
		if (tamaño() == 0)
			return 1;
		else
			return habitaciones.get(tamaño() - 1).getNumero() + 1;
	}

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
				numero= Integer.parseInt(st.nextToken().trim());
				descripcion = st.nextToken().trim();
				tipo= Integer.parseInt(st.nextToken().trim());
				ubicacion= Integer.parseInt(st.nextToken().trim());
				costo = Double.parseDouble(st.nextToken().trim());
				Habitacion x = new Habitacion(numero, descripcion, tipo, ubicacion, costo);
				adicionar(x);
			}
			br.close();
		} catch (Exception e) {
			mensaje("Error : " + e);
		}
	}
	

	private void mensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
}
