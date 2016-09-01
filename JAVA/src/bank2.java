import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

public class bank2 {
//	static String[] name = { "���� (USD)", "��� (HKD)", "�^�� (GBP)", "�D�� (AUD)",
//			"�[���j�� (CAD)", "�s�[�Y�� (SGD)", "��h�k�� (CHF)", "��� (JPY)", "�n�D�� (ZAR)",
//			"���� (SEK)", "�ä� (NZD)", "���� (THB)", "����� (PHP)", "�L���� (IDR)",
//			"�ڤ� (EUR)", "���� (KRW)", "�V�n�� (VND)", "���ӹ� (MYR)", "�H���� (CNY)" };
	static List<String> A= new ArrayList<String>();
	static List<String> buy_cash = new ArrayList<String>();
	static List<String> sell_cash = new ArrayList<String>();
	static List<String> buy_current_rate = new ArrayList<String>();
	static List<String> sell_current_rate = new ArrayList<String>();
	static String urlData = null;

	public static void main(String[] args) {
		// ���}
		String stringURL = "http://rate.bot.com.tw/Pages/Static/UIP003.zh-TW.htm";
		try {
			// 1.����URL�w�}����
			URL myUrl = new URL(stringURL);
			// 2.�s�u
			URLConnection myConn = myUrl.openConnection(); // �}�ҳs�u
			// 3.���o��J��y
			InputStream in = myConn.getInputStream();
			// 4.�����y��Buffer����
			BufferedInputStream bis = new BufferedInputStream(in);
			ByteArrayBuffer baf = new ByteArrayBuffer(bis.available());
			int data = 0;
			while ((data = bis.read()) != -1) { // Ū��BufferedInputStream�����
				baf.append((byte) data); // �N��Ƹm�JByteArrayBuffer��
			}
			// 5.�ഫ��UTF-8�s�X
			urlData = EncodingUtils.getString(baf.toByteArray(), "UTF-8"); // �ഫ���r��
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ���o�{���R�J��X�P�Y���R�J��X
		Parser(urlData);
		// ��X���D�G
		System.out.println("���O\t�{���ײv�R�J\t�{���ײv��X\t�Y���ײv�R�J\t�Y���ײv��X");
		// ��X���e�G
		for (int i = 0; i < A.size(); i++) {
			System.out.println(A.get(i) + "\t" + buy_cash.get(i) + "\t"
					+ sell_cash.get(i) + "\t" + buy_current_rate.get(i) + "\t"
					+ sell_current_rate.get(i));
		}
	}

	public static void Parser(String urlData) {
		String temp = null;
		int start = 0,end = 0,counter = 0;
		do {			
			//���O
			start = urlData.indexOf("gif\" title=\"\" alt=\"\" />&nbsp;", end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 29, end);
			A.add(temp);
			//1.�{���R�J
			start = urlData.indexOf("<td class=\"decimal\">", end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 20, end);
			if (!temp.equals("-"))
				buy_cash.add(temp);
			else
				buy_cash.add("�L���");
			//2.�{����X	
			start = urlData.indexOf("<td class=\"decimal\">", end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 20, end);
			if (!temp.equals("-"))
				sell_cash.add(temp);
			else
				sell_cash.add("�L���");
			//3.�Y���R�J
			start = urlData.indexOf("<td class=\"decimal\">", end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 20, end);
			if (!temp.equals("-"))
				buy_current_rate.add(temp);
			else
				buy_current_rate.add("�L���");
			//4.�Y����X		
			start = urlData.indexOf("<td class=\"decimal\">", end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 20, end);
			if (!temp.equals("-"))
				sell_current_rate.add(temp);
			else
				sell_current_rate.add("�L���");
			
			counter++;
		} while (counter < 19);
	}
}

