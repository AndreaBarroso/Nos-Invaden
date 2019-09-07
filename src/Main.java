import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main (String [] ars){
        long n = 0;
        int exitos_asegurados = 0;
        Scanner leer = new Scanner(System.in);
        System.out.println("Cuidades invadidas:");
        n = leer.nextInt();
        System.out.println("Grupos de Invasores:");
        int [] invasores = new int [(int)n];
        for (int i = 0; i<n;i++){
            System.out.println("Grupo "+(i+1)+":");
            invasores[i] = leer.nextInt();
        }
        System.out.println("Grupos defensores:");
        int [] defensores = new int [(int)n];
        for (int i = 0; i<n;i++){
            System.out.println("Grupo "+(i+1)+":");
            defensores[i] = leer.nextInt();
        }
        //Ordena los vectores
        Arrays.sort(defensores);
        Arrays.sort(invasores);

        for (int i = 0;i<n;i++){
            if (defensores[i] >= invasores[i]){
                defensores[i]= -1;
                invasores[i]= -1;
                exitos_asegurados++;
            }
        }

        for (int j = 0; j < n;j++){
            for (int k = 0; k < n-1;k++){
                if ((defensores[j] == invasores[k] && defensores[j] != -1 && invasores[k]!= -1) || (defensores[j]>invasores[k]&& defensores[j] != -1 && invasores[k]!= -1)){
                    exitos_asegurados++;
                    defensores[j]= -1;
                    invasores[k]= -1;
                }
            }
        }

        System.out.println("Cuidades salvadas: "+exitos_asegurados);
    }

}