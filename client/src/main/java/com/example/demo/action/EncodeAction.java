package com.example.demo.action;

import com.bstek.urule.model.ExposeAction;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * EncodeAction class
 *
 * @author ZF
 * @date 2018/10/25
 */
@Component
public class EncodeAction {

    @ExposeAction("URLEncode")
    public String encode(String str, String enc){
        String encodeStr = str;
        try {
            encodeStr = URLEncoder.encode(str, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            return encodeStr;
        }
    }

    @ExposeAction("URLDecode")
    public String decode(String str, String enc){
        String decodeStr = str;
        try {
            decodeStr = URLDecoder.decode(str, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            return decodeStr;
        }
    }
}
