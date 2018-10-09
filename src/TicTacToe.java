import javafx.scene.layout.Pane;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

/**
 * Created by Viacheslav on 21.09.2018.
 * Игра крестики-нолики на доске 3х3
 */
public class TicTacToe extends Applet implements ActionListener {
    Button squares[];
    Button newGameButton;
    Label score;
    Label winScores;
    Label looseScores;
    int wins,loose;
    int emptySquaresLeft = 9;

    //Метод init() - конструктор апплета
    public void init() {
        //Установка мнеджера располоения апплета, цвета и шрифта
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        /*Изменяем шрифт апплета, его размер 20 и стиль - жирный*/
        Font appletFont = new Font("Monospased", Font.BOLD, 20);
        this.setFont(appletFont);
        /*Создаем кнопку "New Game" и регистрируем в ней слушатель
        * действия*/
        newGameButton = new Button("New Game");
        newGameButton.addActionListener(this);

        Panel topPanel = new Panel();
        winScores = new Label();
        looseScores= new Label();
        topPanel.add(winScores);
        topPanel.add(newGameButton);
        topPanel.add(looseScores);
        this.add(topPanel, "North");

        Panel centralPanel = new Panel();
        centralPanel.setLayout(new GridLayout(3, 3));
        this.add(centralPanel, "Center");

        score = new Label("Your turn!");
        this.add(score, "South");
        // создадим массив, чтобы хранить ссылки на 9 кнопок

        squares = new Button[9];
        /*Создаем кнопки, сохраняем ссылки на них в массиве
        * регистрируем слушатель и красим в оранжевый цвет,
        * и добавляем на панель*/
        for (int i = 0; i < 9; i++) {
            squares[i] = new Button();
            squares[i].addActionListener(this);
            squares[i].setBackground(Color.ORANGE);
            centralPanel.add(squares[i]);
        }

    }

    public void actionPerformed(ActionEvent e) {
        Button theButton = (Button) e.getSource();
        //Это кнопка Новой игры?

        if (theButton == newGameButton) {
            for (int i = 0; i < 9; i++) {
                squares[i].setEnabled(true);
                squares[i].setLabel("");
                squares[i].setBackground(Color.ORANGE);
            }
            emptySquaresLeft = 9;
            score.setText("your turn!");
            newGameButton.setEnabled(false);
            return; //выходим из метода
        }
        String winner = "";
        // Это одна из клеток?
        for (int i = 0; i < 9; i++) {
            if (theButton == squares[i]) {
                squares[i].setLabel("X");
                squares[i].setEnabled(false);
                winner = lookForWinner();
                if (!"".equals(winner)) {
                    endTheGame();
                } else {
                    computerMove();
                    winner = lookForWinner();
                    if (!"".equals(winner)) {
                        endTheGame();
                    }
                }
                break;
            }
        } //конец цикла for
        if (winner.equals("X")) {
            score.setText("Ti pobedil!");
            wins=wins+1;
            winScores.setText("Побед: "+wins);
        } else if (winner.equals("O")) {
            score.setText("Ti proigral!");
            loose=loose+1;
            looseScores.setText(""+loose);
        } else if (winner.equals("T")) {
            score.setText("Nichiya!");
        }
    } //Конец метода actionPerformed




/*Метод, вызываемый после каждого хода, проверяющий наличие по
* вертикали, горизонтали или диагонали наличие трех одинаковых
* клеток( не пустых)
* @return "X","O","T" - ничья, ""- еще нет победителя*/
 String lookForWinner() {
     String theWinner = "";
     emptySquaresLeft--;
     if (emptySquaresLeft == 0) {
         return "T";//Ничья. "Т" - от англ. tie
     }
     // проверяем ряд 1 - элементы массива 0,1,2
     if (!squares[0].getLabel().equals("") &&
             squares[0].getLabel().equals(squares[1].getLabel()) &&
             squares[0].getLabel().equals(squares[2].getLabel())) {
         theWinner = squares[0].getLabel();
         highlightWinner(0, 1, 2);
         //проверяем 2й ряд - элементы массива 3,4,5
     } else if (!squares[3].getLabel().equals("") &&
             squares[3].getLabel().equals(squares[4].getLabel()) &&
             squares[3].getLabel().equals(squares[5].getLabel())) {
         theWinner = squares[3].getLabel();
         highlightWinner(3, 4, 5);
         //проверяем 3й ряд - элементы массива 6,7,8
     } else if (!squares[6].getLabel().equals("") &&
             squares[6].getLabel().equals(squares[7].getLabel()) &&
             squares[6].getLabel().equals(squares[8].getLabel())) {
         theWinner = squares[6].getLabel();
         highlightWinner(6, 7, 8);
//проверяем 1ю колонку с элементами массива 0,3,6
     } else if (!squares[0].getLabel().equals("") &&
             squares[0].getLabel().equals(squares[3].getLabel()) &&
             squares[0].getLabel().equals(squares[6].getLabel())) {
         theWinner = squares[0].getLabel();
         highlightWinner(0, 3, 6);
         //проверяем 2ю колонку с элементами массива 1,4,7
     } else if (!squares[1].getLabel().equals("") &&
             squares[1].getLabel().equals(squares[4].getLabel()) &&
             squares[1].getLabel().equals(squares[7].getLabel())) {
         theWinner = squares[1].getLabel();
         highlightWinner(1, 4, 7);
         //проверяем 3ю колонку с элементами массива 2,5,8

     } else if (!squares[2].getLabel().equals("") &&
             squares[2].getLabel().equals(squares[5].getLabel()) &&
             squares[2].getLabel().equals(squares[8].getLabel())) {
         theWinner = squares[2].getLabel();
         highlightWinner(2, 5, 8);
         // Проверяем первую диагональ - элементы массива 0,4,8
     } else if (!squares[0].getLabel().equals("") &&
             squares[0].getLabel().equals(squares[5].getLabel()) &&
             squares[0].getLabel().equals(squares[8].getLabel())) {
         theWinner = squares[0].getLabel();
         highlightWinner(0, 4, 8);
         // Проверяем вторую диагональ - элементы массива 2,4,6
     } else if (!squares[2].getLabel().equals("") &&
             squares[2].getLabel().equals(squares[4].getLabel()) &&
             squares[2].getLabel().equals(squares[6].getLabel())) {
         theWinner = squares[2].getLabel();
         highlightWinner(2, 4, 6);
     }
     return theWinner;
 }
/*Этот метод определяет луший ход, чтобы выиграть. Если
* клетка не найдена, то ход делается случайно*/
 void computerMove(){
     int selectedSquare;
 /*Сначала компьютер пытается найти пустую клетку
 * рядом с ноликом для выигрыша*/
    selectedSquare=findEmptySquare("O");
 /* Если у него не получается найти два нолика рядом, то он
 * попытается не дать оппоненту поставить 3 крестика,
 * загромоздив свой нолик*/
   if (selectedSquare == -1){
       selectedSquare=findEmptySquare("X");
   }
     /*Если selectedSquare == -1, то попытаеться занять
      * центральную клетку */
     if ((selectedSquare == -1) && (squares[4].getLabel().equals(""))) {
         selectedSquare = 4;
     }
     /*Если не получилось с центральной клеткой,
     * то занимаем любую*/
     if (selectedSquare == -1){
         selectedSquare=getRandomSquare();
     }
     squares[selectedSquare].setLabel("O");
     squares[selectedSquare].setEnabled(false);
 }
/*Этот метод проверяет каждую диагональ, колонку и ряд на
* наличие двух одинаковых  надписей и пустой клетки
* @param - "X" - передается для пользователя,"O" - для компа
* @return - количество свободных клеток или -1, если
* не найдено две клетки с одинаковыми надписями*/
    int findEmptySquare(String player) {
        int weight[] = new int[9];
        for (int i = 0; i < 9; i++) {
            if (squares[i].getLabel().equals("O")) {
                weight[i] = -1;
            } else if (squares[i].getLabel().equals("X")) {
                weight[i] = 1;
            } else {
                weight[i] = 0;
            }

        }
        int twoWeights = player.equals("O") ? -2 : 2;
        /*Проверим есть в 1м ряду две одинаковые клетки
        * и одна пустая*/
        if (weight[0] + weight[1] + weight[2] == twoWeights) {
            if (weight[0] == 0) {
                return 0;
            } else if (weight[1] == 0) {
                return 1;
            } else {
                return 2;
            }
        }
          /*Проверим есть в 2м ряду две одинаковые клетки
        * и одна пустая*/
            if (weight[3] + weight[4] + weight[5] == twoWeights) {
                if (weight[3] == 0)
                    return 3;
                 else if (weight[4] == 0)
                    return 4;
                 else
                    return 5;
                }
                /*Проверим есть в 3м ряду две одинаковые клетки
        * и одна пустая*/
                if (weight[6] + weight[7] + weight[8] == twoWeights) {
                    if (weight[6] == 0) {
                        return 6;
                    } else if (weight[7] == 0) {
                        return 7;
                    } else {
                        return 8;
                    }
                }
                     /*Проверим есть в 1й колонке две одинаковые клетки
        * и одна пустая*/
                    if (weight[0] + weight[3] + weight[6] == twoWeights) {
                        if (weight[0] == 0) {
                            return 0;
                        } else if (weight[3] == 0) {
                            return 3;
                        } else {
                            return 6;
                        }
                    }
         /*Проверим есть в 2й колонке две одинаковые клетки
        * и одна пустая*/
                        if (weight[1] + weight[4] + weight[7] == twoWeights) {
                            if (weight[1] == 0) {
                                return 1;
                            } else if (weight[4] == 0) {
                                return 4;
                            } else {
                                return 7;
                            }
                        }
        /*Проверим есть в 3й колонке две одинаковые клетки
        * и одна пустая*/
                            if (weight[2] + weight[5] + weight[8] == twoWeights) {
                                if (weight[2] == 0) {
                                    return 2;
                                } else if (weight[5] == 0) {
                                    return 5;
                                } else {
                                    return 8;
                                }
                            }
                /*Проверим есть ли в 1й диагонали две одинаковые клетки
        * и одна пустая*/
                                if (weight[0] + weight[4] + weight[8] == twoWeights) {
                                    if (weight[0] == 0) {
                                        return 0;
                                    } else if (weight[4] == 0) {
                                        return 4;
                                    } else {
                                        return 8;
                                    }
                                }
          /*Проверим есть ли во 2й диагонали две одинаковые клетки
        * и одна пустая*/
                                    if (weight[2] + weight[4] + weight[6] == twoWeights) {
                                        if (weight[2] == 0) {
                                            return 2;
                                        } else if (weight[4] == 0) {
                                            return 4;
                                        } else {
                                            return 6;
                                        }
                                    }
                                        // Не найдено двух одинаковых соседних клеток

        return -1;
    }// конец метода findEmptySquare()
    /*Этот метод выбирает любую пустую клетку
    * @return случайно выбранный номер клетки*/
        int getRandomSquare() {
            boolean gotEmptySquare = false;
            int selectedSquare = -1;
            do {
                selectedSquare = (int) (Math.random() * 9);
                if (squares[selectedSquare].getLabel().equals("")) {
                    gotEmptySquare = true; // чтобы закончить цикл
                }

            } while (!gotEmptySquare);
            return selectedSquare;
        } // конец метода getRandomSquare
    /* Метод, который выделяет выигравшую линию.
    * @param первая, вторая и третья клетки выделения*/
    void highlightWinner(int win1, int win2, int win3){
        squares[win1].setBackground(Color.CYAN);
        squares[win2].setBackground(Color.CYAN);
        squares[win3].setBackground(Color.CYAN);}

        // Делаем недоступными клетки и доступную кнопку "новая игра"

        void endTheGame(){
    newGameButton.setEnabled(true);
    for (int i=0;i<9;i++){
        squares[i].setEnabled(false);
    }
        }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
    }

} //конец класса
