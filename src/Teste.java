import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Clube> lista = new ArrayList<Clube>();

        System.out.print("Quantos times jogarão? ");
        int qtd = teclado.nextInt();

        for (int i = 1; i <= qtd; i++) {
            Clube temp = new Clube(Integer.toString(i));
            lista.add(temp);
        }

        Campeonato teste = new Campeonato(lista);
        teste.jogarCampeonato();
    }
}