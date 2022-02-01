package practice;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MySystemProperty {
	public static void main(String[] args) {
//		Map<String, String> map = System.getenv();
//		Iterator<Entry<String, String>> itr = map.entrySet().iterator();
//		while(itr.hasNext()) {
//			Entry<String, String> info = itr.next();
//			System.out.println(info.getKey()+"--->"+info.getValue());
//		}
		
		String browserName=System.getProperty("browser");
		//mvn test-Dbrowser=chrome
		System.out.println(browserName);
	}

}
