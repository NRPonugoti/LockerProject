package com.locker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockerProject {

	static final String folderpath = "C:\\Users\\Admin23\\Desktop\\SimpleLearn\\LockerProject\\LockedFiles";

	public static void main(String[] args) {
		 int proceed=1;
		 do {
		//variable declaration
		Scanner obj= new Scanner(System.in);
		int ch;
		//Displaying manu 
		displayMenu();
		ch=Integer.parseInt(obj.nextLine()) ;
		switch(ch) {
		case 1:getAllFiles();
		         break;
		case 2:createFile();
		        break ;
		case 5 : System.out.println("Application is Closed ");
			System.exit(0);
	     break;
		  default : System.out.println("Invalid Operation");
		  break;
		}
		
		 } while(proceed>0);
		
	}

	private static void displayMenu() {
		//Menu
		System.out.println("*************************************************");
		System.out.println("\t\t Company Lockers Pvt.Ltd.");
		System.out.println("*************************************************");
		
		System.out.println("1. Display all files");
		System.out.println("2. Add new file files");
		System.out.println("3. Delete a files");
		System.out.println("4. Search File a  files");
		System.out.println("5. Exit");

		System.out.println("************************************************");
		System.out.println("Enter Your Choice :");
	}

	

	private static void createFile() {
		// Variable declaration
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();
		// Read file name from User
		System.out.println("Enter FIle Name :");
		fileName = obj.nextLine();
		// Read Number of lines from user
		System.out.println("Enter how many lines in the file");
		linesCount = Integer.parseInt(obj.nextLine());
		// Read file name from user
		for (int i = 1; i <= linesCount; i++) {
			System.out.println("Enter line  " + i + ":");
			content.add(obj.nextLine());

		}
		boolean isSaved = FilesManager.writeContentToFile(folderpath, fileName, content);
		if (isSaved) {
			System.out.println("File and Data Saved Sucessfully ");
		} else {
			System.out.println("Some Error occured , Please contact Admin@gamil.com");
		}
		
	}

	private static void getAllFiles() {
		List<String> filesName = FilesManager.getAllFilesName(folderpath);
		if(filesName.size()==0) {
			System.out.println("File not exist");
		} else {
		for (String f : filesName) {

			System.out.println(f);
		}
		}
	}

}
