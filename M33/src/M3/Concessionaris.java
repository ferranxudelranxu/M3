package M3;

import java.util.Objects;
import java.util.TreeSet;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;

public class Concessionaris {
	private static int NOMBRE_VEHICLES = 0;
	private TreeSet<Vehicle> llistaVehicles;
	private String adreça;

	public Concessionaris(String adreça) {
		this.adreça = adreça;
		this.llistaVehicles = new TreeSet<Vehicle>();
	}

	public static int getNOMBRE_VEHICLES() {
		return NOMBRE_VEHICLES;
	}

	public static void setNOMBRE_VEHICLES(int nombreVehicles) {
		NOMBRE_VEHICLES = nombreVehicles;
	}

	public TreeSet<Vehicle> getLlistaVehicles() {
		return llistaVehicles;
	}

	public void setLlistaVehicles(TreeSet<Vehicle> llistaVehicles) {
		this.llistaVehicles = llistaVehicles;
	}

	public String getAdreça() {
		return adreça;
	}

	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}

	public TreeSet<?> getLlistaCotxes() {
		return llistaVehicles;
	}

	public void setLlistaCotxes(TreeSet<Vehicle> llistaVehicles) {
		this.llistaVehicles = llistaVehicles;
	}
	
	//Mostrar vehicle:
	public void mostrarVehicle() {
		for (Vehicle vehicle : llistaVehicles) {
			System.out.println(vehicle);
		}
	}
	
	//Afegir vehicle:
	public boolean afegirVehicle(Vehicle vehicle) {
		if (llistaVehicles.add(vehicle) && NOMBRE_VEHICLES < 5) {
			NOMBRE_VEHICLES ++;
			return true;
		}
		return false;
	}
	
	//Esborrar vehicles:
	public String esborrarVehicle(String matricula) {
		Iterator<Vehicle> iterator = llistaVehicles.iterator();
		while (iterator.hasNext()) {
			Vehicle vehicle = iterator.next();
			if (vehicle.getMatricula().equals(matricula)) {
				llistaVehicles.remove(vehicle);
				NOMBRE_VEHICLES --;
				return matricula;
			}
		}
		return "No s'ha pogut esborrar";
	}
	
	//Cotxe amb més km:
	public Cotxes mesKm() {
	    Cotxes mesKm = null;
	    double km = 0;
	    Iterator<Vehicle> iterator = llistaVehicles.iterator();

	    while (iterator.hasNext()) {
	        Vehicle vehicle = iterator.next();

	        if (vehicle instanceof Cotxes) {
	            Cotxes c1 = (Cotxes) vehicle;
	            if (c1.getKm() > km) {
	                km = c1.getKm();
	                mesKm = c1;
	            }
	        }
	    }

	    return mesKm; // pot ser null si no hi ha cap Cotxes
	}
	
	//Calcular mitjana km:
	public double mitjanaKm() {
		int sumVehicles = 0;
		int sumKm = 0;
		for (Vehicle vehicle : llistaVehicles) {
			sumVehicles ++;
			sumKm = sumKm + (int)vehicle.getKm();
		}
		return sumKm / sumVehicles;
	}
	
	//Mostrar la llista:
	public void mostrarLlista() {
		System.out.println("Llistat vehicles: ");
		for (Vehicle vehicle : llistaVehicles) {
			System.out.println(vehicle);
		}
		System.out.println("");
		System.out.println("");
	}
	
	@SuppressWarnings("resource")
	public void exportarVehiclesCVS (String direccioFitxer) throws IOException{
		FileWriter fWriter = null;
		PrintWriter pWriter = null;
		String vehicles;
		try {
			boolean append = false;
			fWriter = new FileWriter(direccioFitxer, append);
			pWriter = new PrintWriter(fWriter);
			
			
			
		}	catch (IOException e) {
			System.out.println("Hi ha hagut un error.");
			
		}	catch (NullPointerException e2) {
			System.out.println("L'arxiu no existeix.");
			
		}
	}
	
	//Trobar i importar els vehicles.
	public void importarVehiclesCSV(String direccioFitxer) throws IOException {
		
		FileReader fReader = null;
		BufferedReader bReader = null;
		
		String linea;
		String[] atributs;
		File fitxer = new File(direccioFitxer);
		
		try {
			fReader = new FileReader(fitxer);
			bReader = new BufferedReader(fReader);
			
			while ((linea = bReader.readLine()) != null) {
				atributs = linea.split(";");
				if (atributs[0].charAt(0) != '#') {
					if (atributs[0].equals("moto")) {
						try {
							double d = Double.parseDouble(atributs[2]);
							int i = Integer.parseInt(atributs[3]);
							Motos m1 = new Motos(atributs[1], d, i);
							this.llistaVehicles.add(m1);
						} catch (NumberFormatException e) {
							System.out.println("El format no és correcte. " + e.getMessage());
						} catch (MatriculaInvalida e) {
							System.out.println(e.getMessage());
						}
						
					}
					else if (atributs[0].equals("cotxe")){
						try {
							double d = Double.parseDouble(atributs[2]);
							boolean classic = false;
							if (atributs[3].equals("true")) {
								classic = true;
							}
							Cotxes c1 = new Cotxes(atributs[1], d, classic);
							this.llistaVehicles.add(c1);
						} catch (NumberFormatException e) {
							System.out.println("El format no és correcte. " + e.getMessage());
						} catch (MatriculaInvalida e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}

		}	
		
		catch (IOException e) {
			System.out.println("Hi ha hagut un error.");
		}	
		
		catch (NullPointerException e2) {
			System.out.println("L'arxiu no existeix.");
		}
		
		finally {
		if (bReader != null) {
		bReader.close();
		
		}
		}
	}
	
	public void exportarVehiclesCSV(String direccioFitxer)  throws IOException {
		boolean append = false;
		try (PrintWriter pWriter = new PrintWriter(new FileWriter(direccioFitxer,
		append))) {
		for (Vehicle vehicle : llistaVehicles) {
			if (vehicle instanceof Cotxes) {
	            Cotxes c1 = (Cotxes) vehicle;
	            pWriter.println("cotxe;" + c1.getMatricula() + ";" + c1.getKm() + ";" + c1.isEsClassic());
			}
			else {
				Motos m1 = (Motos) vehicle;
				pWriter.println("moto;" + m1.getMatricula() + ";" + m1.getKm() + ";" + m1.getCilindrada());
			}
			
		}
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
	}
	
	public void exportarVehiclesXML(String direccioFitxerXML) throws FileNotFoundException, IOException {
		ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(direccioFitxerXML));
		for (Vehicle vehicle : llistaVehicles) {
			fileOut.writeObject(vehicle);
		}
        fileOut.close();
	}
	
	public void importarVehiclesXML(String direccioFitxerXML) throws FileNotFoundException, EOFException, NotSerializableException {
		XMLDecoder decodificador = new XMLDecoder(new BufferedInputStream(new FileInputStream(direccioFitxerXML)));
		try {
			while (true) {
				 Vehicle v1 = (Vehicle) decodificador.readObject();
				 llistaVehicles.add(v1);
			}
		} catch (Exception e) {
			System.out.println("Error amb el fitxer.");
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(adreça, llistaVehicles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concessionaris other = (Concessionaris) obj;
		return Objects.equals(adreça, other.adreça) && Objects.equals(llistaVehicles, other.llistaVehicles);
	}
	
	

}
