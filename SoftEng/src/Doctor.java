import java.util.ArrayList;

public class Doctor {
	 String firstName;
	 String lastName;
	 String rn;
	 String password;
	 String timetable;
	
	public Doctor(String firstN, String lastN, String rn)
	{
		super();
		this.firstName = firstN;
		this.lastName = lastN;
		this.rn = rn;
		this.password = null;
		this.timetable = null;
	}
	
	public Doctor(String firstName, String lastName, String rn, String password, String timetable) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.rn = rn;
		this.password = password;
		this.timetable = timetable;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRn() {
		return rn;
	}

	public static ArrayList<Doctor> RemoveDoctor(String RN, ArrayList<Doctor> doctors) {
		ArrayList<Doctor> helpList= new ArrayList<Doctor>();
		
		for(Doctor doct: doctors) {
    		if(!(doct.rn.equals(RN))) {
    			//diagrafi autou tou employee apo tin vasi
    			helpList.add(doct);
    		}
    	}
		return helpList;
	}
	


	
}
