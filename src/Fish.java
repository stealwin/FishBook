/**
 * Created by Admin on 01.08.2018.
 */
public class Fish extends Pet {
    int currentDepth;
    public int dive(int howDeep){
        currentDepth=currentDepth+howDeep;
        System.out.println("Ныряю на глубину "+ howDeep + " футов");
        System.out.println("Я на глубине " + currentDepth +" футов ниже уровня моря");
        return currentDepth;
    }
    public String say(String something) {
        return "Ты че не знаешь, что рыбы не разговаривают?";
    }
}
