import java.util.List;

/**
 * Classe que representa um jogo
 */
public class Jogo {

    private String concurso;
    private String data;
    private List<String> bolasJogo;

    public String getConcurso() {
        return concurso;
    }

    public Jogo setConcurso(String concurso) {
        this.concurso = concurso;
        return this;
    }

    public String getData() {
        return data;
    }

    public Jogo setData(String data) {
        this.data = data;
        return this;
    }

    public List<String> getBolasJogo() {
        return bolasJogo;
    }

    public Jogo setBolasJogo(List<String> bolasJogo) {
        this.bolasJogo = bolasJogo;
        return this;
    }
}
