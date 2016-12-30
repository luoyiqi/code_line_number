package com.skk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
/**
 * 功能：代码统计封装类
 */
public class Numbers {
	private List<File> javaList = new ArrayList<File>();
	private List<File> jspList = new ArrayList<File>();
	private List<File> xmlList = new ArrayList<File>();
	private int javaLines=0;
	private int jspLines=0;
	private int xmlLines=0;
	
	public Numbers(File path) {
		getlist(path);
		getLines();
	}

	public int getJavaLines() {
		return javaLines;
	}

	public void setJavaLines(int javaLines) {
		this.javaLines = javaLines;
	}
	public int getJspLines() {
		return jspLines;
	}

	public void setJspLines(int jspLines) {
		this.jspLines = jspLines;
	}
	public int getXmlLines() {
		return xmlLines;
	}

	public void setXmlLines(int xmlLines) {
		this.xmlLines = xmlLines;
	}

	private void getlist(File path){
		if(path.isDirectory()){
			File[] files = path.listFiles();
			for (File file : files) {
				getlist(file);
			}
		}else if(path.isFile()){
			if(path.getName().toLowerCase().endsWith(".java")){
				javaList.add(path);
			} else if(path.getName().toLowerCase().endsWith(".xml")){
				xmlList.add(path);
			} else if(path.getName().toLowerCase().endsWith(".jsp")){
				jspList.add(path);
			}
		}
	}
	private void getLines(){
		BufferedReader javaBr,xmlBr,jspBr;
		try{
			for (File file : javaList) {
				javaBr = new BufferedReader(new FileReader(file));
				while((javaBr.readLine())!= null){
					javaLines++;
				}
			}
			for (File file : xmlList) {
				xmlBr = new BufferedReader(new FileReader(file));
				while((xmlBr.readLine())!= null){
					xmlLines++;
				}
			}
			for (File file : jspList) {
				jspBr = new BufferedReader(new FileReader(file));
				while((jspBr.readLine())!= null){
					jspLines++;
				}
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "对不起，出错了，请重试",null,JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
