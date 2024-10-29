package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.Phim_DAO;
import enity.Phim;

public class GiaoDienPhim extends JPanel implements ActionListener, MouseListener {
	private JLabel maPhim;
	private JTextField txtMaPhim;
	private JLabel tenPhim;
	private JTextField txtTenPhim;
	private JLabel theLoai;
	private JTextField txtTheLoai;
	private DefaultTableModel modelPhim;
	private JTable tableModelPhim;
	private JLabel namSX;
	private JTextField txtNamSX;
	private JLabel nuocSX;
	private JTextField txtNuocSX;
	private JLabel daoDien;
	private JTextField txtDaoDien;
	private JLabel thoiLuong;
	private JTextField txtThoiLuong;
	private JLabel quocGia;
	private JTextField txtQuocGia;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnSua;
	private JButton btnTim;
	private JLabel maTim;
	private JTextField txtTim;
	private ArrayList<Phim> dsPhim = new ArrayList<>();
	private Phim_DAO dsPhimDao = new Phim_DAO();

	public GiaoDienPhim() {
		super();
		try {
			ConnectDB.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dsPhim = dsPhimDao.getAllPhim(); // lưu dữ liệu vào dsPhim

		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel jpCenter = new JPanel();
		JPanel jpSouth = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();

		TitledBorder thongTinPhim = BorderFactory.createTitledBorder("Thông tin phim");
		thongTinPhim.setTitleFont(new Font("arial", Font.BOLD, 20));
		thongTinPhim.setTitleJustification(TitledBorder.CENTER);
		leftPanel.setBorder(thongTinPhim);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		// leftPanel
		leftPanel.add(Box.createVerticalStrut(127));
		JPanel jpMaPhim = new JPanel();
		jpMaPhim.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpMaPhim.add(maPhim = new JLabel("Mã phim:"));
		jpMaPhim.add(Box.createHorizontalStrut(25));
		jpMaPhim.add(txtMaPhim = new JTextField(30));
		jpMaPhim.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // khoảng cách giữa jpMaPhim và jpTenPhim

		JPanel jpTenPhim = new JPanel();
		jpTenPhim.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpTenPhim.add(tenPhim = new JLabel("Tên phim:"));
		jpTenPhim.add(Box.createHorizontalStrut(20));
		jpTenPhim.add(txtTenPhim = new JTextField(30));
		jpTenPhim.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

		JPanel jpQuocGia = new JPanel();
		jpQuocGia.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpQuocGia.add(quocGia = new JLabel("Quốc gia:"));
		jpQuocGia.add(Box.createHorizontalStrut(20));
		jpQuocGia.add(txtQuocGia = new JTextField(30));
		jpQuocGia.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

		JPanel jpDaoDien = new JPanel();
		jpDaoDien.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpDaoDien.add(daoDien = new JLabel("Đạo diễn:"));
		jpDaoDien.add(Box.createHorizontalStrut(20));
		jpDaoDien.add(txtDaoDien = new JTextField(30));
		jpDaoDien.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

		JPanel jpNamSX = new JPanel();
		jpNamSX.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpNamSX.add(namSX = new JLabel("Năm sản xuất:"));
		jpNamSX.add(txtNamSX = new JTextField(10));
		jpNamSX.add(Box.createHorizontalStrut(13));
		jpNamSX.add(thoiLuong = new JLabel("Thời lượng:"));
		jpNamSX.add(txtThoiLuong = new JTextField(10));
		jpNamSX.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

		JPanel jpTheLoai = new JPanel();
		jpTheLoai.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpTheLoai.add(theLoai = new JLabel("Thể loại:"));
		jpTheLoai.add(Box.createHorizontalStrut(25));
		jpTheLoai.add(txtTheLoai = new JTextField(30));
		// Thêm khoảng cách giữa jpTheLoai và viền của leftPanel
		jpTheLoai.setBorder(BorderFactory.createEmptyBorder(0, 0, 127, 0));

		JPanel jpButton = new JPanel();
		jpButton.add(btnThem = new JButton("Thêm"));
		jpButton.add(btnXoa = new JButton("Xóa"));
		jpButton.add(btnXoaTrang = new JButton("Xóa trắng"));
		jpButton.add(btnSua = new JButton("Cập nhật"));
		jpButton.add(btnTim = new JButton("Tìm"));
		jpButton.add(maTim = new JLabel("Nhập mã cần tìm:"));
		jpButton.add(txtTim = new JTextField(10));

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);

		// set textFiel
		txtMaPhim.setPreferredSize(new Dimension(WIDTH, 25));
		txtTenPhim.setPreferredSize(new Dimension(WIDTH, 25));
		txtQuocGia.setPreferredSize(new Dimension(WIDTH, 25));
		txtDaoDien.setPreferredSize(new Dimension(WIDTH, 25));
		txtNamSX.setPreferredSize(new Dimension(WIDTH, 25));
		txtThoiLuong.setPreferredSize(new Dimension(WIDTH, 25));
		txtTheLoai.setPreferredSize(new Dimension(WIDTH, 25));

		// rightPanel
		String[] colNamePhim = { "Mã phim", "Tên phim", "Quốc gia", "Đạo diễn", "Năm sản xuất", "Thời lượng",
				"Thể loại" };
		modelPhim = new DefaultTableModel(colNamePhim, 0);
		tableModelPhim = new JTable(modelPhim);
		tableModelPhim.setPreferredScrollableViewportSize(new Dimension(800, 500));
		JScrollPane scrollPane = new JScrollPane(tableModelPhim);
		tableModelPhim.addMouseListener(this);

		TitledBorder dsPhim = BorderFactory.createTitledBorder("Danh sách phim");
		dsPhim.setTitleFont(new Font("arial", Font.BOLD, 20));
		dsPhim.setTitleJustification(TitledBorder.CENTER);
		scrollPane.setBorder(dsPhim);
		docPhim(); // gọi hàm docPhim để hiển thị dữ liệu
		rightPanel.add(scrollPane);

		leftPanel.add(jpMaPhim);
		leftPanel.add(jpTenPhim);
		leftPanel.add(jpQuocGia);
		leftPanel.add(jpDaoDien);
		leftPanel.add(jpNamSX);
		leftPanel.add(jpTheLoai);
		jpCenter.add(leftPanel, BorderLayout.WEST);
		jpCenter.add(rightPanel, BorderLayout.CENTER);

		jpSouth.add(jpButton, BorderLayout.CENTER);
		mainPanel.add(jpCenter, BorderLayout.CENTER);
		mainPanel.add(jpSouth, BorderLayout.SOUTH);
		add(mainPanel);

	}

	// xóa dữ liệu
	public void xoaHetDuLieu() {
		DefaultTableModel dtm = (DefaultTableModel) tableModelPhim.getModel();
		dtm.getDataVector().removeAllElements();
	}

	// đọc dữ liệu từ danh sách
	public void docPhim() {
		for (Phim phim : dsPhim) {
			modelPhim.addRow(new Object[] { phim.getMaPhim(), phim.getTenPhim(), phim.getQuocGia(), phim.getDaoDien(),
					phim.getNamSX(), phim.getThoiLuong(), phim.getTheLoai() });
		}
	}

	public static void main(String[] args) {
		new GiaoDienPhim();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableModelPhim.getSelectedRow();
		txtMaPhim.setText(tableModelPhim.getValueAt(row, 0).toString());
		txtTenPhim.setText(tableModelPhim.getValueAt(row, 1).toString());
		txtQuocGia.setText(tableModelPhim.getValueAt(row, 2).toString());
		txtDaoDien.setText(tableModelPhim.getValueAt(row, 3).toString());
		txtNamSX.setText(tableModelPhim.getValueAt(row, 4).toString());
		txtThoiLuong.setText(tableModelPhim.getValueAt(row, 5).toString());
		txtTheLoai.setText(tableModelPhim.getValueAt(row, 6).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (validData()) {
				try {
					if (txtMaPhim.getText().equals("") || txtTenPhim.getText().equals("")
							|| txtQuocGia.getText().equals("") || txtDaoDien.getText().equals("")
							|| txtNamSX.getText().equals("") || txtThoiLuong.getText().equals("")) {
						JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
					} else {
						int namSX = Integer.parseInt(txtNamSX.getText());
						int thoiLuong = Integer.parseInt(txtThoiLuong.getText());
						Phim phim = new Phim(txtMaPhim.getText(), txtTenPhim.getText(), txtQuocGia.getText(),
								txtDaoDien.getText(), namSX, thoiLuong, txtTheLoai.getText());

						String maPhim = txtMaPhim.getText().trim();
						for (int i = 0; i < tableModelPhim.getRowCount(); i++) {
							if (tableModelPhim.getValueAt(i, 0).equals(maPhim)) {
								JOptionPane.showMessageDialog(this, "Trùng mã phim");
								txtMaPhim.grabFocus();
								txtMaPhim.selectAll();
								return;
							}
						}

						modelPhim.addRow(new Object[] { phim.getMaPhim(), phim.getTenPhim(), phim.getQuocGia(),
								phim.getDaoDien(), phim.getNamSX(), phim.getThoiLuong(), phim.getTheLoai() });

						if (dsPhimDao.create(phim)) {
							JOptionPane.showMessageDialog(this, "Thành Công");
						} else {
							JOptionPane.showMessageDialog(this, "Không Thành Công");
						}
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng");
				}
			}
		} else if (o.equals(btnXoaTrang)) {
			txtMaPhim.setText(null);
			txtTenPhim.setText(null);
			txtQuocGia.setText(null);
			txtDaoDien.setText(null);
			txtNamSX.setText(null);
			txtThoiLuong.setText(null);
			txtTheLoai.setText(null);
		} else if (o.equals(btnXoa)) {
			int index = tableModelPhim.getSelectedRow();
			if (tableModelPhim.getRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Danh sách rỗng!");
			}

			if (index < 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn phim cần xóa!");
			} else {
				if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa phim này không?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					String phimXoa = tableModelPhim.getValueAt(index, 0).toString();
					if (dsPhimDao.remove(new Phim(phimXoa))) {
						modelPhim.removeRow(index);
						JOptionPane.showMessageDialog(this, "Xóa thành công!");
					} else
						JOptionPane.showMessageDialog(this, "Xóa không thành công!");
				}
			}
		} else if (o.equals(btnTim)) {
			String maTim = txtTim.getText().trim();
			
			for (int i = 0; i < modelPhim.getRowCount(); i++) {
				Object[] phimTim = new Object[modelPhim.getColumnCount()];
				if (modelPhim.getValueAt(i, 0).equals(maTim)) {
					for (int j = 0; j < modelPhim.getColumnCount(); j++) {
						phimTim[j] = modelPhim.getValueAt(i, j);
					}
					modelPhim.setRowCount(0);
					modelPhim.addRow(phimTim);
					txtTim.setText(null);
					break;
				}
				else if(phimTim == null)
					JOptionPane.showMessageDialog(this, "Không tìm thấy mã phim nào trùng khớp");
			}
			if(maTim == null || maTim.trim().equals("")) {
				modelPhim.setRowCount(0);
				docPhim();
				tableModelPhim.setModel(modelPhim);
			}
		}
	}

	public boolean validData() {
		String maPhim = txtMaPhim.getText().trim();
		String tenPhim = txtTenPhim.getText().trim();
		String quocGia = txtQuocGia.getText().trim();
		String daoDien = txtDaoDien.getText().trim();
		String namSX = txtNamSX.getText().trim();
		String thoiLuong = txtThoiLuong.getText().trim();
		String theLoai = txtTheLoai.getText().trim();

		if (!maPhim.matches("P\\d{3}")) {
			System.out.println("Mã phim nhập: " + maPhim);
			JOptionPane.showMessageDialog(this, "Mã phim phải bắt đầu là P và theo sau 3 chữ số!");
			txtMaPhim.grabFocus();
			txtMaPhim.selectAll();
			return false;
		}

		if (!(tenPhim.length() > 0 && tenPhim.matches("([A-Z][a-z0-9]*)( [A-Z][a-z0-9]*)*( \\d+)?"))) {
			JOptionPane.showMessageDialog(this, "Tên phim chỉ được phép có chữ và số!");
			txtTenPhim.grabFocus();
			txtTenPhim.selectAll();
			return false;
		}

		if (!(quocGia.length() > 0 && quocGia.matches("([A-Z][a-z]+)( [A-Z][a-z]+)*"))) {
			JOptionPane.showMessageDialog(this, "Tên quốc gia phải đúng định dạng. Ví dụ: Việt Nam");
			txtQuocGia.grabFocus();
			txtQuocGia.selectAll();
			return false;
		}

		if (!(daoDien.length() > 0 && daoDien.matches("([A-Z][a-z]+)( [A-Z][a-z]+)*"))) {
			JOptionPane.showMessageDialog(this, "Họ Tên phải viết hoa chữ cái đầu");
			txtDaoDien.grabFocus();
			txtDaoDien.selectAll();
			return false;
		}

		if (namSX.length() > 0) {
			try {
				int nam = Integer.parseInt(namSX);
				if (!(nam >= 1000 && nam <= LocalDate.now().getYear())) {
					JOptionPane.showMessageDialog(this,
							"Năm xuất bản phải từ năm 1000 và trước hoặc bằng năm hiện tại!");
					txtNamSX.grabFocus();
					txtNamSX.selectAll();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Năm xuất bản vui lòng nhập số!");
				txtNamSX.grabFocus();
				txtNamSX.selectAll();
				return false;
			}
		}

		if (thoiLuong.length() > 0) {
			try {
				int time = Integer.parseInt(thoiLuong);
				if (time <= 0) {
					JOptionPane.showMessageDialog(this, "Thời lượng phải > 0!");
					txtThoiLuong.grabFocus();
					txtThoiLuong.selectAll();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Thời lượng vui lòng nhập số!");
				txtThoiLuong.grabFocus();
				txtThoiLuong.selectAll();
				return false;
			}
		}

		if (!(theLoai.length() > 0 && theLoai.matches("([A-Z][a-z]+)( [A-Z][a-z]+)*"))) {
			JOptionPane.showMessageDialog(this, "Thể loại phải viết hoa mỗi chữ cái đầu!");
			txtTheLoai.grabFocus();
			txtTheLoai.selectAll();
			return false;
		}
		return true;
	}

}
