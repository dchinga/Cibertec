package controladores;

import java.util.ArrayList;

import entidades.Reserva;

public class ControladorReserva {
	private ArrayList<Reserva> reservas;

	public ControladorReserva() {
		reservas = new ArrayList<Reserva>();
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

	public int tama�o() {
		return reservas.size();
	}

	public Reserva buscar(int codigo) {
		for (Reserva r : reservas)
			if (r.getCodigo() == codigo)
				return r;
		return null;
	}

	public int generarCodigo() {
		if (tama�o() == 0)
			return 1;
		else
			return reservas.get(tama�o() - 1).getCodigo() + 1;
	}
}
