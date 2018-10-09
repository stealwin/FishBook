import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Viacheslav on 23.09.2018.
 */
public class ScoreReader {
    public static void main(String[] args) {
        FileReader myFile = null;
        BufferedReader buff = null;
        try {
            myFile=new FileReader("c:\\scores.txt");
            buff=new BufferedReader(myFile);
            while (true){
                //считывание строки из файла scores
                String line = buff.readLine();
                //проверка на достижение конца файла
                if (line==null) break;
                    System.out.println(line);

            }// конец цикла while
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                buff.close();
                myFile.close();
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }// конец метода main
}
