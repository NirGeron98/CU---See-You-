import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
public class loginDemo extends JFrame implements ActionListener {

    //https://www.tutorialspoint.com/how-can-we-create-a-login-form-in-java

//    public String user_password;
//    public String user_name;
    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;
    loginDemo() {
        // Username Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();
        // Submit
        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);
        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Log in");
        setSize(425,200);
        setVisible(true);

//        user_name = userName_text.getText();
//        user_password = password_text.getText();

    }


//    public static void main(String[] args) {
//        new loginDemo();
//    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = userName_text.getText();
        String password = password_text.getText();

        Search s = new Search();
        try {
            if (s.GetPasswordFromUsername(userName).equals(password)){
                message.setText("Login successfully");
            }
            else {
                message.setText("User name or password incorrect");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//        if (userName.trim().equals("admin") && password.trim().equals("admin")) {
//            message.setText(" Hello " + userName + "");
//        } else {
//            message.setText(" Invalid user.. ");
//        }
    }

//    public Boolean checkValid() throws FileNotFoundException {
//        Search s = new Search();
//        String password = s.SearchPasswordByUsername(user_name);
//        if (password.equals(user_password)){
//            message.setText("Login successfully");
//        }
//        message.setText("User name or password incorrect");
//        return null;
//    }


}