package com.radik.horoscope;
//File explorer class
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import android.os.Environment;


public class FileExp {

	public FileExp()
	{
		
	}
	
	public boolean SDCardmount()
	{
		return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
	}
	
	public boolean CopyFile(String currentPath, String newPath){
		try{
		InputStream in = null;
        OutputStream out = null;
        
            in = new FileInputStream(currentPath);
            out = new FileOutputStream(newPath);
            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;  
            return true;
       
		}catch (Exception e) {
			return false;
		}
	}	
	
	public boolean DelFile(String currentPath){
		File direct = new File(currentPath);
		if(direct.exists()){
		return direct.delete();
		}else{return false;}
	}
	
	public String FileProp(String currentPath){
		String Prop="";	
		File direct = new File(currentPath);
		if(direct.exists()){
		if(direct.isFile()){Prop=Prop+"f ";}
		if(direct.isDirectory()){Prop=Prop+"d ";}
		if(direct.isHidden()){Prop=Prop+"h ";}
		if(direct.canRead()){Prop=Prop+".r ";}
		if(direct.canWrite()){Prop=Prop+".w ";}
		}else{Prop="false";}
		return Prop;
	}
	
	public boolean ExistsFile(String currentPath){
		File direct = new File(currentPath);
		return direct.exists();
	}	
	
	public boolean MoveFile(String currentPath, String newPath){
		File direct = new File(currentPath);
		if(direct.exists()){
			return direct.renameTo(new File(newPath));
		}else{return false;}
	}
	
	public boolean SaveStringsFile(String currentPath,List<String> LS,boolean append){
		try {
			File file = new File(currentPath);  			
			
			BufferedWriter buf = new BufferedWriter(new FileWriter(file, append));
		    for(String s : LS){		    	
		    		buf.append(s);
				    buf.newLine();
		    }	
		    buf.close(); 
		    return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public boolean ReadStringsFile(String currentPath,List<String> LS){
		try {
			File file = new File(currentPath);  
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
		    while ((line = br.readLine()) != null) {
		        LS.add(line);
		    }			
		    return true;	
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
		
	public boolean MKDir(String currentPath){
		File direct = new File(currentPath);
		return direct.mkdir();
	}
	
	private void copyFile(InputStream in, OutputStream out) throws IOException {
	    byte[] buffer = new byte[1024];
	    int read;
	    while((read = in.read(buffer)) != -1){
	      out.write(buffer, 0, read);
	    }
	}
}
