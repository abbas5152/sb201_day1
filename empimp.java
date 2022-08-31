import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class empimp implements emp {

	@Override
	public List<Employee> getalldetails() throws EmpException {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();

		try (Connection conn = ProvideConn.EstablishConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Employee2");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int r = rs.getInt("eid");
				String n = rs.getString("name");
				String a = rs.getString("address");
				int sa = rs.getInt("Salary");

				Employee e = new Employee(r, n, a, sa);

				list.add(e);

			}

			if (list.size() == 0)
				throw new EmpException("No employee found..");

		} catch (SQLException e) {
			throw new EmpException(e.getMessage());
		}

		return list;
	}

	@Override
	public String getEmployeeAddress(int id) throws EmpException {
		// TODO Auto-generated method stub
		String add = null;

		try (Connection conn = ProvideConn.EstablishConnection()) {

			PreparedStatement ps = conn.prepareStatement("select address from Employee2 where eid=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				add = rs.getString("address");
			} else {
				throw new EmpException("Employee does not exist with ID :" + id);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new EmpException(e.getMessage());

		}

		return add;
	}

	@Override
	public String getBonus(int bonus, int id) {
		// TODO Auto-generated method stub
		String ans = "Bonus not given";

		try (Connection conn = ProvideConn.EstablishConnection()) {

			PreparedStatement ps = conn.prepareStatement("UPDATE employee2 SET salary = salary+? where eid=?");

			ps.setInt(1, bonus);
			ps.setInt(2, id);
			int x = ps.executeUpdate();

			if (x > 0) {
				ans = " bonus given to " + x + " employyes";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();

		}

		return ans;
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		boolean ans = false;

		try (Connection conn = ProvideConn.EstablishConnection()) {

			PreparedStatement ps = conn.prepareStatement("delete from employee2 where eid=?");

			ps.setInt(1, id);
			int x = ps.executeUpdate();

			if (x > 0) {
				ans = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();

		}

		return ans;
	}

	@Override
	public String[] getNameAndAddress(int id) {
		String[] str = new String[2];

		try (Connection conn = ProvideConn.EstablishConnection()) {

			PreparedStatement ps = conn.prepareStatement("select name,address from Employee2 where eid=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String n = rs.getString("name");
				str[0] = n;
				String a = rs.getString("address");
				str[1] = a;

			}

		} catch (SQLException e) {
			e.getMessage();
		}

		return str;
	}

}
