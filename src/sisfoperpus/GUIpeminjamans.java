/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfoperpus;

/**
 *
 * @author Herwin
 */

import javax.activation.DataSource;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GUIpeminjamans extends JFrame implements ActionListener
{
	public String  JJ5, JJ6, id_peminjaman, id_member, id_karyawan, jumlah_buku,tanggal_peminjaman, tanggal_deadline_pengembalian;
	
        private static JLabel lblWall;
	private static JPanel contentPane;
        
	private static JTextField tfIDP;
	private static JTextField tfIDM;
	private static JTextField tfIDK;
	private static JTextField tfJumlah;
	private static JTextField tfTPem;
	private static JTextField tfTDPeng;
	private static JTextField tfCari;
	
	private static JButton btnInsert;
	private static JButton btnUpdate;
	private static JButton btnDelete;
	private static JButton btnTambahbuku;
	private static JButton btnCari;
	
	public static String driver;
	public static Connection con;
	public static Statement st;
	
	public GUIpeminjamans()
	{
            setLocationRelativeTo(null);
            setResizable(false);
            contentPane = new JPanel();	
		setContentPane(contentPane);
		contentPane.setLayout(null);               
                lblWall = new JLabel("");
		lblWall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/viewmenupinjam.png"))); 
               lblWall.setBounds(0, -15, 700, 420);
		contentPane.add(lblWall);
                
            
		JLabel lbJJ5       = new JLabel ("Data");
		JLabel lbJJ6       = new JLabel ("Peminjaman Buku Perpustakaan");
		JLabel lbIDP       = new JLabel ("ID Peminjaman");
		JLabel lbIDM       = new JLabel ("ID Member ");
		JLabel lbIDK       = new JLabel ("ID Karyawan");
		JLabel lbJumlah    = new JLabel ("Jumlah Buku");
		JLabel lbTPem      = new JLabel ("Tanggal Peminjaman");
		JLabel lbTDPeng    = new JLabel ("Tanggal Deadline ");
		
		tfIDP              = new JTextField (20);
		tfIDM              = new JTextField (20);
		tfIDK              = new JTextField (20);
		tfJumlah           = new JTextField (20);
		tfTPem             = new JTextField (20);
		tfTDPeng           = new JTextField (20);
		tfCari             = new JTextField (6);
		
		btnInsert          = new JButton ("Insert");
		btnUpdate          = new JButton ("Update");
		btnDelete          = new JButton ("Delete");
		btnTambahbuku      = new JButton ("Tambah Buku");
		btnCari            = new JButton ("Find >");
		
		setLayout(null);
		Dimension sizelbJJ5       = lbJJ5.getPreferredSize();
		Dimension sizelbJJ6       = lbJJ6.getPreferredSize();
		Dimension sizelbIDP       = lbIDP.getPreferredSize();
		Dimension sizelbIDM       = lbIDM.getPreferredSize();
		Dimension sizelbIDK       = lbIDK.getPreferredSize();
		Dimension sizelbJumlah    = lbJumlah.getPreferredSize();
		Dimension sizelbTPem      = lbTPem.getPreferredSize();
		Dimension sizelbTDPeng    = lbTDPeng.getPreferredSize();
		
		Dimension sizetfIDP       = tfIDP.getPreferredSize();
		Dimension sizetfIDM       = tfIDM.getPreferredSize();
		Dimension sizetfIDK       = tfIDK.getPreferredSize();
		Dimension sizetfJumlah    = tfJumlah.getPreferredSize();
		Dimension sizetfTPem      = tfTPem.getPreferredSize();
		Dimension sizetfTDPeng    = tfTDPeng.getPreferredSize();
		Dimension sizetfCari      = tfCari.getPreferredSize();
		
		Dimension sizebtnInsert   = btnInsert.getPreferredSize();
		Dimension sizebtnUpdate   = btnUpdate.getPreferredSize();
		Dimension sizebtnDelete   = btnDelete.getPreferredSize();
		Dimension sizebtnTambahbuku   = btnTambahbuku.getPreferredSize();
		Dimension sizebtnCari     = btnCari.getPreferredSize();
		
		lbJJ5.setBounds(245,20, sizelbJJ5.width, sizelbJJ5.height);
		lbJJ6.setBounds(170,50, sizelbJJ6.width, sizelbJJ6.height);
		lbIDP.setBounds(10,90, sizelbIDP.width, sizelbIDP.height);
		lbIDM.setBounds(10,130, sizelbIDM.width, sizelbIDM.height);
		lbIDK.setBounds(10,170, sizelbIDK.width, sizelbIDK.height);
		lbJumlah.setBounds(10,210, sizelbJumlah.width, sizelbJumlah.height);
		lbTPem.setBounds(10,280, sizelbTPem.width, sizelbTPem.height);
		lbTDPeng.setBounds(10,320, sizelbTDPeng.width, sizelbTDPeng.height);
		
		tfIDP.setBounds(150,70, sizetfIDP.width, sizetfIDP.height);
		tfIDM.setBounds(150,110, sizetfIDM.width, sizetfIDM.height);
		tfIDK.setBounds(150,150, sizetfIDK.width, sizetfIDK.height);
		tfJumlah.setBounds(150,190, sizetfJumlah.width, sizetfJumlah.height);
		tfTPem.setBounds(150,260, sizetfTPem.width, sizetfTPem.height);
		tfTDPeng.setBounds(150,300, sizetfTDPeng.width, sizetfTDPeng.height);
		tfCari.setBounds(340,425, sizetfCari.width, sizetfCari.height);
		
		btnInsert.setBounds(20,420, sizebtnInsert.width, sizebtnInsert.height);
		btnUpdate.setBounds(95,420, sizebtnUpdate.width, sizebtnUpdate.height);
		btnDelete.setBounds(180,420, sizebtnDelete.width, sizebtnDelete.height);
		btnCari.setBounds(260,420, sizebtnDelete.width, sizebtnDelete.height);
		btnTambahbuku.setBounds(150,225, sizebtnTambahbuku.width, sizebtnTambahbuku.height);
		
		add(lbJJ5);
		add(lbJJ6);
		add(lbIDP);
		add(tfIDP);
		add(lbIDM);
		add(tfIDM);
		add(lbIDK);
		add(tfIDK);
		add(lbJumlah);
		add(tfJumlah);
		add(lbTPem);
		add(tfTPem);
		add(lbTDPeng);
		add(tfTDPeng);
		add(tfCari);
		
		add(btnInsert);
		add(btnUpdate);
		add(btnDelete);               
		add(btnTambahbuku);
		add(btnCari);
		
                
		btnInsert.addActionListener(this);
                btnInsert.setBackground(Color.RED);
                btnInsert.setForeground(Color.white);
                
		btnUpdate.addActionListener(this); 
                btnUpdate.setBackground(Color.RED);
                btnUpdate.setForeground(Color.white);
		
                btnDelete.addActionListener(this);
                btnDelete.setBackground(Color.RED);
                btnDelete.setForeground(Color.white);
                
		btnCari.addActionListener(this);
                btnCari.setBackground(Color.RED);
                btnCari.setForeground(Color.white);
                
		btnTambahbuku.addActionListener(this);
		btnTambahbuku.setBackground(Color.RED);
                btnTambahbuku.setForeground(Color.white);
                
                setSize(430,500);
		setTitle("Peminjaman Buku");
                setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void insert() throws Exception
	{
		id_peminjaman                   = tfIDP.getText();
		id_member                       = tfIDM.getText();
		id_karyawan                     = tfIDK.getText();
		jumlah_buku                     = tfJumlah.getText();
		tanggal_peminjaman              = tfTPem.getText();
		tanggal_deadline_pengembalian   = tfTDPeng.getText();
		
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
		st = con.createStatement();
		st.executeUpdate("INSERT INTO tb_peminjaman (id_peminjaman,id_member,id_karyawan,jumlah_buku,tanggal_peminjaman,tanggal_pengembalian, tanggal_deadline_pengembalian) VALUES('"+id_peminjaman+"','"+id_member+"','"+id_karyawan+"','"+jumlah_buku+"','"+tanggal_peminjaman+"','0000-00-00','"+tanggal_deadline_pengembalian+"')");
		System.out.println("1 row inserted");
	}
	
	public void update() throws Exception
	{
		id_peminjaman                   = tfIDP.getText();
		id_member                       = tfIDM.getText();
		id_karyawan                     = tfIDK.getText();
		jumlah_buku                     = tfJumlah.getText();
		tanggal_peminjaman              = tfTPem.getText();
		tanggal_deadline_pengembalian   = tfTDPeng.getText();
				
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
		st = con.createStatement();
		
		st.executeUpdate("UPDATE tb_peminjaman SET id_member = '"+id_member+"', id_karyawan = '"+id_karyawan+"', jumlah_buku = '"+jumlah_buku+"', tanggal_peminjaman  = '"+tanggal_peminjaman+"', tanggal_deadline_pengembalian = '"+tanggal_deadline_pengembalian+"' WHERE id_peminjaman = '"+id_peminjaman+"'");
		System.out.println("1 row updated");
	}
	
	public void delete() throws Exception
	{
		id_peminjaman                   = tfIDP.getText();
		id_member                       = tfIDM.getText();
		id_karyawan                     = tfIDK.getText();
		jumlah_buku                     = tfJumlah.getText();
		tanggal_peminjaman              = tfTPem.getText();
		tanggal_deadline_pengembalian   = tfTDPeng.getText();
             
				
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
		st = con.createStatement();
		
		st.executeUpdate("DELETE FROM tb_peminjaman WHERE id_peminjaman = '"+id_peminjaman+"'" );
		System.out.println("1 row deleted");
	}
	public void cari () throws Exception
	{
		JPanel panel = new JPanel();
	    GridLayout gl = new GridLayout(7,2);
	    panel.setLayout(gl);
		String Cari = tfCari.getText();
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
		Statement st = con.createStatement();
		String sql= "SELECT * FROM tb_peminjaman WHERE id_peminjaman LIKE '"+Cari+"' ";
		System.out.println("1 row searched");
		ResultSet rs = st.executeQuery(sql);

		if(rs.next()) {
		tfIDP.setText(rs.getString(1));
		tfIDM.setText(rs.getString(2));
		tfIDK.setText(rs.getString(3));
		tfJumlah.setText(rs.getString(4));
		tfTPem.setText(rs.getString(5));
		tfTDPeng.setText(rs.getString(7));
		
		}
                else {
			JOptionPane.showMessageDialog(panel, "ID " + Cari + " Tidak ditemukan");
			}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== btnInsert)
		{
			try{
				this.insert();
			}
			catch (Exception es){
				JOptionPane.showMessageDialog(null, "Maaf! Input Error");	
			}
		}	
		else if(e.getSource()== btnUpdate)
		{
			try
			{
				this.update();
			}
				catch (Exception es)
			{
					JOptionPane.showMessageDialog(null, "Maaf! Input Error");	
			}
		}
	
		else if(e.getSource()== btnDelete)
		{
			try
			{
				this.delete();
			}
				catch (Exception es)
			{
					JOptionPane.showMessageDialog(null, "Maaf! Input Error");	
			}
		}
		else if(e.getSource()== btnTambahbuku)
		{
			try
			{
				new GUIdetailpeminjaman ().setVisible(true);
			}
				catch (Exception es)
			{
					JOptionPane.showMessageDialog(null, "Maaf! Input Error");	
			}
		}
		else if(e.getSource()== btnCari)
		{
			try
			{
				this.cari();
			}
			catch (Exception es)
			{
				JOptionPane.showMessageDialog(null, "Maaf! Input Error");	
			}
		}
	}
		
	public static void main(String args []) throws Exception
	{
		GUIpeminjamans s = new GUIpeminjamans ();
		s.setVisible(true);
                s.setLocationRelativeTo(null);
	}
	
}
	
	
	






