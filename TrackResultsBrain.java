package track;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TrackResultsBrain {
	
	private File file;
	
	public TrackResultsBrain(File file)
	{
		this.file=file;
	}
	
	@SuppressWarnings("resource")
	public String getStudents(String event,String grade,String school) {
		ArrayList<Student> students8G = new ArrayList<Student>();
		ArrayList<Student> students8B = new ArrayList<Student>();
		ArrayList<Student> students7G = new ArrayList<Student>();
		ArrayList<Student> students7B = new ArrayList<Student>();
		String type="F";
		if(event.contains("R")){
			type="R";
			event=event.replace("R", "");
		}
			
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
				Student student = new Student();
				String line = in.readLine();
				Scanner reader = new Scanner(line).useDelimiter(";");
				String tempDelim = "";
				String ev=reader.next();
				if (ev.equals("E")) {
					for (int dex1 = 1; dex1 <= 3; dex1++) {
						reader.next();
					}
					tempDelim = reader.next();

					if (tempDelim.equals(event)&&!type.equals("R") ) {

						for (int dex1 = 1; dex1 <= 23; dex1++) {
							reader.next();
						}
						tempDelim = reader.next();

						if (tempDelim.equals(school)) {
							reader = new Scanner(line).useDelimiter(";");

							for (int dex = 1; dex <= 31; dex++) {
								String r = reader.next();

								if(dex==2){
									student.setEventType(r);
								}
								
								if (dex == 5) {

									student.setEvent(r);
								}
								if (dex == 6) {

									student.setGender(r);

								}
								if (dex == 9) {
									if (r.contains("7th")) {
										student.setGrade("7th");

									}

									else {
										student.setGrade("8th");

									}

								}
								if (dex == 11) {
									student.setDistance(r);

								}
								if (dex == 23) {
									student.setLastName(r);

								}
								if (dex == 24) {
									student.setFirstName(r);

								}
							}
							if (student.getGender().equals("M") && student.getGrade().equals("7th")) {
								students7B.add(student);
							} else if (student.getGender().equals("M") && student.getGrade().equals("8th")) {
								students8B.add(student);
							} else if (student.getGender().equals("F") && student.getGrade().equals("8th")) {
								students8G.add(student);
							} else {
								students7G.add(student);
							}

						}else{
							reader = new Scanner(line).useDelimiter(";");

							for (int dex = 1; dex <= 31; dex++) {
								String r = reader.next();
								
								if(dex==2){
									student.setEventType(r);
								}

								if (dex == 5) {

									student.setEvent(r);
								}
								if (dex == 6) {

									student.setGender(r);

								}
								if (dex == 9) {
									if (r.contains("7th")) {
										student.setGrade("7th");

									}

									else {
										student.setGrade("8th");

									}

								}
								if (dex == 11) {
									student.setDistance(r);

								}
								if (dex == 23) {
									student.setLastName(r);

								}
								if (dex == 24) {
									student.setFirstName(r);

								}
								if(dex==29){
									student.setSchool(r);
								}
							}
							if(!school.equals("Aurora")){
								if (student.getGender().equals("M") && student.getGrade().equals("7th")) {
									students7B.add(student);
								} else if (student.getGender().equals("M") && student.getGrade().equals("8th")) {
									students8B.add(student);
								} else if (student.getGender().equals("F") && student.getGrade().equals("8th")) {
									students8G.add(student);
								} else {
									students7G.add(student);
								}
							}
						}

					}
				}else if(ev.equals("R")){
					
					if(type.equals("R")){
						student.setEventType("R");
						for(int d=1;d<17;d++){
							String s=reader.next();
							
								if(d==1){
									student.setLastName(s);
									student.setFirstName(" ");
								}
								if(d==4){
									student.setEvent(s);
								}
								if(d==5){
									student.setGender(s);
								}
								if(d==8){
									student.setGrade(s);
								}
								if(d==10){
									student.setDistance(s);
								}
								if(d==12){
									student.setSchool(s);
								}
							
						}
						if(student.getEvent().equals(event)){
							
							if (student.getGender().equals("M") && student.getGrade().contains("7th")) {
								System.err.println("add student "+student.getEvent());
								students7B.add(student);
							} else if (student.getGender().equals("M") && student.getGrade().contains("8th")) {
								students8B.add(student);
							} else if (student.getGender().equals("F") && student.getGrade().contains("8th")) {
								students8G.add(student);
							} else {
								students7G.add(student);
							}
							if(school.contains("Aurora")){
								for(int x=0;x<students7B.size();x++){
									if(!students7B.get(x).getSchool().toLowerCase().contains("aur")){
										students7B.remove(students7B.get(x));
										x--;
									}
								}
								for(int x=0;x<students8B.size();x++){
									if(!students8B.get(x).getSchool().toLowerCase().contains("aur")){
										students8B.remove(students8B.get(x));
										x--;
									}
								}
								for(int x=0;x<students7G.size();x++){
									if(!students7G.get(x).getSchool().toLowerCase().contains("aur")){
										students7G.remove(students7G.get(x));
										x--;
									}
								}
								for(int x=0;x<students8G.size();x++){
									if(!students8G.get(x).getSchool().toLowerCase().contains("aur")){
										students8G.remove(students8G.get(x));
										x--;
									}
								}
							}
							
						}
						
					}
					
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			System.err.println("Error in reading file");
			ioe.printStackTrace();
		}

		if(school.equals("Aurora")){
			String printout="";
			if(grade.equals("8th Boys"))
				printout=printStudentsSort(students8B);
			else if(grade.equals("8th Girls"))
				printout = printStudentsSort(students8G);
			else if(grade.equals("7th Boys"))
				printout=printStudentsSort(students7B);
			else if(grade.equals("7th Girls"))
				printout=printStudentsSort(students7G);
			return printout;
		}else{
			String printout="";
			if(grade.equals("8th Boys"))
				printout=printStudentsSortWithSchool(students8B);
			else if(grade.equals("8th Girls"))
				printout = printStudentsSortWithSchool(students8G);
			else if(grade.equals("7th Boys"))
				printout=printStudentsSortWithSchool(students7B);
			else if(grade.equals("7th Girls"))
				printout=printStudentsSortWithSchool(students7G);
			return printout;
		}
	}
	
	

	

	public String printStudentsSort(ArrayList<Student> students) {
		String pr="";
		if(students.get(0).getEventType().equals("F")){
			students.sort(Comparator.comparing(Student::compareDistance).reversed());
		}else{
			students.sort(Comparator.comparing(Student::compareDistance));
		}
		
		String event="";
		for (int i = 0; i < students.size(); i++) {
			if(i==0)
			{
				event=students.get(i).getEvent();
				pr+=(students.get(i).display())+"\n";
			}else if(!students.get(i).getEvent().equals(event))
			{
				pr+="\n"+(students.get(i).display());
				event=students.get(i).getEvent();
			}
			else{
				pr+=(students.get(i).display())+"\n";
			}
			
		}
		pr+=("\n\n");
		return pr;

	}
	
	public String printStudentsSortWithSchool(ArrayList<Student> students) {
		String pr="";
		if(students.get(0).getEventType().equals("F")){
			students.sort(Comparator.comparing(Student::compareDistance).reversed());
		}else{
			students.sort(Comparator.comparing(Student::compareDistance));
		}
		String event="";
		for (int i = 0; i < students.size(); i++) {
			if(i==0)
			{
				event=students.get(i).getEvent();
				pr+=(i+1)+"  "+(students.get(i).displayWSchool());
			}else if(!students.get(i).getEvent().equals(event))
			{
				pr+="\n"+(i+1)+"  "+(students.get(i).displayWSchool());
				event=students.get(i).getEvent();
			}
			else{
				pr+=(i+1)+"  "+(students.get(i).displayWSchool());
			}
			
		}
		pr+=("\n\n");
		return pr;

	}
	
	
	public void setFile(String f)
	{
		file=new File(f);
	}
	
}
