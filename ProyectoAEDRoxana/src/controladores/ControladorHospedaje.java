package controladores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import entidades.Hospedaje;
import entidades.Reserva;

public class ControladorHospedaje {
	private ArrayList<Hospedaje> hospedajes;
	private String nombreArchivo = "hospedajes.txt";
	public ControladorHospedaje() {
		hospedajes = new ArrayList<Hospedaje>();
		cargar();
	}

	public void adicionar(Hospedaje h) {
		hospedajes.add(h);
	}

	public void eliminar(Hospedaje h) {
		hospedajes.remove(h);
	}

	public Hospedaje obtener(int posicion) {
		return hospedajes.get(posicion);
	}

	public int tamaño() {
		return hospedajes.size();
	}

	public Hospedaje buscar(int codigo) {
		for (Hospedaje h : hospedajes)
			if (h.getCodigo() == codigo)
				return h;
		return null;
	}

	public int generarNumero() {
		if (tamaño() == 0)
			return 1;
		else
			return hospedajes.get(tamaño() - 1).getCodigo() + 1;
	}
	
	
	
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this.nombreArchivo));
			String linea = "";

			for (Hospedaje  x : hospedajes) {
				linea = x.getCodigo() + ";"+x.getCodigoReserva() + ";"
						+ x.getCodigoCliente() + ";"+ x.getNumeroHabitacion() + ";"
						+ x.getCodigoRecepcionista() + ";" 
						+ x.getTipo()+";"
						+ x.getFechaRegistro()+";"
						+ x.getEstado();
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
			String linea;
			String fecReg;
			int numero, codCli,codRecep,codReser, tipo,numHabi,estado;
			
			StringTokenizer st;

			while ((linea = br.readLine()) != null) {
				st = new StringTokenizer(linea, ";");
				numero= Integer.parseInt(st.nextToken().trim());
				codCli = Integer.parseInt(st.nextToken().trim());
				codReser= Integer.parseInt(st.nextToken().trim());
				numHabi= Integer.parseInt(st.nextToken().trim());
				codRecep= Integer.parseInt(st.nextToken().trim());
				tipo= Integer.parseInt(st.nextToken().trim());
				fecReg= st.nextToken().trim();
			
				estado = Integer.parseInt(st.nextToken().trim());
				Hospedaje x = 
						new Hospedaje(numero, codCli, codReser, numHabi,
						codRecep,tipo,fecReg,estado);
				adicionar(x);
			}
			br.close();
		} catch (Exception e) {
			mensaje("Error : " + e);
		}
	}
	public void modificar(Hospedaje e) {
		for (int i = 0; i < tamaño(); i++) {
			Hospedaje e2 = obtener(i);
			if (e.getCodigo() == e2.getCodigo())
				hospedajes.set(i, e);
		}
	}
	
	private void mensaje(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
}
