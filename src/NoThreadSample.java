import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Viacheslav on 25.09.2018.
 */
public class NoThreadSample extends JFrame
 implements ActionListener, Runnable{

    //Конструктор
    NoThreadSample(){
        //Создаем окно с кнопкой и текстовым полем
        GridLayout g1 = new GridLayout(2,1);
        this.getContentPane().setLayout(g1);

        JButton myButton = new JButton("Kill time");
        myButton.addActionListener(this);

        this.getContentPane().add(myButton);
        this.getContentPane().add(new JTextField());
    }
    //Обработчик нажатия кнопки
    public void actionPerformed(ActionEvent e){
        /*Создать поток и выполнить "заморажи
        * вающий" код без блокировки*/
        Thread worker = new Thread(this);
        worker.start(); // вызывает метод run()



        }
    public void run(){
                /*Замоозка на некоторое время, чтобы
        * показать что окно заблокировано*/

        for (int i=0;i<30000;i++) {
            this.setTitle("i=" + i);
        }
    }

    public static void main(String[] args) {
        //созаем окно
        NoThreadSample myWindow = new NoThreadSample();
        //Убедиться, что окно закрывается при нажатии
        // на крестик в углу
        myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Установить размеры окна - координаты левого верхнего
        // угла и высоту с шириной
        myWindow.setBounds(0,0,150,100);
        // Делаем окно видимым
        myWindow.setVisible(true);
    }
}
