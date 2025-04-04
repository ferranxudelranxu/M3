package M3;

public class MatriculaInvalida extends Exception{
	public MatriculaInvalida(String message) {
        super(message);
    }
	
	public String getLocalizedMessage() {
        String error = super.getMessage();
        error += "\n La matrícula és incorrecte.";
        return error;
    }
	
}
