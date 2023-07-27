
public class Cat {
	String name; // 名前
	String type; // 種類
	int intimacy;// 親密度
	
	double height;

	public Cat(String name, String type) {
		this.name = name;
		this.type = type;
		this.intimacy = 0;
	}

	// ステータスを返す
	public String showStatus() {
		return String.format("%s[%s](%d)", this.name, this.type, this.intimacy);
	}

	// 遊ぶ
	public void play() {
		System.out.println(this.name + "と遊んだ");
		System.out.println("...");
		System.out.println(this.name + "の親密度がアップした!");
		this.intimacy++;
	}
}
