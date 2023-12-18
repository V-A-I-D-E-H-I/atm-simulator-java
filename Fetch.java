import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel; // Import DefaultTableModel


public class Fetch extends JFrame {
    private JTable table;

    public Fetch(String formnno) {
        Conn c = new Conn();
        try {
            ResultSet resultSet = c.s.executeQuery("SELECT * FROM signuponenew WHERE formno = '" + formnno + "'");


            // Convert ResultSet to a TableModel
            table = new JTable(buildTableModel(resultSet));
            
            // Display the table in a JScrollPane within the JFrame
            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane, BorderLayout.CENTER);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("ResultSet Data");
            setSize(600, 400);
            setLocationRelativeTo(null);
            setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to convert ResultSet to TableModel
    public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        // Get number of columns
        int columnCount = metaData.getColumnCount();

        // Create columns array for JTable
        String[] columnNames = new String[columnCount];
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            columnNames[columnIndex - 1] = metaData.getColumnName(columnIndex);
        }

        // Create data array for JTable
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        while (resultSet.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                rowData[i] = resultSet.getObject(i + 1);
            }
            tableModel.addRow(rowData);
        }

        return tableModel;
    }

    public static void main(String[] args) {
        // Example usage
        SwingUtilities.invokeLater(() -> new Fetch("your_form_number_here"));
    }
}
