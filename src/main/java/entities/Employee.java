
package entities;


public class Employee {
    
    private int eId;
    private String eName;
    private String eDept;
    private String eNumber;
    private String eCity;

    public Employee() {
    }

    public Employee(String eName, String eDept, String eNumber, String eCity) {
        this.eName = eName;
        this.eDept = eDept;
        this.eNumber = eNumber;
        this.eCity = eCity;
    }

    public Employee(int eId, String eName, String eDept, String eNumber, String eCity) {
        this.eId = eId;
        this.eName = eName;
        this.eDept = eDept;
        this.eNumber = eNumber;
        this.eCity = eCity;
    }

    public int geteId() {
        return eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteDept() {
        return eDept;
    }

    public void seteDept(String eDept) {
        this.eDept = eDept;
    }

    public String geteNumber() {
        return eNumber;
    }

    public void seteNumber(String eNumber) {
        this.eNumber = eNumber;
    }

    public String geteCity() {
        return eCity;
    }

    public void seteCity(String eCity) {
        this.eCity = eCity;
    }

    @Override
    public String toString() {
        return "Employee{" + "eId=" + eId + ", eName=" + eName + ", eDept=" + eDept + ", eNumber=" + eNumber + ", eCity=" + eCity + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
