import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class S1 extends JFrame implements ActionListener {
    JTextField nameInput, fNameInput, emailInput, adressInput;
    JButton next;
    Random random;
    long randomNo;
    JRadioButton male, female, Placement, MBA, Masters;
    JDateChooser dateChooser;

    // Constructor:
    public S1() {
        setLayout(null);
        // Frame
        setSize(1500, 1000);
        setVisible(true);
        setLocation(300, 0);
        setTitle("Create new account");
        // getContentPane().setBackground(Color.LIGHT_GRAY);
        getContentPane().setBackground(new Color(70, 150, 180));

        // Random Form No:
        random = new Random();
        // System.out.println((Math.abs(random.nextLong())%9000) + 1000);
        randomNo = Math.abs((random.nextLong() % 9000L) + 1000L);
        // System.out.println(randomNo);
        // Form No:
        JLabel formNo = new JLabel("Application Form No: " + randomNo);

        formNo.setFont(new Font("Times New Roman", Font.BOLD, 18));

        // formNo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        // formNo.setFont(new Font("Ariel", Font.BOLD, 38));
        formNo.setBounds(240, 20, 600, 40);
        add(formNo);
        // personalDetails
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Algerian", Font.BOLD, 26));
        personalDetails.setBounds(340, 80, 600, 30);
        add(personalDetails);
        // name
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        name.setBounds(250, 140, 100, 40);
        add(name);
        // Input
        nameInput = new JTextField();
        nameInput.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
        nameInput.setBounds(330, 140, 600, 40);
        nameInput.setBackground(Color.LIGHT_GRAY);
        add(nameInput);
        // FathersName
        JLabel fathersName = new JLabel("Father's Name:");
        fathersName.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        fathersName.setBounds(170, 190, 200, 40);
        fathersName.setBackground(Color.LIGHT_GRAY);
        add(fathersName);
        // Input
        fNameInput = new JTextField();
        fNameInput.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
        fNameInput.setBounds(330, 190, 600, 40);
        fNameInput.setBackground(Color.LIGHT_GRAY);
        
        add(fNameInput);
        // DOB
        JLabel dOB = new JLabel("Date Of Birth: ");
        dOB.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        dOB.setBounds(120, 240, 200, 40);
        // dateChooser.setBackground(Color.LIGHT_GRAY);
        add(dOB);
        // dateInput - Calender
        // prequisit - Jar file add, com. - package import
        dateChooser = new JDateChooser();
        dateChooser.setBounds(330, 240, 600, 40);
        // dateChooser.setBackground(Color.LIGHT_GRAY);
        add(dateChooser);

        // gender
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        gender.setBounds(150, 290, 200, 40);
        gender.setBackground(Color.LIGHT_GRAY);
        add(gender);
        // radio button
        male = new JRadioButton("Male");
        male.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
        male.setBounds(330, 290, 80, 30);
        male.setBackground(Color.LIGHT_GRAY);
        add(male);
        // radio button female
        female = new JRadioButton("Female");
        female.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
        female.setBounds(450, 290, 80, 30);
        female.setBackground(Color.LIGHT_GRAY);
        add(female);
        // Only one RButton should be selected
        ButtonGroup genderBtnGroup = new ButtonGroup();
        genderBtnGroup.add(male);
        genderBtnGroup.add(female);

        // email
        JLabel email = new JLabel("Email Address");
        email.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        email.setBounds(140, 340, 200, 40);
        add(email);
        // Input
        emailInput = new JTextField();
        emailInput.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
        emailInput.setBounds(330, 340, 600, 40);
        emailInput.setBackground(Color.LIGHT_GRAY);
        add(emailInput);
        // Future Plan
        JLabel future = new JLabel("Future Plan: ");
        future.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        future.setBounds(190, 390, 200, 40);
        add(future);
        // radio button
        MBA = new JRadioButton("MBA");
        MBA.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
        MBA.setBounds(330, 390, 80, 40);
        MBA.setBackground(Color.LIGHT_GRAY);
        add(MBA);
        // radio button
        Placement = new JRadioButton("Placement");
        Placement.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
        Placement.setBounds(450, 390, 100, 30);
        Placement.setBackground(Color.LIGHT_GRAY);
        add(Placement);
        // radio button
        Masters = new JRadioButton("Masters");
        Masters.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
        Masters.setBounds(580, 390, 80, 30);
        Masters.setBackground(Color.LIGHT_GRAY);
        add(Masters);
        // Only one Radio-Button should be selected
        ButtonGroup futureBtnGroup = new ButtonGroup();
        futureBtnGroup.add(MBA);
        futureBtnGroup.add(Placement);
        futureBtnGroup.add(Masters);
        // address
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        address.setBounds(240, 440, 200, 40);
        add(address);
        // Input
        adressInput = new JTextField();
        adressInput.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
        adressInput.setBounds(330, 440, 600, 30);
        adressInput.setBackground(Color.LIGHT_GRAY);
        add(adressInput);

        next = new JButton("Next");
        next.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
        next.setBounds(824, 660, 100, 34);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.LIGHT_GRAY);
        next.addActionListener(this);
        add(next);

    }
    public void createTableIfNotExists() {
        try {
            Conn c = new Conn();
            Statement stmt = c.s;
            String query = "CREATE TABLE IF NOT EXISTS signuponenew ("
    + "formno VARCHAR(10),"
    + "name VARCHAR(100),"
    + "fName VARCHAR(100),"
    + "dob DATE,"
    + "gender VARCHAR(10),"
    + "email VARCHAR(100),"
    + "futureplan VARCHAR(20),"
    + "adress VARCHAR(200)"
    + ")";

            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent ae) {
        // Data store => variables => String
        createTableIfNotExists();
        String formno = "" + randomNo; // Long convert String "" +
        String name = nameInput.getText(); // getText() vs setText()
        String fName = fNameInput.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        String future = null;
        if (Placement.isSelected()) {
            future = "Placement";
        } else if (MBA.isSelected()) {
            future = "MBA";
        } else {
            future = "Masters";
        }
        String email = emailInput.getText();
        String adress = adressInput.getText();

        try {
            // Validation
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name required");
            } else if (fName.equals("")) {
                JOptionPane.showMessageDialog(null, "Father Name required");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "DOB required");
            } else if (gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Gender required");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email required");
            } else if (adress.equals("")) {
                JOptionPane.showMessageDialog(null, "Address required");
            } else if (future.equals("")) {
                JOptionPane.showMessageDialog(null, "Future Plan required");
            }  else {
                // Step 4: Execute query
                Conn c = new Conn();
                String query = "insert into signuponenew values('" + formno + "','" + name + "','" + fName + "','" + dob
    + "','" + gender + "','" + email + "','" + future + "','" + adress + "')";

                c.s.executeUpdate(query);

                setVisible(false);
                new S2(formno).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        new S1();
    }
}