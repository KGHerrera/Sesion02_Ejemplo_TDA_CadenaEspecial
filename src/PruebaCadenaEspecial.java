import java.util.Random;
import java.util.Scanner;

/*
 		1) Mostrar la cadena invertida por letra 
		2) y por palabras
		3) Agregar/ caracteres y/o subcadenas en posiciones especificas
		4) eliminar caracteres y/o subcadenas en posiciones especificas
		5) Mostrar cadena en formato CaMeL CaSe  especial
		6) Mostar la cadena con la primer letra de cada palabra en mayúscula
		
		7) 	

		Ejemplo real en el ITSJ:
		Agregar la letra de la carrera que le corresponda.
		Separar los alumnos de acuerdo a su carrera.
		
		19 070 001 => ISC => S19 070 001   (Cadena compuesta por 16 BYTES)
		19 071 002 => IIM => M19 071 002
		19 072 234 => IIA => M19 072 002
		19 073 014 => LA => M19 073 002
		19 074 890 => LC => M19 074 002
		
		
		Ya se tienen 500 alumnos con formato anterior, es decir, sin la letra al inicio
		
		CREAR algoritmo que agregue la letra a quienes a cada numero de control 
		dependiendo su carrera 
		
		Suponiendo que se tienen 500 alumnos registrados en un archivo de texto.
		
		String nc;
		for ....
			if(nc.substring... .equals("070"))
					nc = "S" + nc;
				
 
	 * 1) Llenar DOS vector con 350 mil NUMEROS DE CONTROL ALEATORIOS uno para ser utilizado
	 * 		en cada metodo
	 * 2) Los metodos indicados abajo deberan hacer lo siguiente:
	 * 		2.1 Analizar cada uno de los numeros de control para verificar la parte central
	 * 			de dicho numero de control y segun el numero, agregar la letra correspondiente
	 * 			de la carrera
	 * 3) Una vez agregada la letra, volver a guardar el vector
	 * 4) MEDIR EL TIEMPO DE EJECUCION para ambos algoritmos
	 * 			

 */

class CadenaEspecial{
	private String cadena;
	
	
	public CadenaEspecial(String cadena) {
		this.cadena = cadena;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	
	// 1) Mostrar cadena invertida por letras
	public String invertirLetras() {
		String cadenaInvertida = "";
		for(int i = cadena.length()-1; i >= 0; i--) {
			cadenaInvertida += cadena.charAt(i);
		}
		
		return cadenaInvertida;
	}
	
	// 2) Mostrar cadena inverida por palabras
	public String invertirPorPalabras() {
		String palabrasInvertidas = "";
		String cadenas[] = cadena.split(" ");
		for(int i = cadenas.length - 1; i >= 0; i--) {
			palabrasInvertidas += cadenas[i] + " ";
		}
		return palabrasInvertidas;
	}
	
	
	// 3) Agregar/ caracteres y/o subcadenas en posiciones especificas
	
	public String agregarCaracteres(int posicion, String subcadena) {
		String nuevaCadena = "";
		
		for (int i = 0; i < cadena.length(); i++) {
			if (posicion == i) {
				nuevaCadena += cadena.charAt(i);
				nuevaCadena += subcadena;
			} else {
				nuevaCadena += cadena.charAt(i);
			}
		}
		return nuevaCadena;
	}
	
	//  --->>> 4) eliminar caracteres y/o subcadenas en posiciones especificas
	public String eliminarCaracteres(int posicion, int numeroLetras) {
		
		String nuevaCadena = "";
		
		for (int i = 0; i < cadena.length(); i++) {
			if (i >= posicion-1 && i <= (posicion + numeroLetras-1)) {
				
			}else {
				nuevaCadena+= cadena.charAt(i);
			}
		}
		
		return nuevaCadena;
	}
	
	//5) Mostrar cadena en formato CaMeL CaSe  especial
	public String mostrarCadenaCamelCase() {
		String nuevaCadena = "";
		for (int i = 0; i < cadena.length(); i++) {
			if(i%2 == 0) {
				nuevaCadena+=cadena.toUpperCase().charAt(i);
				
			}else {
				nuevaCadena+=(cadena.toLowerCase().charAt(i)+"");
			}
		}
		return nuevaCadena;
	}
	
	//6) Mostar la cadena con la primer letra de cada palabra en mayúscula
	public String mostrarPrimeraMayuscula() {
		String [] cadenas = cadena.split(" ");
		
		String nuevaCadena = "";
		
		for (int i = 0; i < cadenas.length; i++) {
			for (int j = 0; j < cadenas[i].length(); j++) {
				if(j == 0) {
					nuevaCadena += cadenas[i].toUpperCase().charAt(j);
				}else {
					nuevaCadena += cadenas[i].toLowerCase().charAt(j);
				}
			}
			nuevaCadena += " ";
		}
		return nuevaCadena;
	}
	
	// dos vectores con 350000 numeros aleatorios
	
	public String [] agregarLetrasString(String[] vector) {
		
		long tInicio = System.currentTimeMillis(); //Devuelve em milisegundos el tiempo actual
		// String x = new String("Hola");
		// x += " Mundo";
		// x = x + " Mundo"
		
		for (int i = 0; i < vector.length; i++) {
			if (vector[i].substring(2, 5).equals("070")){
				vector[i] = "S" + vector[i];
			} else if (vector[i].substring(2, 5).equals("071")){
				vector[i] = "M" + vector[i];
			} else if (vector[i].substring(2, 5).equals("072")){
				vector[i] = "A" + vector[i];
			} else if (vector[i].substring(2, 5).equals("073")){
				vector[i] = "L" + vector[i];
			} else if (vector[i].substring(2, 5).equals("074")){
				vector[i] = "C" + vector[i];
			}
		}
		
		
		long tFin = System.currentTimeMillis();
		System.out.println("\nTiempo de ejecucion: " + (tFin-tInicio) + " en milisegundos.");
		return vector;
		
		//System.out.println(x);
		
	}
	
	public StringBuilder [] agregarletrasStringBuilder(StringBuilder [] vector) {
		long tInicio = System.currentTimeMillis(); //Devuelve em milisegundos el tiempo actual
		//StringBuilder x = new StringBuilder("Hola"); 
		//x += " Mundo"; + NO FUNCIONA CONSTRIBUILDER
		//x.append(" Mundo");
		
		for (int i = 0; i < vector.length; i++) {
			if (vector[i].substring(2, 5).equals("070")){
				vector[i].insert(0, "S");
			} else if (vector[i].substring(2, 5).equals("071")){
				vector[i].insert(0, "M");
			} else if (vector[i].substring(2, 5).equals("072")){
				vector[i].insert(0, "A");
			} else if (vector[i].substring(2, 5).equals("073")){
				vector[i].insert(0, "L");
			} else if (vector[i].substring(2, 5).equals("074")){
				vector[i].insert(0, "C");
			}
			
			
		}
		
		long tFin = System.currentTimeMillis();
		System.out.println("\nTiempo de ejecucion: " + (tFin-tInicio) + " en milisegundos.");
		
		//System.out.println(x);
		return vector;
	}
	
	public String [] generarVectorRandom() {
		Random random = new Random();
		String vector[] = new String[350000];
		String nc = "";
		for(int i = 0; i < 350000; i++) {
			nc = "";
			int primerNumero = (int)(random.nextDouble() * 100);
			if (primerNumero<=9){
				nc += "0" + primerNumero;
			} else {
				nc += primerNumero;
			}
			if (primerNumero <= 20) {
				nc += "070";
			} else if (primerNumero > 20 && primerNumero <= 40){
				nc += "071";
			} else if (primerNumero > 40 && primerNumero <= 60){
				nc += "072";
			} else if (primerNumero > 60 && primerNumero <= 80){
				nc += "073";
			} else if (primerNumero > 80 && primerNumero <= 99){
				nc+="074";
			} else {
				nc += "070";
			}
			
			int tercerNumero = (int)(random.nextDouble() * 1000);
			
			if (tercerNumero <= 9) {
				nc += "00" + tercerNumero;
			} else if (tercerNumero >= 10 && tercerNumero <= 99) {
				nc += "0" + tercerNumero;
			} else {
				nc += tercerNumero;
			}
			vector[i] = nc;
		}
		return vector;
	}
	
	public StringBuilder [] generarVectorRandomBuilder() {
		Random random = new Random();
		StringBuilder vector[] = new StringBuilder[350000];
		StringBuilder nc = new StringBuilder("");
		for(int i = 0; i < 350000; i++) {
			nc = new StringBuilder("");
			int primerNumero = (int)(random.nextDouble() * 100);
			if (primerNumero<=9){
				nc.append( primerNumero + "0");
			} else {
				nc.append(primerNumero);
			}
			if (primerNumero <= 20) {
				nc.append("070");
			} else if (primerNumero > 20 && primerNumero <= 40){
				nc.append("071");
			} else if (primerNumero > 40 && primerNumero <= 60){
				nc.append("072");
			} else if (primerNumero > 60 && primerNumero <= 80){
				nc.append("073");
			} else if (primerNumero > 80 && primerNumero <= 99){
				nc.append("074");
			} else {
				nc.append("070");
			}
			
			int tercerNumero = (int)(random.nextDouble() * 1000);
			
			if (tercerNumero <= 9) {
				nc.append("00" + tercerNumero);
			} else if (tercerNumero >= 10 && tercerNumero <= 99) {
				nc.append("0" + tercerNumero);
			} else {
				nc.append(tercerNumero);
			}
			vector[i] = nc;
		}
		return vector;
	}
	
	
}

public class PruebaCadenaEspecial {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce cadena a analizar: ");
		String cadena = entrada.nextLine();
		CadenaEspecial ce = new CadenaEspecial(cadena);
			
		int opcion = 0;
		do {
			System.out.println("\nElige una de las siguientes opciones");
			System.out.println("1) Mostrar la cadena invertida por letra ");
			System.out.println("2) Mostrar la cadena con palabras invertidas");
			System.out.println("3) Agregar/ caracteres y/o subcadenas en posiciones especificas");
			System.out.println("4) eliminar caracteres y/o subcadenas en posiciones especificas");
			System.out.println("5) Mostrar cadena en formato CaMeL CaSe  especial");
			System.out.println("6) Mostar la cadena con la primer letra de cada palabra en mayúscula");
			System.out.println("7) llenar vector con 35k de nc y agregar letra (usando String)");
			System.out.println("8) llenar vector con 35k de nc y agregar letra (usando StringBuilder)");
			System.out.println("9) Salir");
			System.out.print("Introduce opcion: ");
			opcion = entrada.nextInt();
			System.out.println("");
			int posicion = 0;
			
			switch (opcion) {
			case 1:
				System.out.println("Cadena invertida:");
				System.out.println(ce.invertirLetras());
				break;
				
			case 2:
				System.out.println(ce.invertirPorPalabras());
				break;
			
			case 3:
				System.out.println("Introduce subcadena: ");
				String subCadena = entrada.next();
				System.out.println("Introduce posicion: ");
				posicion = entrada.nextInt();
				
				if(posicion <= cadena.length()) {
					System.out.println("\nCadena con los caracteres agregados:");
					System.out.println(ce.agregarCaracteres(posicion, subCadena));
				} else {
					System.out.println(">> La posicion no existe");
				}
				break;
				
			case 4:
				System.out.println("Introduce pocicion:");
				posicion = entrada.nextInt();
				System.out.println("Introduce numero de letras a eliminar: ");
				int numLetras = entrada.nextInt();
				
				
				if(posicion <= cadena.length()) {
					System.out.println("Cadena con los caracteres eliminados: ");
					System.out.println(ce.eliminarCaracteres(posicion, numLetras));
				}else {
					System.out.println(">> La posicion no existe");
				}
				break;
				
			case 5:
				System.out.println("Cadena camel case: ");
				System.out.println(ce.mostrarCadenaCamelCase());
				
				break;
				
			case 6:
				System.out.println("Cadena con palabras con letra inicial mayuscula: ");
				System.out.println(ce.mostrarPrimeraMayuscula());
				break;
				
			case 7:
				String vector1[] = ce.generarVectorRandom();
				vector1 = ce.agregarLetrasString(vector1); 
				System.out.println("primeros 10 numeros de control");
				for (int i = 0; i < 10; i++) {
					System.out.println(vector1[i]);
				}
				break;
				
			case 8:
				StringBuilder vector2[] = ce.generarVectorRandomBuilder();
				vector2 = ce.agregarletrasStringBuilder(vector2);
				System.out.println("Primeros 10 numeros de control");
				for (int i = 0; i < 10; i++) {
					System.out.println(vector2[i]);
				}
				break;
				
			case 9:
				System.out.println("> Saliendo . . .");
				break;
				
			default:
				System.out.println(">> Opcion erronea");
				break;
			}
			System.out.println("");
			
		} while (opcion != 9);
		
	}
}
