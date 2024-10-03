package com.op.oper.GUI;

import javax.swing.*;

import org.springframework.web.reactive.function.client.WebClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.op.oper.Infrastructure.PerformOp;


public class Gui {

    private static PerformOp pop;
    public static void main(String[] args) {
        
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:5036/").build();
        pop = new PerformOp(webClient);

        JFrame frame = new JFrame("Arithmetic Operations");
        JTextField a = new JTextField(5);
        JTextField b = new JTextField(5);
        JComboBox<String> operationBox = new JComboBox<>(new String[]{"add", "sub", "mul", "div"});
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("Result: ");

        JPanel panel = new JPanel();
        panel.add(new JLabel("A:"));
        panel.add(a);
        panel.add(new JLabel("B:"));
        panel.add(b);
        panel.add(new JLabel("Operation:"));
        panel.add(operationBox);
        panel.add(calculateButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String x = a.getText();
                String y = b.getText();

                Integer p = Integer.parseInt(x);
                Integer q = Integer.parseInt(y);

                String operation = (String) operationBox.getSelectedItem();

                pop.performCalculation(p, q, operation).subscribe(result -> {
                    SwingUtilities.invokeLater(() -> resultLabel.setText("Result: " + result.getRes()));
                });
            }
        });
    }
}


