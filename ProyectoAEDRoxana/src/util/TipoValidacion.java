package util;

public enum TipoValidacion {

	NUMERO("Numero", 1),
	CAOBA("Marrón oscuro", 770), 
	NOGAL("Marrón rojizo", 820), 
	CEREZO("Marrón cereza", 790), 
	BOJ("Marrón negruzco", 675); 

	// Campos tipo constante
	private final String color; // Color de la madera
	private final int pesoEspecifico; // Peso específico de la madera

	/**
	 * Constructor. Al asignarle uno de los valores posibles a una variable del
	 * tipo enumerado el constructor asigna automáticamente valores de los
	 * campos
	 */
	TipoValidacion(String color, int pesoEspecifico) {
		this.color = color;
		this.pesoEspecifico = pesoEspecifico;
	} // Cierre del constructor

	// Métodos de la clase tipo Enum
	public String getColor() {
		return color;
	}

	public int getPesoEspecifico() {
		return pesoEspecifico;
	}
}
