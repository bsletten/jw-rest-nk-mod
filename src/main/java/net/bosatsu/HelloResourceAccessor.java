package org.foo.demo;


import java.util.Calendar;

import org.ten60.netkernel.layer1.nkf.INKFConvenienceHelper;
import org.ten60.netkernel.layer1.nkf.INKFRequestReadOnly;
import org.ten60.netkernel.layer1.nkf.INKFResponse;
import org.ten60.netkernel.layer1.nkf.impl.NKFAccessorImpl;
import org.ten60.netkernel.layer1.representation.StringAspect;

/**
 * <code>HelloResourceAccessor</code> returns a String represenation of
 * the Hello Resource.
 * @author jdeane
 * @version 1.0
 */
public class HelloResourceAccessor extends NKFAccessorImpl {

    /**
     * Default constructor
     */
    public HelloResourceAccessor() {   
        super(SAFE_FOR_CONCURRENT_USE, INKFRequestReadOnly.RQT_SOURCE | 
                INKFRequestReadOnly.RQT_SINK | INKFRequestReadOnly.RQT_DELETE | 
                INKFRequestReadOnly.RQT_NEW);
    }
    
    /**
     * 
     * Return a default text message
     * @param context
     * @throws Exception
     */
    public void processRequest(INKFConvenienceHelper context) throws Exception {

        //method variables
        INKFResponse response = null;
        
        response = context.createResponseFrom
            (new StringAspect("Hello Resource - " 
                    + Calendar.getInstance().getTime()));
        
        response.setExpired();      
        response.setMimeType("text/plain");
        
        context.setResponse(response);
    }
}