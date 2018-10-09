import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Viacheslav on 22.09.2018.
 */
public class OrderWindow implements ActionListener {
    JPanel windowContent;
    JPanel buttonContent;
    JTextField bicycleModel;
    JTextField txtQuantity;
    JTextField txtFieldOrderConfirmation;
    JButton setOrder;
    // Создаем панель и размещаем ее на слои
    // на панель размещаем два текстовых поля

    OrderWindow() {
        windowContent = new JPanel();
        bicycleModel = new JTextField();
        txtQuantity = new JTextField();
        txtFieldOrderConfirmation = new JTextField();
        GridLayout g1 = new GridLayout(3, 3);
        windowContent.setLayout(g1);
        windowContent.add(bicycleModel);
        windowContent.add(txtQuantity);
        // создаем панель, кнопку и  схему для размещения кнопки
        buttonContent = new JPanel();
        setOrder = new JButton("Разместить заказ");
        setOrder.addActionListener(this);
        buttonContent.setLayout(g1);
        buttonContent.add(setOrder);
        buttonContent.add(txtFieldOrderConfirmation);
        windowContent.add(buttonContent);
        JFrame frame = new JFrame();
        frame.setContentPane(windowContent);
        // создаем окно, чтобы все компоненты в него вместились
        frame.pack();
        //Отображаем окно
        frame.setVisible(true);
        //получение информации с текстовых полей


    }

    public void actionPerformed(ActionEvent e) {
        String selectedModel = bicycleModel.getText();
        String selectedQuantity = txtQuantity.getText();
        int quantity = Integer.parseInt(selectedQuantity);

        setOrder = (JButton) e.getSource();
        if ("".equals(bicycleModel) & "".equals(txtQuantity)) {
            javax.swing.JOptionPane.showConfirmDialog(null, "" +
                    "Введите данные", "Невозможно оформить" +
                    "заказ", JOptionPane.PLAIN_MESSAGE);

        }

        try {

            this.checkOrder("FireBird", quantity);
            //следующая строка не выполняется в случае исключения
            txtFieldOrderConfirmation.setText("Размещение" +
                    "вашего заказа завершено");
        } catch (TooManyBikesException e1) {
            txtFieldOrderConfirmation.setText(e1.getMessage());
        }
    }

    void checkOrder(String bikeModel, int quantity)
            throws TooManyBikesException {
        bikeModel = bicycleModel.getText();

        if (bikeModel.equals("Step") && quantity > 3) {
            throw new TooManyBikesException( "Невозможно" +
                    "доставить " + quantity + "велосипедов" +
                    "модели " + bikeModel +
                    "за одну доставку"){
                 };
            };


        }







public static void main(String[] args) {
        OrderWindow order1 = new OrderWindow();
    }}
