package download;

import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;

public class download_music {
	private static String u;
	private static String name;
	private static String filename;
	private static int SIZE=8096;
	static {
		URL url;
		try {
			url = new URL(u);
			URLConnection urlC=url.openConnection();
			File file=new File("F:\\�����ļ�\\"+filename);
			if(!file.exists()) {
				file.mkdirs();
			}
			InputStream is=new BufferedInputStream(urlC.getInputStream());
			String msg=file.getPath()+"\\"+name+".m4a";
			FileOutputStream fos=new FileOutputStream(msg);
			byte[] buf=new byte[SIZE];
			int len;
			while((len=is.read(buf))!=-1) {
				fos.write(buf, 0, len);
			}
			fos.close();
			is.close();
			System.out.println(name+"������ɣ�");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}