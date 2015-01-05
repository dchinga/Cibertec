package entidades;

public class Reserva {
	public int codigo;
	public int codigoCliente;
	public int codigoRecepcionista;
	public int numeroHabitacion;
	public String fechaRegistro;
	public String fechaIngreso;
	public String fechaSalida;
	public int estado;

	public Reserva(int codigo, int codigoCliente, int codigoRecepcionista, int numeroHabitacion, 
			String fechaRegistro,
			String fechaIngreso, String fechaSalida, int estado) {
		this.codigo = codigo;
		this.codigoCliente = codigoCliente;
		this.codigoRecepcionista = codigoRecepcionista;
		this.numeroHabitacion = numeroHabitacion;
		this.fechaRegistro = fechaRegistro;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public int getCodigoRecepcionista() {
		return codigoRecepcionista;
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public int getEstado() {
		return estado;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public void setCodigoRecepcionista(int codigoRecepcionista) {
		this.codigoRecepcionista = codigoRecepcionista;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}