import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Viacheslav on 23.09.2018.
 */
public class ScoreWriter {
    public static void main(String[] args) {
        FileWriter myFile = null;
        BufferedWriter buff = null;
        String[] scores = new String[3];
        //Заполняем массив результатами игры
        scores[0]="Mr.Smith 240";
        scores[1]="Ms.Lee 300";
        scores[2]="Mr.Dolittle 190";

        try {
            myFile = new FileWriter("c:\\tools\\scores2.txt");
            buff = new BufferedWriter(myFile);
            for (int i=0;i<scores.length;i++){
        //запись строк из массива в файл scores2
                buff.write(scores[i]);
                System.out.println("Записывается"+scores[i]);
            }
            System.out.println("Запись файла завершена");

        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                buff.flush();
                buff.close();
                myFile.close();
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }//конец метода main
}
