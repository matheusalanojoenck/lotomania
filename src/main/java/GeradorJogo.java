import java.util.*;

/**
 * Classe reposnavel por gerar um novo jogo a partir dos N jogos selecionados pela classe SorteioJogos
 */
public class GeradorJogo {
    private List<Integer> todosNumeros = new ArrayList<>();
    private Map<Integer, Integer> numerosOcorrencia= new HashMap<>();

    public void criar(List<Jogo> jogosSorteados){
        uniaoNumeroJogos(jogosSorteados);
        setNumerosOcorrencia();
        System.out.println(numerosOcorrencia.toString());
    }

    private void uniaoNumeroJogos(List<Jogo> jogosSorteados){
        for (Jogo jogo: jogosSorteados) {
            for (String numeroDoJogo : jogo.getBolasJogo()){
                todosNumeros.add(Integer.parseInt(numeroDoJogo));
            }
        }
        Collections.sort(todosNumeros);
        System.out.println(todosNumeros.size());
    }

    private void setNumerosOcorrencia(){
        for (Integer atual: todosNumeros) {
            int unico = -1;
            if(atual != unico){
                unico = atual;
                int countOcorrencia = Collections.frequency(todosNumeros, unico);
                numerosOcorrencia.put(atual, countOcorrencia);
            }
        }
    }
}
