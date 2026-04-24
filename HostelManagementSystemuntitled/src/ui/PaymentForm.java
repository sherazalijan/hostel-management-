package ui;

import db.PaymentDAO;

import javax.swing.*;
import java.awt.*;

public class PaymentForm {

    public PaymentForm() {

        JFrame frame = new JFrame("Payment Module");
        frame.setSize(350, 250);
        frame.setLayout(new GridLayout(4, 2));

        JLabel idLabel = new JLabel("Student ID:");
        JLabel amountLabel = new JLabel("Amount:");

        JTextField idField = new JTextField();
        JTextField amountField = new JTextField();

        JButton payBtn = new JButton("Pay");

        frame.add(idLabel);
        frame.add(idField);

        frame.add(amountLabel);
        frame.add(amountField);

        frame.add(new JLabel());
        frame.add(payBtn);

        payBtn.addActionListener(e -> {

            int id = Integer.parseInt(idField.getText());
            double amount = Double.parseDouble(amountField.getText());

            PaymentDAO.addPayment(id, amount);

            JOptionPane.showMessageDialog(frame, "Payment Successful 💰");

            idField.setText("");
            amountField.setText("");
        });

        frame.setVisible(true);
    }
}