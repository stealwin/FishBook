/**
 * Created by viachslav on 29.08.2018.
 */
public class TemperatureConverter {
    public void convertTemp(int temperature, char convertTo) {

        switch (convertTo) {
            case 'F':
                System.out.println(temperature + " градусов по Фаренгейту");
                break;
            case 'C':
                System.out.println(temperature + " градусов по Цельсию");
                break;

        }

    }


    public static void main(String[] args) {
        TemperatureConverter tc = new TemperatureConverter();
        tc.convertTemp(20,'F');
        tc.convertTemp(130,'C');

    }
    }
