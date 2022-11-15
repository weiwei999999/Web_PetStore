package src.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class PaintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String str=(String) session.getAttribute("yzm");


        int width = 120;
        int height = 25;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 创建一支画笔
        Graphics2D graphics = image.createGraphics();
        // 给画笔添加颜色
        graphics.setColor(Color.white);
        // 填充矩形
        graphics.fillRect(0, 0, width, height);


        // 将字符串存入session
        session.setAttribute("yzm", str);

        Random random = new Random();
        // 根据验证码长度随机画干扰线(颜色随机，位置随机，长度随机)
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Font font = new Font("微软雅黑", Font.BOLD, 22);
            graphics.setFont(font);
            Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            graphics.setColor(color);
            graphics.drawString(String.valueOf(c), 20 + i * 15, 20);
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }
        // 把图像刷到BufferedImage对象中
        graphics.dispose();
        // 将图像写入 File，并指定图片格式
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }
}
