import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Gui extends JFrame {

    private Table table = new Table();
    private JTable table1 = new JTable(table.getArray(), table.getColumnsHeader());

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
            Users users = new Users(name.getText(),mail.getText());
            Validation validationUsers = new Validation();
            String message = validationUsers.validationUsers(users);


            if (message.equals("check")){
                new WorkFile().toSaveUsers(users);
                message = "Данные успешно добавлены!";
                mail.setText("");
                name.setText("");
            }

            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }


}
