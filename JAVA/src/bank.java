
import java.util.Scanner;

public class bank {
	public static void main(String args[]) {
		
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("�п�J�ƭ�");

		
		int n= scanner.nextInt();
		System.out.println(n+"�H�U����Ʀ�:\n");
		//��J����
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
	//	System.out.println("�п�J�@�ƭȡG");
	//	int input = scanner.nextInt();
	//	System.out.print(input + " �H�U����Ʀ��G\n");
///////////////////////////////////////////////////////////////		
		
		// ��ƬO���F1�P�Ӽƥ����~..���Q�ӼƤ��e������ƾ㰣
		// for (int i = 2; i <= input; i++) // �q2���J�Ƚd�򪺰j��..
		// {
		// boolean isPrime = true; // �P�_�O�_����ƪ����L�ܼ�
		// for (int j = 2; j < i; j++) // �����k�B�⪺���j��..��2�}�l��p���J����..�C�@�ӥh�@���k�B��
		// {
		// if (i % j == 0) // �l�Ƭ�0��ܥi�H�㰣
		// {
		// isPrime = false; // �N���O���..break���X�j��
		// break;
		// }
		// }
		// if (isPrime) // �Y�O���..�L�X�Ӽƭ�..
		// {
		// System.out.print(i + " ");
		// }
		// }

		
			
		

	
		

	}
}