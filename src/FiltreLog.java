import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiltreLog{

    private static int comptarErrors(String frase, String paraulaACercar){
        String[] paraules = frase.split("\\s+");
        int comptadorErrors = 0;

        for (String paraula : paraules) {
            if (paraula.toUpperCase().equals(paraulaACercar)) comptadorErrors++;
        }

        return comptadorErrors;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nErrors = 0;
        String linia = br.readLine();
        String paraulaACercar = (args.length > 0) ? args[0] : "ERROR";

        if (linia == null || linia.equals("")){
            System.err.print("Error: Text buit");
            System.exit(1);
        } else{
            nErrors += comptarErrors(linia, paraulaACercar);
        }


        System.out.print(nErrors);
        System.exit(0);
    }
    
}
