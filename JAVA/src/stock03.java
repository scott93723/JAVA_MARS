import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

public class stock03 {

	public static void main(String[] args) {
		
		
		class URL_txt_Stock03 {
			// static String[] name = {"1101 台泥","1102 亞泥","1103 嘉泥","1104 環泥","1108
			// 幸福","1109 信大","1110 東泥"};
			List<String> A = new ArrayList<String>();
			List<String> C = new ArrayList<String>();
			String urlData = null;

			public void main(String[] args) {
				// 1.下載網路資料
				String stringURL = "https://tw.finance.yahoo.com/s/list.php?c=%A4%F4%AAd&rr=0.91117800%201463983565";
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
					urlData = EncodingUtils.getString(baf.toByteArray(), "big5"); // 轉換為字串
					// System.out.println(urlData);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 2.切出所需要的資料
				Parser(urlData);
				// 3.輸出資料
				// 輸出標題：
				System.out.println("股票代號\t成交");
				// 輸出內容：
				for (int i = 0; i < A.size(); i++) {
					System.out.println(A.get(i) + "\t" + C.get(i));
				}
			}

			// 切出所需要的資料
			public void Parser(String urlData) {
				String temp = null;
				int start = 0, end = 0, counter = 0;
				do {
					start = urlData.indexOf("<td align=center bgcolor=#FFFfff nowrap><a href=", end + 1);
					end = urlData.indexOf("</a><br>", start + 1);
					temp = urlData.substring(start + 63, end);
					A.add(temp);
					
					start = urlData.indexOf("<td align=\"center\" bgcolor=\"#FFFfff\" nowrap><b>", end + 1);
					end = urlData.indexOf("</b></td>", start + 1);
					temp = urlData.substring(start + 47, end);
					C.add(temp);
					counter++;
				} while (counter < 7);
			}
		}


	}

}
