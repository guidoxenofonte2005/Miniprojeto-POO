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
        }

        Clube[] classificacao = getClassificacao();

        System.out.println("Classificação dos times:");
        for (int k = 0; k < classificacao.length; k++) {
            System.out.println("k = " + k);
            System.out.println("Time " + classificacao[k].getNome() + "\t\t" + classificacao[k].getPontos());
        }

        System.out.println("Campeão: " + this.getCampeao(classificacao, classificacao.length).getNome());
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
        int counter = 0;

        for (int i = 0; i < this.clubes.size(); i++) {
            if (i == 0) {
                classificacao[0] = this.clubes.getFirst();
                counter = 1;
            }
            else {
                for (int j = 0; j < counter; j++) {
                    if (classificacao[j].getPontos() < this.clubes.get(i).getPontos()) {
                        continue;
                    } else if (classificacao[j] == null) {
                        classificacao[j] = this.clubes.get(i);
                        counter++;
                    } else {
                        classificacao[j+1] = classificacao[j];
                        classificacao[j] = this.clubes.get(i);
                        counter++;
                    }
                }
            }
        }

        return classificacao;
    }

    public Clube getCampeao(Clube[] classificacao, int size) {
        return classificacao[size - 1];
    }
}
