package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Home_gui extends JPanel {
    private BufferedImage image;

    public Home_gui() {
        try {
            // Đọc ảnh từ file nằm trong thư mục resources (thư mục src)
            image = ImageIO.read(new File("img/Cinema(6).png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Sử dụng GridBagLayout để căn giữa
        setLayout(new GridBagLayout());

        // Cài đặt GridBagConstraints để thêm các nút
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Cột thứ nhất
        gbc.gridy = 1; // Hàng đầu tiên
        gbc.anchor = GridBagConstraints.CENTER; // Căn giữa các nút
        gbc.insets = new Insets(20, 0, 20, 0); // Khoảng cách trên và dưới

        // Tạo panel chứa các nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Căn giữa và khoảng cách giữa các nút
        buttonPanel.add(Box.createHorizontalStrut(935));
        // Tạo nút "Log in" và "Sign in"
        JButton btnLogin = new JButton("Log in");
        JButton btnSignin = new JButton("Sign in");

        // Thiết lập nút "Log in"
        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        btnLogin.setPreferredSize(new Dimension(100, 40));
        btnLogin.setFocusable(false);
        btnLogin.setForeground(Color.white);

        // Thiết lập nút "Sign in"
        btnSignin.setBackground(Color.red);
        btnSignin.setPreferredSize(new Dimension(100, 40));
        btnSignin.setFocusable(false);
        btnSignin.setBorder(BorderFactory.createEmptyBorder());

        // Cài đặt font
        Font fnt = new Font("Arial", Font.BOLD | Font.ITALIC, 20);
        btnLogin.setFont(fnt);
        btnSignin.setFont(fnt);

        // Thêm nút vào buttonPanel
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnSignin);
        buttonPanel.setOpaque(false);

        // Thêm buttonPanel vào Home_gui
        gbc.gridy = 1; // Thay đổi hàng để các nút nằm bên dưới hình ảnh
        add(buttonPanel, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Gọi phương thức gốc
        if (image != null) {
            // Vẽ ảnh vào panel
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this); // Kéo dài ảnh để phủ toàn bộ panel
        }
    }
}
