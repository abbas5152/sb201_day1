import java.util.Scanner;

public class deletebyid {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the id");
		int id = s.nextInt();

		emp e = new empimp();
		boolean ans = e.deleteEmployee(id);

		System.out.println(ans);
	}

}
