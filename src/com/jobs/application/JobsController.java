package com.jobs.application;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;
	

public class JobsController {

	public EmployeeRepository repository;  // Field
	
	public JobsController(EmployeeRepository repository){  // constructor
		
		this.repository = repository;
		
	}	
	
	//Methods:
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager); 
	}


	public void payAllEmployeers() {
		
		List<AbsStaffMember> members=new ArrayList<>();
		members = repository.getAllMembers();
		
		for (int i=0; i<members.size(); i++) {
		
			AbsStaffMember a = members.get(i);
			a.pay();
			
		}			
	}
	

	public String getAllEmployees() {
		
		List<AbsStaffMember> members = new ArrayList<>(); // I create new object List of the type AbsStaffMember;
		
		members = repository.getAllMembers ();
		
		String membersString = "";
		
		for (int i=0; i<members.size(); i++) {
			
			membersString += members.get(i).name + " ,";
			membersString += members.get(i).address + " ,";
			membersString += members.get(i).phone + " ,";
			membersString += members.get(i).totalPaid + " ." + " \n";
		}	
				
		return membersString;
	
	}

	public void createVolunteer(String name, String address, String phone) throws Exception {
		Volunteer voluntario = new Volunteer(name, address, phone, "No wage");
		repository.addMember(voluntario);
		
	}
	
	
	
}
