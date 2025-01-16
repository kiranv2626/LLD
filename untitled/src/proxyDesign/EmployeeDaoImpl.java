package proxyDesign;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public void create(String client, EmployeeDao employee) throws Exception {
        System.out.println("Employee Created");
    }
    @Override
    public void delete(String client, int   id) throws Exception {
        System.out.println("Employee Deleted");
    }
    @Override
    public EmployeeDao get(String client, EmployeeDao employee) throws  Exception {
        System.out.println("Employee Fetched");
        return employee;
    }
}
