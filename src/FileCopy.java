import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Viacheslav on 23.09.2018.
 */
public class FileCopy {
    public static void main(String[] args) {
       //String[] score = new String[3];
        int score[]={23,45,11,245};
        FileInputStream myFile = null;
        FileOutputStream myFile2 = null;

        /*score[0]="Vasya 310";
        score[1]="Mitya 93";
        score[2]="Valera 126";*/

        try {
            myFile = new FileInputStream("c:\\scores.txt");
            myFile2 = new FileOutputStream("c:\\tools\\scores2.txt");
            while (true){
                int intValueOfByte = myFile.read();
                myFile2.write(intValueOfByte);
                System.out.println(""+ intValueOfByte);
                if (intValueOfByte == -1){
                    //достигнут конец цикла
                    break;
                }
            } // конец while



        } catch (IOException e){
            System.out.println("Невозможно скопировать файл: "+ e.toString());
        } finally {
            try {
                myFile.close();
                myFile2.close();
            }catch (Exception e1){
                e1.printStackTrace();
            }
            System.out.println("Копирование файла завершено успешно");
        }

    }

}
