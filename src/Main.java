import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    private static final String CURP_REGEX = "[A-Z]{4}\d{6}[HM][A-Z]{5}[A-Z0-9]{2}";

    public static void main(String[] args) {
        String filePath = "EjemplosCurps.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                validarCURP(linea, numeroLinea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void validarCURP(String curp, int numeroLinea) {
        Pattern pattern = Pattern.compile(CURP_REGEX);
        Matcher matcher = pattern.matcher(curp);

        if (matcher.matches()) {
            System.out.println("CURP valida: " + curp + " en la linea " + numeroLinea);
        } else {
            System.out.println("CURP invalida: " + curp + " en la linea " + numeroLinea);
        }
    }
}
