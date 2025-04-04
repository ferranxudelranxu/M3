package M3;

public class Motos extends Vehicle{
	private int cilindrada;

	public Motos(String matricula, double km, int cilindrada) throws MatriculaInvalida {
		super(matricula, km);
		this.cilindrada = cilindrada;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	public int calcularDescompte() {
		if (cilindrada <= 125) {
			int descompte = ((int)km / 5000)*2 ;
			if (descompte > 20) {
				descompte = 20;
			}
			return descompte;
		}
		else {
			int descompte = (int)km / 10000;
			if (descompte > 20) {
				descompte = 20;
			}
			return descompte;
		}
	}

	@Override
	public String toString() {
		return "Motos [cilindrada=" + cilindrada + ", matricula=" + matricula + ", km=" + km + "]";
	}
	
	
}
