package com.tow.libs;

import java.io.File;
import java.net.URL;

import org.junit.Test;

public class resourceManager {
	
	/* 
	 * Ref: https://www.programmersought.com/article/26532629119/
	 */

	public String getResourcePath ()  { 
		ClassLoader classLoader = getClass().getClassLoader();
		String location = classLoader.getResource("codeOutput/").getPath();
//		System.out.println(location);
		return location; 
	}
		
	public File getResourceFile (String fileNameInResource)  {		
//		String fileName = resourceFilename;
		URL url = getClass().getClassLoader().getResource(fileNameInResource);
		File file = new File(url.getPath());
		
		return file; 
	}

	@Test 
	public void resourceTest () { 
		
		String dataloc= "."; 
		
		ClassLoader classLoader = getClass().getClassLoader();
//		File n = new File (classLoader.getResource("/xyz1.xml").getPath());
//		File n = new File (classLoader.getResource("hibernate.cfg.xml").getFile());
//		String dataloc = classLoader.getResource("hibernate.cfg.xml").getPath();
//		System.out.println(dataloc);
		
		dataloc = classLoader.getResource("data/Users.csv").getPath();
		System.out.println(dataloc);
		
		dataloc = classLoader.getResource("codeOutput/test.txt").getPath();
		System.out.println(dataloc);
		
//		dataloc = classLoader.getResource("codeOutput/").getPath();
//		System.out.println(dataloc);
		
		// Test the resource code 
		System.out.println(getResourcePath());
		
		// Serializing 'a'
//		FileOutputStream fos = new FileOutputStream(n);
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(a);
		
		
		System.out.println(this.getClass().getResource(""));
		
	
	}	
}
