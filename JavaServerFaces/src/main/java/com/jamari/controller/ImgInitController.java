package com.jamari.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;

import com.jamari.service.serviceImpl.EmpServiceImpl;

@ManagedBean(name = "imgInitCon")
@SessionScoped
public class ImgInitController implements Serializable {

	private static final long serialVersionUID = 1L;

	public void imgInit() {
		try {
			ServletContext servletContext = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();
			EmpServiceImpl empSvc = new EmpServiceImpl();
			for (int i = 1; i < 6; i++) {
				String path = servletContext
						.getRealPath("/resource/imgInit/"+i+".jpg");
				// String path = FacesContext.getCurrentInstance().getExternalContext().getContextName();
				InputStream in = new FileInputStream((new File(path)));
				byte[] img = new byte[in.available()];
				in.read(img);
				empSvc.updateImgByEmpNo(i, img);
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			// Error handling
		}
	}
}
