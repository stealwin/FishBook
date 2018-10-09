import java.util.Date;

/**
 * Created by Viacheslav on 25.09.2018.
 */
public class Score {
    private String firstName;
    private String lastName;
    private int score;
    private Date playDate;

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score=score;
    }

    public Date getPlayDate(){
        return playDate;
    }
    public void setPlayDate(Date playDate){
        this.playDate=playDate;
    }
    //Объединяем все атрибуты в строку и в конце добавляем
    // символ перевода на новую строку.

    public  String toString(){
        String scoreString = firstName +" "+
                lastName + " "+ score+ " "+ playDate +
                System.getProperty("line.separator");
        return scoreString;
    }

    Score (String imya,String familia,int  sc,Date Date1){
    firstName=imya;
        lastName = familia;
        score = sc;
        playDate = Date1;
    }

}
