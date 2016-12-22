package com.proj.senthilmpro.alpha;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UtilClass {
	
	private List<String> fileNamesList = new ArrayList<String>();
	private List<File> filesList = new ArrayList<File>();
	
	/* process file folders and gets list of file names from these folders */
	public void renameFiles(String parentFolder){
		if(parentFolder != null){
			File mainFolder = new File(parentFolder);
			if(mainFolder.isDirectory()){
				// get list of files and add to list
				//filesList.addAll(mainFolder.listFiles());
				File[] localFileList = mainFolder.listFiles();
				for(File singleFile : localFileList){
					if(singleFile.isDirectory()){
						renameFiles(singleFile.getAbsolutePath());
					} else {
						fileNamesList.add(singleFile.getName());
						filesList.add(singleFile);
					}
				}
			}
			// print all the files in this directory
			/*for(String files : fileNamesList){
				//System.out.println(files);
			}*/
			
			
			renameFiles(filesList, getInvalidStringSet());
		}
	}
	
	public Set<String> getInvalidStringSet(){
		Set<String> invalidStringSet = new HashSet<String>();
		invalidStringSet.add("www.TamilRockers.com - ");
		invalidStringSet.add("www.TamilRockers.net - ");
		invalidStringSet.add("www.TamilRockers.ac - ");
		invalidStringSet.add("www.TamilRockers.be -");
		invalidStringSet.add("www.TamilRockers.cc - ");
		invalidStringSet.add("www.TamilRockers.to - ");
		invalidStringSet.add("www.TamilRockers.la - ");
		invalidStringSet.add("www.TamilRockers.net_-_");
		invalidStringSet.add("www.TamilRockers.net+-++");
		invalidStringSet.add("www.TamilRockers.net+-+");
		
		return invalidStringSet;
	}
	
	
	public void printAbsolutePath(List<File> filesList, boolean isPrintFilePaths){
		// prints whole names
		if(isPrintFilePaths){
			if(filesList.size() > 0){
				for(File file : filesList){
					System.out.println(file.getAbsolutePath());
				}
			}
		}
	}
	
	// get each file name and replace the files.
	public void renameFiles(List<File> filesList, Set<String> invalidStringSet){
		if(filesList.size() > 0 && invalidStringSet.size() > 0){
			for(File file : filesList){
				String originalName = file.getName();
				String newFileName = "";
				// loop through strings of invalid string set and if any string matches, then replace
				for(String invalidString : invalidStringSet.toArray(new String[invalidStringSet.size()])){
					if(originalName.contains(invalidString)){
						newFileName = originalName.replace(invalidString, "").trim();
						File newFile = new File(file.getParent() +"\\"+ newFileName);
						Boolean bool = file.renameTo(newFile);
						System.out.println("File renamed : "+bool +" for "+ originalName );
					}
				}
			}
		}
	}
	
}
