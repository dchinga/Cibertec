package entidades;

public class Producto {
	private int codigo;
	private String nombre;
	private double precio;
	private int horas;
	public Producto(int codigo, String nombre, double precio, int horas) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.horas = horas;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	
}
