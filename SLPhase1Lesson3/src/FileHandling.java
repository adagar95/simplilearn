import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//wap to read, write and append a file

public class FileHandling {
	public static void readFile(File filename){
		  try{
			  BufferedReader br = new BufferedReader(new FileReader(filename)); 
			  String str; 
			  while ((str = br.readLine()) != null) 
				  System.out.println(str);
			  br.close();
		  }
		  catch(IOException e){
				System.out.println("##Exception: "+e);
			}
	}
	
	public static void writeFile(File filename, List<String> str){
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		
			for(int i=0; i<str.size(); i++)
				bw.write(str.get(i));
			bw.close();
		}
		catch(IOException e){
			System.out.println("##Exception: "+e);
		}
	}
	
	public static void appendFile(File filename, List<String> str){
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
			for(int i=0; i<str.size(); i++)
				bw.write(str.get(i));
			bw.close();
		}
		catch(IOException e){
			System.out.println("##Exception: "+e);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	  Scanner sc = new Scanner(System.in);
	  int option;  
	  while(true){
		System.out.println("1. Read a file");
		System.out.println("2. Write in a file");
		System.out.println("3. Append in a file");
		System.out.println("4. Exit");
		System.out.println("Enter your choice: ");
		option = sc.nextInt();
		sc.nextLine();
		
		switch(option){
			case 1:	System.out.println("Enter the file path and name: ");
					String inp = sc.next(); //"E:\\workspaceEclipse\\SLPhase1Lesson3\\textFile.txt"
					File file = new File(inp);  
					readFile(file);
					break;
			case 2: System.out.println("Enter the file path and name: ");
					inp = sc.nextLine(); //"E:\\workspaceEclipse\\SLPhase1Lesson3\\textFile.txt"
					file = new File(inp);
					System.out.println("Enter the text to be written in the file: ");		
					List<String> str = new ArrayList<>();
					while(!sc.hasNext("EXIT")){ 
						str.add(sc.nextLine());
					}
					writeFile(file, str);
					break;
			case 3: System.out.println("Enter the file path and name: ");
					inp = sc.nextLine(); //"E:\\workspaceEclipse\\SLPhase1Lesson3\\textFile.txt"
					file = new File(inp);
					System.out.println("Enter the text to be written in the file: ");		
					List<String> str1 = new ArrayList<>();
					while(!sc.hasNext("EXIT")){ 
						str1.add(sc.nextLine());
					}
					//String str1 = sc.nextLine();
					appendFile(file, str1);
					break;
			case 4:	System.exit(0); break;
			default: System.out.println("Error!! You entered a wrong choice!!!");
		}
		sc.nextLine();
	  }
	  //sc.close();
	}

}
