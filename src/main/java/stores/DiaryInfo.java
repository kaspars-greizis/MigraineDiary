package stores;

public class DiaryInfo{
	
    private String username = "null";
    private String description="null";
    private String start="null";
    private String end="null";
    private int severity=0;
    private String medication="null";
    private String triggers="null";
	
        
      public DiaryInfo(String username){
		this.username = username;
	}
	
	 public void setUsername(String username){
         this.username = username;
     }
     public String getUsername(){
         return username;
     }

     public void setDescription(String description){
         this.description = description;
     }
     public String getDescription(){
         return description;
     }

     public void setStart(String start){
         this.start = start;
     }
     public String getStart(){
         return start;
     }

     public void setEnd(String end){
         this.end = end;
     }
     public String getEnd(){
         return end;
     }

     public void setSeverity(int severity){
         this.severity = severity;
     }
     public int getSeverity(){
         return severity;
     }

     public void setMedication(String medication){
         this.medication = medication;
     }
     public String getMedication(){
         return medication;
     }
   
     public void setTriggers(String triggers){
         this.triggers = triggers;
     }
     public String getTriggers(){
         return triggers;
     }
}