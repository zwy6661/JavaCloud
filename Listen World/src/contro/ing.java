package contro;

import java.util.HashMap;

import Info.List_Song;
import Manager.Downurl;
import Manager.Listsong;
import encryption.rSecret;
import view.show;

public class ing {
	public Object ingr(String ida,int type,int num) {
		num=0;
		Object object=new Object();
		if(type==1) {
			while(true) {
				if(num<(61)) {
				num=20+num;
				}else {
					//System.out.println("end");
					break;
				}
				new Thread(new rSecret(ida,type,num)).start();
			}
			
		}else if(type==2) {
			while(true) {
				if(num<(jsonStr.totals)) {
				num=30+num;
				}else {
					//System.out.println("end");
					break;
				}
				new Thread(new rSecret(ida,type,num)).start();
				object=new Listsong();
			}
		}else if(type==3) {
			new Thread(new rSecret(ida,type,num)).start();
			object=show.du; 
		}
		return object;
		
	}
	public static void main(String[]args) {
		Object obj=(new ing()).ingr("陈奕迅",2,0);
		if(obj instanceof Downurl) {
			System.out.println("这是一个下载链接！");
		}else if(obj instanceof Listsong) {
			System.out.println("这是一个歌单链接！");
			List_Song[] ls=((Listsong) obj).getAll();
			int i=1;
			for(List_Song l:ls) {
				
				if(l.toString().contains("陈奕迅")) {
					System.out.println(i+" : "+l.toString());
				}
				i++;
			}
		}
	}
}
