import java.util.List;

public interface emp {

	public List<Employee> getalldetails() throws EmpException;

	public String getEmployeeAddress(int id) throws EmpException;

	public String getBonus(int bonus, int id);

	public boolean deleteEmployee(int id);

	public String[] getNameAndAddress(int id);

}
