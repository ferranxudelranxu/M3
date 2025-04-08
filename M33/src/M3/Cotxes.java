package M3;

import java.io.Serializable;

public class Cotxes extends Vehicle  implements Serializable{
	private boolean esClassic;

	public Cotxes(String matricula, double km, boolean esClassic) throws MatriculaInvalida{
		super(matricula, km);
		this.esClassic = esClassic;
	}

	public boolean isEsClassic() {
		return esClassic;
	}

	//Comentari
	public void setEsClassic(boolean esClassic) {
		this.esClassic = esClassic;
	}
	
	public int calcularDescompte() {
		if (esClassic) {
			return 0;
		}
		else {		
			int descompte = (int)km / 10000;
			if (descompte > 10) {
				descompte = 10;
			}
			return descompte;
		}
	}

	@Override
	public String toString() {
		return "Cotxes [esClassic=" + esClassic + ", matricula=" + matricula + ", km=" + km + "]";
	}
	
	
	
	
}
