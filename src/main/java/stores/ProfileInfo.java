package stores;

public class ProfileInfo {
	
	private String username = null;
	private String firstname = null;
	private String lastname = null;
	private String email = null;
	private String gender = null;
	private String medication = null;
	private String employment = null;
	private String dob = null;
	private String triggers = null;
	public ProfileInfo(String username){
		this.username = username;
	}
	
	 public void setUsername(String username){
         this.username = username;
     }
     public String getUsername(){
         return username;
     }

     public void setFirstname(String firstname){
         this.firstname = firstname;
     }
     public String getFirstname(){
         return firstname;
     }

     public void setLastname(String lastname){
         this.lastname = lastname;
     }
     public String getLastname(){
         return lastname;
     }

     public void setEmail(String email){
         this.email = email;
     }
     public String getEmail(){
         return email;
     }

     public void setGender(String gender){
         this.gender = gender;
     }
     public String getGender(){
         return gender;
     }

     public void setMedication(String medication){
         this.medication = medication;
     }
     public String getMedication(){
         return medication;
     }
     public void setEmployment(String employment){
         this.employment = employment;
     }
     public String getEmployment(){
         return employment;
     }
     public void setDOB(String dob){
         this.dob = dob;
     }
     public String getDOB(){
         return dob;
     }
     public void setTriggers(String triggers){
         this.triggers = triggers;
     }
     public String getTriggers(){
         return triggers;
     }
}