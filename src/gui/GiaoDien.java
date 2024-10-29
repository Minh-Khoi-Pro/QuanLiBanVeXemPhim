package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class GiaoDien extends JFrame {
    private JButton btnLogin;
    private JButton btnSignin;
    private JMenuItem homeItem;
    private JMenuItem dsPhim;
    private JMenuItem xuatChieuItem;
    private JMenuItem taoVeMoi;
    private JMenuItem dsPhong;
    private JMenuItem dsNhanVien;
    private JPanel content;
//	private String ;
	private BufferedImage imgXuatChieu;

    public GiaoDien() {
        setTitle("Quản lý Bán Vé Xem Phim");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        Font iconFont = new Font("Segoe UI Emoji", Font.PLAIN, 20);
        Font fontSize = new Font("arial", Font.BOLD, 20);
        
        // Thanh menu
        JMenuBar menuBar = new JMenuBar();
        JMenu trangChu = new JMenu("Trang Chủ");
        trangChu.add(homeItem = new JMenuItem("Open"));
        JMenu phim = new JMenu("Phim");
        phim.add(dsPhim = new JMenuItem("Danh sách phim"));
        JMenu xuatChieu = new JMenu("Xuất Chiếu");
        xuatChieu.add(xuatChieuItem = new JMenuItem("Danh sách xuất chiếu"));
        JMenu datVe = new JMenu("Đặt vé");
        datVe.add(taoVeMoi = new JMenuItem("Tạo vé mới"));
        JMenu phong = new JMenu("Phòng");
        phong.add(dsPhong = new JMenuItem("Danh sách phòng"));
        JMenu nhanVien = new JMenu("Nhân Viên");
        nhanVien.add(dsNhanVien = new JMenuItem("Danh sách nhân viên"));
        
        //set Font
        trangChu.setFont(fontSize);
        phim.setFont(fontSize);
        xuatChieu.setFont(fontSize);
        datVe.setFont(fontSize);
        phong.setFont(fontSize);
        nhanVien.setFont(fontSize);
        
        //khoang cach giua cac menu
        trangChu.setPreferredSize(new Dimension(120, 40));  
        trangChu.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));  // Viền chỉ ở bên phải
        
        phim.setPreferredSize(new Dimension(80, 40));  
        phim.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
        
        xuatChieu.setPreferredSize(new Dimension(130, 40));  
        xuatChieu.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));

        datVe.setPreferredSize(new Dimension(85, 40));  
        datVe.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
        
        nhanVien.setPreferredSize(new Dimension(120, 40));  
        nhanVien.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
        
        //chèn icon
        JLabel iconCF = new JLabel();
        ImageIcon iconCF2 = new ImageIcon("img/coffee.png");
        Image imgCF = iconCF2.getImage();
        Image newImgCF = imgCF.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        iconCF.setIcon(new ImageIcon(newImgCF));
        
        JLabel iconHome = new JLabel();
        ImageIcon iconHome2 = new ImageIcon("img/home.png");
        Image imgHome = iconHome2.getImage();
        Image newImgHome = imgHome.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        iconHome.setIcon(new ImageIcon(newImgHome));
        
        JLabel iconFilm = new JLabel();
        ImageIcon iconFilm2 = new ImageIcon("img/movie.png");
        Image imgFilm = iconFilm2.getImage();
        Image newImgFilm = imgFilm.getScaledInstance(25,  25,  Image.SCALE_SMOOTH); 
        iconFilm.setIcon(new ImageIcon(newImgFilm));
        
        JLabel iconXuatChieu = new JLabel();
        ImageIcon iconXuatChieu2 = new ImageIcon("img/xuatChieu.png");
        
        //thay đổi kích thước ảnh
        Image imgXuatChieu = iconXuatChieu2.getImage();
        Image newImgXC = imgXuatChieu.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconXuatChieu.setIcon(new ImageIcon(newImgXC));
        
        JLabel iconDatVe = new JLabel();
        ImageIcon iconDatVe2 = new ImageIcon("img/ticket.png");
        Image imgDatVe = iconDatVe2.getImage();
        Image newImgDV = imgDatVe.getScaledInstance(30,  30,  Image.SCALE_SMOOTH);
        iconDatVe.setIcon(new ImageIcon(newImgDV));
        
        JLabel iconNV = new JLabel();
        ImageIcon iconNV2 = new ImageIcon("img/user.png");
        Image imgNV = iconNV2.getImage();
        Image newImgNV = imgNV.getScaledInstance(25,  25, Image.SCALE_SMOOTH);
        iconNV.setIcon(new ImageIcon(newImgNV));
        
        menuBar.add(Box.createHorizontalStrut(15));
        menuBar.add(iconCF);
        menuBar.add(Box.createHorizontalStrut(35));
        menuBar.add(iconHome);
        menuBar.add(trangChu);
        menuBar.add(Box.createHorizontalStrut(25));
        menuBar.add(iconFilm);
        menuBar.add(phim);
        menuBar.add(Box.createHorizontalStrut(15));
        menuBar.add(iconXuatChieu);
        menuBar.add(xuatChieu);
        menuBar.add(Box.createHorizontalStrut(20));
        menuBar.add(iconDatVe);
        menuBar.add(datVe);
        menuBar.add(Box.createHorizontalStrut(20));
        menuBar.add(iconNV);
        menuBar.add(nhanVien);
        menuBar.setBackground(new Color(25,121,169));
        menuBar.setPreferredSize(new Dimension(WIDTH, 70)); //set kích thước menu
        
        this.setJMenuBar(menuBar);

        // Panel chính
        content = new JPanel(new BorderLayout());
        Home_gui home_gui = new Home_gui();

        content.add(home_gui, BorderLayout.CENTER);
        this.add(content);
        
        // Cài đặt ActionListener cho menu
        ActionListener ac = new JMenuAction(this);
        homeItem.addActionListener(ac);
        dsPhim.addActionListener(ac);
        xuatChieuItem.addActionListener(ac);
        dsPhong.addActionListener(ac);
        dsNhanVien.addActionListener(ac);
        taoVeMoi.addActionListener(ac);

        this.setVisible(true);
    }

    public JPanel getContent() {
        return content;
    }

    public static void main(String[] args) {
        new GiaoDien();
    }
}
