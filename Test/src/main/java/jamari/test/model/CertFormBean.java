/**
 * 
 */
package jamari.test.model;

import jamari.base.model.FormBean;

/**
 * 
 */
public class CertFormBean extends FormBean   {


    /**
     * 憑證序號
     */
    private String serialNumber;
    
    /**
     * 主旨
     */
    private String subject;
    
    /**
     * 憑證到期日
     */
    private String notAfter;
    
    /**
     * 憑證發行日
     */
    private String notBefore;
    
    /**
     * 憑證效期
     */
    private String validYear;

    /**
     * 憑證主體, base64
     */
    private String cert;
    
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNotAfter() {
        return notAfter;
    }

    public void setNotAfter(String notAfter) {
        this.notAfter = notAfter;
    }

    public String getNotBefore() {
        return notBefore;
    }

    public void setNotBefore(String notBefore) {
        this.notBefore = notBefore;
    }

    public String getValidYear() {
        return validYear;
    }

    public void setValidYear(String validYear) {
        this.validYear = validYear;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }
}
