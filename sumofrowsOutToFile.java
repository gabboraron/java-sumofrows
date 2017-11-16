import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class sumofrowsOutToFile{
	public static void main(String[] args){
		if (args.length > 2 ) {
			System.err.println("Too mutch command line arguments.");
		} else if( args.length <2){
			System.out.println("Too few arguments!");
		} else {
			try {
				//sumWithoutBufferedReader(args[0]);
				sumWithBufferedReaderToFile(args[0], args[1]);
			} catch (FileNotFoundException e) {
				System.err.println("The file cannot be opened.");
			} catch (IOException e) {
				System.err.println("An IO error occurred.");	
			} catch (ArrayIndexOutOfBoundsException e){
				System.err.println("You must have at least one file!");
				e.printStackTrace();
			}
		}
	}
	
	public static void sumWithBufferedReaderToFile(String inFlieName, String outFlieName)
	throws IOException{
		File inFile = new File(inFlieName);
		File outFile = new File(outFlieName);
		try(
		BufferedReader br = new BufferedReader(new FileReader(inFile));
		PrintWriter pw = new PrintWriter(outFile);){
			String line;
			for(line = br.readLine(); line!=null; line=br.readLine() ){
				String line1 = line;
				line=br.readLine();
				if(line!=null){
					String[] res1 = line1.split(",");
					String[] res2 = line.split(",");
					int[] tmp = new int[res1.length];
					for(int i=0; i<res1.length; ++i){
						tmp[i] = Integer.parseInt(res1[i]) + Integer.parseInt(res2[i]);
					}
					
					System.out.println(Arrays.toString(res1));
					System.out.println(Arrays.toString(res2));
					System.out.println("++++++++++");
					System.out.println(Arrays.toString(tmp));
					System.out.println(" ");
					pw.println(Arrays.toString(tmp));
				}
			}
		}
	}
}