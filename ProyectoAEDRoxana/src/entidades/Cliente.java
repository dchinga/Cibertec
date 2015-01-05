package entidades;

public class Cliente {
	public int codigo;
	public String apellido;
	public String nombre;
	public String telefono;
	public int estado;

	public Cliente(int codigo, String apellido, String nombre, String telefono, int estado) {
		this.codigo = codigo;
		this.apellido = apellido;
		this.nombre = nombre;
		this.telefono = telefono;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
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

	public int getEstado() {
		return estado;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public String getNombreEstado(){
		if(this.estado == 0)
			return "Activo";
		else
			return "Inactivo";
	}

}