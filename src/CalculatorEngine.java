/**
 * Created by Viacheslav on 19.09.2018.
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JButton;
public class CalculatorEngine implements ActionListener {
    Calculator parent; //ccылка на окно калькулятора
    char selectedAction=' ';//+,-,/ или *
    double currentResult = 0;
    /*  Конструктор сохраняет ссылку на окно калькулятора
      в переменной экземпляра класса*/
    CalculatorEngine(Calculator parent){
        this.parent = parent;
    }
    public void actionPerformed(ActionEvent e){

        //Получаем источник события
        JButton clickedButton = (JButton)e.getSource();
        String dispFieldText=parent.displayField.getText();
        double displayValue = 0;
        /*Получить число из дисплея калькулятора, если
        * он не пустой.Восклицательный знак - оператор
        * отрицания*/
        if (!"".equals(dispFieldText)){
            try {
                displayValue=Double.parseDouble(dispFieldText);
            } catch (NumberFormatException e1) {
                javax.swing.JOptionPane.showConfirmDialog(null,"Пожалуйста введите число",
                        "Неправильный ввод", JOptionPane.PLAIN_MESSAGE);
                return;
            }
        }
        Object src = e.getSource();
        /*Для каждой кнопки арифметического действия запомнить его:
        * +, -, /, *, сохранить текущее число в переменной currentResult,
        * и очистить дисплей для ввода нового числа*/
        if (src == parent.buttonPlus){
            selectedAction = '+';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonMinus){
            selectedAction = '-';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonDivide){
            selectedAction = '/';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonUmnoj){
            selectedAction = '*';
            currentResult = displayValue;
            parent.displayField.setText("");
        }else if (src == parent.buttonEqual){
            /*Совершить арифметическое действие, в зависимости от
            * selectedAction, обновить переменную
            * currentResult и выставить резуьтать на экран*/
            if (selectedAction=='+'){
                currentResult+=displayValue;
                /*Сконвертировать результат в строку, добавляя его к
                * пустой строке и показать его*/
                parent.displayField.setText(""+currentResult);
            }else if (selectedAction=='-'){
                currentResult-=displayValue;
                parent.displayField.setText(""+currentResult);
            }else if (selectedAction=='/'){
                currentResult/=displayValue;
                parent.displayField.setText(""+currentResult);
                // Практическое упражнение " На нуль делить нельзя"
                if (displayValue==0){
                   parent.displayField.setText("На нуль делить нельзя");
                }
            }else if (selectedAction=='*'){
                currentResult*=displayValue;
                parent.displayField.setText(""+currentResult);
            }
        } else {
            /*Добавление надписи на цифровых кнопках,
            * к надписям на дисплеях*/
            String clickedButtonLabel = clickedButton.getText();
            parent.displayField.setText(dispFieldText+clickedButtonLabel);
        }
       /* // Получаем надпись на кнопке
        String clickedButtonLabel = clickedButton.getText();
        JOptionPane.showConfirmDialog(null, "You pressed "+ clickedButtonLabel,"Just a test",
                                        JOptionPane.PLAIN_MESSAGE);*/
    }
}
