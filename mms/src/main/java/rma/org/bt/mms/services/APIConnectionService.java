package rma.org.bt.mms.services;

import com.squareup.okhttp.OkHttpClient;
import org.springframework.stereotype.Service;
import org.wso2.client.api.ApiException;
import org.wso2.client.model.NLCS_LandDetailAPI.LandDetailResponse;
import org.wso2.client.model.RSTA_LicenseAndVehicleInformationAPI.VehicledetailsResponse;
import rma.org.bt.mms.global.base.BaseService;
import rma.org.bt.mms.global.dto.ResponseMessage;
import rma.org.bt.mms.global.library.TokenUtil;
import rma.org.bt.mms.model.PersonalInfoDTO;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * ====================================================================
 * Created by Nima Yoezer on 6/26/2020.
 * Description:
 * ====================================================================
 * Modified by:
 * Modified on:
 * Changes made :
 * ====================================================================
 */
@Service
public class APIConnectionService extends BaseService{

    private static String  access_token;


    //region staging ditt api connection
    /*public ResponseMessage getPersonalInfo(String cidNo){
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String url =resourceBundle1.getString("api_citizen_detail.url");
        String access_token =resourceBundle1.getString("api.access_token1");
        PersonalInfoDTO personalInfoDTO = new PersonalInfoDTO();
        try {
            OkHttpClient httpClient = new OkHttpClient();
            httpClient.setConnectTimeout(10000, TimeUnit.MILLISECONDS);
            httpClient.setReadTimeout(10000, TimeUnit.MILLISECONDS);
            org.wso2.client.api.ApiClient apiClient = new org.wso2.client.api.ApiClient();
            apiClient.setHttpClient(httpClient);
            apiClient.setBasePath(url);
            apiClient.setAccessToken(access_token);

            DefaultApi api = new org.wso2.client.api.DCRC_CitizenDetailsAPI.DefaultApi(apiClient);
            CitizenDetailsResponse citizenDetailsResponse = api.citizendetailsCidGet(cidNo);
            CitizendetailsObj citizendetailsObj = citizenDetailsResponse.getCitizenDetailsResponse().getCitizenDetail().get(0);
            //String dzong=commonDao.getValue("cmndzongkhag","Id","NameEn",citizendetailsObj.getDzongkhagName()).toString();

            personalInfoDTO.setFullName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
            personalInfoDTO.setFullName(personalInfoDTO.getFullName().replaceAll("null ", ""));
            personalInfoDTO.setSex(citizendetailsObj.getGender());
            personalInfoDTO.setCidNo(cidNo);
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
    }*/
    //endregion

    public ResponseMessage getPersonalInfo(String cidNo){
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String url =resourceBundle1.getString("api_all_citizen_detail.url");
        PersonalInfoDTO personalInfoDTO = new PersonalInfoDTO();
        try {
            OkHttpClient httpClient = new OkHttpClient();
            httpClient.setConnectTimeout(10000, TimeUnit.MILLISECONDS);
            httpClient.setReadTimeout(10000, TimeUnit.MILLISECONDS);
            org.wso2.client.api.ApiClient apiClient = new org.wso2.client.api.ApiClient();
            apiClient.setHttpClient(httpClient);
            access_token = TokenUtil.getAccessToken();
            apiClient.setBasePath(url);
            apiClient.setAccessToken(access_token);

            org.wso2.client.api.DCRC_AllCitizenDetailsAPI.DefaultApi api = new org.wso2.client.api.DCRC_AllCitizenDetailsAPI.DefaultApi(apiClient);
            org.wso2.client.model.DCRC_AllCitizenDetailsAPI.CitizendetailsResponse citizenDetailsResponse = api.allcitizendetailsCidGet(cidNo);
            org.wso2.client.model.DCRC_AllCitizenDetailsAPI.CitizendetailObj citizendetailsObj = citizenDetailsResponse.getAllCitizenDetailsResponse().getAllCitizenDetail().get(0);
            //String dzong=commonDao.getValue("cmndzongkhag","Id","NameEn",citizendetailsObj.getDzongkhagName()).toString();

            personalInfoDTO.setFullName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
            personalInfoDTO.setFullName(personalInfoDTO.getFullName().replaceAll("null", ""));
            personalInfoDTO.setSex(citizendetailsObj.getGender());
            personalInfoDTO.setCidNo(cidNo);
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

    /**
     * to fetch vehicle details from the RSTA API
     * @param cidNo   --- String
     * @return List of vehicle details
     * @throws ApiException
     */
    public ResponseMessage getVehicleInfo(String cidNo) throws ApiException {
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String url =resourceBundle1.getString("api_vehicle_detail.url");
        access_token = TokenUtil.getAccessToken();

        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setConnectTimeout(10000, TimeUnit.MILLISECONDS);
        httpClient.setReadTimeout(10000, TimeUnit.MILLISECONDS);
        org.wso2.client.api.ApiClient apiClient = new org.wso2.client.api.ApiClient();
        apiClient.setHttpClient(httpClient);
        apiClient.setBasePath(url);
        apiClient.setAccessToken(access_token);

        org.wso2.client.api.RSTA_LicenseAndVehicleInformationAPI.DefaultApi api = new org.wso2.client.api.RSTA_LicenseAndVehicleInformationAPI.DefaultApi(apiClient);
        VehicledetailsResponse vehicledetailsResponse = api.vehicledetailsbycidCidGet(cidNo);

        responseMessage.setStatus(SUCCESSFUL_STATUS);
        responseMessage.setDto(vehicledetailsResponse.getVehicleDetails().getVehicleDetail());
        return responseMessage;

    }


    /**
     * to fetch land details from the NLCS API
     * @param cidNo   --- String
     * @return List of vehicle details
     * @throws ApiException
     */
    public ResponseMessage getLandInfo(String cidNo) throws ApiException {
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String url =resourceBundle1.getString("api_land_detail.url");
        access_token = TokenUtil.getAccessToken();

        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setConnectTimeout(10000, TimeUnit.MILLISECONDS);
        httpClient.setReadTimeout(10000, TimeUnit.MILLISECONDS);
        org.wso2.client.api.ApiClient apiClient = new org.wso2.client.api.ApiClient();
        apiClient.setHttpClient(httpClient);
        apiClient.setBasePath(url);
        apiClient.setAccessToken(access_token);

        String type = cidNo.getClass().getTypeName();

        org.wso2.client.api.NLCS_LandDetailAPI.DefaultApi api = new org.wso2.client.api.NLCS_LandDetailAPI.DefaultApi(apiClient);
        LandDetailResponse landDetailResponse = api.landdetailsbycidCidGet(cidNo, type);

        responseMessage.setStatus(SUCCESSFUL_STATUS);
        responseMessage.setDto(landDetailResponse.getLandDetails().getLandDetail());
        return responseMessage;
    }
}
