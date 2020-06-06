package main.dataclicker.minigames.dataSlots;
import java.awt.GridBagLayout;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

import main.dataclicker.player.Player;

public class Slotsmain {
	
	
	static Random rdm = new Random();
	public static boolean run = false;
	public static boolean ran = false; //the check if the Slot machine just ran
	

	public static JPanel panel = new JPanel();

	public static int slot1;
	public static int slot2;
	public static int slot3;
	
	public static void checkWin(int slot1,int slot2, int slot3) {
		if	(slot1==7 && slot3 ==7 && slot2 ==7) {
			SlotGui.label1.setText("Jackpot 250.000");
			Player.setMoneyAmount(Player.getMoneyAmount()+250000);}
		else if (slot1==7 && slot2 ==7 || slot2 == 7 && slot3 ==7 || slot1 ==7 && slot3 == 7){
			SlotGui.label1.setText("Großer Preis 8.333");
			Player.setMoneyAmount(Player.getMoneyAmount()+8333);
		}
		else if (slot1==7 || slot2 == 7 || slot3 == 7){
			SlotGui.label1.setText("Kleiner Preis 600");
			Player.setMoneyAmount(Player.getMoneyAmount()+600);
		}
		else if (slot1 == slot2 && slot2== slot3){
			{SlotGui.label1.setText("Du hast 7500 Gewonnen");
			Player.setMoneyAmount(Player.getMoneyAmount()+7500);}
		
		}
		else if (slot1 == slot2 || slot2== slot3 || slot1 == slot3){
			{SlotGui.label1.setText("Trostpreis (260)");
			Player.setMoneyAmount(Player.getMoneyAmount()+260);}
		
		}
		else SlotGui.label1.setText("Leider Verloren");
 }
	
	
	public static void main(String[] args) {
	
		panel.setBorder(null);
		GridBagLayout gbl_panel= new GridBagLayout();
		gbl_panel.columnWidths=new int[] { 40,140,20,140,20,140,40};
		gbl_panel.rowHeights=new int[] {125,125,125,125};
		gbl_panel.columnWeights= new double[] {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
		gbl_panel.rowWeights=new double[] {0.0,0.0,0.0,0.0};
		panel.setLayout(gbl_panel);
		SlotGui.addComponentsToPanel(panel);
		SlotGui.createAndShowGUI(true);
		
		
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask (){
		    public void run() {
		    	
		    	
		    	if (run==true) {
		    		ran=true;
		    	 slot1 = rdm.nextInt(9)+1;
				 slot2 = rdm.nextInt(9)+1;
				 slot3 = rdm.nextInt(9)+1;
				
				SlotGui.setGui_slot1(slot1);
				SlotGui.setGui_slot2(slot2);
				SlotGui.setGui_slot3(slot3);
				SlotGui.refreshLabels();
				
		    	}
		    	 
		    	
		    	//if (stop >=10) timer.cancel();
		    		 
		    }
		},1*1000, 200);	
	}
		
	
	 public static void stopper(){
		 int stop=0;
		 while (stop <=2){
		 int slot2 = rdm.nextInt(9)+1;
		 SlotGui.setGui_slot2(slot2);
		 int slot3 = rdm.nextInt(9)+1;
		 SlotGui.setGui_slot3(slot3);
		 
		 SlotGui.refreshLabels();
		 stop=stop+1; 
		 }
		 while (stop <=5){
			 int slot3 = rdm.nextInt(9)+1;
			 SlotGui.setGui_slot3(slot3);
			 SlotGui.refreshLabels();
			 stop=stop+1; 
		 }
		
		 SlotGui.setGui_slot1(slot1);
			SlotGui.setGui_slot2(slot2);
			SlotGui.setGui_slot3(slot3);
			SlotGui.refreshLabels();
		 checkWin(slot1, slot2, slot3);
			
		 
		 
	 }
	 
	 
	 
	 public static void setRun(boolean variable) {
    	  run = variable;
     }
	 public static boolean getRun() {
			return run;
		}
			
	 
			
		
			
		
		
		
	
}
