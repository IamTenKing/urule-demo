package com.example.demo.action;

import com.bstek.urule.model.ExposeAction;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * StringAction class
 *
 * @author ZF
 * @date 2018-11-8
 */
@Component
public class StringAction {

    @ExposeAction("字符串拆为List")
    public List<String> splitToList(String str, String regex){
        List<String> result = Lists.newArrayList();
        String[] strs = str.split(regex);
        if(ArrayUtils.isNotEmpty(strs)){
            for(String _str : strs){
                result.add(_str);
            }
        }
        return result;
    }

    @ExposeAction("字符串拼接")
    public String append(String str1,String str2,String str3,String separator){
        String result = "";
        List<String> sList = Lists.newArrayList();
        if(StringUtils.isNotBlank(str1)){
            sList.add(str1);
        }
        if(StringUtils.isNotBlank(str2)){
            sList.add(str2);
        }
        if (StringUtils.isNotBlank(str3)){
            sList.add(str3);
        }
        if(CollectionUtils.isNotEmpty(sList)){
            if(StringUtils.isBlank(separator)){
                separator = "";
            }
            result = StringUtils.join(sList.toArray(),separator);
        }
        return result;
    }
    @ExposeAction("random")
    public String random(){
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }
}
