package entidades;

public class Reserva {
	private int codigo;
	private int codigoCliente;
	private int codigoRecepcionista;
	private int numeroHabitacion;
	private String fechaRegistro;
	private String fechaIngreso;
	private String fechaSalida;
	private int estado;

	public Reserva(int codigo, int codigoCliente, int codigoRecepcionista,
			int numeroHabitacion, String fechaRegistro, String fechaIngreso,
			String fechaSalida, int estado) {
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

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoRecepcionista() {
		return codigoRecepcionista;
	}

	public void setCodigoRecepcionista(int codigoRecepcionista) {
		this.codigoRecepcionista = codigoRecepcionista;
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}