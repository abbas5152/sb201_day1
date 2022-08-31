import java.util.Scanner;

public class bonusbyid {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the bonus");
		int bonus = s.nextInt();
		System.out.println("Enter the id");
		int id = s.nextInt();

		emp e = new empimp();
		String bon = e.getBonus(bonus, id);

		System.out.println(bon);

	}
}
