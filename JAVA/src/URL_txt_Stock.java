import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

public class URL_txt_Stock {
	// static String[] name = {"1101 �x�d","1102 �Ȫd","1103 �Ūd","1104 ���d","1108
	// ����","1109 �H�j","1110 �F�d"};
	// static List<String> C = new ArrayList<String>();
	// static String urlData = null;

	static String[] name = { "1101�x�d", "1102�Ȫd", "1103�Ūd", "1104���d", "1108����", "1109�H�j", "1110�F��" };
	static List<String> C = new ArrayList<String>();
	static String urlData = null;

	public static void main(String[] args) {
		// 1.�U���������
		// String stringURL =
		// "https://tw.finance.yahoo.com/s/list.php?c=%A4%F4%AAd&rr=0.91117800%201463983565";
		// try {
		// // 1.����URL�w�}����
		// URL myUrl = new URL(stringURL);
		// // 2.�s�u
		// URLConnection myConn = myUrl.openConnection(); // �}�ҳs�u
		// // 3.���o��J��y
		// InputStream in = myConn.getInputStream();
		// // 4.�����y��Buffer����
		// BufferedInputStream bis = new BufferedInputStream(in);
		// ByteArrayBuffer baf = new ByteArrayBuffer(bis.available());
		// int data = 0;
		// while ((data = bis.read()) != -1) { // Ū��BufferedInputStream�����
		// baf.append((byte) data); // �N��Ƹm�JByteArrayBuffer��
		// }
		// // 5.�ഫ��UTF-8�s�X
		// urlData = EncodingUtils.getString(baf.toByteArray(), "UTF-8"); //
		// �ഫ���r��
		//// System.out.println(urlData);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// //2.���X�һݭn�����
		// Parser(urlData);
		// //3.��X���
		// //��X���D�G
		// System.out.println("�Ѳ��N��\t����");
		// // ��X���e�G
		// for (int i = 0; i < name.length; i++) {
		// System.out.println(name[i] + "\t" + C.get(i) );
		// }
		// }

		String stringURL = "https://tw.finance.yahoo.com/s/list.php?c=%A4%F4%AAd&rr=0.91117800%201463983565";

		try {

			URL myUrl = new URL(stringURL);
			URLConnection myConn = myUrl.openConnection();
			InputStream in = myConn.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(in);
			ByteArrayBuffer baf = new ByteArrayBuffer(bis.available());
			int data = 0;
			while ((data = bis.read()) != -1) {
				baf.append((byte) data);

				urlData = EncodingUtils.getString(baf.toByteArray(), "UTF-8");
				System.out.println(urlData);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Parser(urlData);
		System.out.println("�Ѳ��N��\t����");
		for(int i=0;i<name.length;i++){
			System.out.println(name[i]+"\t+"+C.get(i));
			
		}
			
	}

	//////////////////////////////////////////////////////////////////////////
	// ���X�һݭn�����
//	public static void Parser(String urlData) {
//		String temp = null;
//		int start = 0, end = 0, counter = 0;
//		do {
//			start = urlData.indexOf("<td align=\"center\" bgcolor=\"#FFFfff\" nowrap><b>", end + 1);
//			end = urlData.indexOf("</b></td>", start + 1);
//			temp = urlData.substring(start + 47, end);
//			C.add(temp);
//			counter++;
//		} while (counter < name.length);
//	}

		public static void Parser(String urlData){
			
			String temp=null;
			int start=0, end=0, counter=0;
			do{
				
				start=urlData.indexOf("<td align=\"center\" bgcolor=\"#FFFfff\" nowrap><b>", end + 1);
				end=urlData.indexOf("</b></td>",start +1);
				temp=urlData.substring(start+47,end);
				C.add(temp);
				counter++;
			
			}while(counter<name.length);
			
			
			
		}











}
