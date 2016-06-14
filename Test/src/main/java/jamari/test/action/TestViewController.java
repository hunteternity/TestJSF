package jamari.test.action;


import jamari.entities.test.Dept;
import jamari.entities.test.Emp;
import jamari.entities.test.Jobno;
import jamari.test.model.CertFormBean;
import jamari.test.model.EmpForm;
import jamari.test.service.DeptService;
import jamari.test.service.EmpService;
import jamari.test.service.JobService;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;




@Controller
@RequestMapping(value = "/testView")
public class TestViewController {

	@Autowired
	private EmpService empSvc;
	
	@Autowired
	private DeptService deptSvc;
	
	@Autowired
	private JobService jobSvc;
	
	
	@RequestMapping(value = "/angular")
	public String angular() {
		return "forward:/views/html/angular.html";
	}
	
	@RequestMapping(value = "/angularDP")
	public String angularDP() {
		return "forward:/views/html/angularDP.html";
	}
	
	@RequestMapping(value = "/angularUM")
	public String angularUM() {
		return "forward:/WEB-INF/views/test/UserManagement.jsp";
	}
	
	@RequestMapping(value = "/jsfTest")
	public String jsfTest() {
		return "forward:/WEB-INF/views/test/jsfTest.jsp";
	}
	
	@RequestMapping(value = "/index")
	public String index(Model m) {
		m.addAttribute("empForm", new EmpForm());
		m.addAttribute("deptAll", deptSvc.list("deptno",true));
		m.addAttribute("jobAll", jobSvc.list("jobno",true));
		return "/test/index";
	}
	
	@RequestMapping(value = "/uploadTest")
	public String uploadTest(Model m) {
		return "/test/uploadTest";
	}
	
	@RequestMapping(value = "/empAll")
	public String empAll(Model m) {
		m.addAttribute("empAll", empSvc.list("empno",true));
		return "/test/allEmp";
	}
	
	@RequestMapping(value = "/empCreate")
	public String empCreate(Model m,
			@ModelAttribute("empForm") EmpForm empForm, 
			BindingResult result
			) throws UnsupportedEncodingException, ParseException {
		Dept dept = deptSvc.selectByDept(empForm.getDeptno());
		Jobno job = jobSvc.selectByJobno(empForm.getJobno());
		System.out.println(empForm.getHiredate().toString());
		Calendar c = Calendar.getInstance();
		c.setTime(empForm.getHiredate());
		Emp emp = new Emp(null, empForm.getEname(), 
				job, c.getTime(), empForm.getSal(), empForm.getComm(), dept);
		empSvc.save(emp); // emp cascade insert dept
		
		m.addAttribute("empAll", empSvc.list());
		return "/test/allEmp";
	}
	
	@RequestMapping(value = "/empUpdatePage")
	public String empUpdatePage(Model m, @RequestParam(value="empno") int empno){
		
		EmpForm empForm = null;
		Emp emp = empSvc.find(Emp.class, empno);
		empForm = new EmpForm(emp);
		empForm.setDeptno(empSvc.selectByEmpNo(empno).getDeptno().getDeptno());
		empForm.setJobno(empSvc.selectByEmpNo(empno).getJobno().getJobno());
		m.addAttribute("empForm", empForm);
		m.addAttribute("jobAll", jobSvc.list("jobno",true));
		m.addAttribute("deptAll", deptSvc.list("deptno",true));
		return "/test/empUpdatePage";
	}
	
	@RequestMapping(value = "/empUpdate")
	public String empUpdate(Model m , @ModelAttribute("empForm") EmpForm empForm, BindingResult result){
		
		Emp emp = empForm.toEmp();
		emp.setDeptno(deptSvc.find(Dept.class, empForm.getDeptno()));
		emp.setJobno(jobSvc.find(Jobno.class, empForm.getJobno()));
		Calendar c = Calendar.getInstance();
		c.setTime(empForm.getHiredate());
		emp.setHiredate(c.getTime());
		empSvc.save(emp);
		m.addAttribute("empAll", empSvc.list("empno",true));
		return "/test/empUpdate";
	}
	
	@RequestMapping(value = "/empDelete")
	public String empDelete(Model m, @RequestParam(value="empno") int empno){
		Emp emp = empSvc.find(Emp.class, empno);
		empSvc.delete(emp);
		m.addAttribute("empAll", empSvc.list());
		return "/test/empUpdate";
	}
	
	@RequestMapping(value = "/empByEname")
	public String empByEname(Model m, @RequestParam(value="ename") String ename){
		m.addAttribute("empForm", empSvc.selectByEname(ename));
		return "/test/empByEname";
	}
	
/*	@RequestMapping(value = "/uploadCert", method = RequestMethod.POST)
    public String uploadCert(Model m,@ModelAttribute("cert") CertFormBean cert ,@RequestParam("file") MultipartFile file,BindingResult result
            ) throws IOException, CertificateException {
		
		CertFormBean certBean = new CertFormBean();
		
//        if (null == multipartFile) {
//            alerter.warn(Messages.warning_uploadEmptyFile());
//            return certBean;
//        }
//        if (UAAWebAppUtils.isAllowUploadCheck(multipartFile)) {
		
//use upload file change to certBean & save file
            certBean = this.gainCertBeanFromFile(file.getBytes());
            saveCertFile(file);
//        }
            
//resolve certBean.subject to each column
        String s = certBean.getSubject();    
        String CN = s.substring(s.indexOf("\"CN=")+7,s.indexOf(",OU="));
        String OU = s.substring(s.indexOf(",OU=")+4,s.indexOf(",O="));
        String O = s.substring(s.indexOf(",O=")+3,s.indexOf(",C="));
        String C = s.substring(s.indexOf("C=")+2,s.indexOf("C=")+4);

//        String[] subject = {CN,OU,O,C};
//        m.addAttribute("subject",subject);
        m.addAttribute("CN",CN);
        m.addAttribute("OU",OU);
        m.addAttribute("O",O);
        m.addAttribute("C",C);
        m.addAttribute("certForm",certBean);
        
		return "/test/uploadTest";
    }
	
	protected CertFormBean gainCertBeanFromFile(byte[] certContent) throws CertificateException {
		UctDataEncrypter uctDataEncrypter = new UctDataEncrypter();
		
        X509Certificate x509Cert = uctDataEncrypter.gainX509Cert(certContent);
        X509Certificate[] receipts = new X509Certificate[1];
        receipts[0] = x509Cert;
        uctDataEncrypter.displayCertInfo(receipts);
        CertFormBean certBean = new CertFormBean();
        certBean.setSerialNumber(x509Cert.getSerialNumber().toString(16));
        certBean.setSubject(x509Cert.getSubjectDN().toString());
        certBean.setNotBefore(DateUtils.parseTWCalendar(x509Cert.getNotAfter()));
        SimpleDateFormat sdf = new SimpleDateFormat("EEEEE, MMMMM d, yyyy 'at' HH:mm:ss a 'Taipei Standard Time'", Locale.US);
        certBean.setNotAfter(sdf.format(x509Cert.getNotAfter()));
        certBean.setCert(uctDataEncrypter.gainBase64Cert(x509Cert.getEncoded()));
        @SuppressWarnings("deprecation")
        int validYear = x509Cert.getNotAfter().getYear() - x509Cert.getNotBefore().getYear();
        certBean.setValidYear(String.valueOf(validYear));
        return certBean;
    }
	
	protected void saveCertFile(MultipartFile file) throws IOException {
		try {
            byte[] bytes = file.getBytes();

            // Creating the directory to store file
            String rootPath = System.getProperty("catalina.home");
            File dir = new File(rootPath + File.separator + "tmpFiles");
            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            File serverFile = new File(dir.getAbsolutePath() + File.separator+"Fia.cer");
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            System.out.println(dir.getAbsolutePath() + File.separator+"Fia.cer");
        } catch (Exception e) {
        	System.out.println("error!");
        }
	}

//ffs952e for save function code
	protected void saveCertFile(MultipartFile multipartFile) throws IOException {
        StringBuilder filePath = new StringBuilder();
        String filePrefix = filePath.append(ApplicationProperties.ENVIRONMENT_PSRDATA)
                .append(File.separator).toString();
        filePath = new StringBuilder();
        filePath.append(filePrefix).append(File.separator)
                .append(multipartFile.getOriginalFilename());
//        log.debug("save cert file prefix " + filePrefix);
//        log.debug("save cert file path" + filePath.toString());
        // 先清目錄
			fileStore = new FileStore();	
        File fileDir = fileStore.getFile(Locations.Persistent.ROOT, filePrefix);
        FileUtils.deleteDirectory(fileDir);
        
        File file = fileStore.getFile(Locations.Persistent.ROOT, filePath.toString());
        System.out.println(filePath.toString());
        file.getParentFile().mkdirs();
        // 再寫檔
        FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
    } */
}
