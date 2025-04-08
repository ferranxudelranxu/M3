package M3;

import java.io.Serializable;
import java.util.Objects;

public abstract class Vehicle implements Comparable<Vehicle>, Serializable{
	protected String matricula;
	protected double km;
	
	public Vehicle(String matricula, double km) throws MatriculaInvalida {
		if (km < 0 && validarMatricula(matricula)) {
			throw new MatriculaInvalida(matricula);
		}
		this.matricula = matricula;
		this.km = km;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}
	
	public abstract int calcularDescompte();
	
	public boolean validarMatricula(String matricula) {
		return matricula.matches("^\\d{4} - [BCDFGHJKLMYFPSTWXYZ]{3}$");
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(km, matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Double.doubleToLongBits(km) == Double.doubleToLongBits(other.km)
				&& Objects.equals(matricula, other.matricula);
	}

	@Override
	public int compareTo(Vehicle v) {
        return this.matricula.compareTo(v.getMatricula());
    }

}
