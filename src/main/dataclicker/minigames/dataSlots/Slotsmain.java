package main.dataclicker.minigames.dataSlots;
import java.awt.Container;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Slotsmain {
	
	
	
	public static boolean run = false;
	public static boolean ran = false; //the check if the Slot machine just ran
	

	public static Container pane = new Container();

	public static int slot1;
	public static int slot2;
	public static int slot3;
	
	public static void main(String[] args) {
	
	
		SlotGui.addComponentsToPane(pane);
		SlotGui.createAndShowGUI(true);
		
		Random rdm = new Random();
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask (){
		    public void run() {
		    	
		    	int stop=0;
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
		    	 
		    	 if(ran==true && run ==false) {
					
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
		    		
		    		
						
						
		    		 
		    		 stop=stop+1; 
		    	 }
		    	//if (stop >=10) timer.cancel();
		    		 
		    }
		},1*1000, 200);	
	}
		
	 public static void setRun(boolean variable) {
    	  run = variable;
     }
	 public static boolean getRun() {
			return run;
		}
			
	 public static void checkWin(int slot1,int slot2, int slot3) {
			if	(slot1==7 && slot3 ==7 && slot2 ==7) {
				System.out.println("Jackpot");}
			else if (slot1==7 && slot2 ==7 || slot2 == 7 && slot3 ==7 || slot1 ==7 && slot3 == 7){
				System.out.println("Huge Prize");
			}
			else if (slot1==7 || slot2 == 7 || slot3 == 7){
				System.out.println("Prize");
			}
			else if (slot1 == slot2 && slot2== slot3){
				{System.out.println("You´ve won");}
			
			}
			System.out.println("you lost");
	 }
			
		
			
		
		
		
	
}
