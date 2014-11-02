package clases;

import javax.swing.JOptionPane;

//1.	Implemente la clase Arreglo en el paquete clases
public class Arreglo {

	// con el atributo privado: arreglo lineal n de tipo int sin valores
	// iniciales.
	private int[] n = null;

	// Constructor sin parámetros
	public Arreglo() {
		// reserve 10 posiciones para la capacidad máxima del arreglo n.
		this.n = new int[10];
	}

	// Constructor que reciba el parámetro capacidad del tipo int
	public Arreglo(int capacidad) {
		// Reserve como capacidad máxima del arreglo n, lo indicado por el
		// parámetro
		this.n = new int[capacidad];
	}

	// métodos get y set para el arreglo n
	public int[] getN() {
		return n;
	}

	public void setN(int[] n) {
		this.n = n;
	}

	// método longitud que retorne la capacidad máxima del arreglo n.
	public int longitud() {
		// Verificar si el arreglo es diferente de nulo
		if (n != null) {
			return n.length;
		} else {
			return -1;
		}
	}

	// el método obtener el cual recibe una posición (int) y retorna el valor
	// del elemento que ocupa dicha posición.
	public int obtener(int posicion) {
		if (n != null) {
			// Se verifica si la posicion es mayor o igual a cero y menor que la
			// longitud del arreglo
			if (posicion >= 0 && posicion < longitud())
				return n[posicion];
			else
				return -1;
		} else {
			return -1;
		}
	}

	// generar que reciba los parámetros min (int) y max (int) y que permita
	// reemplazar / asignar los elementos del arreglo
	public void generar(int min, int max) {
		for (int i = 0; i < longitud(); i++) {
			n[i] = aleatorio(min, max);
		}
	}

	// sobre carga del método generar que permita reemplazar / asignar los
	// elementos del arreglo n por otros números aleatorios de dos cifras (10 –
	// 99)
	public void generar() {
		generar(10, 99);
	}

	private int aleatorio(int min, int max) {
		return (int) ((max - min + 1) * Math.random()) + min;
	}

	/* METODOS DE BUSQUEDA */

	// 9. El menor número
	public int menor() {
		// Verificar si el arreglo es diferente de nulo
		if (n != null) {
			// Se verifica si el arreglo tiene al menos un elemento para
			// asignarlo como menor
			if (longitud() >= 1) {
				int menor = n[0];
				// El arreglo se recorre a partir de la siguiente posicion
				for (int i = 1; i < longitud(); i++) {
					// Si la posicion actual n[i] es menor, se asigna
					if (n[i] < menor)
						menor = n[i];
				}
				return menor;
			} else
				return -1;
		} else
			return -1;
	}

	// 10. El mayor número
	public int mayor() {
		if (n != null) {
			if (longitud() >= 1) {
				int mayor = n[0];
				// se recorre a partir de la siguiente posicion
				for (int i = 1; i < longitud(); i++) {
					if (n[i] > mayor)
						mayor = n[i];
				}
				return mayor;
			} else
				return -1;
		} else
			return -1;
	}

	// 11. El primer número múltiplo de cinco
	public int primerMultiploDe5() {
		if (n != null) {
			// Se recorre todo el arreglo
			for (int i = 0; i < longitud(); i++) {
				// se verifica si es multiplo de cinco
				// nos piden el primero
				if (n[i] % 5 == 0)
					return n[i];
			}
			// Si despues del recorrido no se encuentra, se retorna -1
			return -1;
		} else
			return -1;
	}

	// 12. El segundo número impar
	public int segundoImpar() {
		if (n != null) {
			// variable para contar cuantos impares se van hayando
			int contador = 0;
			// se recorre todo el arreglo
			for (int i = 0; i < longitud(); i++) {
				// se verifica si es impar
				if (n[i] % 2 != 0) {
					// se incrementa el contador
					contador++;
					// Si es el segundo encontrado, se retorna el elemento
					if (contador == 2)
						return n[i];
				}
			}
			// Si despues del recorrido no se encuentra un segundo impar, se
			// retorna -1
			return -1;
		} else
			return -1;
	}

	// 13. El penúltimo número par
	public int penultimoPar() {
		if (n != null) {
			int contador = 0;
			// Si se recorre de DERECHA a IZQUIERDA, el segundo vendria a ser el
			// penultimo de todo el arreglo
			for (int i = longitud() - 1; i >= 0; i--) {
				// se verifica si es par
				if (n[i] % 2 == 0) {
					// se incrementa el contador
					contador++;
					if (contador == 2)
						return n[i];
				}
			}
			// si luego del recorrido no se encuentra, se retorna -1
			return -1;
		} else
			return -1;
	}

	// 14. El mayor número impar.
	public int mayorImpar() {
		if (n != null) {
			if (longitud() >= 1) {
				int mayorImpar = -1;
				for (int i = 0; i < longitud(); i++) {
					if (n[i] % 2 != 00 && n[i] > mayorImpar)
						mayorImpar = n[i];
				}
				return mayorImpar;
			} else
				return -1;
		} else
			return -1;
	}

	// 15. El tercer número par.
	public int tercerPar() {
		if (n != null) {
			int contador = 0;
			for (int i = 0; i < longitud(); i++) {
				if (n[i] % 2 == 0) {
					contador++;
					if (contador == 3)
						return n[i];
				}
			}
			// si no se encuentra...
			return -1;
		} else
			return -1;
	}

	// 16. El menor número ubicado en alguna de las posiciones impares.
	public int menorEnPosicionImpar() {
		if (n != null) {
			if (longitud() >= 2) {
				// Minimo dos: Posicion cero y posicion uno (este ultimo es
				// impar)
				// se asigna el primer impar como menor
				int menorPosImpar = n[1];
				// se recorre desde la siguiente posicion impar = 3
				// se verifica primero si hay 4 elementos en el arreglo
				if (longitud() >= 4) {
					for (int i = 3; i < longitud(); i += 2) {
						if (n[i] < menorPosImpar)
							menorPosImpar = n[i];
					}
				}
				return menorPosImpar;
			} else
				return -1;
		} else
			return -1;
	}

	// 17. El mayor número ubicado en alguna de las posiciones pares, incluyendo
	// la posición cero
	public int mayorEnPosicionPar() {
		if (n != null) {
			if (longitud() >= 1) {
				// se asigna el mayor a la posicion cero
				int mayorPosPar = n[0];
				if (longitud() >= 3) {
					for (int i = 2; i < longitud(); i += 2) {
						if (n[i] > mayorPosPar)
							mayorPosPar = n[i];
					}
				}
				return mayorPosPar;
			} else
				return -1;
		} else
			return -1;
	}

	// 18. El primer número cuya suma de sus dígitos sea mayor o igual a ocho
	// (8)
	public int primerNumeroSumaDigitosMayorOIgualA8() {
		if (n != null) {
			if (longitud() >= 1) {
				// variable suma y q
				int suma = 0, q = 0;
				// Para obtener los digitos de un numero, se usara el metodo de
				// divisiones sucesivas por 10.
				// El residuo vendría a ser cada dígito.

				// Se recorre el arreglo en su totalidad
				for (int i = 0; i < longitud(); i++) {
					suma = 0;
					q = n[i]; // a fin de no modificar el valor del elemento del
								// arreglo

					// Se obtienen los digitos y la suma hasta que la division
					// sucesiva de un cociente mayor a cero
					while (q > 0) {
						suma += q % 10; // se suma el digito (residuo)
						q = q / 10; // Se asigna el nuevo cociente para seguir
									// dividiendo
					}
					// se verifica si la suma de digitos es mayor o igual a 8.
					if (suma >= 8) {
						return n[i];
					}
				}
				// si no se encuentra, se retorna -1
				return -1;
			} else
				return -1;
		} else
			return -1;
	}

	// 19. El antepenúltimo número cuyo primer dígito sea dos (2)
	public int antepenultimoComienzaCon2() {
		if (n != null) {
			if (longitud() >= 1) {
				int contador = 0;
				int q = 0;
				// Para obtener el primer dígito, se usara las divisiones
				// sucesivas hasta tener un cociente mayor o igual a diez
				// Se recorre de DERECHA a IZQUIERDA
				for (int i = longitud() - 1; i >= 0; i--) {
					q = n[i];

					// se recorre hasta que el cociente se mayor o igual a diez
					while (q >= 10) {
						q = q / 10;
					}
					// Se verifica si es igual a 2
					if (q == 2) {
						contador++;
						// se verifica si es el segundo (antepenultimo)
						if (contador == 2)
							return n[i];
					}
				}
				// Si no se encuentra se retorna -1
				return -1;
			} else
				return -1;
		} else
			return -1;
	}

	/* METODOS DE REEMPLAZO */

	// 20. El cuarto número par por la suma de todos los números
	public void reemplazo1() {
		if (n != null) {
			// Para hacer un reemplazo, se recomienda hacer lo siguiente:
			// 1. Ubicar la POSICION del elemento
			// 2. Obtener el nuevo valor que tendrá el elemento
			// 3. Verificar si existe la posición y si se obtuvo el valor. Solo
			// si cumple se efectúa el reemplazo

			// 1. Ubicar la POSICION del elemento
			int pos = -1, contador = 0;
			// Se recorre todo el arreglo
			for (int i = 0; i < longitud(); i++) {
				// Se verifica si es par y si es el cuarto
				if (n[i] % 2 == 0 && ++contador == 4)
					pos = i;
			}

			// 2. Obtener el nuevo valor que tendrá el elemento
			int suma = 0;
			for (int i = 0; i < longitud(); i++) {
				suma += n[i];
			}

			// 3. Verificar si existe la posición y si se obtuvo el valor.
			if (pos != -1 && suma != 0)
				n[pos] = suma;
			else
				JOptionPane.showMessageDialog(null,
						"Reemplazo 1: No se encontró la posición y/o el valor");
		}
	}

	// 21. El menor número impar por el producto de sus dígitos.
	public void reemplazo2() {
		if (n != null) {
			// El menor número impar
			int pos = -1, menorImpar = n[0];
			for (int i = 1; i < longitud(); i++) {
				if (n[i] % 2 != 0 && n[i] < menorImpar) {
					menorImpar = n[i];
					pos = i;
				}
			}

			// Que pasa si n[0] no era impar?
			if (menorImpar % 2 == 0)
				pos = -1;

			// el producto de sus dígitos
			int producto = 1;

			if (pos != -1) {
				int q = n[pos];
				while (q > 0) {
					producto *= q % 10; // Se multiplica el digito
					q /= 10; // nuevo cociente
				}
			}

			// verificar si existe la posicion y si se obtuvo el valor

			if (pos != -1 && producto != 0)
				n[pos] = producto;
			else
				JOptionPane.showMessageDialog(null,
						"Reemplazo 2: No se encontró la posición y/o el valor");
		}
	}

	/* METODOS DE INTERCAMBIO */

	// 22. El segundo número impar por el menor número par.
	public void intercambio1() {
		// Para hacer un intercambio se recomienda seguir los siguientes pasos:
		// 1. Ubicar la POSICION del primer elemento (pos1)
		// 2. Ubicar la POSICION del segunod elemento (pos2)
		// 3. Verificar si existen las posiciones:
		// 3.1. Almacenar en una variable auxiliar el valor del primer elemento:
		// int aux = n[pos1];
		// 3.2. Asignar el valor del 2do elemento al 1er elemento: n[pos1] =
		// n[pos2];
		// 3.3. Asignar la variable auxiliar al 2do elemento: n[pos2] = aux;

		// 1. Ubicar la POSICION del primer elemento (pos1): segundo número
		// impar
		int pos1 = -1, contador = 0;
		for (int i = 0; i < longitud(); i++) {
			if (n[i] % 2 != 0 && ++contador == 2) {
				pos1 = 1;
				break;
			}
		}

		// 2. Ubicar la POSICION del segundo elemento (pos2): menor número par
		int pos2 = -1, menorPar = n[0];
		for (int i = 1; i < longitud(); i++) {
			if (n[i] % 2 == 0 && n[i] < menorPar) {
				menorPar = n[i];
				pos2 = i;
			}
		}

		// Que pasa si n[0] NO era par
		if (menorPar % 2 != 0)
			pos2 = -1;

		// 3. Verificar si existen las posiciones:
		if (pos1 != -1 && pos2 != -1) {
			// 3.1. Almacenar en una variable auxiliar el valor del primer
			// elemento: int aux = n[pos1];
			int aux = n[pos1];
			// 3.2. Asignar el valor del 2do elemento al 1er elemento: n[pos1] =
			// n[pos2];
			n[pos1] = n[pos2];
			// 3.3. Asignar la variable auxiliar al 2do elemento: n[pos2] = aux;
			
		} else {
			JOptionPane
					.showMessageDialog(null,
							"Intercambio 1: No se encontró una o ninguna de las posiciones");
		}
	}
	
	// 23.	El primer número par por el último número cuyo último dígito sea cinco (5).
	public void intercambio2(){
		if(n != null){
			// El primer número par
			int pos1 = -1;
			for (int i = 0; i < longitud(); i++) {
				if(n[i] % 2 == 0){
					pos1 = i;
					break; // Si encontramos el primero, se termina el for
				}
			}
			
			// último número cuyo último dígito sea cinco (5)
			int pos2 = -1;
			// se recorre de DERECHA a IZQUIERDA
			for (int i = longitud() - 1; i >= 0; i--) {
				if(n[i] % 10 == 5){
					pos2 = i;
					break;
				}
			}
			
			if(pos1 != -1 && pos2 != -1){
				int aux = n[pos1];
				n[pos1] = n[pos2];
				n[pos2] = aux;
			}
			else{
				JOptionPane.showMessageDialog(null, "Intercambio 2: No se realizo el intercambio.");
			}
		}
	}

}
