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

    private Map<Integer, Integer> ordenaMapPorValor(Map<Integer, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(hm.entrySet());

        // Sort the list
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
