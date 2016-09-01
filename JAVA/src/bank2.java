import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

public class bank2 {
//	static String[] name = { "美金 (USD)", "港幣 (HKD)", "英鎊 (GBP)", "澳幣 (AUD)",
//			"加拿大幣 (CAD)", "新加坡幣 (SGD)", "瑞士法郎 (CHF)", "日圓 (JPY)", "南非幣 (ZAR)",
//			"瑞典幣 (SEK)", "紐元 (NZD)", "泰幣 (THB)", "菲國比索 (PHP)", "印尼幣 (IDR)",
//			"歐元 (EUR)", "韓元 (KRW)", "越南盾 (VND)", "馬來幣 (MYR)", "人民幣 (CNY)" };
	static List<String> A= new ArrayList<String>();
	static List<String> buy_cash = new ArrayList<String>();
	static List<String> sell_cash = new ArrayList<String>();
	static List<String> buy_current_rate = new ArrayList<String>();
	static List<String> sell_current_rate = new ArrayList<String>();
	static String urlData = null;

	public static void main(String[] args) {
		// 網址
		String stringURL = "http://rate.bot.com.tw/Pages/Static/UIP003.zh-TW.htm";
		try {
			// 1.產生URL定址物件
			URL myUrl = new URL(stringURL);
			// 2.連線
			URLConnection myConn = myUrl.openConnection(); // 開啟連線
			// 3.取得輸入串流
			InputStream in = myConn.getInputStream();
			// 4.抓取串流到Buffer物件
			BufferedInputStream bis = new BufferedInputStream(in);
			ByteArrayBuffer baf = new ByteArrayBuffer(bis.available());
			int data = 0;
			while ((data = bis.read()) != -1) { // 讀取BufferedInputStream中資料
				baf.append((byte) data); // 將資料置入ByteArrayBuffer中
			}
			// 5.轉換為UTF-8編碼
			urlData = EncodingUtils.getString(baf.toByteArray(), "UTF-8"); // 轉換為字串
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 取得現金買入賣出與即期買入賣出
		Parser(urlData);
		// 輸出標題：
		System.out.println("幣別\t現金匯率買入\t現金匯率賣出\t即期匯率買入\t即期匯率賣出");
		// 輸出內容：
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
			//幣別
			start = urlData.indexOf("gif\" title=\"\" alt=\"\" />&nbsp;", end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 29, end);
			A.add(temp);
			//1.現金買入
			start = urlData.indexOf("<td class=\"decimal\">", end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 20, end);
			if (!temp.equals("-"))
				buy_cash.add(temp);
			else
				buy_cash.add("無資料");
			//2.現金賣出	
			start = urlData.indexOf("<td class=\"decimal\">", end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 20, end);
			if (!temp.equals("-"))
				sell_cash.add(temp);
			else
				sell_cash.add("無資料");
			//3.即期買入
			start = urlData.indexOf("<td class=\"decimal\">", end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 20, end);
			if (!temp.equals("-"))
				buy_current_rate.add(temp);
			else
				buy_current_rate.add("無資料");
			//4.即期賣出		
			start = urlData.indexOf("<td class=\"decimal\">", end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 20, end);
			if (!temp.equals("-"))
				sell_current_rate.add(temp);
			else
				sell_current_rate.add("無資料");
			
			counter++;
		} while (counter < 19);
	}
}

