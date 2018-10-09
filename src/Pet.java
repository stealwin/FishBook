/**
 * Created by Admin on 01.08.2018.
 */
public class Pet {
    protected int age;
    protected float weight;
    protected  float height;
    protected String color;

    public int getAge(){
        return age;
    }
    public void setAge(){
        this.age=age;
    }
    public void sleep(){
        System.out.println("Спокойной ночи! До завтра");
    }
    public void eat(){
        System.out.println("Я очень голоден, давайте перекусим чипсами");
    }
    public String say(String aWord){
        String petResponse = "Ну ладно!! "+ aWord;
        return petResponse;
    }

}
