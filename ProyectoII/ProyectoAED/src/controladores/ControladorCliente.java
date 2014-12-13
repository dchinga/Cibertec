package controladores;

import java.util.ArrayList;

import entidades.Cliente;

public class ControladorCliente {
	private ArrayList<Cliente> clientes;

	public ControladorCliente() {
		clientes = new ArrayList<Cliente>();
	}

	public void adicionar(Cliente c) {
		clientes.add(c);
	}

	public void modificar(Cliente e) {
		for (int i = 0; i < tamaño(); i++) {
			Cliente e2 = obtener(i);
			if (e.getCodigo() == e2.getCodigo())
				clientes.set(i, e);
		}
	}

	public void eliminar(Cliente c) {
		clientes.remove(c);
	}

	public Cliente obtener(int posicion) {
		return clientes.get(posicion);
	}

	public int tamaño() {
		return clientes.size();
	}

	public Cliente buscar(int codigo) {
		for (Cliente c : clientes)
			if (c.getCodigo() == codigo)
				return c;
		return null;
	}

	public int generarCodigo() {
		if (tamaño() == 0)
			return 1;
		else
			return clientes.get(tamaño() - 1).getCodigo() + 1;
	}
}
