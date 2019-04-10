package contro;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class jsonStr {
	private static String params;
	private static String encSecKey;
	public static int totals=200;
	public static int number=1;
	public static int numbers=1;
	public jsonStr(String data) throws IOException {
		FileWriter fw=new FileWriter("����/Comments"+numbers+".txt");
		numbers++;
		BufferedWriter bw=new BufferedWriter(fw);
		if(!data.isEmpty()) {
		JSONObject jobject=JSONObject.fromObject(data);
		totals=(int)jobject.get("total");
		//System.out.println(totals);
		if(jobject.get("hotComments")!=null) {
			JSONArray array2=jobject.getJSONArray("hotComments");
			for(int i=0;i<array2.size();i++) {
			JSONObject child=array2.getJSONObject(i);
			JSONObject msg=JSONObject.fromObject(child.get("user"));
			String result=new String("�û�ID��"+msg.getInt("userId")+" �û�����"+msg.get("nickname").toString()+" ���ۣ�"
			+child.getString("content")+" ��������"+child.getInt("likedCount"));
			System.out.println(result);
			try {
				bw.write(result);
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			number++;
		}
		}
		if(jobject.get("comments")!=null) {
			JSONArray array1=jobject.getJSONArray("comments");
			for(int i=0;i<array1.size();i++) {
				JSONObject child=array1.getJSONObject(i);
				JSONObject msg=JSONObject.fromObject(child.get("user"));
				int userID=msg.getInt("userId");
				String user=msg.getString("nickname");
				String content=child.getString("content");
				int likednum=child.getInt("likedCount");
				String user_pic=msg.getString("avatarUrl");
				int RuserID;
				String Ruser;
				String Rcontent;
				int Rlikednum;
				String Ruser_pic;
				JSONArray reply=child.getJSONArray("beReplied");
				String reps="";
				for(int j=0;j<reply.size();j++) {
					JSONObject third=reply.getJSONObject(j);
					JSONObject json=JSONObject.fromObject(third.get("user"));
					RuserID=json.getInt("userId");
					Ruser=json.getString("nickname");
					Rcontent=third.getString("content");
					Rlikednum=third.getInt("likedCount");
					Ruser_pic=json.getString("avatarUrl");
					reps=reps+" �û���"+RuserID+" ( "+Ruser+" ) "+" ���ۣ�"+Rcontent+" ��������"+Rlikednum;
				}
				String result="�û���"+userID+" ( "+user+" ) "+" ���ۣ�"+content+" ��������"+likednum+" ( Դ����"+reps+" ) ";
				try {
					bw.write(result);
					bw.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				number++;
			}
		}
		bw.close();
		}else {
			System.out.println("Error");
		}
	}
	public jsonStr(String data,int n) {
		if(n==2) {
			if(!data.isEmpty()) {
				JSONObject object=JSONObject.fromObject(data);
				if((object.get("result"))!=null) {
					JSONObject res=JSONObject.fromObject(object.get("result"));
					JSONArray songs=res.getJSONArray("songs");
					int numberi=res.getInt("songCount");
					System.out.println(numberi);
					for(int i=0;i<songs.size();i++) {
						String sing="";
						JSONObject childs=songs.getJSONObject(i);
						JSONArray ar=childs.getJSONArray("ar");
						for(int j=0;j<ar.size();j++) {
							JSONObject sn=ar.getJSONObject(j);
							String sing_name=sn.getString("name");
							int sing_id=sn.getInt("id");
							sing=sing+" ( "+sing_name+" | "+sing_id+" ) ";
						}
					
						String song_name=childs.getString("name");
						int song_id=childs.getInt("id");
						int song_pop=childs.getInt("pop");
						int mv_id=childs.getInt("mv");
						JSONObject al=JSONObject.fromObject(childs.get("al"));
						String pic_url=al.getString("picUrl");
						int song_time=childs.getInt("dt");
						String cd_name=al.getString("name");
						int cd_id=al.getInt("id");
						System.out.println("��������"+song_name+"( "+song_id+" )"+" ���֣�( "+sing+" )"+" mvID��"+mv_id+" ʱ����"
							+ song_time+" ר����"+cd_name+"( "+cd_id+" )"+" �����ַ�� "+pic_url);
					}
					}else {
						System.out.println("ERROR");
					}
			}
	}else if(n==3) {
		if(!data.isEmpty()) {
			JSONObject object=JSONObject.fromObject(data);
			JSONArray url_song=object.getJSONArray("data");
			for(int i=0;i<url_song.size();i++) {
				JSONObject child=url_song.getJSONObject(i);
				String s_url=child.getString("url");
				int s_id=child.getInt("id");
				int size=child.getInt("size");
				System.out.println("url��ַ�� "+s_url+" ��С��"+size+" id: "+s_id);
			}
			}else {
				System.out.println("ERROR");
			}
		}
	}
}