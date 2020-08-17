package rma.org.bt.mms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import rma.org.bt.mms.dao.CallerLogDao;
import rma.org.bt.mms.global.base.BaseService;
import rma.org.bt.mms.global.dto.CurrentUser;
import rma.org.bt.mms.global.dto.DropdownDTO;
import rma.org.bt.mms.global.dto.ResponseMessage;
import rma.org.bt.mms.model.CallerLog;
import rma.org.bt.mms.model.CallerLogDTO;

import java.util.Date;
import java.util.List;

@Service
public class CallerLogService extends BaseService {

    @Autowired
    private CallerLogDao callerLogDao;

    public List<DropdownDTO> getSuperZoneList() {
        return callerLogDao.getSuperZoneList();
    }

    public List<DropdownDTO> getZoneList() {
        return callerLogDao.getZoneList();
    }

    public ResponseMessage save(CallerLog callerLog, CurrentUser currentUser) {

        if (StringUtils.isEmpty(callerLog)) {
            responseMessage.setStatus(UNSUCCESSFUL_STATUS);
            responseMessage.setText("Please enter the details properly.");
            return responseMessage;
        }
        callerLog.setCreatedBy(currentUser.getUserName());
        callerLog.setCreatedDate(currentUser.getServerDate());
        callerLog.setDate(new Date());
        callerLogDao.save(callerLog);

        responseMessage.setStatus(SUCCESSFUL_STATUS);
        responseMessage.setText("Information saved successfully.");
        return responseMessage;
    }

    public List<CallerLogDTO> getCallerLogList(String userName) {
        return callerLogDao.getCallerLogList(userName);
    }
}
