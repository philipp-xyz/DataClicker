package main.dataclicker.minigames.dataSlots;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Slotsmain {
	public static void main(String[] args) {
		
		Random rdm = new Random();
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask (){
		    public void run() {
		    	boolean run = true;
		    	int stop=0;
		    	if (run==true) {	 
		    	int Slot1 = rdm.nextInt(9)+1;
				int Slot2 = rdm.nextInt(9)+1;
				int Slot3 = rdm.nextInt(9)+1;
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
		    	 
		    	 else {
					
		    		 while (stop <=2){
		    		 int Slot2 = rdm.nextInt(9)+1;
		    		 }
		    		 while (stop <=2){
		    			 int Slot3 = rdm.nextInt(9)+1;
			    		 }
		    		
		    		 stop=stop+1; 
		    	 }
		    	if (stop >=10) timer.cancel();
		    		 
		    }
		},1*1000, 200);	
		
			
			
			
			
			
		
			
		
		
		
	}
}
