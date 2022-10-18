import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


// https://www.tutorialspoint.com/how-can-we-create-a-login-form-in-java
public class createUser extends JFrame implements ActionListener {

    public int line_num;
    public String user_name;
    public String id;
    public String password;
    public String email;
    JPanel panel;
    JLabel user_label, password_label, email_label, id_label, message;
    JTextField userName_text,email_text, id_text;
    JPasswordField password_text;
    JButton submit, cancel;
    createUser() {
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();
        //Email
        email_label = new JLabel();
        email_label.setText("Email: ");
        email_text = new JTextField();
        //ID
        id_label = new JLabel();
        id_label.setText("ID :");
        id_text = new JTextField();
        // Submit
        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(5, 1));
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);
        panel.add(id_label);
        panel.add(id_text);
        panel.add(email_label);
        panel.add(email_text);
        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Create User");
        setSize(400,250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        user_name = userName_text.getText();
        password = password_text.getText();
//        int id = Integer.parseInt(id_text.getText());
        id = id_text.getText();
        email = email_text.getText();
        JOptionPane.showMessageDialog(null,"Hello " + user_name + ", Welcome to CU!");

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("Users.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(user_name + "," + password + "," + id + "," + email);
//            FileWriter myWriter = new FileWriter("C:\\Users\\nirb2\\IdeaProjects\\CU\\Users.txt");
//            myWriter.write(user_name + "," + password+ "," + id + "," + email);
//            myWriter.close();

            pw.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);

        }
    }




}
