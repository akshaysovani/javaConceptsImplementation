package ComparableAndComparator;

import java.util.Comparator;

public class EmployeeByNameAndId implements Comparator<Employee>{
	public int compare(Employee e1, Employee e2){
		int flag = e1.getID() - e2.getID();
		if (flag != 0){
			return flag;
		}
		return e1.getName().compareTo(e2.getName());
	}
}
