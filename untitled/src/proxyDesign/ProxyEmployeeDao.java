package proxyDesign;

public class ProxyEmployeeDao implements EmployeeDao {
    EmployeeDao employeeDao;

    public ProxyEmployeeDao() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDao employee) throws Exception {

            if(client.equalsIgnoreCase("admin")) {
                employeeDao.create(client, employee);
            }
            throw new RuntimeException("Access Denied");

    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        if(client.equalsIgnoreCase("admin")) {
            employeeDao.delete(client, employeeId);
            return;
        }
        throw new RuntimeException("Access Denied");
    }

    @Override
    public EmployeeDao get(String client, EmployeeDao employee) throws Exception {
        if(client.equalsIgnoreCase("admin") || client.equalsIgnoreCase("USER")) {
            return employeeDao.get(client, employee);
        }
        throw new RuntimeException("Access Denied");
    }

}
