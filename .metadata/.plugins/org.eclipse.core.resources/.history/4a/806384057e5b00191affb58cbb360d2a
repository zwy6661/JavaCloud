package Manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Info.*;
public class Downurl {
	private static Map<Object , down_url>  down_url=new HashMap<Object , down_url>();
	public void put(int key,down_url s) {
		down_url.put(key, s);
	}
	public down_url get(int key) {
		return down_url.get(key);
	}
	public down_url[] getAll() {
		down_url[] ls=new down_url[down_url.size()];
		int i=0;
		Set keyset=down_url.keySet();
		Iterator it=keyset.iterator();
		while(it.hasNext()) {
			Object key=it.next();
			down_url value=down_url.get(key);
			ls[i]=value;
			i++;
		}
		return ls;
	}
}
