import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AnalitzadorPrincipal {

    public static void main(String[] args) {
        String texte = "Texte de prova amb un error";

        ProcessBuilder pb = new ProcessBuilder("java", "src/FiltreLog.java");
        File fitxerErrors = new File("errors_filtre.log");
        pb.redirectError(fitxerErrors);

        

        try {
            Process proces = pb.start();

            try (
                BufferedWriter alFill = new BufferedWriter(new OutputStreamWriter(proces.getOutputStream()));
                BufferedReader delFill = new BufferedReader(new InputStreamReader(proces.getInputStream()));
            ){
            
                alFill.write(texte);
                alFill.flush();
                alFill.close();

            
                String nErrors = delFill.readLine();
                proces.waitFor();

                int exitValue = proces.exitValue();

                System.out.println("RESULTAT: " + "ERRORS=" + nErrors + " | WARNINGS=" + "BUID" + " | EXIT_CODE=" + exitValue);

            }

        } catch(IOException e){
            IO.println(e.getMessage());
        } catch(InterruptedException e){
            IO.println(e.getMessage());
        }

        
    }
    
    

    
}
