import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// リファクタリング後の内容
public class CatApp2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		List<Cat> cats = new ArrayList<Cat>();// 猫の仲間たち
		System.out.println("***猫集め***");

		while (true) {
			System.out.print("1.集める 2.遊ぶ 3.終了>>");
			int select = scan.nextInt();
			switch (select) {
			case 1:
				Cat cat = correct();
				cats.add(cat);
				System.out.println(cat.name + "が仲間に加わった!");
				break;
			case 2:
				if (cats.size() > 0) { // 猫が居る時
					displayList(cats);
					System.out.print("どの猫と遊ぶ？ >> ");
					select = scan.nextInt();
					cats.get(select).play();
				} else { // 猫が居ない時	
					System.out.println("まだ遊ぶ猫がいません。。。");
				}
				break;
			case 3:
				System.out.println("***結果***");
				// 並び替え処理
				sortAscendingOrder(cats);
				// 画面表示
				displayList(cats);
				System.out.println("また遊んでね。おしまい");
				return;
			default:
				System.out.println("選択肢に無い番号です。");
			}
		}
	}

	// 一覧表示
	public static void displayList(List<Cat> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d・・・%s\n", i, list.get(i).showStatus());
		}
	}

	// 昇順並び替え
	public static void sortAscendingOrder(List<Cat> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).intimacy < list.get(j).intimacy) {
					Cat temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}

	// 猫を１匹集める
	public static Cat correct() {
		// 種類をランダムに決める
		String[] types = { "黒", "白", "茶トラ" };
		int r = new Random().nextInt(types.length);
		System.out.println(types[r] + "猫を見つけた！");

		// 猫の名前を決める
		System.out.print("この猫に名前をつけてください>>");
		String name = new Scanner(System.in).nextLine();

		// 猫を１匹生成する
		Cat cat = new Cat(name, types[r]);
		return cat;
	}
}
