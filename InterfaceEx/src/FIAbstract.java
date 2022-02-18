
public /* abstract */ class FIAbstract // implements Comparable<FIAbstract>,  Cloneable 
{
	private String FIName;
    private long financialInstitutionId;
    private long routingNumber;
    
    public FIAbstract(String name) {
    	FIName = name;
    }
    
    /* Use this next property only to demo Cloneable */
    public Address address; 

    /* Use to demo Abstract methods 
    public abstract double getInterestRate();
	*/

    /* Use to demo Comparable
    public int compareTo(FIAbstract other) {
        if (financialInstitutionId > other.financialInstitutionId) {
            return 1;
        }
        if (financialInstitutionId < other.financialInstitutionId) {
            return -1;
        }
        return 0;
    }
	*/
    
    /* Use to demo Cloneable 	*/
    public FIAbstract clone() throws CloneNotSupportedException {
        FIAbstract clone = (FIAbstract) super.clone();
        // clone.address = new Address();
        // clone.address.streetAddress1 = this.address.streetAddress1;
        return clone;
    }

    
    public String getFIName() {
        return FIName;
    }
 
    public void setFIName(String name) {
        FIName = name;
    }
    
    public long getFinancialInstitutionId() {
        return financialInstitutionId;
    }
    public void setFinancialInstitutionId(long financialInstitutionId) {
        this.financialInstitutionId = financialInstitutionId;
    }
    public long getRoutingNumber() {
        return routingNumber;
    }
    public void setRoutingNumber(long routingNumber) {
        this.routingNumber = routingNumber;
    }
    
} 