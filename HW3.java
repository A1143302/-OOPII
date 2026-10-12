import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HW3{
    static JFrame frm = new JFrame("單位換算器");
    static JPanel centerPanel = new JPanel();

    static JComboBox<String> typeCombo;
    static JComboBox<String> sourceCombo;
    static JComboBox<String> targetCombo;

    static JTextField inputField = new JTextField();
    static JTextField resultField = new JTextField();
    static JButton calcButton = new JButton("換算");

    static String[] types = {"長度", "重量", "溫度"};
    static String[] lengthUnits = {"公尺", "公分", "英吋", "英尺"};
    static String[] weightUnits = {"公斤", "公克", "磅", "盎司"};
    static String[] tempUnits = {"攝氏", "華氏", "克氏"};

    public static void main(String args[]) {
        frm.setSize(480, 280);
        frm.setLayout(new BorderLayout());

        typeCombo = new JComboBox<>(types);
        sourceCombo = new JComboBox<>(lengthUnits);
        targetCombo = new JComboBox<>(lengthUnits);

        frm.add(typeCombo, BorderLayout.NORTH);

        centerPanel.setLayout(new GridLayout(2, 2, 5, 5));
        resultField.setEditable(false);
        centerPanel.add(inputField);
        centerPanel.add(sourceCombo);
        centerPanel.add(resultField);
        centerPanel.add(targetCombo);
        frm.add(centerPanel, BorderLayout.CENTER);

        frm.add(calcButton, BorderLayout.SOUTH);

        typeCombo.addActionListener(new ActLis());
        calcButton.addActionListener(new ActLis());

        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static class ActLis implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == typeCombo) {
                int selectedIndex = typeCombo.getSelectedIndex();
                String[] newUnits = lengthUnits;
                
                if(selectedIndex == 1) newUnits = weightUnits;
                else if(selectedIndex == 2) newUnits = tempUnits;

                sourceCombo.setModel(new DefaultComboBoxModel<>(newUnits));
                targetCombo.setModel(new DefaultComboBoxModel<>(newUnits));
                resultField.setText("");
                inputField.setText("");
            }else if (e.getSource() == calcButton) {
                try {
                    double inputValue = Double.parseDouble(inputField.getText());
                    int typeIdx = typeCombo.getSelectedIndex();
                    int srcIdx = sourceCombo.getSelectedIndex();
                    int tgtIdx = targetCombo.getSelectedIndex();
                    double result = 0.0;

                    if(typeIdx == 0){
                        double[] toMeter = {1.0, 0.01, 0.0254, 0.3048}; 
                        result = (inputValue * toMeter[srcIdx]) / toMeter[tgtIdx];
                    }else if(typeIdx == 1){
                        double[] toKg = {1.0, 0.001, 0.453592, 0.0283495};
                        result = (inputValue * toKg[srcIdx]) / toKg[tgtIdx];
                    }else if(typeIdx == 2){
                        double inCelsius = inputValue;
                        if (srcIdx == 1) inCelsius = (inputValue - 32) * 5.0 / 9.0;
                        else if (srcIdx == 2) inCelsius = inputValue - 273.15;

                        if (tgtIdx == 0) result = inCelsius;
                        else if (tgtIdx == 1) result = inCelsius * 9.0 / 5.0 + 32;
                        else if (tgtIdx == 2) result = inCelsius + 273.15;
                    }

                    resultField.setText(String.format("%.4f", result));
                }catch(Exception ex){
                    resultField.setText("錯誤");
                }
            }
        }
    }
}