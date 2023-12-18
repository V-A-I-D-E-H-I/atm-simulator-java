
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    // GUI components:
    JButton login, signUp, clear;
    JTextField cardInput;
    JPasswordField pinInput;
    
    // Constructor:
    public Login() {
        // Using BorderLayout for better organization
        setLayout(new BorderLayout(5, 5));
        
        // Creating panels for different sections
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 2, 2));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        getContentPane().setBackground(new Color(70, 150, 180));

        // Initializing components with new styles
        cardInput = new JTextField();
        cardInput.setFont(new Font("Arial", Font.BOLD, 10));

        pinInput = new JPasswordField();
        pinInput.setFont(new Font("Arial", Font.BOLD, 10));

        login = new JButton("Login");
        styleButton(login);
        login.addActionListener(this);

        signUp = new JButton("Sign Up");
        styleButton(signUp);
        signUp.addActionListener(this);


        clear = new JButton("Clear");
        styleButton(clear);

        // Adding components to panels
        inputPanel.add(new JLabel("Sap ID:"));
        inputPanel.add(cardInput);
        
        


        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(pinInput);


        buttonPanel.add(login);
        buttonPanel.add(signUp);
        buttonPanel.add(clear);

        // Adding panels to frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Frame properties
        setTitle("Login Form for Student Scolarship");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.BLACK);
    }

    // Event handling (remains the same)
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUp) {
            this.setVisible(false);
            new S1().setVisible(true);
        }

        if (e.getSource() == login) {
            this.setVisible(false);
            new Neww().setVisible(true);
        }


    }

    // Main method to run the application
    public static void main(String[] args) {
        new Login();
    }
}
