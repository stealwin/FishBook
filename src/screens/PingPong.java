package screens;

/**
 * Created by Viacheslav on 24.09.2018.
 */
import engine.PingPongEngine;

import javax.swing.*;
import java.awt.*;

/*Класс, который рисует стол для пинг-понга и отображает координаты
* точки, где пользователь кликнул мышью*/

public class PingPong extends JPanel implements GameConstants {
    JLabel label;

    private Point point = new Point(0,0);
    public int computerRacket_Y = COMPUTER_RACKET_Y_START;
    private int kidRacket_Y=KID_RACKET_Y_START;
    private int ballx = BALL_START_X;
    private int bally = BALL_START_Y;


    Dimension prefferedSize = new Dimension(TABLE_WIDTH,TABLE_HEIGHT);
    /*Метод устанавливает размер, вызывается джава машиной*/

    public Dimension getPrefferedSize(){
        return prefferedSize;
    }
    // конструктор для обработки событий мыши
    PingPong(){
        PingPongEngine gameEngine = new PingPongEngine(this);
        //addMouseListener(gameEngine);
        //Обрабатывет движение мыши для передвижения ракеток
        addMouseMotionListener(gameEngine);
        //Обрабатывем событие клаиватур
        addKeyListener(gameEngine);
    }

    //Добавить панель с Jlabel в окно
    void addPaneltoFrame(Container container){
        container.setLayout(new BoxLayout(container,
                BoxLayout.Y_AXIS));
        container.add(this);
        label = new JLabel("Нажми N для новой игры" +
                " S подать мяч или Q чтобы выйти");
        container.add(label);

    }
    /*Перерисовать окно.Этот метод вызывается виртуальной
    * машиной, когда нужно обновить экран или вызывается
    * метод repaint() из PingPongEngine*/
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        //Рисуем стол
        g.fillRect(0,0,TABLE_WIDTH,TABLE_HEIGHT);

        //Рисуем правую ракетку
        g.setColor(Color.yellow);
        g.fillRect(KID_RACKET_X,kidRacket_Y,RACKET_WIDTH,
                RACKET_LENGTH);

        //Рисуем левую ракетку
        g.setColor(Color.blue);
        g.fillRect(COMPUTER_RACKET_X,computerRacket_Y,RACKET_WIDTH,
                RACKET_LENGTH);

        //рисуем мяч
        g.setColor(Color.red);
        g.fillOval(ballx,bally,10,10);
//рисуем белые линии
        g.setColor(Color.white);
        g.drawRect(10,10,300,200);
        g.drawLine(160,10,160,210);
        //установить фокус на стол,
        //чтобы обработчик клавиатуры мог посылать команты столу
        requestFocus();
        // Отобразить точку как маленький квадрат 2x2 пикселей
       /* if (point != null) {
            label.setText("Координаты (x,y): " + point.x +
                    ", " + point.y);
            g.fillRect(point.x, point.y, 2, 2);
            repaint();*/


    }
    //устанавливаем текущее положение ракетки игрока
    public void setKidRacket_Y(int yCoordinate){
        this.kidRacket_Y=yCoordinate;
        repaint();
    }
    //Вернуть текущее положение ракетки игрока
    public int getKidRacket_Y( ){
        return kidRacket_Y;
    }
    public void setComputerRacket_Y(int yCoordinate) {
        this.computerRacket_Y=yCoordinate;
        repaint();
    }
    //устанавливаем игровое сообщение
    public void setMessageText(String text){
        label.setText(text);
        repaint();
    }
    //устанавливаем позицию мяча
    public void setBallPosition(int xPos, int yPos){
        ballx=xPos;
        bally=yPos;
        repaint();
    }
    public void setPointCoordinates(int x, int y){
        point.x = x;
        point.y = y;
    }
    public static void main(String[] args) {
        //cоздаем экземпляр окна
        JFrame f = new JFrame("Игра пинг-понг");
        // Убедиться, что окно закроется по нажатию крестика
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PingPong table = new PingPong();
        table.addPaneltoFrame(f.getContentPane());
        //устанавливаем размер окна и делаем его видимым
       f.setBounds(0,0,TABLE_WIDTH+5,TABLE_HEIGHT+40);
        f.setVisible(true);

    }
}
