import javax.swing.*;
import java.awt.*;

public class HW1 extends JFrame{
    public HW1(){
        setTitle("登入");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel l1 = new JLabel("帳號:");
        JTextField t1 = new JTextField(15);
        JLabel l2 = new JLabel("密碼:");
        JPasswordField t2 = new JPasswordField(15);
        JButton btn = new JButton("登入");

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(btn);

        btn.addActionListener(e -> {
            String username = t1.getText();
            String password = new String(t2.getPassword());

            if (username.equals("admin") && password.equals("1234")) {
                System.out.println("登入成功");
            } else {
                System.out.println("帳號或密碼錯誤");
            }
        });

        setVisible(true);
    }

    public static void main(String[] a){
        new HW1();
    }
}