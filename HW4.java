import javax.swing.*;
import java.awt.*;

public class HW4 extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 1. 天空與草地(畫布 500x400,上下各一半)
        g.setColor(new Color(135, 206, 235));   // 天藍色
        g.fillRect(0, 0, 500, 250);
        g.setColor(new Color(34, 139, 34));     // 綠色
        g.fillRect(0, 250, 500, 150);

        // 2. 太陽:黃色正圓 + 12 條光芒
        int cx = 420, cy = 70, r = 30;
        g.setColor(Color.YELLOW);
        g.fillOval(cx - r, cy - r, 2 * r, 2 * r);
        g.setColor(Color.ORANGE);
        for (int i = 0; i < 12; i++) {
            double angle = 2 * Math.PI * i / 12;
            int x1 = (int) (cx + (r + 8) * Math.cos(angle));
            int y1 = (int) (cy + (r + 8) * Math.sin(angle));
            int x2 = (int) (cx + (r + 28) * Math.cos(angle));
            int y2 = (int) (cy + (r + 28) * Math.sin(angle));
            g.drawLine(x1, y1, x2, y2);
        }

        // 3. 雲朵:3 個互相重疊的白色橢圓
        g.setColor(Color.WHITE);
        g.fillOval(50, 50, 80, 40);
        g.fillOval(90, 35, 70, 45);
        g.fillOval(120, 55, 80, 40);

        // 4. 房屋主體:fillRect + drawRect
        g.setColor(new Color(255, 228, 181));
        g.fillRect(150, 210, 200, 130);
        g.setColor(Color.BLACK);
        g.drawRect(150, 210, 200, 130);

        // 5. 屋頂:只用 drawLine 畫三角形(三條線段)
        g.setColor(Color.RED);
        g.drawLine(130, 210, 250, 140);   // 左斜邊  
        g.drawLine(250, 140, 370, 210);   // 右斜邊
        g.drawLine(130, 210, 370, 210);   // 底邊

        // 6. 門:fillRoundRect + 小圓形門把
        g.setColor(new Color(139, 69, 19));
        g.fillRoundRect(225, 270, 50, 70, 10, 10);
        g.setColor(Color.YELLOW);
        g.fillOval(262, 301, 8, 8);

        // 7. 窗戶:2 扇,fillRect + drawRect + 十字窗框
        drawWindow(g, 170, 235, 45, 40);
        drawWindow(g, 285, 235, 45, 40);

        // 8. 簽名
        g.setColor(Color.BLACK);
        g.drawString("A1143302   李欣瞳", 10, 390);
    }

    private void drawWindow(Graphics g, int x, int y, int w, int h) {
        g.setColor(new Color(173, 216, 230));
        g.fillRect(x, y, w, h);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, w, h);
        g.drawLine(x + w / 2, y, x + w / 2, y + h);   // 垂直線
        g.drawLine(x, y + h / 2, x + w, y + h / 2);   // 水平線
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("我的小房子");
        HW4 panel = new HW4();
        panel.setPreferredSize(new Dimension(500, 400));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}