package com.jamari.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.StreamedContent;

import com.jamari.service.serviceImpl.EmpServiceImpl;

@WebServlet(name = "ImageServlet", urlPatterns = {"/ImageServlet/*"})
public class DBGifReader4 extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		ServletOutputStream out = res.getOutputStream();
		EmpServiceImpl empSvc = new EmpServiceImpl(); ;
		int empno = new Integer(req.getParameter("empno"));
		try {
			byte[] buf = empSvc.getByEmpNo(empno).getPic();
			out.write(buf);
		} catch (Exception e) {
			e.printStackTrace();
			InputStream in = new FileInputStream(getServletContext().getRealPath("/resource/image/nopic.jpg"));
			byte[] buf = new byte[in.available()];
		    in.read(buf);
			out.write(buf);
		    in.close();
		}
	}

}
