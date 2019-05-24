package guiPBO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Scrollbar;
import javax.swing.JMenu;
import javax.swing.JTextField;

import shodaqahGUI.Shodaqoh;
import zakatGUI.ZakatFitrah;

import java.awt.Color;
import java.awt.List;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.TextArea;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class WinApp {


	private JFrame frmSistemZakatDan;
	public void theQuery(String sql) {
		Connection con=null;
		Statement stat=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/uas_pbo","root","");
			stat=con.createStatement();
			stat.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Data Diinput");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	private int zero;
	private double beras;
	private double kg;

	public int getZero() {
		return zero;
	}

	public void setZero(int zero) {
		this.zero = zero;
	}

	public double getBeras() {
		return beras;
	}

	public void setBeras(double beras) {
		this.beras = beras;
	}

	public double getKg() {
		return kg;
	}

	public void setKg(double kg) {
		this.kg = kg;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinApp window = new WinApp();
					window.frmSistemZakatDan.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WinApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemZakatDan = new JFrame();
		frmSistemZakatDan.setTitle("Sistem Zakat dan Shodaqoh");
		frmSistemZakatDan.getContentPane().setForeground(new Color(102, 204, 204));
		frmSistemZakatDan.setBounds(100, 100, 450, 300);
		frmSistemZakatDan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemZakatDan.getContentPane().setLayout(null);
		
		JLabel lblPilihanZakat = new JLabel("PILIHAN ZAKAT");
		lblPilihanZakat.setFont(new Font("Adobe Hebrew", Font.ITALIC, 15));
		lblPilihanZakat.setBounds(158, 26, 125, 41);
		frmSistemZakatDan.getContentPane().add(lblPilihanZakat);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 75, 414, 2);
		frmSistemZakatDan.getContentPane().add(separator);
		
		JButton btnShodaqoh = new JButton("Shodaqoh");
		btnShodaqoh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Shodaqoh info = new Shodaqoh ();
				Shodaqoh.main(null);
			}
		});
		btnShodaqoh.setBounds(234, 119, 112, 29);
		frmSistemZakatDan.getContentPane().add(btnShodaqoh);
		
		JButton btnZakatFitrah = new JButton("Zakat Fitrah");
		btnZakatFitrah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ZakatFitrah info=new ZakatFitrah();
				ZakatFitrah.main(null);
				
			}
		});
		btnZakatFitrah.setBounds(78, 119, 112, 29);
		frmSistemZakatDan.getContentPane().add(btnZakatFitrah);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
