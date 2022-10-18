import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class forgetPassword extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user_label, id_label, message;
    JTextField userName_text, id_text;
    JButton submit, cancel;

    forgetPassword() {
        // Username Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();

        id_label = new JLabel();
        id_label.setText("ID :");
        id_text = new JTextField();

        // Submit
        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(3, 2));
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(id_label);
        panel.add(id_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Forget my password");
        setSize(400, 175);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = userName_text.getText();
        int id = Integer.parseInt(id_text.getText()); // the ID that the user enter
        Search s = new Search();
        try {
            String password = s.GetPasswordFromUsername(userName); // the password from the database.
            if (s.GetIDFromUsername(userName).equals("null")){ // if the user_name isn't in the database.
                message.setText("User name is incorrect.");
            }
            else {
                int id_database = Integer.parseInt(s.GetIDFromUsername(userName)); // ID from the data of the user.
                if ((id == id_database) && (!password.equals("null"))) {
                    message.setText("Your password is: " + password);
                }
                else {
                    message.setText("ID is incorrect.");
                }
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
