import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class S2 extends JFrame implements ActionListener {
    JTextField panInput, adharInput;
    JComboBox  incomeInput, educationalInput, qualificationInput;
    JButton next;
    JRadioButton yesworkexp, noworkexp, exiAccYesInput, exiAccNoInput;
    String formno;

    // constructor:
    public S2(String formno) {
        this.formno = formno;
        
        setLayout(null);
        setSize(1000, 900);
        setVisible(true);
        setLocation(300, 0);
        setTitle("New Account Application Form Page 2");
        getContentPane().setBackground(new Color(70, 150, 180));

        // additionalDetails
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Algerian", Font.BOLD, 26));
        additionalDetails.setBounds(230, 80, 600, 30);
        add(additionalDetails);

        JLabel income = new JLabel("Family Income");
        income.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        income.setBounds(100, 240, 400, 30);
        add(income);
        // Input
        String[] incomeList = { "---Select Income---", "Null", "< 1,50,000", "< 2,50,000", "< 500,000",
                "up to 10,00,000", "OTHER" };
        incomeInput = new JComboBox(incomeList);
        incomeInput.setBackground(Color.WHITE);
        incomeInput.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
        incomeInput.setBounds(330, 240, 600, 30);
        incomeInput.setBackground(Color.LIGHT_GRAY);
        add(incomeInput);

        // educational
        JLabel educational = new JLabel("Education");
        educational.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        educational.setBounds(100, 290, 400, 30);
        educational.setBackground(Color.LIGHT_GRAY);
        add(educational);

        // Input
        String[] educationList = { "---Select Educational Qualification---", "Non-Graduate", "Graduate",
                "Post Graduate", "Doctrate", "OTHER" };
        educationalInput = new JComboBox(educationList);
        educationalInput.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
        educationalInput.setBounds(330, 290, 600, 30);
        educationalInput.setBackground(Color.LIGHT_GRAY);
        add(educationalInput);
        // pan
        JLabel pan = new JLabel("PAN No:");
        pan.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        pan.setBounds(100, 390, 200, 30);
        pan.setBackground(Color.LIGHT_GRAY);
        // pan.setBounds(100, 440, 200, 30);
        add(pan);
        // Input
        panInput = new JTextField();
        panInput.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
        panInput.setBounds(330, 390, 600, 30);
        panInput.setBackground(Color.LIGHT_GRAY);
        // panInput.setBounds(330, 440, 600, 30);
        add(panInput);
        // adhar
        JLabel adhar = new JLabel("Aadhar No:");
        adhar.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        adhar.setBounds(100, 440, 200, 30);
        adhar.setBackground(Color.LIGHT_GRAY);
        // adhar.setBounds(100, 490, 200, 30);
        add(adhar);
        // Input
        adharInput = new JTextField();
        adharInput.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
        adharInput.setBounds(330, 440, 600, 30);
        adharInput.setBackground(Color.LIGHT_GRAY);
        // adharInput.setBounds(330, 490, 600, 30);
        add(adharInput);
        // senior citizen
        JLabel senior = new JLabel("Work Experience : ");
        senior.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        senior.setBounds(100, 490, 400, 30);
        // senior.setBounds(100, 540, 200, 30);
        add(senior);

        // radio button
        yesworkexp = new JRadioButton("Yes");
        yesworkexp.setBounds(330, 490, 80, 30);
        yesworkexp.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        // Yesworkexp.setBounds(330, 540, 80, 30);
        yesworkexp.setBackground(Color.LIGHT_GRAY);
        add(yesworkexp);
        // radio button
        noworkexp = new JRadioButton("No");
        noworkexp.setBounds(450, 490, 80, 30);
        noworkexp.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        noworkexp.setBackground(Color.LIGHT_GRAY);
        add(noworkexp);
        // Only one Radio-Button should be selected
        ButtonGroup seniorBtnGroup = new ButtonGroup();
        seniorBtnGroup.add(yesworkexp);
        seniorBtnGroup.add(noworkexp);

        // exixtingAccount
        JLabel exixtingAccount = new JLabel("Existing KTs: ");
        exixtingAccount.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        exixtingAccount.setBounds(100, 540, 300, 30);
        add(exixtingAccount);
        // Input
        // radio button
        exiAccYesInput = new JRadioButton("Yes");
        exiAccYesInput.setBounds(330, 540, 80, 30);
        exiAccYesInput.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        exiAccYesInput.setBackground(Color.LIGHT_GRAY);
        add(exiAccYesInput);
        // radio button
        exiAccNoInput = new JRadioButton("No");
        exiAccNoInput.setBounds(450, 540, 80, 30);
        exiAccNoInput.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        exiAccNoInput.setBackground(Color.LIGHT_GRAY);
        add(exiAccNoInput);
        // Only one Radio-Button should be selected
        ButtonGroup exiAccBtnGroup = new ButtonGroup();
        exiAccBtnGroup.add(exiAccYesInput);
        exiAccBtnGroup.add(exiAccNoInput);
        // Button
        next = new JButton("Next");
        next.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
        next.setBounds(824, 600, 100, 34);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

    }
     public void createTableIfNotExists() {
        try {
            Conn c = new Conn();
            Statement stmt = c.s;
            String query = "CREATE TABLE IF NOT EXISTS signuptwonew ("
        + "formno VARCHAR(10),"
        + "income VARCHAR(100),"
        + "education VARCHAR(100),"
        + "pan VARCHAR(20),"
        + "adhar VARCHAR(20),"
        + "senior VARCHAR(5),"
        + "existingAcc VARCHAR(5)"
        + ")";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent ae) {
        createTableIfNotExists();
   
        String income = (String) incomeInput.getSelectedItem();
        String education = (String) educationalInput.getSelectedItem();
        String pan = panInput.getText(); // getText() vs setText()
        String adhar = adharInput.getText();
        String senior = null;
        if (yesworkexp.isSelected()) {
            senior = "Yes";
        } else {
            senior = "No";
        }

        String existingAcc = null;
        if (exiAccYesInput.isSelected()) {
            existingAcc = "Yes";
        } else {
            existingAcc = "No";
        }

        try {
            // Step 4: Execute query
            Conn c = new Conn();
            String query = "insert into signuptwonew values('" + formno +  "','"
            + income + "','" + education + "','" + pan + "','" + adhar + "','" + senior + "','"
            + existingAcc + "')";
    
            c.s.executeUpdate(query);
            //close signupTwo
            setVisible(false);
            new Fetch(formno);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        new S2("");
    }
}
