package M3;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		int cas = 0;
		String direccioFitxer;
		Concessionaris c1 = new Concessionaris ("Adreça 1");
	
	//String direccioFitxer1 = "/home/cfgs/Documents/si.txt";
	//System.out.println("Digues la direcció cap a un segon fitxer el qual té un llistat de vehicles: ");
	//String direccioFitxer2 = sc.nextLine();
	//String direccioFitxer3 = "/home/cfgs/Documents/si.xml";

	try {
		System.out.println();
		
		
		
	while (cas != 0) {
		System.out.println("Digues què vols fer: "
				+ "\n 0: Sortir "
				+ "\n 1: Carregar vehicles des d'un fitxer CSV "
				+ "\n 2: Carregar vehicles des d'un fitxer XML "
				+ "\n 3: Mostrar el llistat de vehicles "
				+ "\n 4: Valor màxim "
				+ "\n 5: Cercar un element "
				+ "\n 6: Mirar si està ordenat "
				+ "\n 7: Ordenar vector "
				+ "\n 8: Sortir" );		
		switch (cas) {
		case 0:
			System.out.println("Has decidit aturar el bucle.");
			break;
			
		case 1:
			System.out.println("Digues la direcció cap a un fitxer (.CSV) el qual té un llistat de vehicles: ");
			direccioFitxer = sc.nextLine();
			c1.importarVehiclesCSV(direccioFitxer);
			break;
			
		case 2:
			System.out.println("Digues la direcció cap a un fitxer (.XML) el qual té un llistat de vehicles: ");
			direccioFitxer = sc.nextLine();
			c1.importarVehiclesXML(direccioFitxer);
			break;
			
		case 3:
			c1.mostrarLlista();
			break;
			
		case 4:
			System.out.println("Quin vehicle vols afegir, cotxe o moto?");
			String vehicle = sc.nextLine();
			boolean esClassic = false;
			if (vehicle.equals("cotxe")) {
				System.out.println("Escriu la matrícula:");
				String matricula = sc.nextLine();
				System.out.println("Escriu els km:");
				double km = sc.nextDouble();
				System.out.println("Escriu si és clàssic (true/false):");
				String classic = sc.nextLine();
				if (classic.equals("true")) {
					 esClassic = true;
				}
				Cotxes cn1 = new Cotxes(matricula, km, esClassic);
				c1.afegirVehicle(cn1);
			}
			break;
			
		case 5:
			System.out.println("Escriu la matrícula del vehicle que vols eliminar. Si retorna la matrícula és que ha funcionat.");
			String matricula = sc.nextLine();
			c1.esborrarVehicle(matricula);
			break;
			
		case 6:
			System.out.println("SI");
			break;
			
		case 7:
			System.out.println("SI");
			break;
			
		case 8:
			System.out.println("Digues la direcció cap a un fitxer (.XML) al qual guardar els vehicles: ");
			direccioFitxer = sc.nextLine();
			c1.exportarVehiclesXML(direccioFitxer);			
			break;
			
		default:
			break;
		}
	}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MatriculaInvalida e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}



	
	
	

}
