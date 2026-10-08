import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AnalitzadorPrincipal {

    public static void main(String[] args) {
        String texte = "Texte de prova amb un tres errors i tres warnings per passar el test. eRrOr error error Warning warning warning";

        ProcessBuilder pb = new ProcessBuilder("java", "src/FiltreLog.java");
        ProcessBuilder pb2 = new ProcessBuilder("java", "src/FiltreLog.java", "WARNING");
        File fitxerErrors = new File("errors_filtre.log");
        pb.redirectError(fitxerErrors);

        

        try {
            Process proces = pb.start();
            Process proces2 = pb2.start();

            try (
                BufferedWriter alFill = new BufferedWriter(new OutputStreamWriter(proces.getOutputStream()));
                BufferedReader delFill = new BufferedReader(new InputStreamReader(proces.getInputStream()));

                BufferedWriter alFill2 = new BufferedWriter(new OutputStreamWriter(proces2.getOutputStream()));
                BufferedReader delFill2 = new BufferedReader(new InputStreamReader(proces2.getInputStream()));
            ){
            
                alFill.write(texte);
                alFill.flush();
                alFill.close();
                
                alFill2.write(texte);
                alFill2.flush();
                alFill2.close();

            
                String nErrors = delFill.readLine();
                proces.waitFor();

                String nWarnings = delFill2.readLine();
                proces2.waitFor();

                int exitValueP1 = proces.exitValue();
                int exitValueP2 = proces2.exitValue();

                int exitValue = (exitValueP1 > exitValueP2) ? exitValueP1 : exitValueP2;


                System.out.println("RESULTAT: " + "ERRORS=" + nErrors + " | WARNINGS=" + nWarnings + " | EXIT_CODE=" + exitValue);

            }

        } catch(IOException e){
            IO.println(e.getMessage());
        } catch(InterruptedException e){
            IO.println(e.getMessage());
        }

        
    }
    
    

    
}
