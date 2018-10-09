import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Viacheslav on 25.09.2018.
 */
public class ScoreWriter3 {
    public static void main(String[] args) {
        ArrayList scoreTank = new ArrayList();
        Score newScore;
        String stScore;
        Date today = new Date();

        Score aScore = new Score("Николай","Eras",24,today);
        scoreTank.add(aScore);
        stScore = scoreTank.toString();

        System.out.println(aScore);

    }


}
