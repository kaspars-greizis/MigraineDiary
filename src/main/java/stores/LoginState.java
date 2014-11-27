package stores;

public class LoginState {
	private boolean loginstate = false;
	private String Username=null;
        //private int access = 2; 
    
    public void LoggedIn(){

    }
    
    public void setUsername(String name){
        this.Username=name;
    }
    public String getUsername(){
        return Username;
    }
    
    public void setLoginState(boolean loginstate){
        this.loginstate = loginstate;
    }
    public boolean getLoginState(){
        return loginstate;
    }
    
    /*public void setAccess(int access){
    	this.access = access;
    }
    
    public int getAccess(){
    	return access;
    }*/
}