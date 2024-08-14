public class Clube {
    public String nome;
    public int pontos;
    public int saldoGols;

    public Clube(String n) {
        this.setNome(n);
        this.setPontos(0);
        this.setSaldoGols(0);
    }

    // funções auxiliares
    public void setSaldoGols(int saldoGols) {
        this.saldoGols = saldoGols;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public int getSaldoGols() {
        return saldoGols;
    }

    public String getNome() {
        return nome;
    }

    // funções pedidas
    public void ganhar(int saldo_gols) {
        this.setPontos(this.getPontos() + 3);
        this.setSaldoGols(this.getSaldoGols() + saldo_gols);
    }

    public void empatar() {
        this.setPontos(this.getPontos() + 1);
    }

    public void perder(int saldo_gols) {
        this.setSaldoGols(this.getSaldoGols() + saldo_gols);
    }
}
