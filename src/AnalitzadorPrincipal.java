import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AnalitzadorPrincipal {

    public static void main(String[] args) {
        String texte = "Texte de prova amb un error";

        ProcessBuilder pb = new ProcessBuilder("java", "src/FiltreLog.java");

        try{
            Process proces = pb.start();

            BufferedWriter alFill = new BufferedWriter(new OutputStreamWriter(proces.getOutputStream()));
            alFill.write(texte);
            alFill.flush();
            alFill.close();

            BufferedReader delFill = new BufferedReader(new InputStreamReader(proces.getInputStream()));
            String nErrors = delFill.readLine();
            System.out.println("Nombre d'errors en el texte: " + nErrors);
            proces.waitFor();

        } catch(IOException e){
            IO.println(e.getMessage());
        } catch(InterruptedException e){
            IO.println(e.getMessage());
        }
    }
    
    

    
}
