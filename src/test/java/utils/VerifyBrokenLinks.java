package utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class VerifyBrokenLinks {

	/**
	 * Validate the broken links
	 *
	 * @param linkUrl
	 * @return list of urls whose link as broken
	 */
	public static List<String> validateLinks(String linkUrl)
	{
		List<String> brokenLink = null;
		try
		{
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if(httpURLConnect.getResponseCode()>=400) // broken links are identified based on the status code of url
			{
				System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
				brokenLink.add(linkUrl);
			}    
			else{
				System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
			}
		}catch (Exception e) {
		}
		return brokenLink;
	}

}
