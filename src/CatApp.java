import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CatApp {
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
				// 種類をランダムに決める
				String[] types = { "黒", "白", "茶トラ" };
				int r = rand.nextInt(types.length);
				System.out.println(types[r] + "猫を見つけた！");

				// 猫の名前を決める
				System.out.print("この猫に名前をつけてください>>");
				String name = new Scanner(System.in).nextLine();

				// 猫を仲間に加える
				System.out.println(name + "が仲間に加わった!");
				Cat cat = new Cat(name, types[r]);
				cats.add(cat);

				break;
			case 2:
				if (cats.size() > 0) {
					for (int i = 0; i < cats.size(); i++) {
						System.out.printf("%d・・・%s[%s](%d)\n", i, cats.get(i).name, cats.get(i).type,
								cats.get(i).intimacy);
					}
					System.out.print("どの猫と遊ぶ？ >> ");
					select = scan.nextInt();
					System.out.println(cats.get(select).name + "と遊んだ");
					System.out.println("...");
					System.out.println(cats.get(select).name + "の親密度がアップした!");
					cats.get(select).intimacy++;
				} else {
					System.out.println("まだ遊ぶ猫がいません。。。");
				}
				break;
			case 3:
				System.out.println("***結果***");
				// 並び替え処理
				for (int i = 0; i < cats.size() - 1; i++) {
					for (int j = i + 1; j < cats.size(); j++) {
						if (cats.get(i).intimacy < cats.get(j).intimacy) {
							Cat temp = cats.get(i);
							cats.set(i, cats.get(j));
							cats.set(j, temp);
						}
					}
				}
				// 画面表示
				for (int i = 0; i < cats.size(); i++) {
					System.out.printf("%d・・・%s[%s](%d)\n", i, cats.get(i).name, cats.get(i).type, cats.get(i).intimacy);
				}
				System.out.println("また遊んでね。おしまい");

				return;
			default:
				System.out.println("選択肢に無い番号です。");
			}
		}
	}
}
