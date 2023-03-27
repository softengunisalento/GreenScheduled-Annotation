package com.example.Tesi.frame;

import com.example.Tesi.strategy.SetStrategy;
import com.example.Tesi.strategy.SetStrategyImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SpringBootApplication
public class CarbonIntensityFrame extends JFrame{
    public CarbonIntensityFrame() {
        initUI();
    }

    public static void initUI(){
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        JButton button = new JButton("Carbon Intensity Live");
        JLabel label = new JLabel("If the carbon intensity live value is higher than the limit you set, the method will not be invoked and this frame will close until the set condition is satisfied.");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetStrategy setStrategy = new SetStrategyImpl();
                System.out.println("CARBON INTENSITY LIVE ON");
                try {
                    //frame.setVisible(false);
                    frame.dispose();
                    setStrategy.strategy();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        mainPanel.add(button);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(label, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true);
    }
}
