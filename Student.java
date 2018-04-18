package track;

public class Student {

	private String fname;
	private String lname;
	private String distance;
	private String grade;
	private String event;
	private String gender;
	private String school;
	private double compDist;
	private String name;
	private String eventType;
	
	public Student(String name,String grade, String gender, String event,String distance,String eventType){
		this.name=name;
		this.grade=grade;
		this.distance=distance;
		this.event=event;
		this.eventType=eventType;
	}
	public Student(){
		
	}
	
	public String display(){
		if(name==null){
			name=fname+" "+lname;
		}
		for(int i=name.length();i<25;i++){
			name+=" ";
		}
		String display=name+"\t"+distance+"\t"+grade+"\t"+event;
		return display;
		
	}
	public String displayWSchool()
	{
		if(school.length()<9){
			String display=display()+"\t"+school+"\n";
			return display;
		}else{
			String display=display()+"\t"+school.substring(0, 9)+"\n";
			return display;
		}
		
	}
	
	public String getEventType(){
		return eventType;
	}
	
	public void setEventType(String ev){
		eventType=ev;
	}
	
	public void setSchool(String school){
		this.school=school;
	}
	
	public void setFirstName(String n)
	{
		fname=n;
	}
	
	public void setLastName(String n)
	{
		lname=n;
	}
	
	public void setEvent(String e)
	{
		event=e;
	}
	public void setGrade(String g)
	{
		grade=g;
	}
	public void setGender(String g)
	{
		gender=g;
	}
	public void setDistance(String d)
	{
		distance =d;
		
	}
	public String getSchool(){
		return school;
	}
	public String getEvent()
	{
		return event;
	}
	public String getDistance()
	{
		return distance;
	}
	public String getFirstName()
	{
		return fname;
	}
	public String getLastName()
	{
		return lname;
	}
	public String getGrade()
	{
		return grade;
	}
	public String getGender()
	{
		return gender;
	}
	public double compareDistance(){
		try {
			if (!distance.equals("NH") && !distance.equals("SCR")&&!distance.equals("ND")&&!distance.equals("NT")&&!distance.equals("DNS")&&!distance.equals("DNP")) {
				compDist = Double.parseDouble(distance.replaceAll("[-:]", ""));
			}
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return compDist;
	}
	
	
}
