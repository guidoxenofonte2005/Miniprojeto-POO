import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Campeonato {
    public ArrayList<Clube> clubes;

    public Campeonato(ArrayList<Clube> lista) {
        this.setClubes(lista);
    }
    // funções auxiliares
    public void setClubes(ArrayList<Clube> clubes) {
        this.clubes = clubes;
    }

    // funções pedidas
    public void jogarCampeonato() {
        ArrayList<Clube[]> perm = new ArrayList<Clube[]>();

        for (int i = 0; i < this.clubes.size(); i++) {
            for (int j = i + 1; j < this.clubes.size(); j++) {
                Clube[] temp = {this.clubes.get(i), this.clubes.get(j)};
                perm.add(temp);
            }
        }

        for (int i = 0; i < perm.size(); i++) {
            for (int j = 0; j < 2; j++) {
                this.jogarPartida(perm.get(i)[0], perm.get(i)[1]);
            }
        }


    }

    private void jogarPartida(Clube clubeA, Clube clubeB) {
        Random rand = new Random();
        int golsA = rand.nextInt(0, 6);
        int golsB = rand.nextInt(0, 6);

        int saldoA = golsA - golsB;
        int saldoB = golsB - golsA;

        if (golsA > golsB) {
            clubeA.ganhar(saldoA);
            clubeB.perder(saldoB);
        } else if (golsA < golsB) {
            clubeA.perder(saldoA);
            clubeB.ganhar(saldoB);
        } else {
            clubeA.empatar();
            clubeB.empatar();
        }
    }

    public void getClassificacao() {

    }

    public Clube getCampeao() {
        return null;
    }
}
