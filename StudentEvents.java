package track;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentEvents {

	public static boolean newStudent;
	public static boolean update;
	ArrayList<StudentAthlete> students= new ArrayList<StudentAthlete>();

	@SuppressWarnings("resource")
	public String getStudents(String searchName, File file,boolean exact) {
		
		int index=0;
		try {
			loadStudents();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StudentAthlete student = new StudentAthlete();
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			int counter = 0;
			in.mark(1000000);
			while (in.readLine() != null) {
				counter++;
			}
			in.reset();
			in.readLine();
			for (int i = 1; i <= counter - 1; i++) {
				String line = in.readLine();
				Scanner reader = new Scanner(line).useDelimiter(";");
				String tempDelim = "";
				if (reader.next().equals("E")) {
					for (int dex1 = 1; dex1 <= 3; dex1++) {
						reader.next();
					}
					tempDelim = reader.next();

					for (int dex1 = 1; dex1 <= 23; dex1++) {
						reader.next();
					}
					tempDelim = reader.next();

					if (tempDelim.toLowerCase().contains("aur")) {
						reader = new Scanner(line).useDelimiter(";");
						for (int dex = 1; dex <= 5; dex++) {
							reader.next();
						}
						reader.next();
						for (int dex = 1; dex <= 2; dex++) {
							reader.next();
						}
						reader.next();
						for (int dex = 1; dex <= 13; dex++) {
							reader.next();
						}
						String name = reader.next();
						name = reader.next() + " " + name;
						newStudent = true;
						index=getStudent(name);
						if(index==-1){
							update = true;
							student=new StudentAthlete();
							students.add(student);
							index=students.size()-1;
						}
						

						reader = new Scanner(line).useDelimiter(";");
						Event e = new Event();
						for (int dex = 1; dex <= 31; dex++) {

							String r = reader.next();

							if (dex == 2) {
								e.setEventType(r);
							}

							if (dex == 5) {

								e.setEventName(r);
							}
							if (dex == 6) {

								students.get(index).setGender(r);

							}
							if (dex == 9) {
								if (r.contains("7th")) {
									students.get(index).setGrade("7th");

								}

								else {
									students.get(index).setGrade("8th");

								}

							}
							if (dex == 11) {
								e.setDistance(r);

							}
							if (dex == 23) {
								students.get(index).setLastName(r);

							}
							if (dex == 24) {
								students.get(index).setFirstName(r);

							}

						}
						boolean add=true;
						for(int x=0;x<students.get(index).getEvents().size();x++){
							
							if(e.getEventName().equals(students.get(index).getEvents().get(x).getEventName())){
								add=false;
								
								students.get(index).getEvents().get(x).setDistance(e.getDistance());
								if(students.get(index).getEvents().get(x).isBest())
								{
									update=true;
								}
								
								students.get(index).getEvents().get(x).resetBest();
							}
						}
						if(add){
							students.get(index).addEvent(e);
							
						}
						

					}
				}

			}
			in.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		String tempName = "";
		if (!displayStudents(searchName).equals("")) {
			tempName = displayStudents (searchName);
		}
		else if(exact==true){
			tempName="Student Not Found";
			
		}
		else{
			tempName=approximateStudent(searchName);
		}

		try {
			if(update){
				System.err.println("save Students");
				saveStudents();
				update=false;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return tempName;
	}
	public String approximateStudent(String tempName){
		String display="";
		String fname="";
		String lname="";
		if(tempName.contains(" ")&&tempName.charAt(tempName.length()-1)!=' ')
		{
			@SuppressWarnings("resource")
			Scanner nameSplitter=new Scanner(tempName).useDelimiter(" ");
			fname=nameSplitter.next();
			lname=nameSplitter.next();
		}
		else{
			fname=tempName.replace(" ", "");
			lname=tempName.replace(" ", "");
		}
		int closest=1000;
		for(int i=0;i<students.size();i++){
			if(students.get(i).getName().toLowerCase().contains(lname.toLowerCase())){
				display+=students.get(i).display()+"\n";
			}
			else if(students.get(i).getName().toLowerCase().contains(fname.toLowerCase())){
				display+=students.get(i).display()+"\n";;
			}
			if(Math.abs(tempName.compareTo(students.get(i).getName()))<closest)
			{
				closest=Math.abs(tempName.compareTo(students.get(i).getName()));
			}
			else if(tempName.compareToIgnoreCase(students.get(i).getName())==0){
				display+=students.get(i).display()+"\n";;
			}
			
			
		}
		
		if(display.equals("")){
			display="Improve Your Typing Skills Man...";
		}
		return display;
		
	}
	
	public ArrayList<StudentAthlete> getStudents(){
		return students;
	}
	
	public void saveStudents()throws IOException{
		FileWriter fw = new FileWriter("studentAthletes.txt");
		PrintWriter pw = new PrintWriter(fw);
		for(int i=0;i<students.size();i++){
			pw.println(students.get(i).saveStudent());
		}
		pw.close();
	}
	
	public void loadStudents()throws IOException{
		File file = new File("studentAthletes.txt");
		if(file.exists()){
			BufferedReader br = new BufferedReader(new FileReader(file));
			br.mark(1000000);
			int counter=0;
			while(br.readLine()!=null){
				counter++;
			}
			br.reset();
			String temp;
			for(int i=0;i<counter;i++){
				@SuppressWarnings("resource")
				Scanner scan = new Scanner(br.readLine()).useDelimiter(",");
				StudentAthlete ath= new StudentAthlete();
				temp=scan.next();
				ath.setFirstName(temp);
				temp=scan.next();
				ath.setLastName(temp);
				temp=scan.next();
				ath.setGrade(temp);
				temp=scan.next();
				ath.setGender(temp);
				temp=scan.next();
				int foorl=Integer.parseInt(temp);
				for(int d=0;d<foorl;d++){
					Event e = new Event();
					temp=scan.next();
					e.setEventName(temp);
					temp=scan.next();
					e.setEventType(temp);
					temp=scan.next();
					e.setBestDistance(temp);
					e.setDistance("DNP");
					ath.addEvent(e);
				}
				students.add(ath);
				scan.close();
			}
			br.close();
			
			
		}else{
			update=true;
		}
	}

	public void printStudents() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).display());
		}
		System.out.print("\n\n");
	}

	public String displayStudents(String name) {
		String result = "";
		students.sort(Comparator.comparing(StudentAthlete::getName));
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equals(name)) {
				result = students.get(i).display();
			}
			
		}
		return result;
	}

	public void printStudentsSort() {
		students.sort(Comparator.comparing(StudentAthlete::getLastName));
		for (int i = 0; i < students.size(); i++) {
			for (int d = 0; d < students.get(i).getEvents().size(); d++) {

			}

		}
		System.out.print("__________________________________________\n\n");

	}

	public int getStudent(String name) {
		int index=-1;
		for (int i = 0; i < students.size(); i++) {
			if (name.equals(students.get(i).getName())) {
				index=i;
				newStudent = false;
			}

		}
		if(index==-1){
			return -1;
		}
		else{
			return index;
		}
		
	}
}
