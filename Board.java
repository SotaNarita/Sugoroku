package sugoroku;

import java.io.*;
import java.util.ArrayList;

public class Board {
	FileInputStream fi=null;
	InputStreamReader is=null;
	BufferedReader br=null;
	private String fileName;
	private int blocks;
	String line; //�ǂݍ��񂾍s
	int index=0; //�ǂݍ��񂾍s��
	String[] columnName = null;
	String[] dataArray = null;//��̓��e������
	public  ArrayList<String> blockNum = new ArrayList<String>();
	public  ArrayList<String> event = new ArrayList<String>();
	public  ArrayList<String> eventLog = new ArrayList<String>();
	
	public Board(String fileName_) {
		this.setFileName(fileName_);
		
		//csv�t�@�C���̓ǂݍ��݊J�n
		try {
			fi=new FileInputStream(getFileName());
			is=new InputStreamReader(fi);
			br=new BufferedReader(is);
			
			//1�s���t�@�C���ǂݍ���
			while ((line=br.readLine()) != null) {
				if (index==0) {
					columnName = line.split(",");//1�s�ڂ����͗�̃^�C�g��
				} else {
					dataArray = line.split(",");//2�s�ڈȍ~�͗�̓��e
					blockNum.add(index-1, dataArray[0]);
					event.add(index-1, dataArray[1]);
					eventLog.add(index-1, dataArray[2]);
				}
				index++;
			}
			
			this.setBlocks(blockNum.size()-1);
			System.out.println("�����낭�̃{�[�h��p�ӂ��܂����B");
			System.out.println("�S����" + this.getBlocks() + "�}�X�B");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public int getBlocks() {
		return this.blocks;
	}
	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}
	
	
}
