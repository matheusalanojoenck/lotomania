import java.util.List;

public class Util {
    public static void mostraJogos(List<Jogo> jogos){
        for (Jogo jogo:jogos) {
            System.out.println(jogo.getConcurso()+" "+jogo.getData()+" "+jogo.getBolasJogo().toString());
        }
    }
}
