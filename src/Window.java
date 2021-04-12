import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;


// Создание фрейма (Swing - окно)
public class Window extends JFrame {

    private Table table = new Table(new String[]{"name", "e-mail"}); //Таблица для отображения двухмерной информации в виде строк и столбцов
    private DefaultTableModel model = new DefaultTableModel();  //Модель для хранения значений ячеек таблицы
    private JTable jTable = new JTable(model);
    private JButton button = new JButton("Subbmit"); //Кнопка подтверждения ввода
    private JTextField name = new JTextField(""); //Контейнер для ввода Имени пользователя
    private JLabel inputname = new JLabel(" Input your name : "); //Информационное поле для навигации пользователя куда ввести Имя
    private JLabel inputmail = new JLabel(" Input your e-mail : ");//Информационное поле для навигации пользователя куда ввести электронную почту
    private JTextField mail = new JTextField(""); //Контейнер для ввода электронной почты пользователя
    private JScrollPane jScrollPane = new JScrollPane(jTable); //Таблица с бегунком


    public Window() throws FileNotFoundException {
        super("Good jobs");
        this.setBounds(700, 350, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /** ВСЕ, что лежит ниже этой строчки - не должно быть в конструкторе! **/
        Container container = this.getContentPane();

        container.setLayout(new GridLayout(6, 3, 2, 2));

        //Получение колонок и столбцов из файла
        Object[] columnsHeader = table.getColumnsHeader();
        Object[][] array = table.getArray();

        //добавление колонок
        for (int i = 0; i < columnsHeader.length; i++) {
            model.addColumn(columnsHeader[i]);
        }
        //добавление полей
        for (int i = 0; i < array.length; i++) {
            model.addRow(array[i]);
        }


        container.add(jScrollPane);
        container.add(inputname);
        container.add(name);
        container.add(inputmail);
        container.add(mail);
        button.addActionListener(new ButtonEventListener());
        container.add(button);

    }

    // Класс слушатель, действие по нажатию кнопки с интерфейса
    class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            User user = new User(name.getText(), mail.getText());
            Validation validationUsers = new Validation();
            String message = validationUsers.validationUsers(user);

            if (message.equals("check")) {
                new WorkFile().saveUser(user);
                message = "Данные успешно добавлены!"; // data has been added successfully
                mail.setText(""); //обнуление поля имейл
                name.setText(""); //обнуление поля имени
                model.addRow(new Object[]{user.getName(), user.geteMail()}); //добавление заполненых данных

            }

            // Информирование пользователя по нажатию на кнопку с интерфейса **/
            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }


}
