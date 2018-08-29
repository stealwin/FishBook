/**
 * Created by viachslav on 29.08.2018.
 */
public class Car {
    public void start(){
        System.out.println("Движок стартанул");
    }
    public void stop(){
        System.out.println("Тормознул знатно, дядя");
    }
    public void drive(int howlong){
        int distance= howlong*60;
        System.out.println("За час продристал "+ distance);
    }
}
