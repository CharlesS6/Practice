///////////////////////////////////////////////////////////////////////////////
// ALL STUDENTS COMPLETE THESE SECTIONS
// Title: (Itsy Bitsy Spider Visualizer)
// Files: (ItsyBitsySpiderVisualizer, Util)
// Semester: CS302 Spring 2014
//
// Author: (Jiachen Zhou)
// Email: (jzhou225@wisc.edu)
// CS Login: (jiachen)
// Lecturer's Name: (Deb Deppeler)
// Lab Section: (324)
//
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Scanner;




public class ItsyBitsySpiderVisualizer {

	/*
	 * You may NOT create non final static fields here. You also may not create
	 * any other public methods. You may create as many private methods as you
	 * want.
	 */

	public static void main(String[] args) {
		
		System.out.println("^@^ ^@^ ^@^ ^@^ ^@^ ^@^ ^@^ ^@^ ^@^ ^@^ ^@^ ^@^" +
				" ^@^ ^@^ ^@^ ^@^ ^@^ ^@^ ^@^ ^@^");
		System.out.println("Welcome to the Itsy Bitsy Spider visualizer!");
		System.out
				.println("In order to tell the Itsy Bitsy's story, " +
						"we need some information:");
		System.out.println();
		System.out.println("First what should be the spout's length?");
		System.out.println("(Enter 4 - 100 or 'r' for a random number " +
				"in that range.)");
		/* first question
		 * ask for the height of spout from user
		 */
		
		boolean pass = false;
		
		
		int a=0;
		do { String initialInput1 = Util.SCNR.nextLine();
		/*variable input used for receiving the height for spout */
			a = ItsyBitsySpiderVisualizer.evaluateUsersInput(initialInput1,
				Util.SPOUT_MIN, Util.SPOUT_MAX,!pass);
			// Check user's input for spout's length
			if(a==-1){
				System.out.println("Your integer was less than " + 
						Util.SPOUT_MIN + ". Please enter another.");
			}
			if(a==-2){
				System.out.println("Your integer was larger than " + 
						Util.SPOUT_MAX + ". Please enter another.");
			}
			if(a==-3){
				System.out.println(initialInput1
						+ " is not an integer. Please try again.");
			}
			
		}while(a==-1||a==-2||a==-3);
		
		System.out.println();
		System.out.println("How high does Itsy Bitsy climb " +
				"before the rain washes the spider out?");
		System.out.println("(Enter "+Util.CLIMB_MIN+"-"+(a-1)+
				" or 'r' for a random number in that range.)");
		/* second question
		 * ask for the height spider climbs from user
		 */
		int b=0;
		do{ String initialInput2 = Util.SCNR.nextLine();
		/*variable input used for receiving the height spider climbs */
			b = ItsyBitsySpiderVisualizer.evaluateUsersInput(initialInput2, 
				Util.CLIMB_MIN,a-1,!pass);
			// Check user's input for climb height
			if(b==-1){
				System.out.println("Your integer was less than " + 
						Util.CLIMB_MIN + ". Please enter another.");
			}
			if(b==-2){
				System.out.println("Your integer was larger than " + (a-1)
						+ ". Please enter another.");
			}
			if(b==-3){
				System.out.println(initialInput2
						+ " is not an integer. Please try again.");
			}
		}
		while(b==-1||b==-2||b==-3);
		
		/* third question
		 * ask for the spaces between spouts from user
		 */
		System.out.println();
		System.out.println("How far apart should the frames of the story" +
				" be located?");
		System.out.println("(Enter 1-3)");
		
		int c =0;
		do{ String initialInput3 = Util.SCNR.nextLine();
		/*variable input used for receiving the spaces between spouts */
			c=ItsyBitsySpiderVisualizer.evaluateUsersInput(initialInput3,
				Util.FRAME_MIN, Util.FRAME_MAX,pass);
			// Check user's input for spaces between spouts
			if(c==-1){
				System.out.println("Your integer was less than " + 
						Util.FRAME_MIN + ". Please enter another.");
			}
			if(c==-2){
				System.out.println("Your integer was larger than " + 
						Util.FRAME_MAX + ". Please enter another.");
			}
			if(c==-3){
				System.out.println(initialInput3
						+ " is not an integer. Please try again.");
			}
			
		}while(c==-1||c==-2||c==-3);
	
		System.out.println();
		char[][] mySpout1 = ItsyBitsySpiderVisualizer.getFirstVerse(a, b, c);
		//FIRST VERSE STARTS
		char[][] mySpout2 = ItsyBitsySpiderVisualizer.getSecondVerse(a, b, c);
		//SECOND VERSE STARTS
		char[][] mySpout3 = ItsyBitsySpiderVisualizer.getThirdVerse(a, b, c);
		//THIRD VERSE STARTS
		char[][] mySpout4 = ItsyBitsySpiderVisualizer.getFourthVerse(a, b, c);
		//FOURTH VERSE STARTS
		System.out
				.println("The itsy bitsy spider climbed up the water spout...");
		ItsyBitsySpiderVisualizer.printContentsOfArray(mySpout1);
		//PRINT FIRST VERSE
		System.out.println("Down came the rain and washed the spider out...");
		ItsyBitsySpiderVisualizer.printContentsOfArray(mySpout2);
		//PRINT SECOND VERSE
		System.out.println("Out came the sun and dried up all the rain...");
		ItsyBitsySpiderVisualizer.printContentsOfArray(mySpout3);
		//PRINT THIRD VERSE
		System.out.println("And the itsy bitsy spider climbed up the spout " +
				"again!!");
		ItsyBitsySpiderVisualizer.printContentsOfArray(mySpout4);
		//PRINT FOURTH VERSE

	}

	/*print the tale and print the array from the methods write below*/
	public static void printContentsOfArray(char[][] someArray) {
		for (int i = 0; i < someArray.length; i++) {
			for (int j = 0; j < someArray[i].length; j++) {
				System.out.print(someArray[i][j]);
			}
			System.out.println();
		}
	}

	public static int evaluateUsersInput(String usersInput, int min, int max,
			boolean isRandomAllowed) {
		Scanner ScanInput = new Scanner(usersInput);
		if(isRandomAllowed==true) //For spoutLength and climbHeight evaluate
			{
			int validInput = 0;
		    if (ScanInput.hasNextInt()) {
				validInput = ScanInput.nextInt();
				if (validInput <= max && validInput >= min) { // check if
																// input is from
																// min to max.
					return validInput;								
				} else if (validInput < min) {
					validInput = -1;
					return validInput;
				} else {
					validInput = -2;	
					return validInput;
				}

			} else {
				if (usersInput.equals("r")) {
					validInput = Util.RNG.nextInt((max - min) + 1) + min;
					//generate a random number from the given min to max
					return validInput;
				} else {
					validInput = -3;
					return validInput;
				}
				
			}
		}
		else //For frameSpaces evaluate
		{
			int validInput = 0;
			
			if (ScanInput.hasNextInt()) {
				validInput = ScanInput.nextInt();
				if (validInput <= max && validInput >= min) { // check if input is from min to max.											
					return validInput;								
				} else if (validInput < min) {
					validInput = -1;
					return validInput;
				} else {
					validInput = -2;	
					return validInput;
				}

			} else {
					validInput = -3;
					return validInput;
			}
		}
		
	}

	/*
	 * This will return an array containing climbHeight "frames" one next to
	 * another separated by the number of tabs specified. The spider starts at
	 * position 0 and climbs climbHeight steps e.g. for a spout of length 12 and
	 * the spider taking 5 steps we print:
	 * 
	 * The itsy bitsy spider climbed up the water spout... | | | | | | | | | | |
	 * | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
	 * | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |^@^| | | | |
	 * | | |^@^| | | | | | | |^@^| | | | | | | |^@^| | | | | | | |^@^| | | | | |
	 * | | |
	 */
	public static char[][] getFirstVerse(int spoutLength, int climbHeight,
			int frameSpaces) {
		char[][] mySpout1 = new char[spoutLength][(5 + frameSpaces) 
		                                          * (climbHeight - 1)  + 5];
		/*loops to get the structure of spouts*/
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 0; j < ((5 + frameSpaces) * (climbHeight - 1) + 1); 
					j += (5 + frameSpaces)) {
				mySpout1[i][j] = '|';
			}
		}
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 4; j < ((5 + frameSpaces) * (climbHeight - 1)
					+ frameSpaces + 5); j += (5 + frameSpaces)) {
				mySpout1[i][j] = '|';
			}
		}
		/*loops to get the structure of frameSpaces*/
		for (int a = 0; a < frameSpaces; a++) {
			for (int i = 0; i < spoutLength; i++) {
				for (int j = 5 + a; j < (5 + frameSpaces) * (climbHeight - 1)
						+ 6 + a-frameSpaces; j += (5 + frameSpaces)) {
					mySpout1[i][j] = '	';
				}
			}
		}
		/*loops to get the structure of spaces*/
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 1; j < ((5 + frameSpaces) * (climbHeight - 1) + 2); 
					j += (5 + frameSpaces)) {
				mySpout1[i][j] = ' ';
			}
		}
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 2; j < ((5 + frameSpaces) * (climbHeight - 1) + 3); 
					j += (5 + frameSpaces)) {
				mySpout1[i][j] = ' ';
			}
		}
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 3; j < ((5 + frameSpaces) * (climbHeight - 1) + 4); 
					j += (5 + frameSpaces)) {
				mySpout1[i][j] = ' ';
			}
		}
		/*loops to get the structure of spider*/
		for (int a = 0; a < spoutLength; a++) {
			for (int i = spoutLength - 1, j = 1; j < ((5 + frameSpaces)
					* (climbHeight - 1) + 2); i--, j += (5 + frameSpaces)) {

				mySpout1[i][j] = '^';

			}
			for (int i = spoutLength - 1, j = 3; j < ((5 + frameSpaces)
					* (climbHeight - 1) + 4); i--, j += (5 + frameSpaces)) {

				mySpout1[i][j] = '^';

			}

			for (int i = spoutLength - 1, j = 2; j < ((5 + frameSpaces)
					* (climbHeight - 1) + 3); i--, j += (5 + frameSpaces)) {

				mySpout1[i][j] = '@';

			}
		}
		return mySpout1;
	}

	/*
	 * While the spider is at the climbHeight step, the rain comes down i.e. we
	 * fill the spout with rain at position climbHeight+1 all the way to the top
	 * and then we move the spider one position down and we repeat for each
	 * frame until the spider is at position 0 again. e.g. continuing the
	 * previous case of length 12 and 5 steps before the rain:
	 * 
	 * Down came the rain and washed the spider out... |###| |###| |###| |###|
	 * |###| |###| |###| |###| |###| |###| |###| |###| |###| |###| |###| |###|
	 * |###| |###| |###| |###| |###| |###| |###| |###| |###| |###| |###| |###|
	 * |###| |###| |###| |###| |###| |###| |###| |^@^| |###| |###| |###| |###| |
	 * | |^@^| |###| |###| |###| | | | | |^@^| |###| |###| | | | | | | |^@^|
	 * |###| | | | | | | | | |^@^|
	 */
	public static char[][] getSecondVerse(int spoutLength, int climbHeight,
			int frameSpaces) {
		char[][] mySpout2 = new char[spoutLength][(5 + frameSpaces)
				* (climbHeight - 1) + 5];
		/*loops to get the structure of spouts*/
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 0; j < ((5 + frameSpaces) * (climbHeight - 1) + 1); 
					j += (5 + frameSpaces)) {
				mySpout2[i][j] = '|';
			}
		}
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 4; j < ((5 + frameSpaces) * (climbHeight - 1)
					+ frameSpaces + 5); j += (5 + frameSpaces)) {
				mySpout2[i][j] = '|';
			}
		}
		/*loops to get the structure of frameSpaces*/
		for (int a = 0; a < frameSpaces; a++) {
			for (int i = 0; i < spoutLength; i++) {
				for (int j = 5 + a; j < (5 + frameSpaces) * (climbHeight - 1)
						+ 6 + a-frameSpaces; j += (5 + frameSpaces)) {
					mySpout2[i][j] = '	';
				}
			}
		}
		/*loops to get the structure of Spaces*/
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 1; j < ((5 + frameSpaces) * (climbHeight - 1) + 2); 
					j += (5 + frameSpaces)) {
				mySpout2[i][j] = ' ';
			}
		}
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 2; j < ((5 + frameSpaces) * (climbHeight - 1) + 3); 
					j += (5 + frameSpaces)) {
				mySpout2[i][j] = ' ';
			}
		}
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 3; j < ((5 + frameSpaces) * (climbHeight - 1) + 4); 
					j += (5 + frameSpaces)) {
				mySpout2[i][j] = ' ';
			}
		}
		/*loops to get the structure of spider*/
		for (int a = 0; a < climbHeight; a++) {
			for (int i = spoutLength - climbHeight, j = 1; i < spoutLength; 
					i++, j += (5 + frameSpaces)) {

				mySpout2[i][j] = '^';

			}
			for (int i = spoutLength - climbHeight, j = 3; i < spoutLength; 
					i++, j += (5 + frameSpaces)) {

				mySpout2[i][j] = '^';

			}

			for (int i = spoutLength - climbHeight, j = 2; i < spoutLength; 
					i++, j += (5 + frameSpaces)) {

				mySpout2[i][j] = '@';

			}
		}
		/*loop for filling the frames with rains*/
		for (int a = 0; a < climbHeight; a++) {
			
			for (int i = spoutLength - climbHeight-1, j = 1; i < spoutLength-1;
					i++, j += (5 + frameSpaces)) {
				for (int b=0; b<=i;b++){
				mySpout2[b][j] = '#';
				
				}
			}
			for (int i = spoutLength - climbHeight-1, j = 3; i < spoutLength-1;
					i++, j += (5 + frameSpaces)) {
				for (int b=0; b<=i;b++){
				mySpout2[b][j] = '#';
				
				}
			}

			for (int i = spoutLength - climbHeight-1, j = 2; i < spoutLength-1;
					i++, j += (5 + frameSpaces)) {
				for (int b=0; b<=i;b++){
				mySpout2[b][j] = '#';
				
                }
			}
		}
		return mySpout2;

	}

	/*
	 * In this series of "frames" we depict the drying of the rain, by having
	 * the spouts only partially full. In all frames the spider is at position
	 * 0, and in each frame we subtract one unit of water. The first "frame"
	 * should contain enough water so that after subtracting a unit of water in
	 * each frame we end up with the spider alone in the last "frame" e.g again
	 * continuing the 12 and 5 example we get:
	 * 
	 * Out came the sun and dried up all the rain... | | | | | | | | | | | | | |
	 * | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
	 * | | | | | | | | | | | | | | | | | | | |###| | | | | | | | | |###| |###| |
	 * | | | | | |###| |###| |###| | | | | |###| |###| |###| |###| | | |^@^|
	 * |^@^| |^@^| |^@^| |^@^|
	 */
	public static char[][] getThirdVerse(int spoutLength, int climbHeight,
	int frameSpaces) {
		char[][] mySpout3 = new char[spoutLength][(5 + frameSpaces)
		                          				* (climbHeight - 1) + 5];
		/*loops to get the structure of spouts*/
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 0; j < ((5 + frameSpaces) * (climbHeight - 1) + 1); 
					j += (5 + frameSpaces)) {
				mySpout3[i][j] = '|';
			}
		}
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 4; j < ((5 + frameSpaces) * (climbHeight - 1)
					+ frameSpaces + 5); j += (5 + frameSpaces)) {
				mySpout3[i][j] = '|';
			}
		}
		/*loops to get the structure of frameSpaces*/
		for (int a = 0; a < frameSpaces; a++) {
			for (int i = 0; i < spoutLength; i++) {
				for (int j = 5 + a; j < (5 + frameSpaces) * (climbHeight - 1)
						+ 6 + a-frameSpaces; j += (5 + frameSpaces)) {
				mySpout3[i][j] = '	';
				}
			}
		}
		/*loop for filling the frames with rains*/
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 1; j < ((5 + frameSpaces) * (climbHeight - 1) + 2); 
					j += (5 + frameSpaces)) {
				mySpout3[i][j] = '#';
			}
		}
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 2; j < ((5 + frameSpaces) * (climbHeight - 1) + 3); 
					j += (5 + frameSpaces)) {
				mySpout3[i][j] = '#';
			}
		}
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 3; j < ((5 + frameSpaces) * (climbHeight - 1) + 4); 
					j += (5 + frameSpaces)) {
				mySpout3[i][j] = '#';
			}
		}
		/*loops to get the structure of Spider*/
			for (int i = spoutLength - 1, j = 1; j < ((5 + frameSpaces)
					* (climbHeight - 1) + 2); j += (5 + frameSpaces)) {

				mySpout3[i][j] = '^';

			}
			for (int i = spoutLength - 1, j = 3; j < ((5 + frameSpaces)
					* (climbHeight - 1) + 4); j += (5 + frameSpaces)) {

				mySpout3[i][j] = '^';

			}

			for (int i = spoutLength - 1, j = 2; j < ((5 + frameSpaces)
					* (climbHeight - 1) + 3);  j += (5 + frameSpaces)) {

				mySpout3[i][j] = '@';

			}
			/*loops to get the structure of Spaces*/
			for (int a = 0; a < climbHeight; a++) {
				
				for (int i = spoutLength - climbHeight, j = 1; 
						i <= spoutLength-1; i++, j += (5 + frameSpaces)) {
					for (int b=0; b<i;b++){
					mySpout3[b][j] = ' ';
					
					}
				}
				for (int i = spoutLength - climbHeight, j = 3; 
						i <= spoutLength-1; i++, j += (5 + frameSpaces)) {
					for (int b=0; b<i;b++){
					mySpout3[b][j] = ' ';
					
					}
				}

				for (int i = spoutLength - climbHeight, j = 2; 
						i <= spoutLength-1; i++, j += (5 + frameSpaces)) {
					for (int b=0; b<i;b++){
					mySpout3[b][j] = ' ';
					
					}
				}
			}
		
		return mySpout3;
		
	}

	/*
	 * Finally we want the spider at the last frame to be at the very top so we
	 * depict the spider climbing one step at a time again as before but this
	 * time the first "frame" should show the spider high enough so that after
	 * climbHeight frames the spider will be at the top. e.g. continuing the
	 * previous 12 and 5 example:
	 * 
	 * And the itsy bitsy spider climbed up the spout again!! | | | | | | | |
	 * |^@^| | | | | | | |^@^| | | | | | | |^@^| | | | | | | |^@^| | | | | | |
	 * |^@^| | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
	 * | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
	 * | | | | | | |
	 */
	public static char[][] getFourthVerse(int spoutLength, int climbHeight,
			int frameSpaces) {
		char[][] mySpout4 = new char[spoutLength][(5 + frameSpaces)
				* (climbHeight - 1) + 5];
		/*loops to get the structure of spouts*/
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 0; j < ((5 + frameSpaces) * (climbHeight - 1) + 1); 
					j += (5 + frameSpaces)) {
				mySpout4[i][j] = '|';
			}
		}
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 4; j < ((5 + frameSpaces) * (climbHeight - 1)
					+ frameSpaces + 5); j += (5 + frameSpaces)) {
				mySpout4[i][j] = '|';
			}
		}
		/*loops to get the structure of frameSpaces*/
		for (int a = 0; a < frameSpaces; a++) {
			for (int i = 0; i < spoutLength; i++) {
				for (int j = 5 + a; j < (5 + frameSpaces) * (climbHeight - 1)
						+ 6 + a-frameSpaces; j += (5 + frameSpaces)) {
					mySpout4[i][j] = '	';
				}
			}
		}
		/*loops to get the structure of Spaces*/
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 1; j < ((5 + frameSpaces) * (climbHeight - 1) + 2); 
					j += (5 + frameSpaces)) {
				mySpout4[i][j] = ' ';
			}
		}
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 2; j < ((5 + frameSpaces) * (climbHeight - 1) + 3); 
					j += (5 + frameSpaces)) {
				mySpout4[i][j] = ' ';
			}
		}
		for (int i = 0; i < spoutLength; i++) {
			for (int j = 3; j < ((5 + frameSpaces) * (climbHeight - 1) + 4); 
					j += (5 + frameSpaces)) {
				mySpout4[i][j] = ' ';
			}
		}
		/*loops to get the structure of spider*/
		for (int a = 0; a < climbHeight; a++) {
			for (int i = climbHeight - 1, j = 1; j < ((5 + frameSpaces)
					* (climbHeight - 1) + 2); i--, j += (5 + frameSpaces)) {

				mySpout4[i][j] = '^';

			}
			for (int i = climbHeight - 1, j = 3; j < ((5 + frameSpaces)
					* (climbHeight - 1) + 4); i--, j += (5 + frameSpaces)) {

				mySpout4[i][j] = '^';

			}

			for (int i = climbHeight - 1, j = 2; j < ((5 + frameSpaces)
					* (climbHeight - 1) + 3); i--, j += (5 + frameSpaces)) {

				mySpout4[i][j] = '@';

			}
		}
		return mySpout4;
	}

}
