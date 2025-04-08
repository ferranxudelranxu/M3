package M3;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		Concessionaris c1 = new Concessionaris ("Adreça 1");
	//System.out.println("Digues la direcció cap a un fitxer el qual té un llistat de vehicles: ");
	//String direccioFitxer1 = sc.nextLine();
	String direccioFitxer1 = "/home/cfgs/Documents/si.txt";
	//System.out.println("Digues la direcció cap a un segon fitxer el qual té un llistat de vehicles: ");
	//String direccioFitxer2 = sc.nextLine();
	//System.out.println("Digues la direcció cap a un tercer fitxer (.XML) al qual guardar els vehicles: ");
	//String direccioFitxer3 = sc.nextLine();
	String direccioFitxer3 = "/home/cfgs/Documents/si.xml";

	try {
		c1.importarVehicles(direccioFitxer1);
		//c1.importarVehicles(direccioFitxer2);

		c1.mostrarLlista();
		System.out.println();
		
		c1.exportarVehiclesXML(direccioFitxer3);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	
	

}
