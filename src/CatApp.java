import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CatApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String[] kinds = { "黒", "白", "茶トラ" };
		List<Cat> cats = new ArrayList<Cat>();
		System.out.println("***猫集め***");
		System.out.println("1.集める 2.遊ぶ 3.終了>>");
		int select = scan.nextInt();
		switch (select) {
		case 1:
			// 種類を決める
			int r = rand.nextInt(kinds.length);
			String kind = kinds[r];
			System.out.println(kind + "猫を見つけた");
			//名前を決める
			System.out.print("この猫に名前をつけてください>>");
			String name = new Scanner(System.in).nextLine();
			// インスタンスを生成、リストに追加
			Cat cat = new Cat(name, kind);
			cats.add(cat);
			System.out.println(cat.name + "が仲間に加わった!");
			break;
		case 2:

			if (cats.size() > 0) {
				System.out.print("どの猫とあそびますか? >> ");
				int selectCat = scan.nextInt();
			} else {
				System.out.println("遊ぶ猫がいません");
			}
			break;
		case 3:
			break;
		}
	}
}
