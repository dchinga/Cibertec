package entidades;

public class Hospedaje {
	public int codigo;
	public int codigoReserva;
	public int codigoCliente;
	public int numeroHabitacion;
	public int codigoRecepcionista;
	public int tipo;
	public String fechaRegistro;
	public int estado;

	public Hospedaje(int codigo, int codigoReserva, int codigoCliente, 
			int numeroHabitacion, int codigoRecepcionista,
			int tipo, String fechaRegistro, int estado) {
		this.codigo = codigo;
		this.codigoReserva = codigoReserva;
		this.codigoCliente = codigoCliente;
		this.numeroHabitacion = numeroHabitacion;
		this.codigoRecepcionista = codigoRecepcionista;
		this.tipo = tipo;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getCodigoReserva() {
		return codigoReserva;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public int getCodigoRecepcionista() {
		return codigoRecepcionista;
	}

	public int getTipo() {
		return tipo;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public int getEstado() {
		return estado;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public void setCodigoRecepcionista(int codigoRecepcionista) {
		this.codigoRecepcionista = codigoRecepcionista;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
