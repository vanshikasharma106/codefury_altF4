package util.modelutil;

import exceptions.ValidationFailedException;
import models.users.Employee;

public class EmployeeUtils {

    // Below Function returns if the Employee is of the expected user type
    public static boolean isATypeOf(Employee emp, int type){
        return emp.getEmpType() == type;
    }

    // Returns Type of Employee as a String
    public static String isATypeOf(Employee emp){
        return switch (emp.getEmpType()) {
            case 1 -> "Admin";
            case 2 -> "Manager";
            case 3 -> "Member";
            default -> "Invalid";
        };
    }

    // Return Mapping of int-String for Employee Rol
    public static int employeeRoleType(String typeOfEmp){
        return switch ( typeOfEmp.toLowerCase() ){
            case "admin" -> 1;
            case "manager" -> 2;
            case "member" -> 3;
            default -> -1;
        };
    }

    // Returns boolean value if Employee Info is Same
    public static boolean isValidEmployee( Employee frontendEmp, Employee backendEmp ) throws ValidationFailedException {

        if ( ( frontendEmp.getEmpID() == backendEmp.getEmpID() ) &&
                ( frontendEmp.getEmployeeType() == backendEmp.getEmployeeType() ) &&
                ( frontendEmp.getEmpName().equals( backendEmp.getEmpName() ) ) &&
                ( frontendEmp.getEmail().equals( backendEmp.getEmail() ) ) &&
                ( frontendEmp.getPasswd().equals( backendEmp.getPasswd() ) )){
            return true;
        }

        throw new ValidationFailedException("Employee Details Do Not Match");

    }

}
