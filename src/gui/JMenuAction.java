package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class JMenuAction implements ActionListener {
	GiaoDien giaoDien;
	
	public JMenuAction(GiaoDien giaoDien) {
		this.giaoDien = giaoDien;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel newContent = new JPanel(); // Tạo panel mới cho nội dung
        switch (e.getActionCommand()) {
        	case "Open":
        		newContent = new Home_gui();
        		giaoDien.getContent().add(newContent);
        		break;
            case "Danh sách phim":
                newContent = new GiaoDienPhim(); // Panel danh sách phim
                break;
            case "Tạo vé mới":
            	newContent = new GiaoDienVe();
            	break;
        }
        
     // Thay thế nội dung của panel content
        giaoDien.getContent().removeAll();  // Xóa nội dung cũ
        giaoDien.getContent().add(newContent, BorderLayout.CENTER);  // Thêm panel mới
        giaoDien.getContent().revalidate();  // Xác nhận lại bố cục
        giaoDien.getContent().repaint();  // Vẽ lại giao diện
	}
}
