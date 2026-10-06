import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiltreLog{

    private static int comptarErrors(String frase){
        String[] paraules = frase.split("\\s+");
        int comptadorErrors = 0;

        for (String paraula : paraules) {
            if (paraula.toUpperCase().equals("ERROR")) comptadorErrors++;
        }

        return comptadorErrors;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nErrors = 0;
        String linia = br.readLine();


        if (linia.equals("") || linia == null){
            System.err.print("Error: Text buit");
            System.exit(1);
        } else{
            nErrors += comptarErrors(linia);
        }


        System.out.print(nErrors);
        System.exit(0);
    }
    
}
