package engine;
import screens.*;

import java.awt.event.*;

/**
 * Created by Viacheslav on 24.09.2018.
 */
public class PingPongEngine implements Runnable,MouseListener,
        MouseMotionListener,KeyListener,GameConstants {
   private PingPong table;
    private int kidRacket_Y= KID_RACKET_Y_START;
    private int computerRacket_Y=COMPUTER_RACKET_Y_START;
    private int kidScore;
    private int computerScore;
    private int ballx;
    private int bally;
    private boolean movingLeft=true;
    private boolean ballServed=false;

    //значение вертикального движения мяча в пикселях
    private int verticalSlide;

    // Конструктор. Ссылается на объект стола
    public PingPongEngine(PingPong greenTable){
        table = greenTable;
        Thread worker = new Thread(this);
        worker.start();
    }

    //Обязательные методы ищ интерфейся MouseMotionListener
    public void mouseDragged(MouseEvent e){};
    public void mouseMoved(MouseEvent e){
        int mouse_Y = e.getY();

        /*Если мышь находиться выше ракетки ребенка и не выходит
        * за пределы стола - передвинуть ее вверх,
        * в противном случае - опустить вниз*/
        if (mouse_Y<kidRacket_Y && kidRacket_Y>TABLE_TOP){
            kidRacket_Y-=RACKET_INCREMENT;
        }else if (kidRacket_Y<TABLE_BOTTOM){
            kidRacket_Y+=RACKET_INCREMENT;
        }
        //устанавливаем новое положение ракетки
        table.setKidRacket_Y(kidRacket_Y);
    };
    // обязательные методы из интерфейса KeyListener
    public void keyPressed(KeyEvent e){
        char key = e.getKeyChar();
        if ('n'==key ||'N'==key){
            startNewGame();
        }else if ('q'==key ||'Q'==key){
            endGame();

        } else if ('s'==key ||'S'==key){
            kidServe();
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
    //Начать новую игру
    public void startNewGame(){
        computerScore=0;
        kidScore=0;
        table.setMessageText("Очки Копьютер:0  Игрок:0");
        kidServe();
    }
    //Завершить игру
    public void endGame(){
        System.exit(0);
    }
    //Обязательный метод run из интерфейся Runnable
    public void run(){
        boolean canBounce = false;
        while (true){
            if (ballServed){//если мяч движется
                //Шаг1- мяч движется влево?
                if (movingLeft && ballx>BALL_MIN_X){
                    canBounce = (bally>= computerRacket_Y &&
                    bally< (computerRacket_Y+RACKET_LENGTH)
                            ?true: false);
                    ballx-=BALL_INCREMENT;
                //добавить смещение вверх или вниз к любым
            //движениям мяча влево и вправо
                 bally-=verticalSlide;
                    table.setBallPosition(ballx,bally);
                 //может отскочить?
                 if (ballx<= COMPUTER_RACKET_X && canBounce)  {
                     movingLeft = false;
                 }
                }
                //шаг2 - мяч движется вправо
        if (!movingLeft && ballx <= BALL_MAX_X){
            canBounce = (bally>= kidRacket_Y && bally<
                    (kidRacket_Y+RACKET_LENGTH)?true: false);

        ballx+=BALL_INCREMENT;
            table.setBallPosition(ballx,bally);
     //может отскочить?
            if (ballx>=KID_RACKET_X &&canBounce){
                movingLeft = true;
            }
        }

     /*Шаг3 - перемещать ракетку компьютера вверх или вниз, чтобы
     * блокировать мяч*/
        if (computerRacket_Y<bally &&
                computerRacket_Y<TABLE_BOTTOM){
            computerRacket_Y+=RACKET_INCREMENT;
        } else if (computerRacket_Y>TABLE_TOP){
            computerRacket_Y-=RACKET_INCREMENT;
        }
                table.setComputerRacket_Y(computerRacket_Y);

     //ШАг4 - приостановить
        try {
            Thread.sleep(SLEEP_TIME);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    //шаг5 - обновить счет, если мяч в зеленой области и не движется
     if (isBallOnTheTable()){
         if (ballx>BALL_MAX_X){
             computerScore++;
             displayScore();



         }else if (ballx<BALL_MIN_X){
             kidScore++;
             displayScore();




         }
     }
        }//конец if ballserved
        }//конец while
    }//конец run()

    //Подать с текущей позиции ракетки игрока
    private void kidServe(){
        ballServed = true;
        ballx=KID_RACKET_X-1;
        bally=kidRacket_Y;
      if (bally>TABLE_HEIGHT/2){
          verticalSlide=-1;
      }else {
          verticalSlide=1;}
          table.setBallPosition(ballx,bally);
          table.setKidRacket_Y(kidRacket_Y);

    }
    private void displayScore(){
        ballServed =false;
        if (computerScore ==WINNING_SCORE){
            table.setMessageText("Комп победил! "+computerScore
            +":"+ kidScore);
        }else if (kidScore == WINNING_SCORE){
            table.setMessageText("Ты победил! "+ kidScore+
            ":"+ computerScore);
        }else {
            table.setMessageText("Комп: "+ computerScore+
            "Игрок: "+ kidScore);
    }
}

/*Проверка - не пересек ли мяч верхнюю или нижнюю границу стола*/

private boolean isBallOnTheTable(){
if (bally>= BALL_MIN_Y && bally<=BALL_MAX_Y){
    return true;
}else {
    return false;
}
}

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        table.setPointCoordinates(e.getX(),e.getY());




    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
