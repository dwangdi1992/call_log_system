package rma.org.bt.mms.global.library;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthClientResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;

import java.util.ResourceBundle;

public class TokenUtil {


    public static String getAccessToken() {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String consumer_key = resourceBundle.getString("api.consumer_key");
        String consumer_secret = resourceBundle.getString("api.consumer_secrete");
        String endpoint_url = resourceBundle.getString("api.endpoint_url");

        try {
            OAuthClientRequest accessRequest = OAuthClientRequest.tokenLocation(endpoint_url).setGrantType(GrantType.CLIENT_CREDENTIALS).setClientId(consumer_key).setClientSecret(consumer_secret).buildQueryMessage();

            accessRequest.addHeader("Accept", "application/json");
            accessRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");

            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
            OAuthClientResponse oAuthResponse = oAuthClient.accessToken(accessRequest);

            setAccessTokenExpireTime(System.currentTimeMillis() +
                    Long.valueOf(oAuthResponse.getParam("expires_in")) * 1000L);
            setApplicationToken(oAuthResponse.getParam("access_token"));
            return oAuthResponse.getParam("access_token");
        } catch (Exception e) {
            System.out.print("Token generation error." + e.getMessage());
        }
        return null;
    }

    private static String applicationToken;

    private static void setAccessTokenExpireTime(long accessTokenExpireTime) {
        accessTokenExpireTime = accessTokenExpireTime;
    }

    private static void setApplicationToken(String applicationToken) {
        applicationToken = applicationToken;
    }
}

