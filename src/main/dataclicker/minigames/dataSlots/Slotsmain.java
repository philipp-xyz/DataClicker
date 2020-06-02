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
		    	int Slot1 = rdm.nextInt(9)+1;
				int Slot2 = rdm.nextInt(9)+1;
				int Slot3 = rdm.nextInt(9)+1;
				
				SlotGui.setGui_Slot1(Slot1);
				SlotGui.setGui_Slot2(Slot2);
				SlotGui.setGui_Slot3(Slot3);
				SlotGui.refreshLabels();
				
				
				if	(Slot1==7 && Slot3 ==7 && Slot2 ==7) {
					System.out.println("Jackpot");}
				else if (Slot1==7 && Slot2 ==7 || Slot2 == 7 && Slot3 ==7 || Slot1 ==7 && Slot3 == 7){
					System.out.println("Huge Prize");
				}
				else if (Slot1==7 || Slot2 == 7 || Slot3 == 7){
					System.out.println("Prize");
				}
				else if (Slot1 == Slot2 && Slot2== Slot3){
					{System.out.println("You´ve won");}
				
				}
				System.out.println("you lost");
		    		 }
		    	 
		    	 if(ran==true && run ==false) {
					
		    		 while (stop <=2){
		    		 int Slot2 = rdm.nextInt(9)+1;
		    		 SlotGui.setGui_Slot2(Slot2);
		    		 int Slot3 = rdm.nextInt(9)+1;
	    			 SlotGui.setGui_Slot3(Slot3);
	    			 
		    		 SlotGui.refreshLabels();
		    		 stop=stop+1; 
		    		 }
		    		 while (stop <=5){
		    			 int Slot3 = rdm.nextInt(9)+1;
		    			 SlotGui.setGui_Slot3(Slot3);
		    			 SlotGui.refreshLabels();
		    			 stop=stop+1; 
		    		 }
		    		
		    		
						
						
		    		 
		    		 stop=stop+1; 
		    	 }
		    	if (stop >=10) timer.cancel();
		    		 
		    }
		},1*1000, 200);	
	}
		
	 public static void setRun(boolean variable) {
    	  run = variable;
     }
	 public static boolean getRun() {
			return run;
		}
			
			
		
			
		
		
		
	
}
