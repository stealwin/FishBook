/**
 * Created by Viacheslav on 18.09.2018.
 */
import javax.swing.*;
import java.awt.*;

public class Calculator {
    //объяление  всех компонентов калькулятора
   // Button numButtons[];
    JPanel windowContent;
    JTextField displayField;
    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonPoint;
    JButton buttonEqual;
    JButton buttonMinus;
    JButton buttonDivide;
    JButton buttonPlus;
    JButton buttonUmnoj;
    JPanel p1,p2;

    /* В конструкторе создаются все компоненты и добавляются на фрейм
    * с помощью комбинации BorderLayout и GridLayout*/
    Calculator(){
        windowContent = new JPanel();
        //Задаем схему для этой панели
        BorderLayout b1 = new BorderLayout();
        windowContent.setLayout(b1);
        // Cоздаем и отображаем поле, добавляем его в Северную область окна
        displayField = new JTextField(30);
        windowContent.add("North",displayField);
        /*Создаем кнопки, используя конструктор Jbutton
        c текстом кнопки как параметр
        * */
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        //numButtons = new Button[10];
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");
        /*Создание GridLayout с 12 кнопками - где 10 кнопок
        * с числами, остальные  - знаки*/
        p1 = new JPanel();
       /* p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));*/
        GridLayout g1 = new GridLayout(4,3);
        p1.setLayout(g1);
        // Добавляем кнопки на панель p1
        /*for (int i=0;i<=9;i++){
            numButtons[i]=new Button(""+i);

           p1.add(numButtons[i]) ;
        }*/
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(button0);
        p1.add(buttonPoint);
        p1.add(buttonEqual);
        //Помещаем р1 в центральную область окна
        windowContent.add("Center",p1);

        // Практическое задание 1
        // Создание кнопок : +,-,/,*
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonDivide = new JButton("/");
        buttonUmnoj = new JButton("*");
        // Создание панели р2
        p2 = new JPanel();
        p2.setLayout(g1);
        // Добавляем кнопки на панель р2
        p2.add(buttonPlus);
        p2.add(buttonMinus);
        p2.add(buttonDivide);
        p2.add(buttonUmnoj);
        //Помещаем p2 в Восточную область основной панели
        windowContent.add("East",p2);
        // Cоздаем фрейм и задаем его основную панель
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
        // создаем окно, чтобы все компоненты в него вместились
        frame.pack();
        //Отображаем окно
        frame.setVisible(true);

        CalculatorEngine calcEngine = new CalculatorEngine(this);
        button0.addActionListener(calcEngine);
        button1.addActionListener(calcEngine);
        button2.addActionListener(calcEngine);
        button3.addActionListener(calcEngine);
        button4.addActionListener(calcEngine);
        button5.addActionListener(calcEngine);
        button6.addActionListener(calcEngine);
        button7.addActionListener(calcEngine);
        button8.addActionListener(calcEngine);
        button9.addActionListener(calcEngine);

        buttonPoint.addActionListener(calcEngine);
        buttonPlus.addActionListener(calcEngine);
        buttonMinus.addActionListener(calcEngine);
        buttonDivide.addActionListener(calcEngine);
        buttonUmnoj.addActionListener(calcEngine);
        buttonEqual.addActionListener(calcEngine);

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();


    }

}
