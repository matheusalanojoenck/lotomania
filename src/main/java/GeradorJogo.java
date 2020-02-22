import java.util.*;

/**
 * Classe reposnavel por gerar um novo jogo a partir dos N jogos selecionados pela classe SorteioJogos
 */
public class GeradorJogo {
    private List<Integer> todosNumeros = new ArrayList<>();

    //Chave = Numero do jogo | Valor = ocorrencia desse numero
    private Map<Integer, Integer> numerosOcorrencia = new HashMap<>();

    public void criar(List<Jogo> jogosSorteados){
        uniaoNumeroJogos(jogosSorteados);
        setNumerosOcorrencia();
    }

    private void uniaoNumeroJogos(List<Jogo> jogosSorteados){
        for (Jogo jogo: jogosSorteados) {
            for (String numeroDoJogo : jogo.getBolasJogo()){
                todosNumeros.add(Integer.parseInt(numeroDoJogo));
            }
        }
        Collections.sort(todosNumeros);
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
        numerosOcorrencia = ordenaMapPorValor(numerosOcorrencia);

        System.out.println(numerosOcorrencia.toString());
    }

    private Map<Integer, Integer> ordenaMapPorValor(Map<Integer, Integer> numerosOcorencia) {
        //Lista de elementos do HashMap
        List<Map.Entry<Integer, Integer>> listaNumerosOcorrencia = new LinkedList<>(numerosOcorencia.entrySet());

        //Ordena Lista de forma crescente
        listaNumerosOcorrencia.sort(Map.Entry.comparingByValue());
        //Inverte lista ordenada para forma decrescente
        Collections.reverse(listaNumerosOcorrencia);

        //Coloca a lsita ordenada no HasMap
        Map<Integer, Integer> mapOcorrenciaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> numero : listaNumerosOcorrencia) {
            mapOcorrenciaOrdenado.put(numero.getKey(), numero.getValue());
        }
        return mapOcorrenciaOrdenado;
    }
}
