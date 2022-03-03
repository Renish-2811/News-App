package basics;
import java.util.Scanner;
import java.lang.Math;
import java.io.*;








public class main {
public static void main(String[] args) {
		try {
			String line = "";
			int p,r = 0;
			String x;
			FileReader myFile = new FileReader("C:\\Users\\sthak\\Downloads\\poker-hand-training-true.data");
			BufferedReader br = new BufferedReader(myFile);
			
			System.out.println("S(1,2,3,4)={Hearts, Spades, Diamonds, Clubs}");
			System.out.println("C(1-13)=(Ace, 2, 3, ... , Queen, King)");
			System.out.println("pocker hand(0-9) = 0: Nothing in hand; not a recognized poker hand\r\n" + 
					"1: One pair; one pair of equal ranks within five cards\r\n" + 
					"2: Two pairs; two pairs of equal ranks within five cards\r\n" + 
					"3: Three of a kind; three equal ranks within five cards\r\n" + 
					"4: Straight; five cards, sequentially ranked with no gaps\r\n" + 
					"5: Flush; five cards with the same suit\r\n" + 
					"6: Full house; pair + different rank three of a kind\r\n" + 
					"7: Four of a kind; four equal ranks within five cards\r\n" + 
					"8: Straight flush; straight + flush\r\n" + 
					"9: Royal flush; {Ace, King, Queen, Jack, Ten} + flush\r\n" + 
					"\r\n" + 
					"");
			System.out.println("Enter pocker hand:");
		Scanner sc = new Scanner(System.in);
		x = sc.next();
		System.out.println("Numer of " + x +"type of card packs are:");
			
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				p = Integer.valueOf(values[10]);
			
				if(values[10].equalsIgnoreCase(x)) {
				
					System.out.println("S1 : " + values[0] + " C1 : " + values[1] + " S2 : " + values[2] + " C2 : " + values[3] + " S3 : " + values[4] + " C3 : " + values[5] + " S4 : " + values[6] + " C4 : " + values[7]
							+ " S5 : " + values[8] + " C5 : " + values[9]);
					r = r +1;
				
				}
				
				
				
				
				
				
				
			
				
			}
			
			
			br.close();
			sc.close();
		
			
			
			
		} 
		catch(IOException e) {
			System.out.println("file not found");
			e.printStackTrace();
}
		
}

	
			
		
			
		
		

	
		

		
		
		
		
			
		
		
		
		
		
	
		
			
				
				
					
					
				
				
				
					
				
			
		
		
	}
	
		


