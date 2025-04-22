package M3;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		int cas = 9;
		String direccioFitxer;
		System.out.println("Quina és l'adreça del teu concessionari?");
		String adreça = sc.nextLine();
		Concessionaris c1 = new Concessionaris (adreça);

	try {
		System.out.println();
		
		
		
	while (cas != 0) {
		System.out.println("Digues què vols fer: "
				+ "\n 0: Sortir "
				+ "\n 1: Carregar vehicles des d'un fitxer CSV."
				+ "\n 2: Carregar vehicles des d'un fitxer XML."
				+ "\n 3: Mostrar el llistat de vehicles."
				+ "\n 4: Afegir un vehicle."
				+ "\n 5: Treure un vehicle mitjançant la matrícula."
				+ "\n 6: Mirar quin cotxe té més Km."
				+ "\n 7: Desar els vehicles a un fitxer CSV."
				+ "\n 8: Desar els vehicles a un fitxer XML" );
		cas = sc.nextInt();
		sc.nextLine(); //Saltar la línea en blanc que queda pel sc.nextInt().
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
			else {
				System.out.println("Escriu la matrícula:");
				String matricula = sc.nextLine();
				
				System.out.println("Escriu els km:");
				double km = sc.nextDouble();
				
				System.out.println("Escriu la dada per a cilindrada:");
				int cilindrada = sc.nextInt();
				
				Motos m1 = new Motos(matricula, km, cilindrada);
				c1.afegirVehicle(m1);
			}
			break;
			
		case 5:
			System.out.println("Escriu la matrícula del vehicle que vols eliminar. Si retorna la matrícula és que ha funcionat.");
			String matricula = sc.nextLine();
			c1.esborrarVehicle(matricula);
			break;
			
		case 6:
			if (c1.mesKm() != null) {
				System.out.println("El cotxe amb més quilòmetres és: " + c1.mesKm());
			}
			System.out.println("No hi ha cap cotxe.");
			break;
			
		case 7:
			System.out.println("Digues la direcció cap a un fitxer CSV (.txt) al qual guardar els vehicles: ");
			direccioFitxer = sc.nextLine();
			c1.exportarVehiclesCSV(direccioFitxer);		
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
