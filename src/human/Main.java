package human;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception{
		List<Human> humans = new ArrayList<Human>();
		String path = "classmate - シート1.csv";

		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		BufferedReader br = new BufferedReader(isr);

		String line = null;
		while((line = br.readLine()) != null) {
			String[] datas = line.split(",");
			String name = datas[0];
			int age = Integer.parseInt(datas[1]);
			double height = Double.parseDouble(datas[2]);
			Human human = new Human(name,age,height);
			humans.add(human);
		}
		br.close();
		
		for(Human h : humans) {
			System.out.printf("私の名前は%s(%d)、身長は%fcmです\n", h.name,h.age,h.height);
		}
		
		// セーブする時
		Human h = humans.get(0);
		h.name = "佐々木ンぐ222";
		
		FileOutputStream fos = new FileOutputStream("classmate2.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		for(Human h1 : humans) {
			bw.write(h1.name + "," + h1.age + "," + h1.height);
			bw.newLine();
		}
		bw.close();
	}
}
