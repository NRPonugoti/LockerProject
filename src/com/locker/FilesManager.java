package com.locker;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FilesManager {
	/**
	 * This method will return the fileNames from the folder
	 * 
	 * @param folderpath
	 * @return List<String>
	 */
	public static List<String> getAllFilesName(String folderpath) {

		// Creating File Object

		File fl = new File(folderpath);
		// Getting all the files into FileArray
		File[] listOfFiles = fl.listFiles();
		// Make Asscending Order
		// Arrays.sort(listOfFiles);
		System.out.println("\tTotal Number of files :" + listOfFiles.length);
		// declare a list to store file name
		List<String> fileNames = new ArrayList<String>();
		// fileNames.forEach(f->System.out.println(f));
		for (File f : listOfFiles) {
			fileNames.add(f.getName());
			Collections.sort(fileNames);

		}

		return fileNames;

	}

	/**
	 * This method will create or append content
	 * 
	 * @param folderpath
	 * @param fileName
	 * @param content
	 * @return
	 */
	public static boolean writeContentToFile(String folderpath, String fileName, List<String> content) {
		try {
			// Creating File Object
			File fl = new File(folderpath, fileName);
			FileWriter fw = new FileWriter(fl);
			for (String s : content) {
				fw.write(s + "\n");
			}
			fw.close();
			return true;
		} catch (Exception e) {
			return false;

		}

	}
	/**
	 * File will be deleted using this method
	 * 
	 * @param folderpath
	 * @param filename
	 * @return
	 */

	public static boolean deleteFile(String folderpath, String filename) {
		// adding folderpath with file name and creating object
		File file = new File(folderpath + "\\" + filename);
		try {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * this method will search the file from the folder
	 * 
	 * @param folderpath
	 * @param filename
	 * @return
	 */

	public static boolean searchFile(String folderpath, String filename) {
		// adding folderpath with file name and creating object
		File file = new File(folderpath + "\\" + filename);
		/*
		 * if file will be exist then return true otherwise fasle
		 */
		if (file.exists()) {
			return true;
		} else {
			return false;
		}

	}

	
}
