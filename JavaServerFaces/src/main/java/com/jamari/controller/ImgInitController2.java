package com.jamari.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.context.FacesContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jamari.service.serviceImpl.EmpServiceImpl;

/**
 * Servlet implementation class ImgInitController2
 */
public class ImgInitController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgInitController2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void init(ServletConfig cfg) throws ServletException{
		super.init(cfg);
		System.out.println("start!");
		try {
			EmpServiceImpl empSvc = new EmpServiceImpl();
			for (int i = 1; i < 6; i++) {
				String path = getServletContext().getRealPath("/resource/imgInit/"+i+".jpg");
				// String path = FacesContext.getCurrentInstance().getExternalContext().getContextName();
				InputStream in = new FileInputStream((new File(path)));
				byte[] img = new byte[in.available()];
				in.read(img);
				empSvc.updateImgByEmpNo(i, img);
				System.out.println(img.length);
				for(int j =0;j<10000;j++){
					int jjj = j;
				}
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			// Error handling
		}
		
	}
	

}
