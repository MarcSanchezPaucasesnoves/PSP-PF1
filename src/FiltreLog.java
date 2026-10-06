import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiltreLog{

    private static int comptarErrors(String frase){
        String[] paraules = frase.split("\\s+");
        int comptadorErrors = 0;

        for (String paraula : paraules) {
            if (paraula.toUpperCase() == "ERROR") comptadorErrors++;
        }

        return comptadorErrors;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nErrors = 0;
        String linia;

        while ((linia = br.readLine()) != null) {
            nErrors += comptarErrors(linia);
        }

        System.out.print(nErrors);

    }
    
}
