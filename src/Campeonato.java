import java.util.ArrayList;
import java.util.Random;
import java.lang.Thread;

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
                switch (j) {
                    case 0:
                        System.out.println("Jogo de Ida - " + perm.get(i)[0].getNome() + " vs " + perm.get(i)[1].getNome());
                        break;
                    case 1:
                        System.out.println("Jogo de Volta - " + perm.get(i)[0].getNome() + " vs " + perm.get(i)[1].getNome());
                        break;
                }
                this.jogarPartida(perm.get(i)[0], perm.get(i)[1]);
            }
            System.out.println();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        Clube[] classificacao = getClassificacao();

        System.out.println("Classificação dos times:");
        for (int k = 0; k < classificacao.length; k++) {
            System.out.println("Time " + classificacao[k].getNome() + "\t\t" + classificacao[k].getPontos());
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Campeão: time " + this.getCampeao(classificacao).getNome());
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
            System.out.println("O time " + clubeA.getNome() + " ganhou o jogo!\nPlacar final: " + golsA + " x " + golsB);
        } else if (golsA < golsB) {
            clubeA.perder(saldoA);
            clubeB.ganhar(saldoB);
            System.out.println("O time " + clubeB.getNome() + " ganhou o jogo!\nPlacar final: " + golsB + " x " + golsA);
        } else {
            clubeA.empatar();
            clubeB.empatar();
            System.out.println("Empate!");
        }
    }

    public Clube[] getClassificacao() {
        Clube[] classificacao = new Clube[this.clubes.size()];

        for (int i = 0; i < this.clubes.size(); i++) {
            classificacao[i] = this.clubes.get(i);
        }

        for (int i = 0; i < classificacao.length - 1; i++) {
            for (int j = i + 1; j < classificacao.length; j++) {
                if (classificacao[i].getPontos() < classificacao[j].getPontos()) {
                    Clube temp = classificacao[i];
                    classificacao[i] = classificacao[j];
                    classificacao[j] = temp;
                }
            }
        }

        return classificacao;
    }


    public Clube getCampeao(Clube[] classificacao) {
        return classificacao[0];
    }
}
