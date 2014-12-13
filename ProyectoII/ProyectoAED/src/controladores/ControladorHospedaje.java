package controladores;

import java.util.ArrayList;

import entidades.Hospedaje;

public class ControladorHospedaje {
	private ArrayList<Hospedaje> hospedajes;

	public ControladorHospedaje() {
		hospedajes = new ArrayList<Hospedaje>();
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

	public int tama�o() {
		return hospedajes.size();
	}

	public Hospedaje buscar(int codigo) {
		for (Hospedaje h : hospedajes)
			if (h.getCodigo() == codigo)
				return h;
		return null;
	}

	public int generarCodigo() {
		if (tama�o() == 0)
			return 1;
		else
			return hospedajes.get(tama�o() - 1).getCodigo() + 1;
	}
}
