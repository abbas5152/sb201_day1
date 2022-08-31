import java.util.Arrays;
import java.util.Scanner;

public class nameandadd {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the id");
		int id = s.nextInt();

		emp e = new empimp();

		String[] str = e.getNameAndAddress(id);
		System.out.println(Arrays.toString(str));

	}
}
