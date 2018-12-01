/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.struts;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 *
 * @author PhongNTSE1997
 */
public class MyInterceptor implements Interceptor {
    
    public MyInterceptor() {
    }
    
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void init() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
