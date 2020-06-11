package main.dataclicker.minigames.blackJack.bj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import main.dataclicker.*;
import main.dataclicker.player.Player;

public class BJ 
{
	/*public static void main(String[] args)
	{
		new BJ("Black Jack", 800, 800);
	}
	*/
	
	private String title;
	private int width;
	private int height;
	private JFrame frame;
	private static int einsatz = 1;
	private static int vermögen;
	private boolean runde = true;
	static JButton start = new JButton("Karten legen");
	static JLabel kapital = new JLabel();
	static JLabel eingesetzt = new JLabel("Einsatz: " + einsatz + " Euro");
	static JButton erhöhen = new JButton("Einsatz erhöhen");
	static JButton senken = new JButton("Einsatz senken");
	static JButton karte = new JButton("Karte ziehen");
	static JButton keineKarte = new JButton("keine Karte ziehen");
	static JButton verdoppeln = new JButton("Verdoppeln");
	static JLabel label1 = new JLabel("Ihre Karten");
	static JLabel label2 = new JLabel("Karten des Croupier");
	static JLabel label3 = new JLabel("Der Croupier zieht bis er mindesten 17 hat");
	//possible spieler karten
	private int s1 = 0; 
	private int s2 = 0;
	private int s3 = 0;
	private int s4 = 0;
	private int s5 = 0;
	//possible croupier karten
	private int c1 = 0;
	private int c2 = 0;
	private int c3 = 0;
	private int c4 = 0;
	private int c5 = 0;
	//??homestuck?? o no wait it's hilfs-karten to determine the suit
	private int hs1;
	private int hs2;
	private int hs3;
	private int hs4;
	private int hs5;
	private int hc1;
	private int hc2;
	private int hc3;
	private int hc4;
	private int hc5;
	static JLabel s1A = new JLabel("");
	static JLabel s2A = new JLabel("");
	static JLabel s3A = new JLabel("");
	static JLabel s4A = new JLabel("");
	static JLabel s5A = new JLabel("");
	static JLabel c1A = new JLabel("");
	static JLabel c2A = new JLabel("");
	static JLabel c3A = new JLabel("");
	static JLabel c4A = new JLabel("");
	static JLabel c5A = new JLabel("");
	static JLabel sieger = new JLabel("");
	private String c2Hilf;
	
	
	public BJ(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;	
		createDisplay();
		vermögen = Player.getMoneyAmount();
		kapital.setText("Vermögen: " + vermögen + " Euro");
	}

	private void createDisplay() 
	{
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.add(start);
		start.setBounds(300, 400, 200, 100);
		frame.add(eingesetzt);
		eingesetzt.setBounds(300, 375, 200, 25);
		frame.add(kapital);
		kapital.setBounds(300, 350, 200, 25);
		frame.add(erhöhen);
		erhöhen.setBounds(505, 400, 150, 50);
		frame.add(senken);
		senken.setBounds(505, 450, 150, 50);
		frame.add(karte);
		karte.setBounds(145, 400, 150, 33);
		karte.setVisible(false);
		frame.add(keineKarte);
		keineKarte.setBounds(145, 433, 150, 33);
		keineKarte.setVisible(false);
		frame.add(verdoppeln);
		verdoppeln.setBounds(145, 466, 150, 33);
		verdoppeln.setVisible(false);
		frame.add(label1);
		label1.setBounds(350, 500, 100, 50);
		frame.add(label2);
		label2.setBounds(300, 50, 150, 50);
		frame.add(label3);
		label3.setBounds(250, 10, 250, 50);
		frame.add(s1A);
		frame.add(s2A);
		frame.add(s3A);
		frame.add(s4A);
		frame.add(s5A);
		frame.add(c1A);
		frame.add(c2A);
		frame.add(c3A);
		frame.add(c4A);
		frame.add(c5A);
		s1A.setBounds(73, 550, 130, 230);
		s2A.setBounds(206, 550, 130, 230);
		s3A.setBounds(339, 550, 130, 230);
		s4A.setBounds(472, 550, 130, 230);
		s5A.setBounds(605, 550, 130, 230);
		c1A.setBounds(73, 75, 130, 230);
		c2A.setBounds(206, 75, 130, 230);
		c3A.setBounds(339, 75, 130, 230);
		c4A.setBounds(472, 75, 130, 230);
		c5A.setBounds(605, 75, 130, 230);
		frame.add(sieger);
		sieger.setBounds(300, 300, 200, 50);
		
		erhöhen.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						if(einsatz < 1000000)
						{	
							if(einsatz >= 100000)
								einsatz = einsatz + 100000;
							else if (einsatz >= 10000)
								einsatz = einsatz + 10000;
							else if(einsatz >= 1000)
								einsatz = einsatz + 1000;
							else if(einsatz >= 100)
								einsatz = einsatz + 100;
							else if(einsatz >= 10)
								einsatz = einsatz + 10;
							else
								einsatz = einsatz + 1;
							eingesetzt.setText("Einsatz: " + einsatz + " Euro");
						}	
					}
				});
		
		senken.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(einsatz > 0)
				{	
					if(einsatz > 100000)
						einsatz = einsatz - 100000;
					else if (einsatz > 10000)
						einsatz = einsatz - 10000;
					else if(einsatz > 1000)
						einsatz = einsatz - 1000;
					else if(einsatz > 100)
						einsatz = einsatz - 100;
					else if(einsatz > 10)
						einsatz = einsatz - 10;
					else
						einsatz = einsatz - 1;
					eingesetzt.setText("Einsatz: " + einsatz + " Euro");
				}	
			}
		});
		
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(runde && einsatz <= vermögen)
				{
					vermögen = vermögen - einsatz;
					kapital.setText("Vermögen: " + vermögen + " Euro");
					Player.setMoneyAmount(vermögen);
					erhöhen.setVisible(false);
					senken.setVisible(false);
					start.setText("Passen");
					karte.setVisible(true);
					keineKarte.setVisible(true);
					verdoppeln.setVisible(true);
					
					s1 = (int)(Math.random()*12+2);
					if(s1 == 12)
					{
						s1 = 10;
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
					}
					else if(s1 == 13)
					{
						s1 = 10;
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
					}
					else if(s1 == 14)
					{
						s1 = 10;
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
					}
					else if(s1 == 11)
					{
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
					}
					else if(s1 == 10)
					{
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
					}
					else if(s1 == 9)
					{
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
					}
					else if(s1 == 8)
					{
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
					}
					else if(s1 == 7)
					{
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
					}
					else if(s1 == 6)
					{
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
					}
					else if(s1 == 5)
					{
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
					}
					else if(s1 == 4)
					{
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
					}
					else if(s1 == 3)
					{
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
					}
					else if(s1 == 2)
					{
						hs1 = (int)(Math.random()*4);
						if(hs1 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
						else if(hs1 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
						else if(hs1 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
					}
						
					
					s2 = (int)(Math.random()*12+2);
					if(s2 == 12)
					{
						s2 = 10;
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
					}
					else if(s2 == 13)
					{
						s2 = 10;
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
					}
					else if(s2 == 14)
					{
						s2 = 10;
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
					}
					else if(s2 == 11)
					{
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
					}
					else if(s2 == 10)
					{
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
					}
					else if(s2 == 9)
					{
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
					}
					else if(s2 == 8)
					{
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
					}
					else if(s2 == 7)
					{
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
					}
					else if(s2 == 6)
					{
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
					}
					else if(s2 == 5)
					{
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
					}
					else if(s2 == 4)
					{
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
					}
					else if(s2 == 3)
					{
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
					}
					else if(s2 == 2)
					{
						hs2 = (int)(Math.random()*4);
						if(hs2 == 0)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
						else if(hs2 == 1)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
						else if(hs2 == 2)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
						else if(hs2 == 3)
							s2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
					}
					
					c1 = (int)(Math.random()*12+2);
					if(c1 == 12)
					{
						c1 = 10;
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
					}
					else if(c1 == 13)
					{
						c1 = 10;
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
					}
					else if(c1 == 14)
					{
						c1 = 10;
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
					}
					else if(c1 == 11)
					{
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
					}
					else if(c1 == 10)
					{
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
					}
					else if(c1 == 9)
					{
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
					}
					else if(c1 == 8)
					{
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
					}
					else if(c1 == 7)
					{
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
					}
					else if(c1 == 6)
					{
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
					}
					else if(c1 == 5)
					{
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
					}
					else if(c1 == 4)
					{
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
					}
					else if(c1 == 3)
					{
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
					}
					else if(c1 == 2)
					{
						hc1 = (int)(Math.random()*4);
						if(hc1 == 0)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
						else if(hc1 == 1)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
						else if(hc1 == 2)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
						else if(hc1 == 3)
							c1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
					}
					
					c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/Bilder/KartenHintergrund.png")));
					c2 = (int)(Math.random()*12+2);
					if(c2 == 12)
					{
						c2 = 10;
						c2Hilf = "Bube";
					}
					else if(c2 == 13)
					{
						c2 = 10;
						c2Hilf = "Dame";
					}
					else if(c2 == 14)
					{
						c2 = 10;
						c2Hilf = "K�nig";
					}
					if(c2 == 11)
						c2Hilf = "Ass";
					
					if(s1 + s2 == 21 && c1 + c2 != 21)
					{
						sieger.setText("Sie gewinnen");
						start.setText("Beenden");
						vermögen = (int) (vermögen + 0.5 * einsatz);
						kapital.setText("Vermögen: " + vermögen + " Euro");
						Player.setMoneyAmount(vermögen);
						if(c2Hilf == "Bube")
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
						}
						else if(c2Hilf == "Dame")
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
						}
						else if(c2Hilf == "K�nig")
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
						}
						else if(c2Hilf == "Ass")
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
						}
						else if(c2 == 10)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
						}
						else if(c2 == 9)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
						}
						else if(c2 == 8)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
						}
						else if(c2 == 7)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
						}
						else if(c2 == 6)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
						}
						else if(c2 == 5)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
						}
						else if(c2 == 4)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
						}
						else if(c2 == 3)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
						}
						else if(c2 == 2)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
						}
					}
					else if(s1 + s2 == 21 && c1 + c2 == 21)
					{
						sieger.setText("Unentschieden");
						start.setText("Beenden");
						vermögen = vermögen + einsatz;
						kapital.setText("Verm�gen: " + vermögen + " Euro");
						Player.setMoneyAmount(vermögen);
						if(c2Hilf == "Bube")
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
						}
						else if(c2Hilf == "Dame")
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
						}
						else if(c2Hilf == "K�nig")
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
						}
						else if(c2Hilf == "Ass")
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
						}
						else if(c2 == 10)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
						}
						else if(c2 == 9)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
						}
						else if(c2 == 8)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
						}
						else if(c2 == 7)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
						}
						else if(c2 == 6)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
						}
						else if(c2 == 5)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
						}
						else if(c2 == 4)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
						}
						else if(c2 == 3)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
						}
						else if(c2 == 2)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
						}
					}
					else if (c1 + c2 == 21)
					{
						sieger.setText("Croupier gewinnt");
						start.setText("Beenden");
						if(c2Hilf == "Bube")
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
						}
						else if(c2Hilf == "Dame")
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
						}
						else if(c2Hilf == "K�nig")
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
						}
						else if(c2Hilf == "Ass")
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
						}
						else if(c2 == 10)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
						}
						else if(c2 == 9)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
						}
						else if(c2 == 8)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
						}
						else if(c2 == 7)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
						}
						else if(c2 == 6)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
						}
						else if(c2 == 5)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
						}
						else if(c2 == 4)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
						}
						else if(c2 == 3)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
						}
						else if(c2 == 2)
						{
							hc2 = (int)(Math.random()*4);
							if(hc2 == 0)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
							else if(hc2 == 1)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
							else if(hc2 == 2)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
							else if(hc2 == 3)
								c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
						}
					}
					
					runde = false;
				}
				else
				{
					
					finish();
					
				}
			}
		});
		
		
		
		karte.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				verdoppeln.setVisible(false);
				if(s3 == 0)
				{
					s3 = (int)(Math.random()*12+2);
					if(s3 == 12)
					{
						s3 = 10;
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
					}
					else if(s3 == 13)
					{
						s3 = 10;
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
					}
					else if(s3 == 14)
					{
						s3 = 10;
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
					}
					else if(s3 == 11)
					{
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
					}
					else if(s3 == 10)
					{
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
					}
					else if(s3 == 9)
					{
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
					}
					else if(s3 == 8)
					{
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
					}
					else if(s3 == 7)
					{
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
					}
					else if(s3 == 6)
					{
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
					}
					else if(s3 == 5)
					{
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
					}
					else if(s3 == 4)
					{
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
					}
					else if(s3 == 3)
					{
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
					}
					else if(s3 == 2)
					{
						hs3 = (int)(Math.random()*4);
						if(hs3 == 0)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
						else if(hs3 == 1)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
						else if(hs3 == 2)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
						else if(hs3 == 3)
							s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
					}
				}
				else if(s4 == 0)
				{
					s4 = (int)(Math.random()*12+2);
					if(s4 == 12)
					{
						s4 = 10;
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
					}
					else if(s4 == 13)
					{
						s4 = 10;
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
					}
					else if(s4 == 14)
					{
						s4 = 10;
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
					}
					else if(s4 == 11)
					{
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
					}
					else if(s4 == 10)
					{
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
					}
					else if(s4 == 9)
					{
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
					}
					else if(s4 == 8)
					{
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
					}
					else if(s4 == 7)
					{
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
					}
					else if(s4 == 6)
					{
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
					}
					else if(s4 == 5)
					{
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
					}
					else if(s4 == 4)
					{
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
					}
					else if(s4 == 3)
					{
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
					}
					else if(s4 == 2)
					{
						hs4 = (int)(Math.random()*4);
						if(hs4 == 0)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
						else if(hs4 == 1)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
						else if(hs4 == 2)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
						else if(hs4 == 3)
							s4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
					}
				}
				else
				{
					s5 = (int)(Math.random()*12+2);
					if(s5 == 12)
					{
						s5 = 10;
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
						else if(hs5 == 1)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
						else if(hs5 == 2)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
						else if(hs5 == 3)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
					}
					else if(s5 == 13)
					{
						s5 = 10;
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
						else if(hs5 == 1)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
						else if(hs5 == 2)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
						else if(hs5 == 3)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
					}
					else if(s5 == 14)
					{
						s5 = 10;
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
						else if(hs5 == 1)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
						else if(hs5 == 2)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
						else if(hs5 == 3)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
					}
					else if(s5 == 11)
					{
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
						else if(hs5 == 1)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
						else if(hs5 == 2)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
						else if(hs5 == 3)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
					}
					else if(s5 == 10)
					{
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
						else if(hs5 == 1)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
						else if(hs5 == 2)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
						else if(hs5 == 3)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
					}
					else if(s5 == 9)
					{
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
						else if(hs5 == 1)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
						else if(hs5 == 2)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
						else if(hs5 == 3)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
					}
					else if(s5 == 8)
					{
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
						else if(hs5 == 1)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
						else if(hs5 == 2)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
						else if(hs1 == 3)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
					}
					else if(s5 == 7)
					{
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
						else if(hs5 == 1)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
						else if(hs5 == 2)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
						else if(hs5 == 3)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
					}
					else if(s5 == 6)
					{
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
						else if(hs5 == 1)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
						else if(hs5 == 2)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
						else if(hs5 == 3)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
					}
					else if(s5 == 5)
					{
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
						else if(hs5 == 1)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
						else if(hs5 == 2)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
						else if(hs5 == 3)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
					}
					else if(s5 == 4)
					{
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
						else if(hs5 == 1)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
						else if(hs5 == 2)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
						else if(hs5 == 3)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
					}
					else if(s5 == 3)
					{
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
						else if(hs5 == 1)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
						else if(hs5 == 2)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
						else if(hs5 == 3)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
					}
					else if(s5 == 2)
					{
						hs5 = (int)(Math.random()*4);
						if(hs5 == 0)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
						else if(hs5 == 1)
							s1A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
						else if(hs5 == 2)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
						else if(hs5 == 3)
							s5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
					}
				}
				
				if(s1 + s2 + s3 + s4 + s5 > 21)
				{
					sieger.setText("Sie haben sich �berkauft");
					karte.setVisible(false);
					keineKarte.setVisible(false);
					start.setText("Beenden");
				}
			}
		});
		
		keineKarte.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				verdoppeln.setVisible(false);
				karte.setVisible(false);
				keineKarte.setVisible(false);
				if(c2Hilf == "Bube")
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
				}
				else if(c2Hilf == "Dame")
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
				}
				else if(c2Hilf == "K�nig")
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
				}
				else if(c2Hilf == "Ass")
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
				}
				else if(c2 == 10)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
				}
				else if(c2 == 9)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
				}
				else if(c2 == 8)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
				}
				else if(c2 == 7)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
				}
				else if(c2 == 6)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
				}
				else if(c2 == 5)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
				}
				else if(c2 == 4)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
				}
				else if(c2 == 3)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
				}
				else if(c2 == 2)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
				}
				
				if(c1 + c2 < 17)
				{
					c3 = (int)(Math.random()*12+2);
					if(c3 == 12)
					{
						c3 = 10;
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
					}
					else if(c3 == 13)
					{
						c3 = 10;
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
					}
					else if(c3 == 14)
					{
						c3 = 10;
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
					}
					else if(c3 == 11)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
					}
					else if(c3 == 10)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
					}
					else if(c3 == 9)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
					}
					else if(c3 == 8)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
					}
					else if(c3 == 7)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
					}
					else if(c3 == 6)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
					}
					else if(c3 == 5)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
					}
					else if(c3 == 4)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
					}
					else if(c3 == 3)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
					}
					else if(c3 == 2)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
					}
				}
				if(c1 + c2 + c3 < 17)
				{
					c4 = (int)(Math.random()*12+2);
					if(c4 == 12)
					{
						c4 = 10;
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
					}
					else if(c4 == 13)
					{
						c4 = 10;
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
					}
					else if(c4 == 14)
					{
						c4 = 10;
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
					}
					else if(c4 == 11)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
					}
					else if(c4 == 10)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
					}
					else if(c4 == 9)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
					}
					else if(c4 == 8)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
					}
					else if(c4 == 7)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
					}
					else if(c4 == 6)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
					}
					else if(c4 == 5)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
					}
					else if(c4 == 4)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
					}
					else if(c4 == 3)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
					}
					else if(c4 == 2)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
						else if(c4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
					}
				}
				if(c1 + c2 + c3 + c4 < 17)
				{
					c5 = (int)(Math.random()*12+2);
					if(c5 == 12)
					{
						c5 = 10;
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
					}
					else if(c5 == 13)
					{
						c5 = 10;
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
					}
					else if(c5 == 14)
					{
						c5 = 10;
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
					}
					else if(c5 == 11)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
					}
					else if(c5 == 10)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
					}
					else if(c5 == 9)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
					}
					else if(c5 == 8)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
					}
					else if(c5 == 7)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
					}
					else if(c5 == 6)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
					}
					else if(c5 == 5)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
					}
					else if(c5 == 4)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
					}
					else if(c5 == 3)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
					}
					else if(c5 == 2)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
					}
				}
				
				if(c1 + c2 + c3 + c4 + c5 > 21)
				{
					sieger.setText("Croupier hat sich �berkauft");
					start.setText("Beenden");
					vermögen = vermögen + 2 * einsatz;
					kapital.setText("Vermögen: " + vermögen + " Euro");
					Player.setMoneyAmount(vermögen);
					
				}
				else if(c1 + c2 + c3 + c4 + c5 > s1 + s2 + s3 + s4 + s5)
				{
					sieger.setText("Croupier gewinnt");
					start.setText("Beenden");
				}
				else if(c1 + c2 + c3 + c4 + c5 == s1 + s2 + s3 + s4 + s5)
				{
					sieger.setText("Unentschieden");
					start.setText("Beenden");
					vermögen = vermögen + einsatz;
					kapital.setText("Vermögen: " + vermögen + " Euro");
					c2A.setText(c2 + "");
				}
				else
				{
					sieger.setText("Sie gewinnen");
					start.setText("Beenden");
					vermögen = vermögen + 2 * einsatz;
					kapital.setText("Vermögen: " + vermögen + " Euro");
				}
			}
		});
		
		verdoppeln.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				einsatz = einsatz * 2;
				verdoppeln.setVisible(false);
				karte.setVisible(false);
				keineKarte.setVisible(false);
				s3 = (int)(Math.random()*12+2);
				s3 = (int)(Math.random()*12+2);
				if(s3 == 12)
				{
					s3 = 10;
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
				}
				else if(s3 == 13)
				{
					s3 = 10;
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
				}
				else if(s3 == 14)
				{
					s3 = 10;
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
				}
				else if(s3 == 11)
				{
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
				}
				else if(s3 == 10)
				{
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
				}
				else if(s3 == 9)
				{
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
				}
				else if(s3 == 8)
				{
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
				}
				else if(s3 == 7)
				{
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
				}
				else if(s3 == 6)
				{
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
				}
				else if(s3 == 5)
				{
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
				}
				else if(s3 == 4)
				{
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
				}
				else if(s3 == 3)
				{
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
				}
				else if(s3 == 2)
				{
					hs3 = (int)(Math.random()*4);
					if(hs3 == 0)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
					else if(hs3 == 1)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
					else if(hs3 == 2)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
					else if(hs3 == 3)
						s3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
				}
				
				if(c2Hilf == "Bube")
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
				}
				else if(c2Hilf == "Dame")
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
				}
				else if(c2Hilf == "K�nig")
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
				}
				else if(c2Hilf == "Ass")
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
				}
				else if(c2 == 10)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
				}
				else if(c2 == 9)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
				}
				else if(c2 == 8)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
				}
				else if(c2 == 7)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
				}
				else if(c2 == 6)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
				}
				else if(c2 == 5)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
				}
				else if(c2 == 4)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
				}
				else if(c2 == 3)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
				}
				else if(c2 == 2)
				{
					hc2 = (int)(Math.random()*4);
					if(hc2 == 0)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
					else if(hc2 == 1)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
					else if(hc2 == 2)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
					else if(hc2 == 3)
						c2A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
				}
				
				if(c1 + c2 < 17)
				{
					c3 = (int)(Math.random()*12+2);
					if(c3 == 12)
					{
						c3 = 10;
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
					}
					else if(c3 == 13)
					{
						c3 = 10;
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
					}
					else if(c3 == 14)
					{
						c3 = 10;
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
					}
					else if(c3 == 11)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
					}
					else if(c3 == 10)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
					}
					else if(c3 == 9)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
					}
					else if(c3 == 8)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
					}
					else if(c3 == 7)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
					}
					else if(c3 == 6)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
					}
					else if(c3 == 5)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
					}
					else if(c3 == 4)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
					}
					else if(c3 == 3)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
					}
					else if(c3 == 2)
					{
						hc3 = (int)(Math.random()*4);
						if(hc3 == 0)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
						else if(hc3 == 1)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
						else if(hc3 == 2)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
						else if(hc3 == 3)
							c3A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
					}
				}
				if(c1 + c2 + c3 < 17)
				{
					c4 = (int)(Math.random()*12+2);
					if(c4 == 12)
					{
						c4 = 10;
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
					}
					else if(c4 == 13)
					{
						c4 = 10;
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
					}
					else if(c4 == 14)
					{
						c4 = 10;
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
					}
					else if(c4 == 11)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
					}
					else if(c4 == 10)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
					}
					else if(c4 == 9)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
					}
					else if(c4 == 8)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
					}
					else if(c4 == 7)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
					}
					else if(c4 == 6)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
					}
					else if(c4 == 5)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
					}
					else if(c4 == 4)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
					}
					else if(c4 == 3)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
						else if(hc4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
					}
					else if(c4 == 2)
					{
						hc4 = (int)(Math.random()*4);
						if(hc4 == 0)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
						else if(c4 == 1)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
						else if(hc4 == 2)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
						else if(hc4 == 3)
							c4A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
					}
				}
				if(c1 + c2 + c3 + c4 < 17)
				{
					c5 = (int)(Math.random()*12+2);
					if(c5 == 12)
					{
						c5 = 10;
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzBube.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroBube.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikBube.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzBube.png")));
					}
					else if(c5 == 13)
					{
						c5 = 10;
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzDame.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroDame.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikDame.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzDame.png")));
					}
					else if(c5 == 14)
					{
						c5 = 10;
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzK�nig.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroK�nig.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikK�nig.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzK�nig.png")));
					}
					else if(c5 == 11)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/HerzAss.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KaroAss.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/PikAss.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/KreuzAss.png")));
					}
					else if(c5 == 10)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz10.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo10.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik10.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz10.png")));
					}
					else if(c5 == 9)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz9.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo9.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik9.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz9.png")));
					}
					else if(c5 == 8)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz8.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo8.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik8.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz8.png")));
					}
					else if(c5 == 7)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz7.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo7.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik7.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz7.png")));
					}
					else if(c5 == 6)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz6.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo6.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik6.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz6.png")));
					}
					else if(c5 == 5)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz5.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo5.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik5.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz5.png")));
					}
					else if(c5 == 4)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz4.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo4.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik4.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz4.png")));
					}
					else if(c5 == 3)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz3.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo3.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik3.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz3.png")));
					}
					else if(c5 == 2)
					{
						hc5 = (int)(Math.random()*4);
						if(hc5 == 0)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Herz2.png")));
						else if(hc5 == 1)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Karo2.png")));
						else if(hc5 == 2)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Pik2.png")));
						else if(hc5 == 3)
							c5A.setIcon(new ImageIcon(BJ.class.getResource("/main/dataclicker/minigames/blackJack/bilder/Kreuz2.png")));
					}
				}
				
				if(c1 + c2 + c3 + c4 + c5 > 21)
				{
					sieger.setText("Croupier hat sich �berkauft");
					start.setText("Beenden");
					vermögen = vermögen + 2 * einsatz;
					kapital.setText("Vermögen: " + vermögen + " Euro");
					Player.setMoneyAmount(vermögen);
					
				}
				else if(c1 + c2 + c3 + c4 + c5 > s1 + s2 + s3 + s4 + s5)
				{
					sieger.setText("Croupier gewinnt");
					start.setText("Beenden");
				}
				else if(c1 + c2 + c3 + c4 + c5 == s1 + s2 + s3 + s4 + s5)
				{
					sieger.setText("Unentschieden");
					start.setText("Beenden");
					vermögen = vermögen + einsatz;
					kapital.setText("Vermögen: " + vermögen + " Euro");
					Player.setMoneyAmount(vermögen);
					c2A.setText(c2 + "");
				}
				else
				{
					sieger.setText("Sie gewinnen");
					start.setText("Beenden");
					vermögen = vermögen + 2 * einsatz;
					kapital.setText("Vermögen: " + vermögen + " Euro");
					Player.setMoneyAmount(vermögen);
				}
			}
		});
	}
	public void finish() {
		erhöhen.setVisible(true);
		senken.setVisible(true);
		start.setText("Karten legen");
		karte.setVisible(false);
		keineKarte.setVisible(false);
		verdoppeln.setVisible(false);
		
		s1A.setIcon(null);
		s2A.setIcon(null);
		s3A.setIcon(null);
		s4A.setIcon(null);
		s5A.setIcon(null);
		c1A.setIcon(null);
		c2A.setIcon(null);
		c3A.setIcon(null);
		c4A.setIcon(null);
		c5A.setIcon(null);
		s1 = 0;
		s2 = 0;
		s3 = 0;
		s4 = 0;
		s5 = 0;
		c1 = 0;
		c2 = 0;
		c3 = 0;
		c4 = 0;
		c5 = 0;
		sieger.setText("");
		runde = true;
	}
}
