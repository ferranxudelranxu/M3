package M3;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		Concessionaris c1 = new Concessionaris ("Adreça 1");
	System.out.println("Digues la direcció cap a un fitxer el qual té un llistat de vehicles: ");
	String direccioFitxer1 = sc.nextLine();
	System.out.println("Digues la direcció cap a un segon fitxer el qual té un llistat de vehicles: ");
	String direccioFitxer2 = sc.nextLine();

	try {
		c1.importarVehicles(direccioFitxer1);
		c1.importarVehicles(direccioFitxer2);

		c1.mostrarLlista();
		System.out.println();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	
	

}
