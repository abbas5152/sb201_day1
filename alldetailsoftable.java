import java.util.List;

public class alldetailsoftable {
   public static void main(String[] args) {
	   emp e= new empimp();
		 try {
		 
		 List<Employee> list=e.getalldetails();
	 
	 list.forEach(s ->{
			
			
			System.out.println(s);
			
			
		});
	 }
		 catch (EmpException e1) {
				
				System.out.println(e1.getMessage());
				
				
			}
	 }
	 
}

