package rma.org.bt.mms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rma.org.bt.mms.global.common.CommonService;
import rma.org.bt.mms.model.KiduInfoDTO;
import rma.org.bt.mms.services.FinancialInfoService;
import rma.org.bt.mms.services.KiduService;

import java.util.List;

@Controller
@RequestMapping(value = "/kidu")
public class KiduController {

    //region private variables.
    private KiduService kiduService;
    private CommonService commonService;
    //endregion

    //region constructor injection
    @Autowired
    public KiduController(KiduService kiduService, CommonService commonService) {
        this.kiduService = kiduService;
        this.commonService = commonService;
    }
    //endregion

    //region public methods.

    /**
     * Index page.
     *
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        //TODO need to check.
//        model.addAttribute("companyList", commonService.getCompanyList());
        return "mms/kidu";
    }

    /**
     * To get the list of kidu information if any.
     *
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/getKiduInfoList", method = RequestMethod.GET)
    public List<KiduInfoDTO> getKiduInfoList() {
        return kiduService.getKiduInfoList();
    }

    /**
     * To get kidu information list by company.
     *
     * @param company String
     * @return List<KiduInfoDTO>
     */
    @ResponseBody
    @RequestMapping(value = "/getKiduInfoListByCompany", method = RequestMethod.GET)
    public List<KiduInfoDTO> getKiduInfoListByCompany(String company) {
        return kiduService.getKiduInfoListByCompany(company);
    }
    //endregion
}
