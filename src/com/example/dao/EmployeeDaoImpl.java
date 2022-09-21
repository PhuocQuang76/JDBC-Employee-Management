package com.example.dao;

import com.example.pojos.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    public Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/javaoursoul2";
        Connection con = DriverManager.getConnection(jdbcURL, "root", "NHOel@2804");
        return con;
    }

    @Override
    public List<Employee> findAll() throws EmployeeException {
        List<Employee> empList = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery("Select * from employee");
            while (rs.next()) {
                int id = rs.getInt("EMP_ID");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int did = rs.getInt("DEPT_ID");
                int mgrid = rs.getInt("MGR_ID");
                empList.add(new Employee(id, name, salary, did, mgrid));
            }
        } catch (SQLException e) {
            throw new EmployeeException(e.getMessage(), e);
        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException s) {
                System.out.println(s); // logger to store it in file.
            }
        }
        return empList;
    }

    @Override
    public String register(Employee emp) throws EmployeeException {
        Connection con=null;
        Statement st=null;
        String message="";
        try {
            con=getConnection();
            st=con.createStatement();
            String query="insert into employee values("+emp.getId()+",'"+emp.getName()+"',"+emp.getSalary()+","+emp.getDeptId()+","+emp.getManager_id()+")";
            System.out.println(query);
            int n=st.executeUpdate(query);
            if(n==1) {
                message="Hi "+emp.getName()+ ", You are registred successfully";
            }
        }catch(SQLException s) {
            message="Error while inserting a record";
            throw new EmployeeException(message);
        }finally {
            try {
                st.close();
                con.close();
            }catch(SQLException s) {
                System.out.println(s); // logger to store it in file.
            }
        }
        return message;
    }

    @Override
    public Employee findById(int searchId) throws EmployeeException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Employee e = null;
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery("Select * from employee where EMP_ID =" + searchId);
            while (rs.next()) {
                int id = rs.getInt("EMP_ID");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int did = rs.getInt("DEPT_ID");
                int mgrid = rs.getInt("MGR_ID");
                e = new Employee(id, name, salary, did, mgrid);
            }
        } catch (SQLException s) {
            throw new EmployeeException(s.getMessage(), s);
        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException s) {
                System.out.println(s); // logger to store it in file.
            }
        }
        return e;
    }

    @Override
    public int remove(int id) throws EmployeeException {
        Connection con = null;
        Statement st = null;

        String message="";
        int returnValue = 0;
        try {
            con=getConnection();
            st=con.createStatement();
            String query= ("delete from employee where EMP_ID =" + id);
            int n=st.executeUpdate(query);
            if(n==1) {
                message= (" Record was delete " + n);
                returnValue = n;

            }
        }catch(SQLException s) {
            message="Error while inserting a record";
            throw new EmployeeException(s.getMessage(),s);
        }finally {
            try {
                st.close();
                con.close();
            }catch(SQLException s) {
                System.out.println(s); // logger to store it in file.
            }
        }
        return returnValue;
    }

    @Override
    public String update(Employee e) throws EmployeeException{
        String updateString = null;
        Connection con = null;
        PreparedStatement st = null;
        String query = "update employee set MGR_ID=? where EMP_ID=? ";

        try {
            con = getConnection();
            st = con.prepareStatement(query);
            st.setInt(1,e.getManager_id());
            st.setInt(2,e.getId());
            int n= st.executeUpdate();
            if(n == 1){
                updateString = "Data update successfully!";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return updateString;
    }

}
