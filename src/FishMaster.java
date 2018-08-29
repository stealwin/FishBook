/**
 * Created by Admin on 01.08.2018.
 */
public class FishMaster {
    public static void main(String[] args) {
        Fish myFish = new Fish();

        myFish.dive(2);

        myFish.dive(96);
        myFish.dive(5);
        System.out.println(myFish.say("sdsadas"));
        myFish.sleep();

    }
}
