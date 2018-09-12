/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.xml.DOMConfigurator;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;

/**
 * This class helps loggin the given message
 * 
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date Jan 20, 2004
 * 
 * revision date author reason
 * 
 * </PRE>
 * 
 * <br/>
 * 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class OPPTLogger {
    /** constant */
    public static final int DEBUG = 1;

    /** constant */
    public static final int INFO = 2;

    /** constant */
    public static final int WARNING = 3;

    /** constant */
    public static final int ERROR = 4;

    /** constant */
    public static final int FATAL = 5;

    private static final String OPPT_ERROR_LOGGER = "OPPTErrorLogger"; /* NOI18N */

    private static final String OPPT_LOGGER = "OPPTLogger"; /* NOI18N */
    
    private static final String OPPT_ACTIVITY_LOGGER = "OPPTActivityLogger"; /* NOI18N */

    private static Logger cOPPTErrorLogger = null;

    private static Logger cOPPTLogger = null;
    
    private static Logger cOPPTActivityLogger = null;

    private static Properties properties = new Properties();

    private static OPPTLogger cOpptLogger = new OPPTLogger();

    /**
     * Constructor
     * 
     * <br/>
     * 
     * <PRE>
     * 
     * date Dec 2, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br/>
     *  
     */
    private OPPTLogger() {
        DOMConfigurator.configureAndWatch(OPPTPropertiesReader
                .getLoggerConfigurationFile());

        cOPPTErrorLogger = Logger.getLogger(OPPT_ERROR_LOGGER);
        cOPPTLogger = Logger.getLogger(OPPT_LOGGER);
        
        /* Start change  CR0801074150 - CBS OPPT activity logging */
        cOPPTActivityLogger = Logger.getLogger(OPPT_ACTIVITY_LOGGER);
        /* End change  CR0801074150 - CBS OPPT activity logging */

        try {
            properties.load(new FileInputStream(new File(OPPTPropertiesReader
                    .getLoggerMessageFile())));
        } catch (Exception e) {
            LogLog.error("Unable to load the Message Properties File", e); /* NOI18N */
        }
    }

    /**
     * To log the given message
     * 
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Jan 27, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param messageID
     *            message-id which should be present in the
     *            logmessages.properties
     * @param logLevel
     *            log level can be FATAL, ERROR,WARNING, INFO, DEBUG
     * @param className
     *            name of the class from where the log call being called
     * @param methodName
     *            name of the method from where this log call being called
     * @param messageString
     *            value for the message. It can be either null or some value
     */
    public static void log(String messageID, int logLevel, String className,
            String methodName, String messageString) {
        log(messageID, logLevel, className, methodName, messageString, null);
    }

    /**
     * To log the given message
     * 
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Jan 27, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param messageID
     *            message-id which should be present in the
     *            logmessages.properties
     * @param logLevel
     *            log level can be FATAL, ERROR,WARNING, INFO, DEBUG
     * @param className
     *            Class from which the logging initialized.
     * @param methodName
     *            Method from which the logging initialized.
     * @param messageString
     *            value for the message. It can be either null or some value
     * @param exception
     *            exception that needs to be logged.
     */
    public static void log(String messageID, int logLevel, String className,
            String methodName, String messageString, Throwable exception) {
        String message = properties.getProperty(messageID);

        if (message != null) {
            logMessage(message, logLevel, className, methodName, messageString,
                    exception);
        } else {
            LogLog.error("Mapping for message ID[" + messageID
                    + "] Not Found In the Properties File"); /* NOI18N *//* NOI18N */
        }
    }

    /**
     * This method helps debugging the code. The messages are directly passed to
     * this method to log. This method doesn't use the message-id.
     * 
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param message
     *            Message to be logged
     * @param className
     *            Class from which the logging initialized.
     * @param methodName
     *            Method from which the logging initialized.
     */
    public static final void debug(String message, String className,
            String methodName) {
        logMessage(message, DEBUG, className, methodName, null, null);
    }

    /**
     * This method helps debugging the code. The messages are directly passed to
     * this method to log. This method doesn't use the message-id.
     * 
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 5, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param message
     *            Message to be logged
     * @param className
     *            Class from which the logging initialized.
     * @param methodName
     *            Method from which the logging initialized.
     */
    public static final void info(String message, String className,
            String methodName) {
        logMessage(message, INFO, className, methodName, null, null);
    }
    /* Start change  CR0801074150 - CBS OPPT activity logging */
    public static final void infoActivityLogger(String message, String className,
            String methodName) {
        logMessageActivityLogger(message, INFO,"" ,"", null, null);
    }
    
    private static void logMessageActivityLogger(String message, int logLevel,
            String className, String methodName, String messageString,
            Throwable exception) {
        messageString = new StringBuffer().append(message).append(
                UtilityConstants.MESSAGE_DELIMITER).append(className).append(
                UtilityConstants.MESSAGE_DELIMITER).append(methodName).append(
                UtilityConstants.MESSAGE_DELIMITER).append(
                ((messageString == null) ? " " : messageString)) /* NOI18N */
        .toString();

      cOPPTActivityLogger.info(messageString, exception);
        
    }
    /* End change  CR0801074150 - CBS OPPT activity logging */
    
    private static void logMessage(String message, int logLevel,
            String className, String methodName, String messageString,
            Throwable exception) {
        messageString = new StringBuffer().append(message).append(
                UtilityConstants.MESSAGE_DELIMITER).append(className).append(
                UtilityConstants.MESSAGE_DELIMITER).append(methodName).append(
                UtilityConstants.MESSAGE_DELIMITER).append(
                ((messageString == null) ? " " : messageString)) /* NOI18N */
        .toString();

        switch (logLevel) {
        case WARNING:
            cOPPTErrorLogger.warn(messageString, exception);
            break;

        case ERROR:
            cOPPTErrorLogger.error(messageString, exception);
            break;

        case FATAL:
            cOPPTErrorLogger.fatal(messageString, exception);
            break;

        case INFO:
            cOPPTLogger.info(messageString, exception);
            
            break;

        case DEBUG:
        default:
            cOPPTLogger.debug(messageString, exception);
        }
    }
}
