// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormMaintenanceCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormNumbersBySalesOrgCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationOptionCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypesCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationsBySalesOrgCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SalesOrgForReportsCustomDTO;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.rmi.Remote;
import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;
import javax.rmi.CORBA.Tie;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;
import org.omg.CORBA.portable.UnknownException;

public class _EJSRemoteStatelessBaseAgreementDataManager_7c609f96_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements Tie {
    
    private EJSRemoteStatelessBaseAgreementDataManager_7c609f96 target = null;
    private ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(Remote target) {
        this.target = (EJSRemoteStatelessBaseAgreementDataManager_7c609f96) target;
    }
    
    public Remote getTarget() {
        return target;
    }
    
    public org.omg.CORBA.Object thisObject() {
        return this;
    }
    
    public void deactivate() {
        if (orb != null) {
            orb.disconnect(this);
            _set_delegate(null);
        }
    }
    
    public ORB orb() {
        return _orb();
    }
    
    public void orb(ORB orb) {
        orb.connect(this);
    }
    
    public void _set_delegate(Delegate del) {
        super._set_delegate(del);
        if (del != null)
            orb = _orb();
        else
            orb = null;
    }
    
    public String[] _ids() { 
        return (String [] )  _type_ids.clone();
    }
    
    public OutputStream _invoke(String method, InputStream _in, ResponseHandler reply) throws SystemException {
        try {
            org.omg.CORBA_2_3.portable.InputStream in = 
                (org.omg.CORBA_2_3.portable.InputStream) _in;
            switch (method.length()) {
                case 6: 
                    if (method.equals("remove")) {
                        return remove(in, reply);
                    }
                case 7: 
                    if (method.equals("addForm")) {
                        return addForm(in, reply);
                    }
                case 10: 
                    if (method.equals("deleteForm")) {
                        return deleteForm(in, reply);
                    } else if (method.equals("updateForm")) {
                        return updateForm(in, reply);
                    }
                case 11: 
                    if (method.equals("_get_handle")) {
                        return _get_handle(in, reply);
                    } else if (method.equals("isIdentical")) {
                        return isIdentical(in, reply);
                    } else if (method.equals("getAllForms")) {
                        return getAllForms(in, reply);
                    }
                case 12: 
                    if (method.equals("_get_EJBHome")) {
                        return _get_EJBHome(in, reply);
                    }
                case 15: 
                    if (method.equals("_get_primaryKey")) {
                        return _get_primaryKey(in, reply);
                    }
                case 19: 
                    if (method.equals("addModificationType")) {
                        return addModificationType(in, reply);
                    }
                case 21: 
                    if (method.equals("addModificationOption")) {
                        return addModificationOption(in, reply);
                    }
                case 22: 
                    if (method.equals("updateModificationType")) {
                        return updateModificationType(in, reply);
                    } else if (method.equals("getModificationOptions")) {
                        return getModificationOptions(in, reply);
                    } else if (method.equals("deleteModificationType")) {
                        return deleteModificationType(in, reply);
                    }
                case 23: 
                    if (method.equals("getAllModificationTypes")) {
                        return getAllModificationTypes(in, reply);
                    }
                case 24: 
                    if (method.equals("getFormNumbersBySalesOrg")) {
                        return getFormNumbersBySalesOrg(in, reply);
                    }
                case 25: 
                    if (method.equals("updateModificationOptions")) {
                        return updateModificationOptions(in, reply);
                    }
                case 26: 
                    if (method.equals("getModificationsBySalesOrg")) {
                        return getModificationsBySalesOrg(in, reply);
                    }
            }
            throw new BAD_OPERATION();
        } catch (SystemException ex) {
            throw ex;
        } catch (Throwable ex) {
            throw new UnknownException(ex);
        }
    }
    
    private OutputStream _get_EJBHome(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        EJBHome result = target.getEJBHome();
        OutputStream out = reply.createReply();
        Util.writeRemoteObject(out,result);
        return out;
    }
    
    private OutputStream _get_primaryKey(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Object result = target.getPrimaryKey();
        OutputStream out = reply.createReply();
        Util.writeAny(out,result);
        return out;
    }
    
    private OutputStream remove(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        try {
            target.remove();
        } catch (RemoveException ex) {
            String id = "IDL:javax/ejb/RemoveEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,RemoveException.class);
            return out;
        }
        OutputStream out = reply.createReply();
        return out;
    }
    
    private OutputStream _get_handle(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        Handle result = target.getHandle();
        OutputStream out = reply.createReply();
        Util.writeAbstractObject(out,result);
        return out;
    }
    
    private OutputStream isIdentical(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        EJBObject arg0 = (EJBObject) in.read_Object(EJBObject.class);
        boolean result = target.isIdentical(arg0);
        OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private OutputStream getAllModificationTypes(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        ModificationTypesCustomDTO arg0 = (ModificationTypesCustomDTO) in.read_value(ModificationTypesCustomDTO.class);
        ModificationTypesCustomDTO result;
        try {
            result = target.getAllModificationTypes(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,ModificationTypesCustomDTO.class);
        return out;
    }
    
    private OutputStream addModificationType(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        ModificationTypeCustomDTO arg0 = (ModificationTypeCustomDTO) in.read_value(ModificationTypeCustomDTO.class);
        ModificationTypeCustomDTO result;
        try {
            result = target.addModificationType(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,ModificationTypeCustomDTO.class);
        return out;
    }
    
    private OutputStream updateModificationType(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        ModificationTypeCustomDTO arg0 = (ModificationTypeCustomDTO) in.read_value(ModificationTypeCustomDTO.class);
        ModificationTypeCustomDTO result;
        try {
            result = target.updateModificationType(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,ModificationTypeCustomDTO.class);
        return out;
    }
    
    private OutputStream addModificationOption(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        ModificationOptionCustomDTO arg0 = (ModificationOptionCustomDTO) in.read_value(ModificationOptionCustomDTO.class);
        ModificationOptionCustomDTO result;
        try {
            result = target.addModificationOption(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,ModificationOptionCustomDTO.class);
        return out;
    }
    
    private OutputStream getModificationOptions(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        ModificationTypeCustomDTO arg0 = (ModificationTypeCustomDTO) in.read_value(ModificationTypeCustomDTO.class);
        ModificationTypeCustomDTO result;
        try {
            result = target.getModificationOptions(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,ModificationTypeCustomDTO.class);
        return out;
    }
    
    private OutputStream updateModificationOptions(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        ModificationOptionCustomDTO arg0 = (ModificationOptionCustomDTO) in.read_value(ModificationOptionCustomDTO.class);
        ModificationOptionCustomDTO result;
        try {
            result = target.updateModificationOptions(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,ModificationOptionCustomDTO.class);
        return out;
    }
    
    private OutputStream getModificationsBySalesOrg(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        SalesOrgForReportsCustomDTO arg0 = (SalesOrgForReportsCustomDTO) in.read_value(SalesOrgForReportsCustomDTO.class);
        ModificationsBySalesOrgCustomDTO result;
        try {
            result = target.getModificationsBySalesOrg(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,ModificationsBySalesOrgCustomDTO.class);
        return out;
    }
    
    private OutputStream getFormNumbersBySalesOrg(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        SalesOrgForReportsCustomDTO arg0 = (SalesOrgForReportsCustomDTO) in.read_value(SalesOrgForReportsCustomDTO.class);
        FormNumbersBySalesOrgCustomDTO result;
        try {
            result = target.getFormNumbersBySalesOrg(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,FormNumbersBySalesOrgCustomDTO.class);
        return out;
    }
    
    private OutputStream getAllForms(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        FormMaintenanceCustomDTO arg0 = (FormMaintenanceCustomDTO) in.read_value(FormMaintenanceCustomDTO.class);
        FormMaintenanceCustomDTO result;
        try {
            result = target.getAllForms(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,FormMaintenanceCustomDTO.class);
        return out;
    }
    
    private OutputStream addForm(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        FormDetailsCustomDTO arg0 = (FormDetailsCustomDTO) in.read_value(FormDetailsCustomDTO.class);
        FormDetailsCustomDTO result;
        try {
            result = target.addForm(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,FormDetailsCustomDTO.class);
        return out;
    }
    
    private OutputStream deleteForm(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        FormDetailsCustomDTO arg0 = (FormDetailsCustomDTO) in.read_value(FormDetailsCustomDTO.class);
        try {
            target.deleteForm(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        OutputStream out = reply.createReply();
        return out;
    }
    
    private OutputStream updateForm(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        FormDetailsCustomDTO arg0 = (FormDetailsCustomDTO) in.read_value(FormDetailsCustomDTO.class);
        FormDetailsCustomDTO result;
        try {
            result = target.updateForm(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,FormDetailsCustomDTO.class);
        return out;
    }
    
    private OutputStream deleteModificationType(org.omg.CORBA_2_3.portable.InputStream in , ResponseHandler reply) throws Throwable {
        ModificationTypeCustomDTO arg0 = (ModificationTypeCustomDTO) in.read_value(ModificationTypeCustomDTO.class);
        try {
            target.deleteModificationType(arg0);
        } catch (ServiceException ex) {
            String id = "IDL:com/ibm/isc/customerfulfillment/bhoppt/projectutilities/_exception/ServiceEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,ServiceException.class);
            return out;
        }
        OutputStream out = reply.createReply();
        return out;
    }
}
