package controladores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import entidades.Habitacion;
import entidades.Reserva;
public class ControladorReserva {
	
	private String nombreArchivo = "reservas.txt";
	
	private ArrayList<Reserva> reservas;

	public ControladorReserva() {
		reservas = new ArrayList<Reserva>();
		cargar();
	}

	public void adicionar(Reserva r) {
		reservas.add(r);
	}

	public void eliminar(Reserva r) {
		reservas.remove(r);
	}

	public Reserva obtener(int posicion) {
		return reservas.get(posicion);
	}

	public void modificar(Reserva e) {
		for (int i = 0; i < tamaño(); i++) {
			Reserva e2 = obtener(i);
			if (e.getCodigo() == e2.getCodigo())
				reservas.set(i, e);
		}
	}
	public int tamaño() {
		return reservas.size();
	}

	public Reserva buscar(int codigo) {
		for (Reserva r : reservas)
			if (r.getCodigo() == codigo)
				return r;
		return null;
	}


	
	public int generarNumero() {
		if (tamaño() == 0)
			return 1;
		else
			return reservas.get(tamaño() - 1).getCodigo() + 1;
	}
	
	
	public void grabar() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(this.nombreArchivo));
			String linea = "";

			for (Reserva  x : reservas) {
				linea = x.getCodigo() + ";" + x.getCodigoCliente() + ";"
						+ x.getCodigoRecepcionista() + ";" + x.getNumeroHabitacion() + ";"
						+ x.getFechaRegistro()+";"+x.getFechaIngreso()+";"+x.getFechaSalida()+";"
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
			String fecIn,fecReg,fecSalida;
			int numero, codCli, codRecep,numHabi,estado;
			
			StringTokenizer st;

			while ((linea = br.readLine()) != null) {
				st = new StringTokenizer(linea, ";");
				numero= Integer.parseInt(st.nextToken().trim());
				codCli = Integer.parseInt(st.nextToken().trim());
				codRecep= Integer.parseInt(st.nextToken().trim());
				numHabi= Integer.parseInt(st.nextToken().trim());
				fecIn=st.nextToken().trim();
				fecReg= st.nextToken().trim();
				fecSalida=st.nextToken().trim();
				estado = Integer.parseInt(st.nextToken().trim());
				Reserva x = new Reserva(numero, codCli, codRecep, numHabi,
						fecReg,fecIn,fecSalida,estado);
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
