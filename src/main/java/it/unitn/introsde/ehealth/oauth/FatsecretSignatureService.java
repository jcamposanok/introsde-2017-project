package it.unitn.introsde.ehealth.oauth;

import com.github.scribejava.core.exceptions.OAuthSignatureException;
import com.github.scribejava.core.services.Base64Encoder;
import com.github.scribejava.core.services.HMACSha1SignatureService;
import com.github.scribejava.core.utils.OAuthEncoder;
import com.github.scribejava.core.utils.Preconditions;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class FatsecretSignatureService extends HMACSha1SignatureService {

    public String getSignature(String baseString, String apiSecret, String tokenSecret) {
        try {
            Preconditions.checkEmptyString(baseString, "Base string cant be null or empty string");
            Preconditions.checkEmptyString(apiSecret, "Api secret cant be null or empty string");
            return this.doSign(baseString, OAuthEncoder.encode(apiSecret) + '&' + OAuthEncoder.encode(tokenSecret));
        } catch (NoSuchAlgorithmException | InvalidKeyException | RuntimeException | UnsupportedEncodingException var5) {
            throw new OAuthSignatureException(baseString, var5);
        }
    }

    private String doSign(String toSign, String keyString) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        // keyString += '&';
        SecretKeySpec key = new SecretKeySpec(keyString.getBytes(), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(key);
        byte[] bytes = mac.doFinal(toSign.getBytes());
        return this.bytesToBase64String(bytes).replace("\r\n", "").trim();
    }

    private String bytesToBase64String(byte[] bytes) {
        return Base64Encoder.getInstance().encode(bytes);
    }

}
