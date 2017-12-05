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
import java.awt.Image;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;


public class FormMainMenu extends JFrame implements ActionListener //implements manggil interface actionlistener
{       private static JButton btnTerminal;
        private static JButton btnDatabase;
        private static JButton btnAbout;
	private static JButton btnBuku;
	private static JButton btnMember;
	private static JButton btnPeminjaman;
	private static JButton btnKaryawan;
        private static JButton btnLihatBuku;
	private static JButton btnPengembalian; 
        private static JButton btnInfo; 
        private static JLabel lblWall;
	private static JPanel contentPane;
        private static JTextField Search;

        public FormMainMenu ()
	{
      setResizable(false);
      
	
            
                contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);    
            
                lblWall = new JLabel("");
		lblWall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/adminpage.png"))); 
                lblWall.setBounds(0, -9, 1366, 768);
		contentPane.add(lblWall);
            
                btnTerminal        = new JButton ("Terminal");
                btnDatabase        = new JButton ("Database    ");
                btnInfo            = new JButton ("Information ");
               	btnAbout           = new JButton ("About Us     ");
		btnBuku            = new JButton ("Book Manage"); 
		btnMember   	   = new JButton ("Members      ");
                btnPeminjaman      = new JButton ("Borrowing      ");
		btnKaryawan        = new JButton ("Officer          ");
		btnPengembalian    = new JButton ("Returns          ");
		btnLihatBuku       = new JButton ("Book Search");
                Search             = new JTextField (20);
                
              /*  btnDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/database.png"))); 
                btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/infos.png"))); 
              btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/about.png")));    
            btnBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/bukuku.png"))); 
            btnMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/user2.png")));    
             btnKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/orang.png")));
            btnPengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/pengembalian.png")));
             btnPeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/kind2.png")));
             btnLihatBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/lhtbuku.png")));
             */
                
                 btnDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/icon/database.png"))); 
                btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/icon/informasi.png"))); 
              btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/icon/aboutus.png")));    
            btnBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/icon/book.png"))); 
            btnMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/icon/member.png")));    
             btnKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/icon/oficer.png")));
            btnPengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/icon/pengembalian.png")));
             btnPeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/icon/peminjaman.png")));
             btnLihatBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/icon/cari buku.png")));
                
             
            setLayout(null);
                Dimension sizebtnTerminal         = btnTerminal.getPreferredSize();
                Dimension sizebtnDatabase         = btnDatabase.getPreferredSize();
		Dimension sizebtnInfo         = btnInfo.getPreferredSize();
		Dimension sizebtnAbout         = btnAbout.getPreferredSize();
		Dimension sizebtnBuku         = btnBuku.getPreferredSize();
		Dimension sizebtnMember       = btnMember.getPreferredSize();
		Dimension sizebtnPeminjaman   = btnPeminjaman.getPreferredSize();
		Dimension sizebtnKaryawan     = btnKaryawan.getPreferredSize();
		Dimension sizebtnPengembalian = btnPengembalian.getPreferredSize();
		Dimension sizebtnLihatBuku = btnLihatBuku.getPreferredSize();
		Dimension sizeSearch      = Search.getPreferredSize();
                
		//(kiri.kanan-atas.bawah)
                btnTerminal.setBounds(477,300, sizebtnTerminal.width, sizebtnTerminal.height);
                btnDatabase.setBounds(1108,460, sizebtnDatabase.width, sizebtnDatabase.height);
                btnInfo.setBounds(1108,370, sizebtnInfo.width, sizebtnInfo.height);
                btnAbout.setBounds(1108,280, sizebtnAbout.width, sizebtnAbout.height);
		btnBuku.setBounds(692,280, sizebtnBuku.width, sizebtnBuku.height);
		btnMember.setBounds(905,370, sizebtnMember.width, sizebtnMember.height);
		btnPeminjaman.setBounds(692,370, sizebtnPeminjaman.width, sizebtnPeminjaman.height);
		btnKaryawan.setBounds(905,280, sizebtnKaryawan.width, sizebtnKaryawan.height);
		btnPengembalian.setBounds(692,460, sizebtnPengembalian.width, sizebtnPengembalian.height);
		btnLihatBuku.setBounds(905,460, sizebtnLihatBuku.width, sizebtnLihatBuku.height);
                Search.setBounds(1060,64, sizeSearch.width, sizeSearch.height);
                
                add(btnTerminal);
                add(btnDatabase);
                add(btnInfo);
                add(btnAbout);
		add(btnBuku);
		add(btnMember);
		add(btnPeminjaman);
		add(btnKaryawan);
		add(btnPengembalian);
		add(btnLihatBuku);
                add(Search);
                
                btnTerminal.addActionListener(this);
                btnTerminal.setBackground(Color.LIGHT_GRAY);
                btnTerminal.setForeground(Color.DARK_GRAY);
                
                btnDatabase.addActionListener(this);
                btnDatabase.setBackground(Color.darkGray);
                btnDatabase.setForeground(Color.white);
                
                btnInfo.addActionListener(this);
                btnInfo.setBackground(Color.darkGray);
                btnInfo.setForeground(Color.white);
                
                btnAbout.addActionListener(this);
                btnAbout.setBackground(Color.darkGray);
                btnAbout.setForeground(Color.white);
                
		btnBuku.addActionListener(this);
                btnBuku.setBackground(Color.darkGray);
                btnBuku.setForeground(Color.white);
                
		btnMember.addActionListener(this);
                btnMember.setBackground(Color.darkGray);
                btnMember.setForeground(Color.white);
                
		btnPeminjaman.addActionListener(this);
                btnPeminjaman.setBackground(Color.darkGray);
                btnPeminjaman.setForeground(Color.white);
                
		btnKaryawan.addActionListener(this);
		btnKaryawan.setBackground(Color.darkGray);
                btnKaryawan.setForeground(Color.white);
                
                btnPengembalian.addActionListener(this);
                btnPengembalian.setBackground(Color.darkGray);
                btnPengembalian.setForeground(Color.white);
                
                btnLihatBuku.addActionListener(this);
                btnLihatBuku.setBackground(Color.darkGray);
                btnLihatBuku.setForeground(Color.white);
                
		setSize(1366,768);
		setTitle("[ System Information  |  Sidoarjo Library Aplication ]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                      
                
	}
	public void actionPerformed(ActionEvent e)
	{
        
	
            if(e.getSource()== btnAbout)
		{
			try
			{
				//form di close - dispose();
				new Abouts ().setVisible(true);
                              


			}
			catch (Exception es)
			{
				es.printStackTrace();	
			}
		}	
                
                    
            else if(e.getSource()== btnTerminal)
		{
			try
			{
				//form di close - dispose();
                                
				new Terminal ();//.setVisible(true);
                          
			}
			catch (Exception es)
			{
				es.printStackTrace();	
			}
		}
            
            
                  else if(e.getSource()== btnDatabase)
		{
			try
			{
				//form di close - dispose();
                                
				new Databases ();//.setVisible(true);
                          
			}
			catch (Exception es)
			{
				es.printStackTrace();	
			}
		}
                
                
                else if(e.getSource()== btnInfo)
		{
			try
			{
				//form di close - dispose();
				new Readme ().setVisible(true); 
			}
			catch (Exception es)
			{
				es.printStackTrace();	
			}
		}
                
                
                else if(e.getSource()== btnBuku)
		{
			try
			{
				//form di close - dispose();
				new GUIbuku ().setVisible(true); 
			}
			catch (Exception es)
			{
				es.printStackTrace();	
			}
		}
                
                
		else if(e.getSource()== btnMember)
		{
			try
			{
				//form di close - dispose();
				new GUImembers ().setVisible(true); 
			}
			catch (Exception es)
			{
				es.printStackTrace();	
			}
		}
	
		else if(e.getSource()== btnPeminjaman)
		{
			try
			{
				//form di close - dispose();
				new GUIpeminjamans ().setVisible(true); //panggil form guipeminjaman
			}
			catch (Exception es)
			{
				es.printStackTrace();	
			}
		}
		else if(e.getSource()== btnKaryawan)
		{
			try
			{
				//form di close - dispose();
				new GUIkaryawan ().setVisible(true); 
			}
			catch (Exception es)
			{
				es.printStackTrace();	
			}
		}
		else if(e.getSource()== btnPengembalian)
		{
			try
			{
				//form di close - dispose();
				new GUIpengembalian ().setVisible(true); 
			}
			catch (Exception es)
			{
				es.printStackTrace();	
			}
		}
                
                else if(e.getSource()== btnLihatBuku)
		{
			try
			{
				//form di close - dispose();
				new LihatBuku ().setVisible(true); 
			}
			catch (Exception es)
			{
				es.printStackTrace();	
			}
		}
	}		
	public static void main(String args []) throws Exception
	{       
       
		FormMainMenu s = new FormMainMenu ();
		s.setVisible(true);
                s.setLocationRelativeTo(null);
      

	}
}