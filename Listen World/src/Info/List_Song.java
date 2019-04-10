package Info;
import java.util.*;
public class List_Song {
	private int song_id;
	private String song_name;
	private String songer_id;
	private String songer_name;
	private int song_pop;
	private int song_time;
	private String song_pic;
	private String song_cd;
	private int mv_id;
	public String toString() {
		return "歌曲：("+song_id+" | "+song_name+")"+"歌手：("+songer_id+" | "+songer_name+") 热度 : "
				+song_pop+" 专辑："+song_cd+" 专辑照片："+song_pic+" 时长： "+song_time+" MV: "+mv_id;
	}
}
