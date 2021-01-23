import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LockedMe {
	static Scanner sc = new Scanner(System.in);
	
	public static void mainMenu(){
		System.out.println("------------MAIN MENU------------");
		System.out.println("1. Display existing files");
		System.out.println("2. Perform operations on files");
		System.out.println("3. Exit");
		System.out.println("Enter your choice: ");
	}
	public static void subMenu(){
		System.out.println("------------SUB MENU------------");
		System.out.println("1. Add a file");
		System.out.println("2. Delete a file");
		System.out.println("3. Search a file");
		System.out.println("4. Go Back to MAIN MENU");
		System.out.println("Enter your choice: ");
	}
	
	public static void displayAllFiles(){
		System.out.println("Display");
		System.out.println("<-------------------------------------------------------------------->");
		File dir = new File("E:\\workspaceEclipse\\SLPhase1Assessment\\");	//("C:\\Users\\Ankita\\Desktop\\");	//("E:\\workspaceEclipse\\SLPhase1Assessment\\");
		
		if(dir.isDirectory()){
			List<String> filesList = Arrays.asList(dir.list());
			if(filesList.size()>0){
				Collections.sort(filesList);
				for(String s:filesList){
					System.out.println(s);
				}
			}
			else
				System.out.println("There are no files in the existing directory ");
		}
		else{
			System.out.println(dir+" is not a directory ");
		}
		System.out.println("<-------------------------------------------------------------------->");
	}
	
	public static void addFile(){
		System.out.println("<-------------------------------------------------------------------->");
		System.out.println("Enter the path of the file to be added to the existing directory: ");
		String path = sc.nextLine();		//"C:\\Users\\Ankita\\Desktop\\"
		System.out.println("Enter the filename along with the type(.txt) to be added to the existing directory (Case-Insensitive): ");
		String fn = sc.nextLine();			//"addME.txt"
		
		File inFilename = new File(path+fn);
		if(inFilename.exists()){
			fn = fn.toLowerCase();
			File outFilename = new File("E:\\workspaceEclipse\\SLPhase1Assessment\\"+fn);
			try{
				if(outFilename.createNewFile()){
					FileInputStream instream = new FileInputStream(inFilename);
					FileOutputStream outstream = new FileOutputStream(outFilename);
					byte[] buffer = new byte[1024];
					int len;
					while((len=instream.read(buffer))>0){
						outstream.write(buffer, 0, len);
					}
					instream.close();
					outstream.close();
					System.out.println("File is added!");
				}
				else
					System.out.println("File with this filename already exists!!");
			}
			catch(IOException e){
				System.out.println("##Error in adding the file!!");
			}
			
		}
		else{
			System.out.println("##Exception: File to be added doesn't exist!!");
		}
		System.out.println("<-------------------------------------------------------------------->");
	}	
	
	public static void deleteFile(){
		System.out.println("<-------------------------------------------------------------------->");
		System.out.println("Enter the filename along with the type(.txt) to be deleted (Case-sensitive): ");
		String fn = sc.nextLine();
		
		File dir = new File("E:\\workspaceEclipse\\SLPhase1Assessment\\");
		String filename = "E:\\workspaceEclipse\\SLPhase1Assessment\\"+fn;
		try {
			List<String> filesList = Arrays.asList(dir.list());
			if(filesList.contains(fn)){
				Files.deleteIfExists(Paths.get(filename));
				System.out.println("File is Deleted!");
			}
			else
				System.out.println("File to be deleted doesn't exist!!");
/*			boolean del = Files.deleteIfExists(Paths.get(filename));
			if(del==true)
				System.out.println("File is Deleted!");
			else
				System.out.println("File to be deleted doesn't exist!!");
*/			
		}
		catch(NoSuchFileException e){
			System.out.println("##Exception: No such file or directory exists!!");
		}
		catch(DirectoryNotEmptyException e){
			System.out.println("##Exception: Directory is not empty!!");
		}
		catch(IOException e){
			System.out.println("##Exception: Invalid permissions!!");
		}
		System.out.println("<-------------------------------------------------------------------->");
	}
	
	public static void searchFile(){
		System.out.println("<-------------------------------------------------------------------->");
		System.out.println("Enter the filename to be searched along with the type(.txt) (Case-Insensitive): ");
		String fn = sc.nextLine();			//"addme.txt"
		//File filename = new File("E:\\workspaceEclipse\\SLPhase1Assessment\\"+fn);
		
		File dir = new File("E:\\workspaceEclipse\\SLPhase1Assessment\\");
		List<String> filesList = Arrays.asList(dir.list());
		if(filesList.contains(fn))
			System.out.println("File Found!");
		else
				System.out.println("File not found!!");			

/*		if(filename.exists())
			System.out.println("File Found!");
		else
			System.out.println("File not found!!");
*/		System.out.println("<-------------------------------------------------------------------->");
		
	}
	
	public static void main(String[] args) {
		int mainMenuOption=0, subMenuOption=0;
		boolean back=true;
		
		System.out.println("**********************************************************************");
		System.out.println("Hello User! \nLockers Pvt.Ltd welcomes you to LockedMe.com, your digitalized locker.");
		System.out.println("This application is developed by Ankita Dagar in 2021.");
		System.out.println("Hope You enjoy using it!");
		System.out.println("**********************************************************************");
		
		while(true){
			mainMenu();
			try{
			mainMenuOption = sc.nextInt();
			}
			catch(InputMismatchException e){
			}
			sc.nextLine();
			back = true;
			
			switch(mainMenuOption){
				case 1:	System.out.println("--> This option displays all the existing files in ascending order <--");
						displayAllFiles();
						break;
				case 2:	while(back==true){
							subMenu();
							try{
							subMenuOption = sc.nextInt();
							}
							catch(InputMismatchException e){
							}
							sc.nextLine();
							switch(subMenuOption){
								case 1: addFile();
										break;
								case 2: deleteFile();
										break;
								case 3: searchFile();
										break;
								case 4: back=false;
										break;
								default:System.out.println("Error!! You entered a wrong choice!!!");
							}
							//sc.nextLine();
						}
						break;
				case 3:	System.exit(0);
						break;
				default:System.out.println("Error!! You entered a wrong choice!!!");
			}
			//sc.nextLine();
		}	
	}
	
}

