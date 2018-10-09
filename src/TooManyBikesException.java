/**
 * Created by Viacheslav on 23.09.2018.
 */
public class TooManyBikesException extends Exception {
    //Конструктор
    TooManyBikesException(String s) {

        super("Мы не сможем доставить столько " +
                "велосипедов за один раз");
    }


}
