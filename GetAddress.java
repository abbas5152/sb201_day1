import java.util.Scanner;

public class GetAddress {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the id");
		int id = s.nextInt();

		emp e = new empimp();
		try {
			String add = e.getEmployeeAddress(id);

			System.out.println(add);
		} catch (EmpException e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		}
	}

}
