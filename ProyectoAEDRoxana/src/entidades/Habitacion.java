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
		case 1:
			return "Simple";
		case 2:
			return "Doble";
		case 3:
			return "Matrimonial";
		case 4:
			return "Suite Junior";
		case 5:
			return "Matrimonial";
		default:
			return "";
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
		case 4:
			return "5to Piso";
		case 5:
			return "6to Piso";
		default:
			return "7mo Piso";
		}	
	}
}
