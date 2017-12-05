/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfoperpus;

/**
 *
 * @author Herwin
 */
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


public class Abouts extends JFrame
{
	private JPanel contentPane;
	private JLabel lblWall;

	/**
	 * Create the frame.
	 */
	public Abouts() {
		setTitle("WinzApps About");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWall = new JLabel("");
		lblWall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisfoperpus/image/wall.png")));
		lblWall.setBounds(-1, -10, 1000, 396);
		contentPane.add(lblWall);
		setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	
					Abouts frame = new Abouts();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
