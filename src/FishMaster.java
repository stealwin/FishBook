import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Admin on 01.08.2018.
 */
public class FishMaster {
    public static void main(String[] args) {
        Fish myFish = new Fish();
        String feetString="";
        int feet;
        myFish.dive();
        myFish.dive(20);
/*

        */
/*Создаем обработчик чтения входного потока
        * InputStreamReader, который подключен к
        * System.in и передаем его буферизированному
        * обработчику чтения BufferedReader*//*

        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in)
        ) ;
        */
/*Погружаемся до тех пор, пока не будет нажата
        * клавиша Q*//*

         while (true){
             System.out.println("Готова к погружению. На " +
                     "какую глубину?");
             try {
                 feetString = stdin.readLine();
                 if (feetString.equals("Q")){
                     //выход из программы
                     System.out.println("Пока!");
                     System.exit(0);
                 } else {
         //Конвертируем feetString в целое число
         // и погружаемся на глубину, которая
        // записывается в переменную feet
              feet = Integer.parseInt(feetString);
              myFish.dive(feet);
                 }
             }catch (IOException e){
                 e.printStackTrace();
             }
         }// конец while
*/



    }//конец main
}
