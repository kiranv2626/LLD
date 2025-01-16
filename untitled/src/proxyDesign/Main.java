package proxyDesign;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new ProxyEmployeeDao();
        try {
//            employeeDao.create("admin", new EmployeeDaoImpl());
            employeeDao.get("admin", new EmployeeDaoImpl());
//            employeeDao.delete("admin", 1);
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
}
