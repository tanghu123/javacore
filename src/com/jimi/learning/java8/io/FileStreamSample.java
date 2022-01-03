package com.jimi.learning.java8.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamSample {

	public static void main(String[] args) {
		try {
			// FileOutputStream Test
			OutputStream output = new FileOutputStream("configure/FileOutputStream.text");
			int n = 1;
			while (n <= 1000) {
				output.write((String.valueOf(n) + ",").getBytes());
				n++;
			}
			output.flush();
			output.close();

			// FileInputStream Test
			InputStream in = new FileInputStream(FileStreamSample.class.getResource("FileInputStream.text").getPath());
			byte[] buf = new byte[1024];
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			int read;
			while ((read = in.read(buf, 0, 1024)) > -1) {
				byteOut.write(buf, 0, read);
			}
			String s = new String(byteOut.toByteArray(), "UTF-8");
			in.close();
			System.out.println(s);

			// File Reader/Writer by char
			System.out.println("---------- Charactor Stream Test ----------");
			FileReader fReader = new FileReader(FileStreamSample.class.getResource("FileReader.text").getPath());
			FileWriter fWrite = new FileWriter("configure/FileWriter.text");
			char[] bufC = new char[1024];
			int readC = -1;
			StringBuilder sb = new StringBuilder();
			while ((readC = fReader.read(bufC, 0, 1024)) != -1) {
				fWrite.write(bufC, 0, readC);
				for (int i = 0; i < readC; i++) {
					sb.append(bufC[i]);
				}
			}
			fWrite.flush();
			fWrite.close();
			System.out.println(sb.toString());
			fReader.close();
			
			//BufferReader
			BufferedReader bReader = new BufferedReader(new FileReader(FileStreamSample.class.getResource("BufferedReader.text").getPath()));
			BufferedWriter bWriter = new BufferedWriter(new FileWriter("configure/BufferedWriter.text"));
			String readLine = "";
			sb = new StringBuilder();
			while((readLine = bReader.readLine()) != null) {
				sb.append(readLine);
				bWriter.append(readLine);
				bWriter.newLine();
			}
			System.out.println(sb.toString());
			bReader.close();
			bWriter.flush();
			bWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
