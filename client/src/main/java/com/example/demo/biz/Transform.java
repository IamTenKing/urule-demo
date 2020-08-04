package com.example.demo.biz;

import com.alibaba.fastjson.JSON;
import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.service.KnowledgeService;
import com.example.demo.model.OutBean;
import com.example.demo.model.OuterWorkAuthDTO;
import com.example.demo.model.OuterWorkDTO;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author jt
 * @date 2020-6-13
 */
@Slf4j
@Component
public class Transform<T> {


    @Value("${consumer.knowledge}")
    private String knowledgePath;

    @Value("${consumer.flowId}")
    private String flowId;

    public Map<String, Object> transform(T dto){
        Map<String, Object> result = Maps.newHashMap();

        if(dto != null){
            try{
                KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
                //getgetKnowledge 获取知识包，如果内存中没有缓存就会请求远程服务器
                KnowledgePackage knowledgePackage = knowledgeService.getKnowledge(knowledgePath);
                KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

                if(session != null){
                    //新建空对象，传入引擎，进行赋值操作
                    OuterWorkDTO outerWorkDTO = new OuterWorkDTO();
                    //传入dto
                    session.insert(dto);
                    //传入outerWorkDTO
                    session.insert(outerWorkDTO);
                    OuterWorkAuthDTO outerWorkAuthDTO = new OuterWorkAuthDTO();
                    OutBean outBean = new OutBean();
                    session.insert(outBean);
                    //传入OuterWorkAuthDTO，复用此对象生成集合
                    session.insert(outerWorkAuthDTO);
                    session.startProcess(flowId);

                    //执行完流程
                    //空对象已经赋值完成
                    System.out.println("标题"+outerWorkDTO.getTitle());
                    //获取规则中产生的参数
                    Boolean flag = (Boolean)session.getParameter("flag");
                    List<OutBean> outBeans = (List<OutBean>)session.getParameter("outBeans");
                    System.out.println(flag+"=============");
                    System.out.println(JSON.toJSONString(outBeans)+"=============");
//                    List<OuterWorkAuthDTO> outerWorkAuthDTOs = (List<OuterWorkAuthDTO>)session.getParameter("outerWorkAuthDTOs");
                    result.put("outerWorkDTO", outerWorkDTO);
//                    result.put("outerWorkAuthDTOs", outerWorkAuthDTOs);

                    log.info(JSON.toJSONString(result));
                } else {
                    log.info("");
                }
            } catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }
        return result;
    }
}
