public class Scanner{
	public static void main(String[] args) {
		boolean flag=true;
		String data;
		int n=0;
		
		while(true){
			System.out.println(n);
			n++;
			if(n==50){
			break;
			}
		}
		while(true){
			System.out.println("input data>");
			data=new java.util.Scanner(System.in).nextLine();
			System.out.println(data);
		
		if (data.equals("exit")){
			break;
		}
	}
	}
	
}