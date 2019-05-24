package shodaqahGUI;

import java.sql.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import guiPBO.WinApp;
import net.proteanit.sql.DbUtils;
import zakatGUI.ZakatFitrah;

import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Shodaqoh extends WinApp{

	private JFrame frmPencatatanShodaqoh;
	private JTextField txtPencatatanShodaqoh;
	private JTextField textField_1;
	private ButtonGroup bg=new ButtonGroup();
	private JTable table;
	private JTextField textField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shodaqoh window = new Shodaqoh();
					window.frmPencatatanShodaqoh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Shodaqoh() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPencatatanShodaqoh = new JFrame();
		frmPencatatanShodaqoh.setTitle("Pencatatan Shodaqoh");
		frmPencatatanShodaqoh.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\ARIK\\Foto\\avatarold.JPG"));
		frmPencatatanShodaqoh.setBounds(100, 100, 831, 523);
		frmPencatatanShodaqoh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPencatatanShodaqoh.getContentPane().setLayout(null);
		
		JLabel lblPencatatanSodaqoh = new JLabel("Input Data");
		lblPencatatanSodaqoh.setFont(new Font("Courier New", Font.BOLD, 20));
		lblPencatatanSodaqoh.setBounds(25, 28, 351, 28);
		frmPencatatanShodaqoh.getContentPane().add(lblPencatatanSodaqoh);
		
		JLabel lblShodaqoh = new JLabel("Shodaqoh");
		lblShodaqoh.setFont(new Font("Courier New", Font.BOLD, 20));
		lblShodaqoh.setBounds(25, 53, 120, 28);
		frmPencatatanShodaqoh.getContentPane().add(lblShodaqoh);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 101, 197, 2);
		frmPencatatanShodaqoh.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(241, 11, 2, 462);
		frmPencatatanShodaqoh.getContentPane().add(separator_1);
		
		JLabel lblAtasNama = new JLabel("Atas Nama :");
		lblAtasNama.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAtasNama.setBounds(25, 102, 120, 33);
		frmPencatatanShodaqoh.getContentPane().add(lblAtasNama);
		
		txtPencatatanShodaqoh = new JTextField();
		txtPencatatanShodaqoh.setBounds(25, 146, 181, 20);
		frmPencatatanShodaqoh.getContentPane().add(txtPencatatanShodaqoh);
		txtPencatatanShodaqoh.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nominal :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 177, 91, 28);
		frmPencatatanShodaqoh.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(25, 226, 109, 20);
		frmPencatatanShodaqoh.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				theQuery("insert into shodaqoh (nama,nominal) values('"+txtPencatatanShodaqoh.getText()+"','"+textField_1.getText()+"')");
				txtPencatatanShodaqoh.setText("");
				textField_1.setText("");
			}
		});
		btnSubmit.setBounds(25, 403, 85, 28);
		frmPencatatanShodaqoh.getContentPane().add(btnSubmit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 27, 518, 368);
		frmPencatatanShodaqoh.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnShowTable = new JButton("Show table");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection konek=null;
				Statement st=null;
				String query="Select * from shodaqoh";
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
		btnShowTable.setBounds(271, 406, 255, 23);
		frmPencatatanShodaqoh.getContentPane().add(btnShowTable);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WinApp info=new WinApp();
				WinApp.main(null);
				
				
				
			}
			
			
		});
		btnMenu.setBounds(133, 406, 89, 23);
		frmPencatatanShodaqoh.getContentPane().add(btnMenu);
		
		JButton btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection konek=null;
				Statement st=null;
				String query="Delete from shodaqoh";
				try {
					konek=DriverManager.getConnection("jdbc:mysql://localhost/uas_pbo","root","");
					st=konek.createStatement();
					st.executeUpdate(query);
					
					
					query="alter table shodaqoh auto_increment=0";
					st.executeUpdate(query);
					
			
					query="select * from shodaqoh";
					ResultSet set=st.executeQuery(query);
					
					table.setModel(DbUtils.resultSetToTableModel(set));
					JOptionPane.showMessageDialog(null, "Data Terhapus");
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnDeleteAll.setBounds(271, 440, 255, 23);
		frmPencatatanShodaqoh.getContentPane().add(btnDeleteAll);
		
		JButton btnDelete = new JButton("Delete BY ID");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection konek=null;
				Statement st=null;
				String query="Delete from shodaqoh where id='"+textField.getText()+"'";
				try {
					konek=DriverManager.getConnection("jdbc:mysql://localhost/uas_pbo","root","");
					st=konek.createStatement();
					st.executeUpdate(query);
					
					
					query="select * from shodaqoh";
					ResultSet rs=st.executeQuery(query);
					
					
					
					textField.setText("");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,"isi id di text box atas");
					
				}
			}
		});
		btnDelete.setBounds(680, 406, 109, 23);
		frmPencatatanShodaqoh.getContentPane().add(btnDelete);
		
		JLabel lblrp = new JLabel("(RP)");
		lblrp.setBounds(144, 229, 46, 14);
		frmPencatatanShodaqoh.getContentPane().add(lblrp);
		
		textField = new JTextField();
		textField.setBounds(595, 407, 66, 20);
		frmPencatatanShodaqoh.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPilihId = new JLabel("Pilih ID :");
		lblPilihId.setBounds(539, 410, 46, 14);
		frmPencatatanShodaqoh.getContentPane().add(lblPilihId);
	}
}
