import java.util.Scanner;

public class calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			double op1 = sc.nextDouble();
			String opr = sc.next();
			double op2 = sc.nextDouble();
			//System.out.println(op1+" "+opr+" "+op2);
			double result=0;
			boolean flag = false;
			if(opr.equals("+")){	//addition
				System.out.println("add");
				result = op1 + op2;
			}
			else if(opr.equals("-")){	//subtraction
				System.out.println("sub");
				result = op1 - op2;
			}
			else if(opr.equals("*")){	//multiplication
				System.out.println("mul");
				result = op1 * op2;
			}
			else{	//division
				System.out.println("div");
				if(op2!=0){
					result = op1/op2;
				}
				else{
					System.out.println("division by zero not possible");
					flag = true;
				}
			}
			if(flag == false){
				System.out.println("= " +result);
			}
			flag = false;
		}
		sc.close();
	}
}