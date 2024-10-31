package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Home_gui extends JPanel {
    private BufferedImage image;

//    public Home_gui() {
//        try {
//            // Đọc ảnh từ file nằm trong thư mục resources (thư mục src)
//            image = ImageIO.read(new File("img/Cinema(6).png"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Sử dụng GridBagLayout để căn giữa
//        setLayout(new GridBagLayout());
//
//        // Cài đặt GridBagConstraints để thêm các nút
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0; // Cột thứ nhất
//        gbc.gridy = 1; // Hàng đầu tiên
//        gbc.anchor = GridBagConstraints.CENTER; // Căn giữa các nút
//        gbc.insets = new Insets(20, 0, 20, 0); // Khoảng cách trên và dưới
//
//        // Tạo panel chứa các nút
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Căn giữa và khoảng cách giữa các nút
//        buttonPanel.add(Box.createHorizontalStrut(935));
//        // Tạo nút "Log in" và "Sign in"
//        JButton btnLogin = new JButton("Log in");
//        JButton btnSignin = new JButton("Sign in");
//
//        // Thiết lập nút "Log in"
//        btnLogin.setContentAreaFilled(false);
//        btnLogin.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
//        btnLogin.setPreferredSize(new Dimension(100, 40));
//        btnLogin.setFocusable(false);
//        btnLogin.setForeground(Color.white);
//
//        // Thiết lập nút "Sign in"
//        btnSignin.setBackground(Color.red);
//        btnSignin.setPreferredSize(new Dimension(100, 40));
//        btnSignin.setFocusable(false);
//        btnSignin.setBorder(BorderFactory.createEmptyBorder());
//
//        // Cài đặt font
//        Font fnt = new Font("Arial", Font.BOLD | Font.ITALIC, 20);
//        btnLogin.setFont(fnt);
//        btnSignin.setFont(fnt);
//
//        // Thêm nút vào buttonPanel
//        buttonPanel.add(btnLogin);
//        buttonPanel.add(btnSignin);
//        buttonPanel.setOpaque(false);
//
//        // Thêm buttonPanel vào Home_gui
//        gbc.gridy = 1; // Thay đổi hàng để các nút nằm bên dưới hình ảnh
//        add(buttonPanel, gbc);
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g); // Gọi phương thức gốc
//        if (image != null) {
//            // Vẽ ảnh vào panel
//            g.drawImage(image, 0, 0, getWidth(), getHeight(), this); // Kéo dài ảnh để phủ toàn bộ panel
//        }
//    }
    public Home_gui() {
        setSize(1200, 800);
        setLayout(new BorderLayout());

        // Tạo thanh điều hướng bên trái
        JPanel sidebar = createSidebar();
        
        // Tạo danh sách phim
        JScrollPane movieGrid = createMovieGrid();

        // Thêm các thành phần vào frame chính
        add(sidebar, BorderLayout.WEST);
        add(movieGrid, BorderLayout.CENTER);
        setVisible(true);
    }

    // Tạo thanh điều hướng bên trái
    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(44, 62, 80));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(200, getHeight()));
        
        JLabel userName = new JLabel("Happy cinema");
        userName.setForeground(Color.WHITE);
        userName.setFont(new Font("Arial", Font.BOLD, 20));
        userName.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(Box.createVerticalStrut(15));
        sidebar.add(userName);
        sidebar.add(Box.createVerticalStrut(20));

        String[] menuItems = {"Phim hành dộng", "Phim tình cảm", "Phim hài", "Phim khoa học viễn tưởng", "Phim hoạt hình"};
        for (String item : menuItems) {
            JButton button = new JButton(item);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(150, 40));
            button.setBackground(new Color(52, 73, 94));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            sidebar.add(button);
            sidebar.add(Box.createVerticalStrut(10));
        }

        return sidebar;
    }

    // Tạo danh sách phim
    private JScrollPane createMovieGrid() {
        JPanel movieGrid = new JPanel();
        movieGrid.setBackground(new Color(52, 73, 94));
        movieGrid.setLayout(new GridLayout(5, 5));
        movieGrid.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        String[] movieNames = {"Thor", "Elvis & Nixon", "Homefront", "Brooklyn", "WALL-E", "The Dark Knight", "Frozen","Wolverine","Deedpool","Lalaland","Iron man","Avenger: End game","Inside out",
        						"Car 3", "Cloverfield","Annabelle","Plane","Captain America","Indepence Day","Man of steel","Split","Class","Die hard","Fast 5","Furious 7"};
        String[] moviePosters = {
                "img//thor.jpg",
                "img//elvis.jpg",
                "img//homefront.jpg",
                "img//brooklyn.jpg",
                "img//walle.jpg",
                "img//batman.jpg",
                "img//frozen.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",
                "img//batman.jpg",               
        };
        for (int i = 0; i < movieNames.length; i++) {
            JPanel moviePanel = new JPanel();
            moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));
            moviePanel.setBackground(new Color(52, 73, 94));
            
            // Tạo nhãn cho ảnh poster phim
            JLabel posterLabel = new JLabel();
            posterLabel.setIcon(new ImageIcon(new ImageIcon(moviePosters[i]).getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH)));
            posterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Tạo nhãn cho tên phim
            JLabel movieTitle = new JLabel(movieNames[i]);
            movieTitle.setForeground(Color.WHITE);
            movieTitle.setFont(new Font("Arial", Font.PLAIN, 14));
            movieTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

            moviePanel.add(posterLabel);
            moviePanel.add(Box.createVerticalStrut(10));
            moviePanel.add(movieTitle);
            moviePanel.add(Box.createVerticalStrut(10));
            
            movieGrid.add(moviePanel);
        }
        JScrollPane scrMovies = new JScrollPane(movieGrid);
        
        return scrMovies;
    }
}
