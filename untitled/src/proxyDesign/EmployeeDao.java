package proxyDesign;

public interface EmployeeDao {
    public void create(String client,EmployeeDao employee) throws Exception;
    public void delete(String client,int employeeId) throws Exception;
    public EmployeeDao get(String client,EmployeeDao employee) throws Exception;

}
