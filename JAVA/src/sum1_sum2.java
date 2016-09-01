import java.util.Random;
import java.util.Scanner;

public class sum1_sum2 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("請輸入1-10個數字");
		int n=scanner.nextInt();
		

		if(n<=1||n>=10){
			System.out.println("請重新輸入正確的數字");
			
			n=scanner.nextInt();
					
		}
		
		Random ran=new Random();

		if(n>=ran||n<=ran)
		{
			System.out.println(x);
			
		}
//		System.out.println("電腦出:"+ran.nextInt(10)+1);
		
		
		
		

	}

}
