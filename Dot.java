package dotLocator;
import java.io.*;
import java.util.Arrays;

// Made By
//  /===\   ||=====  ||====||  ||====||
// ||   ||  ||		 ||	  //   ||    ||
// ||===||  ||==	 ||===     ||    ||
// ||   ||  ||		 ||	  \\   ||    ||
// ||   ||  ||=====  ||	   \\  ||====|| & Zero

//System.out.println("");

/*Separating Commas
 * 		Scanner xrange = new Scanner(System.in);
		String Xrange = xrange.nextLine();
		//xrange.close();
		char[] xin = Xrange.toCharArray();
		int commaindex = new String(Xrange).indexOf(",");
		if(commaindex != -1) {
			System.out.println("Index Of Comma : " + commaindex);
			System.out.println("Character Before Comma : " + xin[commaindex - 1]);
			System.out.println("Character Before Comma : " + xin[commaindex + 1]);
		}
		else {
			System.out.println("!!! You Didn't Added Comma In Your Input !!!");
			creategraph();
		}
*/

// ------------------------------------------------------
// -		NOTE :- 									-
// -		DO NOT WASTE YOUR TIME ON THIS PROGRAM		-
// -				ITS COMPLETE BULLSHIT :'( 			-
// ------------------------------------------------------

/* Updates And Logs
 * 		26.09.2018 (7:00 pm) : BufferedReader Fixed. Program Can Take Input From User
 * 							   More than once. Help Menu ReAdded;
 * 
 * 		28.09.2018 (3:06 am) : 1) Finally Got Create Graph Function Working But It have Printing
 * 							   Problems... Which i am not going to fix anyway;
 * 							   2) Made Help Menu Look A Little Better;
 * 
 * 		29.09.2018 (11:06 pm) : 1) Improved Printing For x values that are more than 9 & 99
 * 								and that are less than -9 & -99;
 * 									- Program Can Print Much Better Now;
 * 								2) Removed "Enter Y Value" entry and Set the y value same
 * 								as the x value. So The Graph now doesn't show null entries
 * 								While Printing;
 * 								================ PRINTING IMPROVED 100 % ==================
 * 		
 * 		02.10.2018 (1:50 am) : 1) Add Dot Function Is Fully Working (Have some minor bugs :
 * 							   Prints "X" in place of "-" instead of the whole number when the
 * 							   value of x axis is 0.);
 * 							   2) Remove Dot Function is now Working Fine As FUCK !!;
 * 							   3) Added A Menu For Printing Graph (Menu index No. : 4);
 * 							   4) Added Some New Empty Lines To Make It Look Pretty;
 */

public class Dot {
	
	public static String[][] graph;
	public static int halfx;
	public static int halfy;
	public static int totalx;
	public static int totaly;

	public static void mainmenu() {
		System.out.println("Type The Number To Select");
		System.out.println("1.Creat Graph");
		System.out.println("2.Add Dot");
		System.out.println("3.Remove Dot");
		System.out.println("4.Print Graph");
		System.out.println("5.Save File");
		System.out.println("6.Help");
	}
	
	public static void mainmenuinput() throws IOException {
		BufferedReader menuin = new BufferedReader(new InputStreamReader(System.in));
		String Menuin = menuin.readLine();
		
		if(Menuin.equals("1")) {
			creategraph();
		}
		else if(Menuin.equals("2")) {
			adddot();
		}
		else if(Menuin.equals("3")) {
			removedot();
		}
		else if(Menuin.equals("4")) {
			try {
				print();
				System.out.println();
			}catch(Exception e) {
				System.out.println();
				System.out.println(" [!] No Graph Has Been Created [!]");
				System.out.println();
			}
			mainmenu();
			mainmenuinput();
		}
		else if(Menuin.equals("6")) {
			System.out.println("");
			System.out.println("=================================================");
			System.out.println("=      Type The Number Of The Thing To Select   =");
			System.out.println("=  You Can Mail Me At ayushthakur667@gmail.com  =");
			System.out.println("=        Copyright (c) 2018 AeroAndZero         =");
			System.out.println("=               All Right Reserved              =");
			System.out.println("=================================================");
			System.out.println("");
			mainmenu();
			mainmenuinput();
		}
		else {
			System.out.println();
			System.out.println("=== Invalid Menu Number ===");
			System.out.println();
			mainmenu();
			mainmenuinput();
		}
		
	}
	
	public static void creategraph() throws IOException {
		System.out.println();
		System.out.println("============================================");
		
		System.out.println("Enter the Range of X & Y axis (eg. Typing 10 will make your"
				+ " graph's x & y -10 to 10 : ");
		
		//takes input of x axis
		BufferedReader inputx = new BufferedReader(new InputStreamReader(System.in));
		String stringx = inputx.readLine();
		
		// initializing y and x values
		double doublex = Double.parseDouble(stringx);
		double doubley = Double.parseDouble(stringx);
			//Making X And Y into integer
			int x = (int)Math.ceil(doublex);
			int y = (int)Math.ceil(doubley);
			
			//Setting Y and X Total Length
			totalx = x * 2 + 1;
			totaly = y * 2 + 1;
			int totalx2 = x * 2 + 1;
			//Real Y and X Numbers
			int actualx = x * -1;
			int actualy = y;
			int virtualx = x * -1;
			//Half Of X And Y
			halfx = totalx/2;
			halfy = totaly/2;
			
		//checking if x and y values are less than 0
		if(x > 0 && y > 0) {
			
			graph = new String[totaly][totalx];
			
			//Printing Out Stuff
			System.out.println();
			System.out.println("===== We Can Proceed =====");
			System.out.println("X : " + x);
			System.out.println("Y : "+ y);
			System.out.println("Total X : " + totalx);
			System.out.println("Total Y : " + totaly);
			System.out.println("Actual X : " + actualx);
			System.out.println("Actual Y : " + actualy);
			System.out.println("Half Of X : " + halfx);
			System.out.println("Half Of Y : " + halfy);
			System.out.println();
			
			//NOT WORKING> NEEDS A RECODE
			//UPDATE> ITS WORKING NOW
			//Generating Graph :
			for(int main = 0; main < totaly; main++) {
				
				// This Is For The Main X Axis
				if(main == halfy) {
					
					// Inputing X Values Into Array
					for(int i = 0; i < totalx;i++) {
						// For Negative X Axis Value
						if(actualx < 0) {
							graph[main][i] =Integer.toString(actualx);
						}
						
						//When X Axis Becomes 0
						else if(actualx == 0) {
							
							// Checks If the X range is bigger than [-9, 9] or not
							if(totalx2 < 19) {
								graph[main][i] = " " + Integer.toString(actualx);
							}
							else{
								graph[main][i] = "  " + Integer.toString(actualx);
							}
						}
						
						// Checks If The Number is More Than 100
						else if(actualx > 99) {
							graph[main][i] = "  " + Integer.toString(actualx);
						}
						
						//For Normal Numbers
						else {
							graph[main][i] = " " + Integer.toString(actualx);
						}
						actualx++;
					}
					actualy--;
				}
				
				// This Is For Y Axis
				else {
					virtualx = x * -1;
					for(int sub= 0; sub < totaly;sub++) {
						
						// Inputing Y Values Into Array
						if(sub == halfx) {
							if(actualy < 0) {
								graph[main][sub] = Integer.toString(actualy) + " ";
							}
							else {
								graph[main][sub] = " " + Integer.toString(actualy) + " ";
							}
							actualy--;
						}
						
						// Inputing Dots Into Array
						else {
							// I'm A Retard (Just in case if you don't know)
							if(virtualx <= -9) {
								if(virtualx < -99) {
									graph[main][sub] = "  . ";
								}
								else {
									graph[main][sub] = " . ";
								}
							}
							else if(virtualx >= 9) {
								if(virtualx >= 99) {
									graph[main][sub] = "   . ";
								}
								else {
									graph[main][sub] = " . ";
								}
							}
							else {
								graph[main][sub] = ". ";
							}
							virtualx++;
						}
					}
				}
			}
			
			// ======================= END OF THE FOR LOOP ========================
			
			//Printing The Graph
			print();
		}
		
		// Checks if The Input Number Is Negative (Out Dated)
		else if( x <= 0 || y <= 0){
			System.out.println("[!] Enter a Valid Number [!]");
			creategraph();
		}
		
		//Empty Line For Making It Look Good
		System.out.println();
		
		// Recalling The Main Menu Again
		mainmenu();
		mainmenuinput();
		
	} // End Of creategraph()
	
	public static void print() throws IOException{
		for(int j = 0; j < totaly; j++) {
			for(int k = 0; k < totalx; k++) {
				System.out.print(graph[j][k]);
			}
			System.out.println();
		}
	}
	
	public static void adddot() throws IOException{
		
		System.out.println();
		// Getting X And Y Values
		System.out.println("Enter The X Value Of The Point : ");
		BufferedReader dotxinput = new BufferedReader(new InputStreamReader(System.in));
		int dotx = Integer.parseInt(dotxinput.readLine());
		System.out.println("Enter The Y Value OF The Point : ");
		BufferedReader dotyinput = new BufferedReader(new InputStreamReader(System.in));
		int doty = Integer.parseInt(dotyinput.readLine());
		
		try {
			// Locating String On The Entered X And Y Values
			String location = graph[halfy - doty][halfx - (dotx * -1)];
		
			//Updating Graph
			char[] update = location.toCharArray();
			if(dotx == halfx - halfx) {
				update[new String(update).indexOf(Integer.toString(doty))] = 'X';
			}
			else {
				update[new String(update).indexOf(".")] = 'X';
			}
			graph[halfy - doty][halfx - (dotx * -1)] = new String(update);
			print();
		
		}catch(Exception e) {
			System.out.println();
			System.out.println("{!} Invalid Point Axis Entered {!}");
			System.out.println();
		}
		System.out.println();
		mainmenu();
		mainmenuinput();
		
	}
	
	public static void removedot() throws IOException{
		
		System.out.println();
		System.out.println("Enter The X Value Of The Point That You Want To Remove : ");
		BufferedReader dotxinput = new BufferedReader(new InputStreamReader(System.in));
		int dotx = Integer.parseInt(dotxinput.readLine());
		System.out.println("Enter The Y Value OF The Point That You Want To Remove : ");
		BufferedReader dotyinput = new BufferedReader(new InputStreamReader(System.in));
		int doty = Integer.parseInt(dotyinput.readLine());
		
		try {
			String location = graph[halfy - doty][halfx - (dotx * -1)];
		
			//Updating Graph
			char[] update = location.toCharArray();
			if(dotx == halfx - halfx) {
				String lasty = Integer.toString(doty);
				update[new String(update).indexOf("X")] = lasty.charAt(0);
			}
			else {
				update[new String(update).indexOf("X")] = '.';
			}
			
			graph[halfy - doty][halfx - (dotx * -1)] = new String(update);
			print();
			
		}catch(Exception e) {
			System.out.println();
			System.out.println("{!} Invalid Point Axis Entered {!}");
			System.out.println();
		}
		System.out.println();
		mainmenu();
		mainmenuinput();
	}
	
	public static void main(String[] args) throws IOException{
		
		mainmenu();
		mainmenuinput();
		
	}

}
