import java.util.*;
class XO_Project {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[][] arr = new String[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				arr[i][j] = " ";
			}
		}
		grid(arr);
		int first = 0, second = 0, count = 1;
		for (int k = 0; ; k++) {
			if(isImpossible(arr)){
				break;
			}	
			if(isDraw(arr)){
				System.out.println("Draw");
				break;
			}	
			gameNotFinish(arr);	
			if(xsWin(arr)){
				System.out.println("X wins");
				break;
			} else if (osWin(arr)){
				System.out.println("O wins");
				break;
			}
			boolean entry = false;
			while(!entry){
				System.out.print("Enter the coordinates: ");
				String cords = sc.nextLine();
				try{
					first = Integer.parseInt(String.valueOf(cords.charAt(0)));
					second = Integer.parseInt(String.valueOf(cords.charAt(2)));
					if(first > 3 || second > 3){
						System.out.println("Coordinates should be from 1 to 3!");	
						break;	
					} 	
					
					if (count % 2 != 0) {
						if(isXsContain(arr, first, second)){
							break;
						}
					} else {
						if(isOsContain(arr, first, second)){
							break;
						}
					}
					count++;
					grid(arr);
					entry = true;	
				} catch (Exception e){
					System.out.println("You should enter numbers!");
					break;
				} 	
			}
		}
		
	}
	public static boolean xsWin(String[][] arr){
		if(arr[0][0].equals("X") && arr[0][1].equals("X") && arr[0][2].equals("X")){
			return true;
		} else if(arr[1][0].equals("X") && arr[1][1].equals("X") && arr[1][2].equals("X")){
			return true;
		} else if(arr[2][0].equals("X") && arr[2][1].equals("X") && arr[2][2].equals("X")){
			return true;
		} else if(arr[0][0].equals("X") && arr[1][1].equals("X") && arr[2][2].equals("X")){
			return true;
		} else if(arr[0][2].equals("X") && arr[1][1].equals("X") && arr[2][0].equals("X")){
			return true;
		} else if(arr[0][0].equals("X") && arr[1][0].equals("X") && arr[2][0].equals("X")){
			return true;
		} else if(arr[0][1].equals("X") && arr[1][1].equals("X") && arr[2][1].equals("X")){
			return true;
		} else if(arr[0][2].equals("X") && arr[1][2].equals("X") && arr[2][2].equals("X")){
			return true;
		} else {
			return false;
		}		
	}
	public static boolean osWin(String[][] arr){
		if(arr[0][0].equals("O") && arr[0][1].equals("O") && arr[0][2].equals("O")){
			return true;
		} else if(arr[1][0].equals("O") && arr[1][1].equals("O") && arr[1][2].equals("O")){
			return true;
		} else if(arr[2][0].equals("O") && arr[2][1].equals("O") && arr[2][2].equals("O")){
			return true;
		} else if(arr[0][0].equals("O") && arr[1][1].equals("O") && arr[2][2].equals("O")){
			return true;
		} else if(arr[0][2].equals("O") && arr[1][1].equals("O") && arr[2][0].equals("O")){
			return true;
		} else if(arr[0][0].equals("O") && arr[1][0].equals("O") && arr[2][0].equals("O")){
			return true;
		} else if(arr[0][1].equals("O") && arr[1][1].equals("O") && arr[2][1].equals("O")){
			return true;
		} else if(arr[0][2].equals("O") && arr[1][2].equals("O") && arr[2][2].equals("O")){
			return true;
		} else {
			return false;
		}		
	}
	public static boolean isXsContain(String[][] arr, int first, int second){
		int i = first - 1;
		int j = second - 1;
		boolean isContains = false;
		if(arr[i][j].contains(" ")){
			arr[i][j] = "X";
		} else {
			System.out.println("This cell is occupied! Choose another one!");
			isContains = true;
		}
		return isContains;
	}
	public static boolean isOsContain(String[][] arr, int first, int second){
		int i = first - 1;
		int j = second - 1;
		boolean isContains = false;
		if(arr[i][j].contains(" ")){
			arr[i][j] = "O";
		} else {
			System.out.println("This cell is occupied! Choose another one!");
			isContains = true;
		}
		return isContains;
	}
	public static void gameNotFinish(String[][] arr){
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				if(arr[x][y].contains(" ") && !xsWin(arr) && !osWin(arr)){
					//System.out.println("Game not finished!");
					break;
				} 
			}
			break;
		}
	}
	public static boolean isImpossible(String[][] arr){
		int txs = 0;
		int tos = 0;
		boolean isPossible = false;
		for (int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(arr[i][j].equals("X")){
					txs++;
				} else if(arr[i][j].equals("O")) {
					tos++;
				}
			}	
		}
		if(Math.abs(tos - txs) > 1){
			//System.out.println("Impossible");
			isPossible = true;
		} else if(xsWin(arr) && osWin(arr)){
			//System.out.println("Impossible");
			isPossible = true;
		} 
		return isPossible;
	}
	public static boolean isDraw(String[][] arr){
		boolean draw = false;
		int scount = 0;
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				if(arr[x][y].contains(" ")){scount++;}
			}
		}
		if(scount == 0 && !xsWin(arr) && !osWin(arr)){
			draw = true;
		}
		return draw;
	}
	public static void grid(String[][] arr){
		System.out.println("---------");
		System.out.println("| " + arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + " |");
		System.out.println("| " + arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + " |");
		System.out.println("| " + arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + " |");
		System.out.println("---------");
	}
}
