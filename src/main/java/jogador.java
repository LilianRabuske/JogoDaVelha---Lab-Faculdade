public class jogador {
    private String nome;
    private double pontos = 0;

    public jogador(String nome) {
        this.nome = nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }


    public String getNome() {
        return nome;
    }

    public double getPontos() {
        return pontos;
    }


    public String toString() {
        return this.getNome() + "\n" + "Pontuacao: " + this.getPontos() + "\n";
    }
}
