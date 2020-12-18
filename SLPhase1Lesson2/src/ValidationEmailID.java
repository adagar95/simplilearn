import java.util.Scanner;

public class ValidationEmailID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String empEmailID[] = {"ankita@office.com", "ashwani@office.com", "ankur@office.com", 
								"prateek@office.com", "akanksha@office.com", "puru@office.com", 
								"akansha@office.com"};
		System.out.println("Enter the email ID to be searched: ");
		Scanner sc = new Scanner(System.in);
		boolean found = false;
		while(sc.hasNext()){
			String inp = sc.next();
			for(int i=0; i<empEmailID.length; i++){
				if(empEmailID[i].equalsIgnoreCase(inp)){
					found = true;
					break;
				}
			}
			if(found==true)
				System.out.println("The searched email ID exists in records!");
			else
				System.out.println("The searched email ID does not exists in records!");
		}
		sc.close();
	}
}
