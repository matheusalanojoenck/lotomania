import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LeitorJogos gerenciadorJogos = new LeitorJogos();
        gerenciadorJogos.criar();
        SorteioJogos sorteioJogo = new SorteioJogos();
        sorteioJogo.criar(gerenciadorJogos.getJogos());
        GeradorJogo geradorJogo = new GeradorJogo();
        geradorJogo.criar(sorteioJogo.getJogosSorteados());
    }
}
