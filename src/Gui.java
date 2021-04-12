import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Gui extends JFrame {

    private Table table = new Table();
    private DefaultTableModel model = new DefaultTableModel();
    private JTable table1 = new JTable( model);


    private JButton button = new JButton("Subbmit");
    private JTextField name = new JTextField("", 0); //text то что будет внутри контейнера  для ввода написано
    private JLabel inputname = new JLabel(" Input your name : ");
    private JLabel inputmail = new JLabel(" Input your e-mail : ");
    private JTextField mail = new JTextField("", 3);
    private JScrollPane jScrollPane = new JScrollPane(table1);

    public Gui() throws FileNotFoundException {
        super("Good jobs");
        this.setBounds(700, 350, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container container = this.getContentPane();

        container.setLayout(new GridLayout(6, 3, 2, 2));

        //Заменить в дальнейшем
        Object[] columnsHeader = table.getColumnsHeader();
        Object[][] array = table.getArray();

        //добавление колонок
        for (int i = 0; i < columnsHeader.length;i++){
            model.addColumn(columnsHeader[i]);
        }
        //добавление полей
        for (int i = 0; i < array.length;i++){
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

    class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Users users = new Users(name.getText(), mail.getText());
            Validation validationUsers = new Validation();
            String message = validationUsers.validationUsers(users);


            if (message.equals("check")) {
                new WorkFile().toSaveUsers(users);
                message = "Данные успешно добавлены!";
                mail.setText(""); //обнуление поля имейл
                name.setText(""); //обнуление поля имени
                model.addRow(new Object[]{users.getName(),users.geteMail()}); //добавление заполненых данных

            }

            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }


}
