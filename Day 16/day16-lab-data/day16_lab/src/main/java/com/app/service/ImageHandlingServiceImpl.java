package com.app.service;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class ImageHandlingServiceImpl implements ImageHandlingService {
	// dep : emp dao i/f
	@Autowired
	private EmployeeRepository empRepo;
	//how to inject the property from app property file :
//SpEL : spring Expression language
	@Value("${upload.location}")
	private String uploadFolder;
	
	

	// add custom init method to check if folder exists ,
	//if not create a new one !
	@PostConstruct
	public void myInit()
	{
		System.out.println("in init "+uploadFolder);
		//chk if folder exists
		File dir=new File(uploadFolder);
		if(dir.exists())
			System.out.println("folder alrdy exists !!!!");
		else  {
			dir.mkdirs();//creating required dirs
			System.out.println("created a new folder");
		}
		
	}
	@Override
	public ApiResponse uploadImageToFolder(Long empId, MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

}
