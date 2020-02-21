import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe responsavel por ler do arquivo excel todos os jogos e criar um objeto Jogo para cada um dos jogos e guarda-los em um Lis<Jogo>
 */
public class LeitorJogos {

    private List<Jogo> jogos = new ArrayList<Jogo>();

    public void criar() throws IOException {
        FileInputStream file = new FileInputStream("src/main/resources/lotomania_resultados.xlsx");

        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);

         List<Row> rows = (List<Row>) toList(sheet.iterator());

         //Remove linha dos nomes das colunas
         rows.remove(0);

         rows.forEach(row -> {
             List<Cell> cells = (List<Cell>) toList(row.cellIterator());

             Jogo jogo = new Jogo()
                     .setConcurso(cells.get(0).getStringCellValue())
                     .setData(row.getCell(1).toString())
                     .setBolasJogo(setBolasJogo(cells));
             jogos.add(jogo);
        });

        file.close();
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    private List<?> toList(Iterator<?> iterator){
        return IteratorUtils.toList(iterator);
    }

    private List<String> setBolasJogo(List<Cell> cells){
        List<String> bolasJogoList = new ArrayList<>();

        for(int i = 2; i<cells.size(); i++){
            bolasJogoList.add(cells.get(i).getStringCellValue());
        }
        return bolasJogoList;
    }
}
