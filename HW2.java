import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HW2 implements ActionListener{
    private JFrame frm;

    private int count = 0;
    private int sum = 0;

    private JLabel lblUp;
    private JLabel lblC;
    private JButton btn;

    public HW2() {
        frm = new JFrame("骰子模擬器");
        frm.setSize(400, 320);
        frm.setLocationRelativeTo(null);
        frm.setLayout(new BorderLayout(10, 10));

        lblUp = new JLabel("已擲 0 次，總和 0，平均 0.00", SwingConstants.CENTER);
        lblUp.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
        frm.add(lblUp, BorderLayout.NORTH);

        lblC = new JLabel("?", SwingConstants.CENTER);
        lblC.setFont(new Font("Serif", Font.BOLD, 60));
        frm.add(lblC, BorderLayout.CENTER);

        btn = new JButton("擲骰子");
        btn.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
        btn.addActionListener(this);
        frm.add(btn, BorderLayout.SOUTH);

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        int point = (int) (Math.random() * 6) + 1;

        count++;
        sum += point;
        double avg = (double) sum / count;

        lblUp.setText(String.format("已擲 %d 次，總和 %d，平均 %.2f", count, sum, avg));

        lblC.setText(String.valueOf(point));
        if (point == 6) {
            lblC.setForeground(Color.GREEN);
        } else if (point == 1) {
            lblC.setForeground(Color.RED);
        } else {
            lblC.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        new HW2();
    }
}