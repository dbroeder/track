package track;


import java.util.ArrayList;

public class StudentAthlete {
	private ArrayList<Event> events=new ArrayList<Event>();
	private String fname;
	private String gender;
	private String grade;
	private String lname;
	
	public StudentAthlete(String name)
	{
		this.fname=name;
	}
	
	public StudentAthlete(){
		
	}
	public void setLastName(String l){
		lname=l;
	}
	
	public void setGender(String g){
		gender=g;
	}
	
	public void setGrade(String g){
		grade=g;
	}
	
	public void setFirstName(String n){
		fname=n;
	}
	
	public void addEvent(Event e){
		events.add(e);
	}
	
	public String getLastName(){
		return lname;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String getGrade(){
		return grade;
	}
	
	public String getFirstName(){
		return fname;
	}
	
	public String getName(){
		return fname+" "+lname;
	}
	
	public ArrayList<Event> getEvents(){
		return events;
	}
	
	public String display(){
		String r=getName()+"\nEvents:\n";
		for(int i=0;i<events.size();i++){
			r+="\t"+events.get(i).getEventName()+"\t"+events.get(i).getDistance()+"\tBest: "+events.get(i).getBestDistance()+"\n";
		}
		return r;
	}
	
	public String saveEventsDisplay(){
		String r="";
		for(int i=0;i<events.size();i++){
			r+=","+events.get(i).getEventName()+","+events.get(i).getEventType()+","+events.get(i).getBestDistance();
		}
		return r;
	}
	public String saveStudent(){
		return fname+","+lname+","+grade+","+gender+","+events.size()+saveEventsDisplay();
	}
}
