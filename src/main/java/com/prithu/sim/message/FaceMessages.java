/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.message;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author lion
 */
public class FaceMessages {

    public static void setErrorMessage(String errorMessage) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, null));
    }

    public static void setSuccessMessage(String successMessage) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, successMessage, null));
    }

    public static void setWarnMessage(String warnMessage) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, warnMessage, null));
    }

    public static void setFatalMessage(String fatalMessage) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL, fatalMessage, null));
    }

}
