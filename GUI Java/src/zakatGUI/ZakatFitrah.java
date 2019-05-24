package zakatGUI;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;

import guiPBO.WinApp;
import net.proteanit.sql.DbUtils;
import shodaqahGUI.Shodaqoh;

import javax.swing.event.AncestorEvent;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;

public class ZakatFitrah extends WinApp{

	private JFrame frmPencatatanZakatFitrah;
	private JTextField txtNama;
	private JTextField textJml;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField Search_ID;
	
	WinApp wa = new WinApp ();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZakatFitrah window = new ZakatFitrah();
					window.frmPencatatanZakatFitrah.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ZakatFitrah() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPencatatanZakatFitrah = new JFrame();
		frmPencatatanZakatFitrah.setTitle("Pencatatan Zakat Fitrah");
		frmPencatatanZakatFitrah.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\ARIK\\Foto\\avatarold.JPG"));
		frmPencatatanZakatFitrah.setBackground(new Color(240, 240, 240));
		frmPencatatanZakatFitrah.setBounds(100, 100, 916, 523);
		frmPencatatanZakatFitrah.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPencatatanZakatFitrah.getContentPane().setLayout(null);
		
		JLabel lblInputData = new JLabel("Input Data");
		lblInputData.setFont(new Font("OCR A Std", Font.BOLD, 15));
		lblInputData.setBounds(10, 11, 147, 24);
		frmPencatatanZakatFitrah.getContentPane().add(lblInputData);
		
		JLabel lblZakatFitrah = new JLabel("Zakat Fitrah");
		lblZakatFitrah.setFont(new Font("OCR A Std", Font.BOLD, 15));
		lblZakatFitrah.setBounds(10, 31, 147, 30);
		frmPencatatanZakatFitrah.getContentPane().add(lblZakatFitrah);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 72, 184, 2);
		frmPencatatanZakatFitrah.getContentPane().add(separator);
		
		JLabel lblAtasNama = new JLabel("Atas Nama : ");
		lblAtasNama.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAtasNama.setBounds(10, 85, 87, 24);
		frmPencatatanZakatFitrah.getContentPane().add(lblAtasNama);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(255, 11, 7, 464);
		frmPencatatanZakatFitrah.getContentPane().add(separator_1);
		
		txtNama = new JTextField();
		txtNama.setBounds(10, 109, 184, 20);
		frmPencatatanZakatFitrah.getContentPane().add(txtNama);
		txtNama.setColumns(10);
		
		JLabel lblJumlahAnggota = new JLabel("Jumlah Anggota : ");
		lblJumlahAnggota.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJumlahAnggota.setBounds(10, 140, 125, 24);
		frmPencatatanZakatFitrah.getContentPane().add(lblJumlahAnggota);
		
		textJml = new JTextField();
		textJml.setBounds(11, 165, 183, 24);
		frmPencatatanZakatFitrah.getContentPane().add(textJml);
		textJml.setColumns(10);
		
		JLabel lblOpsiZakat = new JLabel("Opsi Zakat : ");
		lblOpsiZakat.setBounds(10, 200, 75, 14);
		frmPencatatanZakatFitrah.getContentPane().add(lblOpsiZakat);
		
		JLabel lblNominalUang = new JLabel("Nominal Uang :");
		lblNominalUang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNominalUang.setBounds(10, 262, 109, 21);
		frmPencatatanZakatFitrah.getContentPane().add(lblNominalUang);
		
		JLabel lblBeras = new JLabel("Beras :");
		lblBeras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBeras.setBounds(10, 344, 56, 14);
		frmPencatatanZakatFitrah.getContentPane().add(lblBeras);
		
		JButton btnSubmitZakat = new JButton("Submit");
		btnSubmitZakat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				theQuery("insert into zakatfitrah (nama,jmlanggota,nominal,beras) values('"+txtNama.getText()+"','"+textJml.getText()+"','"+textField.getText()+"',"+textField_1.getText()+")");
				txtNama.setText("");
				textJml.setText("");
				textField.setText("");
				textField_1.setText("");
				
				
			}
		});
		btnSubmitZakat.setBounds(10, 426, 115, 23);
		frmPencatatanZakatFitrah.getContentPane().add(btnSubmitZakat);
		
		JButton btnShowData = new JButton("Show Data");
		btnShowData.addActionListener(new ActionListener() 		 {
			public void actionPerformed(ActionEvent arg0) {
				Connection konek=null;
				Statement st=null;
				String query="Select * from zakatfitrah";
				try {
					konek=DriverManager.getConnection("jdbc:mysql://localhost/uas_pbo","root","");
					st=konek.createStatement();
					ResultSet rs=st.executeQuery(query);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnShowData.setBounds(329, 408, 247, 23);
		frmPencatatanZakatFitrah.getContentPane().add(btnShowData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(329, 15, 527, 371);
		frmPencatatanZakatFitrah.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Delete All");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection konek=null;
				Statement st=null;
				String query="Delete from zakatfitrah";
				try {
					konek=DriverManager.getConnection("jdbc:mysql://localhost/uas_pbo","root","");
					st=konek.createStatement();
					st.executeUpdate(query);
					
					
					query="alter table zakatfitrah auto_increment=0";
					st.executeUpdate(query);
					
			
					query="select * from zakatfitrah";
					ResultSet set=st.executeQuery(query);
					
					table.setModel(DbUtils.resultSetToTableModel(set));
					JOptionPane.showMessageDialog(null, "Data Terhapus");
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnNewButton.setBounds(329, 452, 247, 23);
		frmPencatatanZakatFitrah.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					WinApp back = new WinApp ();
					WinApp.main(null);
				
			}
		});
		btnNewButton_1.setBounds(135, 426, 110, 23);
		frmPencatatanZakatFitrah.getContentPane().add(btnNewButton_1);
		
		JButton btnUang = new JButton("Uang");
		btnUang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int jml;
				double ans;
				wa.setZero(0);
				wa.setBeras(10000);
				
				try {
					jml=Integer.parseInt(textJml.getText());
					ans = jml * wa.getBeras();
					
					textField.setText(Double.toString(ans));
					textField_1.setText(Integer.toString(getZero()));
							
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "data salah !");
				}
				
			}
		});
		btnUang.setBounds(8, 228, 111, 23);
		frmPencatatanZakatFitrah.getContentPane().add(btnUang);
		
		JButton btnBeras = new JButton("Beras");
		btnBeras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double jml, jwb;
				wa.setKg(2.5);
				wa.setZero(0);
				
				try {
					jml=Integer.parseInt(textJml.getText());
					jwb = jml * wa.getKg();
					
					textField_1.setText(Double.toString(jwb));
					textField.setText(Integer.toString(wa.getZero()));
							
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "data salah !");
				}
			}
		});
		
		btnBeras.setBounds(129, 228, 109, 23);
		frmPencatatanZakatFitrah.getContentPane().add(btnBeras);
		
		textField = new JTextField();
		textField.setBounds(10, 313, 109, 20);
		frmPencatatanZakatFitrah.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 369, 109, 20);
		frmPencatatanZakatFitrah.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblKilogram = new JLabel("kilogram");
		lblKilogram.setBounds(135, 372, 103, 14);
		frmPencatatanZakatFitrah.getContentPane().add(lblKilogram);
		
		JLabel lblRupiah = new JLabel("Rupiah");
		lblRupiah.setBounds(135, 316, 46, 14);
		frmPencatatanZakatFitrah.getContentPane().add(lblRupiah);
		
		JLabel lblKg = new JLabel("* 1 kg beras = Rp. 10.000.00");
		lblKg.setBounds(10, 288, 167, 14);
		frmPencatatanZakatFitrah.getContentPane().add(lblKg);
		
		JButton btnNewButton_2 = new JButton("Delete BY ID");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection konek=null;
				Statement st=null;
				String query="Delete from zakatfitrah where id='"+Search_ID.getText()+"'";
				try {
					konek=DriverManager.getConnection("jdbc:mysql://localhost/uas_pbo","root","");
					st=konek.createStatement();
					st.executeUpdate(query);
					
					
					query="select * from zakatfitrah";
					ResultSet rs=st.executeQuery(query);
					
					
					
					Search_ID.setText("");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,("isi id di text box atas"));
					
				}
			}
		});
		btnNewButton_2.setBounds(750, 408, 106, 23);
		frmPencatatanZakatFitrah.getContentPane().add(btnNewButton_2);
		
		Search_ID = new JTextField();
		Search_ID.setBounds(665, 409, 75, 20);
		frmPencatatanZakatFitrah.getContentPane().add(Search_ID);
		Search_ID.setColumns(10);
		
		JLabel lblPilihId = new JLabel("Pilih ID :");
		lblPilihId.setBounds(609, 412, 46, 14);
		frmPencatatanZakatFitrah.getContentPane().add(lblPilihId);
		
	}
}
