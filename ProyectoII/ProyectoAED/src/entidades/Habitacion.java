package entidades;

public class Habitacion {
	public int numero;
	public String descripcion;
	public int tipo;
	public int ubicacion;
	public double costo;
	
	public Habitacion(int numero, String descripcion, int tipo, int ubicacion, double costo) {
		this.numero = numero;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		this.costo = costo;
	}

	public int getNumero() {
		return numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getTipo() {
		return tipo;
	}

	public int getUbicacion() {
		return ubicacion;
	}

	public double getCosto() {
		return costo;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	// Metodos para obtener los nombres
	public String getNombreTipo(){
		switch (this.tipo) {
		case 0:
			return "Simple";
		case 1:
			return "Doble";
		case 2:
			return "Triple";
		default:
			return "Matrimonial";
		}
	}
	
	public String getNombreUbicacion(){
		switch (this.ubicacion) {
		case 0:
			return "1er Piso";
		case 1:
			return "2do Piso";
		case 2:
			return "3er Piso";
		case 3:
			return "4to Piso";
		default:
			return "5to Piso";
		}	
	}
}
