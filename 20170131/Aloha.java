public class Aloha {
	public static void main(String[] args) {
	//	System.out.println("Aloha!");

	/*for (int i=0;i<30 ;i++) {
		System.out.println(i+"aloha");
	}*/

	/*for (int i=0;i<30 ;i++) {
		if (i%4==0) {
			System.out.println("アロハ！");
		}
		System.out.println(i+"aloha");
	}*/

	/*String msg=args[0];
	System.out.println(msg);*/

	String msg;
	System.out.print("名前入力してください ---");
	msg = new java.util.Scanner(System.in).nextLine();
	System.out.println(msg+"さんです");
	}
}