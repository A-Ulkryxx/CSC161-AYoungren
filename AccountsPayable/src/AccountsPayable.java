import java.util.Scanner;

/*
 * 
In main, create an array called payableEmployees of 6 employees. Collect
information for each of 6 employees based on the type of employee by prompting the
user

Write a method in the driver class to print out the details of an employee when given 
the employee object as an argument. This method will in turn call the object’s
toString() method.

 Write a method in the driver class to print out the details of an employee when given 
the employee object as an argument without calling the objects toString() method.

In main(), traverse payableEmployees, and print out employee name and the payment
amount for the employee.

In main(), again traverse payableEmployees, and if an object is a <----
BasePlusCommissionEmployee, increase the base salary by 10%.

In main(), again traverse payableEmp
 */

public class AccountsPayable 
{
	static Scanner input;

	public static void main(String[] args) 
	{
		input = new Scanner(System.in);
		Employee[] payableEmployees = new Employee[6];
		String firstName;
		String lastName;
		long socialSecNum;
		double weeklySalary;
		double hourlyPay;
		float hours;
		double grossSales;
		float commissionRate;
		double basePay;
		int employeeType;

		for (int i = 0; i < 6; i++) 
		{
			System.out.println("What is the first name of employee " + (i + 1) + "?");
			firstName = input.next();
			System.out.println("What is " + firstName + "'s last name?");
			lastName = input.next();
			System.out.println("What is " + firstName + " " + lastName + "'s SSN?");
			socialSecNum = input.nextLong();

			do 
			{
				System.out.println("What is " + firstName + " " + lastName + "'s employee type? \n "
						+ "Salaried (1), Hourly (2), Commission (3), Base with Commission (4)");
				employeeType = input.nextInt();

				if (employeeType == 1)
				{
					System.out.println("What is " + firstName + " " + lastName + "'s weekly salary?");
					weeklySalary = input.nextDouble();
					payableEmployees[i] = new SalariedEmployee(weeklySalary, firstName, lastName, socialSecNum);
				}
				else if (employeeType == 2) 
				{
					System.out.println("What is " + firstName + " " + lastName + "'s hourly wage?");
					hourlyPay = input.nextDouble();
					System.out.println("How many hours did " + firstName + " " + lastName + " work?");
					hours = input.nextFloat();
					payableEmployees[i] = new HourlyEmployee(hourlyPay, hours, firstName, lastName, socialSecNum);
				}
				else if (employeeType == 3)
				{
					System.out.println("What was " + firstName + " " + lastName + "'s gross sales for the week?");
					grossSales = input.nextFloat();
					System.out.println("What is " + firstName + " " + lastName + "'s commission rate?");
					commissionRate = input.nextFloat();

					payableEmployees[i] = new CommissionEmployee(grossSales, commissionRate, firstName, lastName,
							socialSecNum);
				} 
				else if (employeeType == 4)
				{
					System.out.println("What is " + firstName + " " + lastName + "'s weekly base pay?");
					basePay = input.nextDouble();
					System.out.println("What was " + firstName + " " + lastName + "'s gross sales for the week?");
					grossSales = input.nextFloat();
					System.out.println("What is " + firstName + " " + lastName + "'s commission rate?");
					commissionRate = input.nextFloat();

					payableEmployees[i] = new BasePlusCommissionEmployee(grossSales, commissionRate, basePay, firstName,
							lastName, socialSecNum);
				}
				else
				{
					System.out.println(
							"That is not a valid employee type, please use a number corresponding with listed employee type.");
				}
			} while ((employeeType != 1) && (employeeType != 2) && (employeeType != 3) && (employeeType != 4));
		}

		for (int j = 0; j < 6; j++) 
		{
			System.out.println(payableEmployees[j].getFirstName() + " " + payableEmployees[j].getLastName() + ": $"
					+ payableEmployees[j].getPaymentAmount());
		}

		for (int u = 0; u < 6; u++) 
		{
			if (payableEmployees[u] instanceof BasePlusCommissionEmployee)
			{
				((BasePlusCommissionEmployee) payableEmployees[u]).setBasePay( ((BasePlusCommissionEmployee) payableEmployees[u]).getBasePay()
								+ 0.1);
			}
		}

		for (int p = 0; p < 6; p++) 
		{
			System.out.println(payableEmployees[p].getFirstName() + " " + payableEmployees[p].getLastName() + ": $"
					+ payableEmployees[p].getPaymentAmount());
		}

	}

	public static void getEmployeeInfo(Employee employee) 
	{
		System.out.println(employee.toString());
	}

	public static void getEmployeeInformation(Employee employee) 
	{
		if (employee instanceof SalariedEmployee) 
		{
			System.out.println("Salaried Employee - First Name:" + employee.getFirstName() + "Last Name: "
					+ employee.getLastName() + "\nSSN: " + employee.getSocialSecNum() + "\nWeekly Salary: "
					+ ((SalariedEmployee) employee).getWeeklySalary());
		} 
		else if (employee instanceof HourlyEmployee) 
		{
			System.out.println("Salaried Employee - First Name:" + employee.getFirstName() + "Last Name: "
					+ employee.getLastName() + "\nSSN: " + employee.getSocialSecNum() + "\nHours: "
					+ ((HourlyEmployee) employee).getHours() + "\nHourly Wage: "
					+ ((HourlyEmployee) employee).getHourlyWage());
		} 
		else if (employee instanceof CommissionEmployee)
		{
			System.out.println("Salaried Employee - First Name:" + employee.getFirstName() + "Last Name: "
					+ employee.getLastName() + "\nSSN: " + employee.getSocialSecNum() + "\nGross Sales: "
					+ ((CommissionEmployee) employee).getGrossSales() + "\nCommission Rate: "
					+ ((CommissionEmployee) employee).getCommissionRate());
		}
		else if (employee instanceof BasePlusCommissionEmployee)
		{
			System.out.println("Salaried Employee - First Name:" + employee.getFirstName() + "Last Name: "
					+ employee.getLastName() + "\nSSN: " + employee.getSocialSecNum() + "\nGross Sales: "
					+ ((CommissionEmployee) employee).getGrossSales() + "\nCommission Rate: "
					+ ((CommissionEmployee) employee).getCommissionRate() + "\nBase Pay: "
					+ ((BasePlusCommissionEmployee) employee).getBasePay());
		} 
		else 
		{;}
	}
}
