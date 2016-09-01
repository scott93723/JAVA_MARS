
import java.util.Scanner;

public class bank {
	public static void main(String args[]) {
		
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("請輸入數值");

		
		int n= scanner.nextInt();
		System.out.println(n+"以下的質數有:\n");
		//輸入介面
		///////////////////////////////////////////////////
		for(int i=2;i<=n ;i++){
			boolean prime =true;
				
				for(int j=2;j<i;j++){
					
					if(i%j==0){
						prime=false;
						break;
					}
					if(prime){
						System.out.print(i+"");
					}
				}
			
		}
		
		
		
	//	Scanner scanner = new Scanner(System.in);
	//	System.out.println("請輸入一數值：");
	//	int input = scanner.nextInt();
	//	System.out.print(input + " 以下的質數有：\n");
///////////////////////////////////////////////////////////////		
		
		// 質數是除了1與該數本身外..不被該數之前的任何數整除
		// for (int i = 2; i <= input; i++) // 從2到輸入值範圍的迴圈..
		// {
		// boolean isPrime = true; // 判斷是否為質數的布林變數
		// for (int j = 2; j < i; j++) // 做除法運算的內迴圈..由2開始到小於輸入的值..每一個去作除法運算
		// {
		// if (i % j == 0) // 餘數為0表示可以整除
		// {
		// isPrime = false; // 就不是質數..break跳出迴圈
		// break;
		// }
		// }
		// if (isPrime) // 若是質數..印出該數值..
		// {
		// System.out.print(i + " ");
		// }
		// }

		
			
		

	
		

	}
}