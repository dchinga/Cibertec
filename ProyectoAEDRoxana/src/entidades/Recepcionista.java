package entidades;

public class Recepcionista {
	public int codigo;
	public int estado;
	public String apellido;
	public String nombre;
	public String telefono;

	public Recepcionista(int codigo, String apellido, String nombre, String telefono, int estado) {
		this.codigo = codigo;
		this.estado = estado;
		this.apellido = apellido;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getEstado() {
		return estado;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}