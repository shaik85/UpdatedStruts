/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller;


import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;


/** 
 * All the actions that we expect to take long time to give out the response back to the client should
 * extend OPPTLongAction. This makes the actual action to be executed in seperate thread. This action
 * waits for 7.2 seconds(minium). If the action is finished with in this time interval, the actual output 
 * is shown to the user. If the action takes more time thane 7.2 secongs it forwards the control to a progress 
 * bar page. 
 * 
 * The progress bar page refreshes for each second and checks if the thread is finished with the execution. 
 * If finished it shows the actual output. If not it continues with the progress page.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public abstract class OPPTLongAction extends OPPTAction implements Runnable
{
	private boolean started;
	private boolean running;
	private boolean completed;
	
	private ActionForm actionForm = null;
	private HttpSession session = null;
	/**
	 * userId
     */
    public String userId = null;

	/**
     * Overridden method - This method is overridden to make the action response to wait for 7.2 seconds,
     * if the action is not complted with in this period the control if forwarded to Progress action. If
     * the action is completed with in 7.2 sec the control is forwarded to actual view.
     * This method is also responsible for making this action to run in a seperate thread.
     * <br/><PRE>
     * date Nov 11, 2003
     * revision date author reason
     * </PRE><br/>
     *
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     * @param mapping ActionMapping value which holds all the action mapping setting done in struts-config.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception
     * @concurrency $none
     */
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		userId = request.getRemoteUser();
		this.actionForm = actionForm;
		session = request.getSession();
		session.setAttribute("task", this);  //$NON-NLS-1$
		new Thread(this).start();
		synchronized (this) {
			wait(7000);
		}

		if(isCompleted()){
			return mapping.findForward(getForwardName());
		}
		else{
			return mapping.findForward("progress");  //$NON-NLS-1$
		}
	}
	/**
	 * Overridden method - Overridden to place the code to be executed in a seperate thread. In our action the 
	 * code will be the actual action execution.  
	 * 
	 * <br/><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see java.lang.Runnable#run() 
	 *  
	 *
	 */
	public void run() {
		try 
		{
			setCompleted(false);
			setRunning(true);
			try 
			{
				executeLongAction(actionForm, session);
				setCompleted(true);
			}
			catch(Exception e){
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"OPPTLongAction","run",null,e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
				OPPTSession opptSession = new OPPTSession(getSession());
				ErrorViewBean viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA00));
				opptSession.setCurrentMessageViewBean(viewBean);
				setForwardName(ForwardNameConstants.PAGE_ERROR);
				setCompleted(true);
			}
		} 
		finally {
			if(!isFirstActionOfProcess() && actionForm instanceof OPPTActionForm){
				((OPPTActionForm)actionForm).reset();		
			}
			setRunning(false);
		}
	}

	/**
     * Returns true if the thread excution is already started. Else it returns false.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 11, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @return boolean
     * @concurrency $none
     */
	public synchronized boolean isStarted() {
		return started;
	}
	
	/**
     * Returns true if the thread is started and is currently running. When ever the execution of
     * the thread is completed this running flag is set to false.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 11, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @return boolean
     * @concurrency $none
     */
	public synchronized boolean isRunning() {
		return running;
	}
	
	/**
     * Returns true if the execution of the thread is completed. The initial value for this completed
     * flag will be false, so when ever a thread is started and completed its exection this flag will
     * be set to true.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 11, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @return boolean
     * @concurrency $none
     */
	public synchronized boolean isCompleted() {
		return completed;
	}
	
	/**
     * Sets the state of the completed flag. If the completed state is true, it notifies the process
     * that is waiting. In our case the execute method is waiting for 7.2 seconds, if the thread
     * execution is completed with in 7.2 sec, at the end of thread execution we will calling the
     * setComplted method which in turn notifies to the waiting process.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 11, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param completed boolean value which shows the state of the completed flag
     * @concurrency $none
     */
	public synchronized void setCompleted(boolean completed) {
		this.completed = completed;
		if(completed) {
			synchronized (this) {
				notify();
			}
		}
	}
	
	/**
     * Sets the running flags state. If the running state is true, it shows that the action thread has
     * started running. If it is false, it shows that the action thread has finished its running.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 11, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param running boolean which shows the state of the running flag
     * @concurrency $none
     */
	public synchronized void setRunning(boolean running) {
		this.running = running;
		if (running) {
			started = true;
		}
	}

	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public HttpSession getSession() {
		return session;
	}

	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session 
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}

}
