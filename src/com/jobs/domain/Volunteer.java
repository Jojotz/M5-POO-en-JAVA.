package com.jobs.domain;


public class Volunteer extends AbsStaffMember {
	
	private String description;

	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		// TODO Auto-generated constructor stub
		this.description = description;
	}
	
	public String getDescription (String newValue) {
			
			return description;
	    } 

	@Override
	public void pay() {
		totalPaid = 0; //??
		
	}

}