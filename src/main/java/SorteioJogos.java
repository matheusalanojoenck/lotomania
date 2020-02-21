import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe responsavel por sortear N jogos que vão vão ser usados para criar um novo jogo
 */
public class SorteioJogos {

    //Lista/Set de numeros sorteados, usando Set para não haver numero repetido, TreeSet para ser ordenado
    private Set<Integer> indexSorteados = new TreeSet<>();

    //Lista de jogos sorteados, usando os numeros de indexSorteados como referencia
    private List<Jogo> jogosSorteados = new ArrayList<>();

    public Set<Integer> getIndexSorteados() {
        return indexSorteados;
    }

    public List<Jogo> getJogosSorteados() {
        return jogosSorteados;
    }

    public void criar(List<Jogo> jogos){
        setIndexSorteados(jogos);
        sorteiaJogos(jogos);
    }

    private void sorteiaJogos(List<Jogo> jogos){
        for (Integer numeroSorteado: indexSorteados) {
            jogosSorteados.add(jogos.get(numeroSorteado));
        }
    }

    private void setIndexSorteados(List<Jogo> jogos){
        int numeroSorteado;
        while(indexSorteados.size() != 10){
            numeroSorteado = ThreadLocalRandom.current().nextInt(0,jogos.size());
            indexSorteados.add(numeroSorteado);
        }
    }
}
