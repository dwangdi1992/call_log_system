package rma.org.bt.mms.master.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rma.org.bt.mms.global.base.BaseController;
import rma.org.bt.mms.global.common.CommonService;
import rma.org.bt.mms.global.dto.DropdownDTO;
import rma.org.bt.mms.global.dto.ResponseMessage;
import rma.org.bt.mms.global.enumeration.ScreenNumber;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ====================================================================
 * Created by Dechen Wangdi on 13/12/2019.
 * Description:
 * ====================================================================
 * Modified by:
 * Modified date:
 * Purpose:
 * ====================================================================
 */
@Controller
@RequestMapping(value = "/permissionSetup")
@PreAuthorize("isAuthenticated()")
public class PermissionSetupController extends BaseController {

    //region private variables
    @Autowired
    private CommonService commonService;
    @Autowired
    private PermissionSetupService permissionSetupService;
    //endregion

    /**
     * Index page for permission setup.
     *
     * @param request HttpServletRequest
     * @param model   Model
     * @return String
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("userGroupList", commonService.getUserGroupList());
        model.addAttribute("screenTypeList", commonService.getScreenTypeList());
        model.addAttribute("screenList", commonService.getScreenList());
        model.addAttribute("SCREEN_ID", ScreenNumber.PERMISSION_SETUP.getValue());
        return "setup/permissionSetup";
    }

    @ResponseBody
    @RequestMapping(value = "/getScreenList", method = RequestMethod.GET)
    public List<DropdownDTO> getScreenByTypeList(Character screenType) throws Exception {
        return commonService.getScreenByTypeList(screenType);
    }

    /**
     * To save permission information.
     *
     * @param request            HttpServletRequest
     * @param permissionSetupDTO PermissionSetupDTO
     * @return ResponseMessage
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseMessage save(HttpServletRequest request, PermissionSetupDTO permissionSetupDTO) throws Exception {
        currentUser = getCurrentUser(request);
        responseMessage = permissionSetupService.save(permissionSetupDTO, currentUser);
        return responseMessage;
    }

    /**
     * To get permission list.
     *
     * @param request HttpServletRequest
     * @param groupId Integer
     * @return List
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getPermissionList", method = RequestMethod.GET)
    public List getPermissionList(HttpServletRequest request, Integer groupId) throws Exception {
        return permissionSetupService.getPermissionList(groupId);
    }
}
