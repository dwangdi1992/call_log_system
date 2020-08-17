package rma.org.bt.mms.global.common;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.poiji.option.PoijiOptions;
import com.squareup.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.wso2.client.api.DCRC_CitizenDetailsAPI.DefaultApi;
import org.wso2.client.model.DCRC_CitizenDetailsAPI.CitizenDetailsResponse;
import org.wso2.client.model.DCRC_CitizenDetailsAPI.CitizendetailsObj;
import rma.org.bt.mms.global.base.BaseService;
import rma.org.bt.mms.global.dto.CurrentUser;
import rma.org.bt.mms.global.dto.DropdownDTO;
import rma.org.bt.mms.global.dto.PersonalInfoDTO;
import rma.org.bt.mms.global.dto.ResponseMessage;
import rma.org.bt.mms.global.enumeration.ScreenType;
import rma.org.bt.mms.global.enumeration.StatusCode;
import rma.org.bt.mms.global.library.GlobalVariable;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * ====================================================================
 * Created by Nima Yoezer on 05/12/2019.
 * Description:
 * ====================================================================
 * Modified by:
 * Modified on:
 * Changes made :
 * ====================================================================
 */
@Service
public class CommonService extends BaseService {

    @Autowired
    private CommonDao commonDao;

    @Transactional(readOnly = true)
    public List<DropdownDTO> getScreenList() {
        return commonDao.getScreenList();
    }

    public List<DropdownDTO> getScreenByTypeList(Character screenType) {
        return commonDao.getScreenByTypeList(screenType);
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getUserGroupList() {
        return commonDao.getUserGroupList();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getBankList() {
        return commonDao.getBankList(StatusCode.ACTIVE.getValue());
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getTSWCFLoans() {
        return commonDao.getTSWCFLoans(StatusCode.ACTIVE.getValue());
    }

    /**
     * To get status list
     *
     * @return List<DropdownDTO>
     */
    public List<DropdownDTO> getStatusList() {
        List<DropdownDTO> statusList = new ArrayList<>();
        DropdownDTO dropdownDTO;
        for (StatusCode statusCode : StatusCode.values()) {
            dropdownDTO = new DropdownDTO(statusCode.getValue(), statusCode.getText());
            statusList.add(dropdownDTO);
        }
        return statusList;
    }

    public List<DropdownDTO> getScreenTypeList() {
        List<DropdownDTO> screenTypeList = new ArrayList<>();
        DropdownDTO dropdownDTO;
        for (ScreenType screenType : ScreenType.values()) {
            dropdownDTO = new DropdownDTO(screenType.getValue(), screenType.getText());
            screenTypeList.add(dropdownDTO);
        }
        return screenTypeList;
    }

    public List<DropdownDTO> getBranchCodeList() {
        return commonDao.getBranchCodeList(StatusCode.ACTIVE.getValue());
    }

    public List<DropdownDTO> getReportList() {
        return commonDao.getReportList(StatusCode.ACTIVE.getValue());
    }

    public Object getValue(String tblName, String colName, String filterCol, Object filterVal) {
        return commonDao.getValue(tblName, colName, filterCol, filterVal);
    }

    public Object getNextID(String tblName, String colName) {
        return commonDao.getNextID(tblName, colName);
    }

    public Date getDateFromString(String sDate) throws ParseException {
        return new SimpleDateFormat("dd-MMM-yyyy").parse(sDate);
    }

    /**
     * read excel file and convert to object class
     *
     * @param mFile    -- MultipartFile
     * @param classObj -- Class to map
     * @return List
     * @throws java.io.IOException
     */
    public List readExcel(MultipartFile mFile, Class classObj) throws IOException {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings(0).datePattern("dd-rererwerrrrwrwer-yyyy").build();
        InputStream inputStream = mFile.getInputStream();
        List list = Poiji.fromExcel(inputStream, PoijiExcelType.XLSX, classObj, options);
        inputStream.close();
        return list;
    }

    /**
     * read from excel file from specified row number only
     *
     * @param mFile    -- MultipartFile
     * @param classObj -- Class to map
     * @param row      --  row number to read from
     * @return List
     * @throws java.io.IOException
     */
    public List readExcel(MultipartFile mFile, Class classObj, int row) throws IOException {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings(row).datePattern("dd-MMM-yyyy").build();
        InputStream inputStream = mFile.getInputStream();
        List list = Poiji.fromExcel(inputStream, PoijiExcelType.XLSX, classObj, options);
        inputStream.close();
        return list;

    }

    /**
     * read from excel file from specified row number only
     *
     * @param file     -- MultipartFile
     * @param classObj -- Class to map
     * @param row      --  row number to read from
     * @return List
     * @throws java.io.IOException
     */
    public List readExcel(MultipartFile file, Class classObj, int row, Date reportDate, CurrentUser currentUser) throws Exception {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings(row).preferNullOverDefault(true).datePattern("dd-MMM-yyyy").ignoreHiddenSheets(true).build();
        InputStream inputStream = file.getInputStream();
        List list = Poiji.fromExcel(inputStream, PoijiExcelType.XLSX, classObj, options);
        inputStream.close();
        String rootPath = uploadFile(file, currentUser);
        saveFileDetail(rootPath
                , file.getContentType()
                , file.getOriginalFilename()
                , reportDate
                , currentUser);
        return list;

    }

    /**
     * read from excel file from specified row number only
     *
     * @param file     -- MultipartFile
     * @param classObj -- Class to map
     * @param row      --  row number to read from
     * @return List
     * @throws java.io.IOException
     */
    public List readExcel(MultipartFile file, Class classObj, int row, Date reportDate, int sheetIndex, CurrentUser currentUser) throws Exception {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings(row).preferNullOverDefault(true).sheetIndex(sheetIndex).datePattern("dd-MMM-yyyy").build();
        InputStream inputStream = file.getInputStream();
        List list = Poiji.fromExcel(inputStream, PoijiExcelType.XLSX, classObj, options);
        inputStream.close();
        String rootPath = uploadFile(file, currentUser);
        saveFileDetail(rootPath
                , file.getContentType()
                , file.getOriginalFilename()
                , reportDate
                , currentUser);
        return list;

    }

    /**
     * read excel file and convert to object class
     *
     * @param mFile    -- MultipartFile
     * @param classObj -- Class to map
     * @return List
     * @throws java.io.IOException
     */
    public List readExcel(MultipartFile mFile, Class classObj, PoijiOptions options) throws IOException {
        InputStream inputStream = mFile.getInputStream();
        List list = Poiji.fromExcel(inputStream, PoijiExcelType.XLSX, classObj, options);
        inputStream.close();
        return list;
    }

    /**
     * To upload the attachment to the file location
     *
     * @param attachment -- file
     * @throws Exception
     */
    public String uploadFile(MultipartFile attachment, CurrentUser currentUser) throws Exception {
        String rootPath = null;
        if (attachment != null && !attachment.isEmpty()) {
            //get file upload location from properties file
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String folder = simpleDateFormat.format(new Date());

            Resource resource = new ClassPathResource("/lang/fileUpload.properties");
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            rootPath = props.getProperty("fileUpload.loc");

            rootPath = rootPath + folder + "/" + currentUser.getUserName() + "/" + attachment.getOriginalFilename();

            byte[] bytes = attachment.getBytes();
            Path path = Paths.get(rootPath);

            Path parentDir = path.getParent();
            if (!Files.exists(parentDir))
                Files.createDirectories(parentDir);
            Files.write(path, bytes);

        }
        return rootPath;
    }


    public void saveFileDetail(String loc, String fileType, String fileName, Date rDate, CurrentUser currentUser) {
        BigInteger file_id = (BigInteger) getNextID("common_file_detail", "file_id");
        FileDetailEntity fileDetail = new FileDetailEntity();
        fileDetail.setFile_id(file_id);
        fileDetail.setFile_name(fileName);
        fileDetail.setFile_location(loc);
        fileDetail.setFile_type(fileType);
        fileDetail.setReport_date(rDate);
        fileDetail.setCreatedBy(currentUser.getUserName());
        fileDetail.setCreatedDate(currentUser.getServerDate());
        commonDao.saveUpdate(fileDetail);
        GlobalVariable.FILE_ID = file_id;
    }

    /**
     * to fetch the personal details from DCRC API
     * @param cidNo -- String
     * @return ResponseMessage
     */
    public ResponseMessage getPersonalInfo(String cidNo){
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String url =resourceBundle1.getString("api_citizen_detail.url");
        String access_token =resourceBundle1.getString("api.access_token");
        String consumer_key =resourceBundle1.getString("api.consumer_key");
        String consumer_secret =resourceBundle1.getString("api.consumer_secret");
        PersonalInfoDTO personalInfoDTO = new PersonalInfoDTO();
        try {
            OkHttpClient httpClient = new OkHttpClient();
            httpClient.setConnectTimeout(10000, TimeUnit.MILLISECONDS);
            httpClient.setReadTimeout(10000, TimeUnit.MILLISECONDS);
            org.wso2.client.api.ApiClient apiClient = new org.wso2.client.api.ApiClient();
            apiClient.setHttpClient(httpClient);
            apiClient.setBasePath(url);
            apiClient.setAccessToken(access_token);
            apiClient.setApiKey(consumer_secret);
            apiClient.setApiKeyPrefix(consumer_key);

            DefaultApi api = new org.wso2.client.api.DCRC_CitizenDetailsAPI.DefaultApi(apiClient);
            CitizenDetailsResponse citizenDetailsResponse = api.citizendetailsCidGet(cidNo);
            CitizendetailsObj citizendetailsObj = citizenDetailsResponse.getCitizenDetailsResponse().getCitizenDetail().get(0);
            //String dzong=commonDao.getValue("cmndzongkhag","Id","NameEn",citizendetailsObj.getDzongkhagName()).toString();

            personalInfoDTO.setFullName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
            personalInfoDTO.setFullName(personalInfoDTO.getFullName().replaceAll("null ", ""));
            personalInfoDTO.setSex(citizendetailsObj.getGender());
            //personalInfoDTO.setDzongkhagId(dzong);
            personalInfoDTO.setDzongkhagNmae(citizendetailsObj.getDzongkhagName());
            personalInfoDTO.setGowegId(citizendetailsObj.getGewogId());
            personalInfoDTO.setGowegName(citizendetailsObj.getGewogName());
            personalInfoDTO.setVillageId(citizendetailsObj.getVillageSerialNo());
            personalInfoDTO.setVillageName(citizendetailsObj.getVillageName());

        }catch(Exception e){
            //System.out.print("Exception in CommonDaoImpl # getPersonalDetails: "+e);
            e.printStackTrace();
            responseMessage = new ResponseMessage();
            responseMessage.setStatus(UNSUCCESSFUL_STATUS);
            responseMessage.setDto(null);
            responseMessage.setText(e.getMessage());
            return responseMessage;
        }

        responseMessage = new ResponseMessage();
        responseMessage.setStatus(SUCCESSFUL_STATUS);
        responseMessage.setDto(personalInfoDTO);
        return responseMessage;
    }


}
