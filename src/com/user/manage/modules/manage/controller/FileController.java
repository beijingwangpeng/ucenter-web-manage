package com.user.manage.modules.manage.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.dc.penguinMVC.annotation.Controller;
import org.dc.penguinMVC.annotation.RequestMapping;
@Controller
@RequestMapping("/manage")
public class FileController {
	@RequestMapping("/doUpload")
	public void doUpload(HttpServletRequest request){
		String contentType = request.getContentType();
		System.out.println(contentType);
		int fileSize = request.getContentLength();
		System.out.println(fileSize);
		
		FileOutputStream fileOut = null;
		DataInputStream in = null;
		try {
			in = new DataInputStream(request.getInputStream());
			byte[] dataBytes = new byte[fileSize];
			
			int byteRead = 0; 
			int totalBytesRead = 0;
			/** 上传的数据保存在byte数组 */
			while(totalBytesRead < fileSize){ 
				byteRead = in.read(dataBytes, totalBytesRead, fileSize); 
				totalBytesRead += byteRead; 
			}
			in.close();
			String file = new String(dataBytes,"UTF-8");
			String upFileName = file.substring(file.indexOf("filename=\"") + 10);
			upFileName = upFileName.substring(0, upFileName.indexOf("\n"));
			upFileName = upFileName.substring(upFileName.lastIndexOf("\\") + 1, upFileName.indexOf("\"")); 
			System.out.println(upFileName);
			
			/** 取得数据的分隔字符串 */
			String boundary = contentType.substring(contentType.lastIndexOf("boundary=") + 9, contentType.length()); 
			/** 创建保存路径的文件名 */
			
			int pos; 
			pos = file.indexOf("filename=\""); 
			pos = file.indexOf("\n",pos) + 1; 
			pos = file.indexOf("\n",pos) + 1; 
			pos = file.indexOf("\n",pos) + 1; 
			int boundaryLocation = file.indexOf(boundary, pos)-4;
			
			/** 取得文件数据的开始的位置 */
			int startPos = file.substring(0, pos).length();
			
			/** 取得文件数据的结束的位置 */
			int endPos = file.substring(boundaryLocation).length();
			
			File f = new File(request.getServletContext().getRealPath("/file"));
			if(!f.exists()){
				f.mkdirs();
			}
			/** 创建文件的写出类 */
			fileOut = new FileOutputStream(f.getAbsolutePath()+File.separator+upFileName); 
			/** 保存文件的数据 */
			fileOut.write(dataBytes, startPos, (fileSize - endPos - startPos));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
