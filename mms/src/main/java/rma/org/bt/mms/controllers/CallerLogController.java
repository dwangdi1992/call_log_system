package rma.org.bt.mms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rma.org.bt.mms.global.base.BaseController;
import rma.org.bt.mms.global.dto.ResponseMessage;
import rma.org.bt.mms.model.CallerLog;
import rma.org.bt.mms.model.CallerLogDTO;
import rma.org.bt.mms.services.CallerLogService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping(value = "/callerLog")
public class CallerLogController extends BaseController {


    @Autowired
    private CallerLogService callerLogService;


    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        currentUser = getCurrentUser(request);
        model.addAttribute("superZoneList", callerLogService.getSuperZoneList());
        model.addAttribute("zoneList", callerLogService.getZoneList());
        model.addAttribute("callAttendBy", currentUser.getUserName());
        return "callerLog";
    }

    @RequestMapping(value = "/Report", method = RequestMethod.GET)
    public String report(Model model) {
        return "reports/callerLog";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseMessage save(HttpServletRequest request, CallerLog callerLog) {
        currentUser = getCurrentUser(request);
        return callerLogService.save(callerLog, currentUser);
    }

    @ResponseBody
    @RequestMapping(value = "/Report/getCallerLogList", method = RequestMethod.GET)
    public List<CallerLogDTO> getCallerLogList(HttpServletRequest request) {
        currentUser = getCurrentUser(request);
        return callerLogService.getCallerLogList(currentUser.getUserName());
    }
}

