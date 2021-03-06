package CoreJava.DAO;

import CoreJava.Models.Course;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseDAO {
    public List<Course> getAllCourses(){
    	String filePath = "src/database/courses.csv";
    	File file = new File(filePath);
    	
    	ArrayList<Course> data = new ArrayList<Course>();
    	
    	try {
			Scanner read = new Scanner(file);
			
			while(read.hasNextLine()) {
				
				//storing the line in a String array.
				String line[] = read.nextLine().split(",");
				
				//immediately storing the data from that array in a Student object.
				data.add(new Course(Integer.parseInt(line[0]), line[1], line[2]));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
    	
    	return data;
    }
}
