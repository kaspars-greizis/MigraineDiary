package stores;

public class DiaryInfo{
	
    private String username;
    private String description;
    private String start;
    private String end;
    private int severity;
    private String medication;
    private String triggers;
    private int diaryId;
    private int test;
	
        
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
     
     public void setDiary(String username,String medication,String triggers, String start, String end, String description, int severity)
     {     
            this.username=username;
            this.medication=medication;
            this.triggers=triggers;
            this.start=start;
            this.severity=severity;
            this.end=end;
            this.description=description;
           
    
         
     }
     
}