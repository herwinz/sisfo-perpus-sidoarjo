/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfoperpus;


import javax.swing.*; //pemanggilan seluruh kelas swing 
import java.awt.*; //pemanggilan seluruh kelas awt 
import java.awt.event.*; //pemanggilan kelas event yg berada dalam kelas awt 
import sisfoperpus.FormMainMenu;
import sisfoperpus.LihatBuku;
import java.lang.NullPointerException;
import javax.swing.ImageIcon;

//mendefiniskan kelas PassFrame dengan perluasan JFrame pd komponen swing 
public class Login extends JFrame 
{ 
//pendefinisian objek seperti JTextField, JButton, dan JLabel 
JTextField inputID = new JTextField(); 
JTextField inputNama = new JTextField(); 
JPasswordField inputPass = new JPasswordField(); 
JButton jLogin = new JButton(); 
JButton jCancel = new JButton(); 
JLabel header = new JLabel(); 
JLabel id = new JLabel(); 
JLabel nama = new JLabel(); 
JLabel pass = new JLabel(); 

//membuat sebuah constructor untuk merancang kelas PassFrame 
public Login() 
{ 
    setLocationRelativeTo(null);
    setResizable(false); //mematikan maxzimize dan minimize 
//mengatur posisi frame PassFrame 
this.getContentPane().setLayout(null); 

//mengatur objek yg di gunakan 
//setFont = untuk mengatur format character yg dipakai 
//setHorizontalAligment = untuk mengatur posisi text 
//setText = untuk memberi/mengisi text 
//setBounds = untuk mengatur posisi objek dalam frame 
//pada setBounds(newRectangle(posisi x, posisi y, lebar, tinggi)) 
        
        Container content = getContentPane();                             //membuat layout
        Container contentArea = getContentPane();
        contentArea.setBackground(Color.gray); 

header.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); 
header.setHorizontalAlignment(SwingConstants.CENTER); 
header.setText("Masukkan dengan Benar!"); 
header.setBounds(new Rectangle(15, 8, 350, 20)); 

id.setHorizontalAlignment(SwingConstants.LEFT); 
id.setText("ID USER:"); 
id.setBounds(new Rectangle(8, 40, 120, 20)); 

nama.setHorizontalAlignment(SwingConstants.LEFT); 
nama.setText("Nama:"); 
nama.setBounds(new Rectangle(8, 65, 120, 20)); 

pass.setHorizontalAlignment(SwingConstants.LEFT); 
pass.setText("Password:"); 
pass.setBounds(new Rectangle(8, 90, 120, 20)); 

inputID.setBounds(new Rectangle(125, 40, 250, 20)); 

inputNama.setBounds(new Rectangle(125, 65, 250, 20)); 

inputPass.setBounds(new Rectangle(125, 90, 250, 20)); 

jLogin.setBounds(new Rectangle(170, 120, 100,30)); 
jLogin.setHorizontalAlignment(SwingConstants.CENTER); 
jLogin.setText("OK"); 

jCancel.setBounds(new Rectangle(275, 120, 100,30)); 
jCancel.setHorizontalAlignment(SwingConstants.CENTER); 
jCancel.setText("EXIT"); 

//menampilkan objek 
this.getContentPane().add(header); 
this.getContentPane().add(id); 
this.getContentPane().add(nama); 
this.getContentPane().add(pass); 
this.getContentPane().add(inputID); 
this.getContentPane().add(inputNama); 
this.getContentPane().add(inputPass); 
this.getContentPane().add(jLogin); 
this.getContentPane().add(jCancel); 

//jLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/Logout.png"))); 
//jCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/Exit.png"))); 
                jLogin.setBackground(Color.darkGray);
                jLogin.setForeground(Color.white);
                jCancel.setBackground(Color.darkGray);
                jCancel.setForeground(Color.white);
                
addListener(); //memanggil kelas addListener 
setLocationRelativeTo(null);
} 

//kelas utama(main class) 
public static void main(String [] args) 
{ 
//pengaturan frame PassFrame 
//mendeklarasikan PassFrame menjadi sebuah variabel pFrame 
//setTitle mengatur judul atau title frame 
//setDefaultCloseOperation mengatur event default saat frame akan ditutup 
//setSize mengatur lebar dan tinggi frame 
//setLocation menentukan posisi frame 
//show menampilkan frame 
Login pFrame = new Login(); 
pFrame.setTitle("Login User"); 
pFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
pFrame.setSize(400, 200); 
//mendapatkan ukuran dimensi layar monitor dari sistem 
Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); 
int panjang = (screen.width - pFrame.getSize().width) / 2; 
int lebar = (screen.width - pFrame.getSize().height) / 2; 
pFrame.setLocationRelativeTo(null);
pFrame.show(); 
} 

//membuat kelas addListener 
//kelas addListener di gunakan untuk pendefinisian metode 
public void addListener() 
{ 
//membuat event handling saat tombol jLogin di tekan 
//metode event-nya adalah ActionEvent 
jLogin.addActionListener(new ActionListener() 
{ 
public void actionPerformed(ActionEvent e) 
{ 
jLogin_actionPerformed(e); 
} 
}); 

//membuat event handling saat tombol jCancel di tekan 
//metode event-nya adalah ActionEvent 
jCancel.addActionListener(new ActionListener() 
{ 
public void actionPerformed(ActionEvent e) 
{ 
jCancel_actionPerformed(e); 
} 
}); 
} 

//menentukan aksi dari event dari tombol jLogin 
//event tersebut akan di tangkap oleh jLogin_actionPerformed 
public void jLogin_actionPerformed(ActionEvent e) 
{ 
//aksi saat tombol jLogin ditekan 
//apabila textfield inputID diisi "1234", inputNama diisi "kampreto" 
//inputPass diisi "lupa" maka akan muncul kotak pesan "Anda berhasil login" 
if(inputID.getText().equals("1111") && 
inputNama.getText().equals("admin") && 
inputPass.getText().equals("admin")) 
{ 
JOptionPane.showMessageDialog(null, "Anda berhasil login Admin"); 
    dispose();
    FormMainMenu s = new FormMainMenu ();
		s.setVisible(true);
                s.setLocationRelativeTo(null);
} 

//jika tidak akan keluar kotak pesan "Anda gagal login" 
else if (inputID.getText().equals("1234") && 
inputNama.getText().equals("member") && 
inputPass.getText().equals("member")) 
{ 
JOptionPane.showMessageDialog(null, "Anda berhasil login sebagai Member"); 
dispose();
LihatBuku s = new LihatBuku ();
		s.setVisible(true);
                s.setLocationRelativeTo(null);
}

else {
    JOptionPane.showMessageDialog(null, "ID Nama atau Password yang anda masukkan Salah!");
}
} 

//menentukan aksi dari event dari tombol jCancel 
//event tersebut akan di tangkap oleh jLogin_actionPerformed 
public void jCancel_actionPerformed(ActionEvent e) 
{ 
//aksinya adalah memunculkan kotak dialog "Anda telah keluar dari Program" 
//dan keluar dari program 
JOptionPane.showMessageDialog(null, "Anda telah keluar dari Program"); 
System.exit(0); 
} 
}