package com.chenqf.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller  
@RequestMapping("/file")
public class FileController {
	
	@RequestMapping("/formUpload")  
	public String formUpload(@RequestParam("file") CommonsMultipartFile[] files,HttpServletRequest request){
		//重定向的url地址
		String redirectUrl = null;
		
		for(int i = 0;i<files.length;i++){  
			
            System.out.println("fileName---------->" + files[i].getOriginalFilename());  
          
            if(!files[i].isEmpty()){  
                int pre = (int) System.currentTimeMillis();  
                try {  
                    //拿到输出流，同时重命名上传的文件  
                    FileOutputStream os = new FileOutputStream("F:/" + new Date().getTime() + files[i].getOriginalFilename());  
                    //拿到上传文件的输入流  
                    FileInputStream in = (FileInputStream) files[i].getInputStream();  
                      
                    //以写字节的方式写文件  
                    int b = 0;  
                    while((b=in.read()) != -1){  
                        os.write(b);  
                    }  
                    os.flush();  
                    os.close();  
                    in.close();  
                    int finaltime = (int) System.currentTimeMillis();  
                    System.out.println(finaltime - pre);  
                    redirectUrl = "redirect:../demo/success.html";
                } catch (Exception e) {  
                    e.printStackTrace();  
                    System.out.println("上传出错");  
                    redirectUrl = "redirect:../demo/error.html";
                }  
            }  
        }
		
		return redirectUrl;
	}
	
	@RequestMapping("/ajaxUpload")  
	@ResponseBody
	public void ajaxUpload(@RequestParam("file") CommonsMultipartFile[] files,HttpServletRequest request){
		
		for(int i = 0;i<files.length;i++){  
			
            System.out.println("fileName---------->" + files[i].getOriginalFilename());  
          
            if(!files[i].isEmpty()){  
                int pre = (int) System.currentTimeMillis();  
                try {  
                    //拿到输出流，同时重命名上传的文件  
                    FileOutputStream os = new FileOutputStream("F:/" + new Date().getTime() + files[i].getOriginalFilename());  
                    //拿到上传文件的输入流  
                    FileInputStream in = (FileInputStream) files[i].getInputStream();  
                      
                    //以写字节的方式写文件  
                    int b = 0;  
                    while((b=in.read()) != -1){  
                        os.write(b);  
                    }  
                    os.flush();  
                    os.close();  
                    in.close();  
                    int finaltime = (int) System.currentTimeMillis();  
                    System.out.println(finaltime - pre);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                    System.out.println("上传出错");  
                }  
            }  
        }
	}
}
