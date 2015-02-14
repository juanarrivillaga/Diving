//Program Author: Juan Arrivillaga
import java.util.Scanner;
public class Diving {
	
	
	public static void main(String[] args) { // main method
		
		double [] scores = inputAllScores();
		double difficulty = inputValidDegreeOfDifficulty();
		
		double score = calculateScore(difficulty, scores);
		System.out.printf("The final score is %.4f",score);
		
	}
	
	public static double inputValidScore(int number){ // this method will be used to input a single valid score
		int sentinal = 0;
		double score;
		Scanner input = new Scanner(System.in);
		do{
			System.out.println("Please input score for judge "+ number +":" );
			score = input.nextDouble();
			if ((score>= 0)&&(score<=10) ) // check for valid score
				sentinal = 1;
			else
				System.out.println("Invalid Entry.");
			
		} while (sentinal != 1);
		
		return score;
	}
	
	public static double [] inputAllScores(){//this method will make an array of 7 different scores
		double[] array = new double[7];
		
		array[0]=inputValidScore(1);
		array[1]=inputValidScore(2);
		array[2]=inputValidScore(3);
		array[3]=inputValidScore(4);
		array[4]=inputValidScore(5);
		array[5]=inputValidScore(6);
		array[6]=inputValidScore(7);
		
		return array;
	}
	
	public static double inputValidDegreeOfDifficulty(){ // this method will allow the input of a degree of difficulty
		int sentinal = 0;
		double degree;
		Scanner input = new Scanner(System.in);
		do{
			System.out.println("Please input degree of difficulty:");
			degree = input.nextDouble();
			if ((degree >= 1.2) && (degree <= 3.8)) // check for valid difficulty
				sentinal = 1;
			else
				System.out.println("Invalid Entry.");
			
		} while (sentinal !=1);
		
		return degree;
	}
	
	public static double calculateScore(double difficulty, double[]score){
		double maxScore=-1;
		double minScore=11;
		double total=0;
		
		//Find maximum score and store to maxScore
		for (int counter = 0; counter < score.length; counter++){
			maxScore = Math.max(score[counter],maxScore);
		}
		//Find minimum score and store to minScore
		for (int counter = 0; counter < score.length; counter++){
			minScore = Math.min(score[counter], minScore);
		}
		// Add up all the elements of the score array
		for (int counter = 0; counter < score.length; counter++){
			total = score[counter] + total;
		}
		
		total = total - maxScore - minScore; // subtract largest and smallest scores from total
		
		total = total * difficulty; // multiply by degree of difficulty
		
		total = total * 0.6; // multiply by 0.6
		
		return total;
		
	}

}
