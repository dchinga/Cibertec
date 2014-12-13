package controladores;

import java.util.ArrayList;

import entidades.Recepcionista;

public class ControladorRecepcionista {
	private ArrayList<Recepcionista> recepcionistas;

	public ControladorRecepcionista() {
		recepcionistas = new ArrayList<Recepcionista>();
	}

	public void adicionar(Recepcionista r) {
		recepcionistas.add(r);
	}

	public void eliminar(Recepcionista r) {
		recepcionistas.remove(r);
	}

	public Recepcionista obtener(int posicion) {
		return recepcionistas.get(posicion);
	}

	public int tamaño() {
		return recepcionistas.size();
	}

	public Recepcionista buscar(int codigo) {
		for (Recepcionista r : recepcionistas)
			if (r.getCodigo() == codigo)
				return r;
		return null;
	}

	public int generarCodigo() {
		if (tamaño() == 0)
			return 1;
		else
			return recepcionistas.get(tamaño() - 1).getCodigo() + 1;
	}
}
