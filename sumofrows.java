import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class sumofrows{
	public static void main(String[] args){
		if (args.length > 1 ) {
			System.err.println("Too mutch command line arguments.");
		}
		try {
			sumWithoutBufferedReader(args[0]);
		} catch (FileNotFoundException e) {
			System.err.println("The file cannot be opened.");
		} catch (IOException e) {
			System.err.println("An IO error occurred.");	
		} catch (ArrayIndexOutOfBoundsException e){
			System.err.println("You must have at least one file!");
			e.printStackTrace();
		}
	}
	
	public static void sumWithoutBufferedReader(String input)
	throws FileNotFoundException, IOException {

		try ( Scanner sc = new Scanner(new File(input));){
			while (sc.hasNextLine()) {
				String current = sc.nextLine();
				if(sc.hasNextLine()){
					String next = sc.nextLine();
				
					
					String[] res1 = current.split(",");
					String[] res2 = next.split(",");
					
					System.out.println(Arrays.toString(res1));
					System.out.println(Arrays.toString(res2));
					//System.out.println(res2);
					System.out.println("++++");

					int i = 0;
					int[] sum = new int[res1.length];
					for(String s : res1){
						sum[i] = Integer.parseInt(s) + Integer.parseInt(res2[i]);
						System.out.println(sum[i]);
						++i;
					}
				}
				
				/*for(String s : res){
					System.out.println(s);
				}
				System.out.println("***");*/
			}
		}
	}
}