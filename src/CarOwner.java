/**
 * Created by viachslav on 29.08.2018.
 */
public class CarOwner {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start();
        myCar.stop();
        myCar.drive(5);
        Car car = new JamesBondCar();
        car.start();
        car.drive(5);
    }

}
