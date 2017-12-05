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

public class GUIbuku extends JFrame implements ActionListener
{
	public String JJ1, JJ2,id_buku, judul_buku,isbn, pengarang, penerbit,tahun_buku;
	
        private static JLabel lblWall;
	private static JPanel contentPane;
        
	private static JTextField tfID;
	private static JTextField tfJudul;
	private static JTextField tfIsbn;
	private static JTextField tfPengarang;
	private static JTextField tfPenerbit;
	private static JTextField tfTahun;
	private static JTextField tfCari;
	
	private static JButton btnInsert;
	private static JButton btnUpdate;
	private static JButton btnDelete;
	private static JButton btnCari;
	
	public static String driver;
	public static Connection con;
	public static Statement st;
	
	public GUIbuku()
	{
            setLocationRelativeTo(null);
           setResizable(false);
                contentPane = new JPanel();	
		setContentPane(contentPane);
		contentPane.setLayout(null);               
                lblWall = new JLabel("");
		lblWall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/viewmenubuku.png"))); 
               lblWall.setBounds(0, -15, 700, 420);
		contentPane.add(lblWall);
            
		JLabel lbJJ1       = new JLabel ("Data");
		JLabel lbJJ2       = new JLabel ("Buku Perpustakaan");
		JLabel lbID        = new JLabel ("ID");
		JLabel lbJudul     = new JLabel ("Judul Buku");
		JLabel lbIsbn      = new JLabel ("ISBN");
		JLabel lbPengarang = new JLabel ("Pengarang");
		JLabel lbPenerbit  = new JLabel ("Penerbit");
		JLabel lbTahun     = new JLabel ("Tahun Terbit");
		
		lbJJ1.setFont(new java.awt.Font("Footlight MT Light",10,25));
		
		
		tfID        = new JTextField (20);
		tfJudul     = new JTextField (20);
		tfIsbn      = new JTextField (20);
		tfPengarang = new JTextField (20);
		tfPenerbit  = new JTextField (20);
		tfTahun     = new JTextField (20);
		tfCari		= new JTextField (6);
		
		btnInsert   = new JButton ("Insert");
		btnUpdate   = new JButton ("Update");
		btnDelete   = new JButton ("Delete");
		btnCari		= new JButton ("Find >");
		
		setLayout(null);
		Dimension sizelbJJ1       = lbJJ1.getPreferredSize();
		Dimension sizelbJJ2       = lbJJ2.getPreferredSize();
		Dimension sizelbID        = lbID.getPreferredSize();
		Dimension sizelbJudul     = lbJudul.getPreferredSize();
		Dimension sizelbIsbn      = lbIsbn.getPreferredSize();
		Dimension sizelbPengarang = lbPengarang.getPreferredSize();
		Dimension sizelbPenerbit  = lbPenerbit.getPreferredSize();
		Dimension sizelbTahun     = lbTahun.getPreferredSize();
		
		Dimension sizetfID        = tfID.getPreferredSize();
		Dimension sizetfJudul     = tfJudul.getPreferredSize();
		Dimension sizetfIsbn      = tfIsbn.getPreferredSize();
		Dimension sizetfPengarang = tfPengarang.getPreferredSize();
		Dimension sizetfPenerbit  = tfPenerbit.getPreferredSize();
		Dimension sizetfTahun     = tfTahun.getPreferredSize();
		Dimension sizetfCari      = tfCari.getPreferredSize();
		
		Dimension sizebtnInsert   = btnInsert.getPreferredSize();
		Dimension sizebtnUpdate   = btnUpdate.getPreferredSize();
		Dimension sizebtnDelete   = btnDelete.getPreferredSize();
		Dimension sizebtnCari     = btnCari.getPreferredSize();
				
		lbJJ1.setBounds(210,5, sizelbJJ1.width, sizelbJJ1.height);
		lbJJ2.setBounds(170,25, sizelbJJ2.width, sizelbJJ2.height);
		lbID.setBounds(10,50, sizelbID.width, sizelbID.height);
		lbJudul.setBounds(10,90, sizelbJudul.width, sizelbJudul.height);
		lbIsbn.setBounds(10,130, sizelbIsbn.width, sizelbIsbn.height);
		lbPengarang.setBounds(10,170, sizelbPengarang.width, sizelbPengarang.height);
		lbPenerbit.setBounds(10,210, sizelbPenerbit.width, sizelbPenerbit.height);
		lbTahun.setBounds(10,250, sizelbTahun.width, sizelbTahun.height);
		
		tfID.setBounds(100,80, sizetfID.width, sizetfID.height);
		tfJudul.setBounds(100,110, sizetfJudul.width, sizetfJudul.height);
		tfIsbn.setBounds(100,140, sizetfIsbn.width, sizetfIsbn.height);	
		tfPenerbit.setBounds(100,200, sizetfPenerbit.width, sizetfPenerbit.height);
		tfTahun.setBounds(100,230, sizetfTahun.width, sizetfTahun.height);
                tfPengarang.setBounds(100,260, sizetfPengarang.width, sizetfPengarang.height);
		tfCari.setBounds(340,425, sizetfCari.width, sizetfCari.height);
		
		btnInsert.setBounds(20,420, sizebtnInsert.width, sizebtnInsert.height);
		btnUpdate.setBounds(95,420, sizebtnUpdate.width, sizebtnUpdate.height);
		btnDelete.setBounds(180,420, sizebtnDelete.width, sizebtnDelete.height);
		btnCari.setBounds(260,420, sizebtnDelete.width, sizebtnDelete.height);
				
		add(lbJJ1);
		add(lbJJ2);
		add(lbID);
		add(tfID);
		add(lbJudul);
		add(tfJudul);
		add(lbIsbn);
		add(tfIsbn);
		add(lbPengarang);
		add(tfPengarang);
		add(lbPenerbit);
		add(tfPenerbit);
		add(lbTahun);
		add(tfTahun);
		add(tfCari);
		
		add(btnInsert);
		add(btnUpdate);
		add(btnDelete);
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
                
		setSize(450,500);
		setTitle("Book Manage");
                setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               
	}
	
	public void insert() throws Exception
	{
		id_buku       = tfID.getText();
		judul_buku    = tfJudul.getText();
		isbn          = tfIsbn.getText();
		pengarang     = tfPengarang.getText();
		penerbit      = tfPenerbit.getText();
		tahun_buku    = tfTahun.getText();
                
		
		String driver = "com.mysql.jdbc.Driver";        
		Class.forName(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
		st = con.createStatement();
		st.executeUpdate("INSERT INTO tb_buku  VALUES('"+id_buku+"','"+judul_buku+"','"+isbn+"','"+pengarang+"','"+penerbit+"','"+tahun_buku+"')");
		System.out.println("1 row inserted");
             
	}
	
	public void update() throws Exception
	{
		id_buku       = tfID.getText();
		judul_buku    = tfJudul.getText();
		isbn          = tfIsbn.getText();
		pengarang     = tfPengarang.getText();
		penerbit      = tfPenerbit.getText();
		tahun_buku    = tfTahun.getText();
		
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
		st = con.createStatement();
		st.executeUpdate("UPDATE tb_buku SET judul_buku  = '"+judul_buku+"', isbn = '"+isbn+"', pengarang = '"+pengarang+"', penerbit = '"+penerbit+"', tahun_buku = '"+tahun_buku+"' WHERE id_buku = '"+id_buku+"'");
		System.out.println("1 row updated");
	}
	
	public void delete() throws Exception
	{
		id_buku = tfID.getText();
		judul_buku = tfJudul.getText();
		isbn = tfIsbn.getText();
		pengarang = tfPengarang.getText();
		penerbit = tfPenerbit.getText();
		tahun_buku = tfTahun.getText();
		
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
		st = con.createStatement();
		st.executeUpdate("DELETE FROM tb_buku WHERE id_buku = '"+id_buku+"'" );
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
		String sql= "SELECT * FROM tb_buku WHERE id_buku LIKE '"+Cari+"' ";
		System.out.println("1 row searched");
		ResultSet rs = st.executeQuery(sql);

		if(rs.next()) {
		tfID.setText(rs.getString(1));
		tfJudul.setText(rs.getString(2));
		tfIsbn.setText(rs.getString(3));
		tfPengarang.setText(rs.getString(4));
		tfPenerbit.setText(rs.getString(5));
		tfTahun.setText(rs.getString(6));
		

		} 
		
		else {
			JOptionPane.showMessageDialog(panel, "ID " + Cari + " Tidak ditemukan");
			}
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== btnInsert)
		{
			try
			{
                           //  JOptionPane.showMessageDialog(null, "DEBUG");
				this.insert();
			}
			catch (Exception es)
			{
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
		GUIbuku s = new GUIbuku ();
		s.setVisible(true);
                s.setLocationRelativeTo(null);
	}
	
	
}
	
	
	




