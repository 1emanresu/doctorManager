package cn.yunji.doctormanager.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ReflectEntity {

	
	public static Map<String,String> reflect(Object t){
		Map<String,String> map=new HashMap<String,String>();
		Field[] fields=t.getClass().getDeclaredFields();
		for(Field field:fields){
			field.setAccessible(true);
			try {
				Object value=field.get(t);
				if(value!=null){
					String str=value.toString();
					if(!str.equals("0")&&!str.equals("")&&!str.equals(null)){
						map.put(field.getName(), str);
					}
				}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return map;
	}
	
	
	public static void print(Map<String,String> map){
		Set<Entry<String, String>> entries = map.entrySet();

		for (Entry<String, String> entry : entries) {   
			//System.out.println("{"+entry.getKey()+":"+entry.getValue()+"}");
		}
	}
	
}
