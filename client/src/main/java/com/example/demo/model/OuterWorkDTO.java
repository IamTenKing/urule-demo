package com.example.demo.model;

import com.bstek.urule.model.Label;
import lombok.Data;

import java.util.Set;

/**
 * OuterWorkDTO class
 *
 * @author ZF
 * @date 2018/10/17
 */
@Data
public class OuterWorkDTO {

    @Label("ID")
    private String id;

    @Label("开始时间")
    private Long start;
    /**
     * 结束时间（日历用，不可为空）
     */
    @Label("结束时间")
    private Long end;

    @Label("即将到期时间")
    private Long alertDate;

    @Label("显示用结束日期")
    private Long viewEnd;

    @Label("来源系统")
    private String sys;
    /**
     * 类型（待办、计划之类的）
     */
    @Label("待办类型")
    private String type;

    @Label("链接")
    private String url;

    @Label("新链接")
    private String redirectUri;

    @Label("标题")
    private String title;

    @Label("排序号")
    private String sortFlg;

    @Label("备注")
    private String remarks;

    /**
     * 状态,可用值为
     * STATUS_TODO；STATUS_FINISH；STATUS_DELAYED
     */
    @Label("状态")
    private String status;

    @Label("外部数据ID")
    private String outerId;
    /**
     * 类型（例如 发文、缺陷管理之类的东西）
     */
    @Label("任务类型")
    private String kind;

    @Label("taskId")
    private String taskId;

    @Label("workFlowId")
    private String workFlowId;

    @Label("工单号")
    private String serialNumber;

    @Label("业务信息")
    private String elements;

    @Label("打开链接方式")
    private String openType;

    /**
     * auth表节点完成情况
     * STATUS_TODO,STATUS_FINISH
     */
    @Label("节点完成情况")
    private String authStatus;

    /**
     * 岗位待办及个人待办区分标志
     * AUTH_TYPE_ROLE,AUTH_TYPE_USER
     */
    @Label("岗位/个人待办区分标志")
    private String mktype;

    @Label("statusFlg")
    private int statusFlg;

    //cj begin
    //所关联的考核是否已发布,1：已发布，0：未发布
    @Label("关联的考核是否已发布")
    private Boolean hadPublish;

    @Label("关联的考核")
    private String examineID;

    //该任务是属于哪个单位的
    @Label("任务所属单位ID")
    private String bizOrgID;//该任务是属于哪个单位的。这样才能知道它归属为哪个考核
    //cj end
    /**
     * 是否完成
     **/
    @Label("是否已完成")
    private Boolean finished;
    /**
     * 办理意见
     */
    @Label("处理意见")
    private String attendingResult;
//
//    /**
//     * 工单关联附件
//     */
//    @Label("附件")
//    private transient Set<WorkAttachmentDTO> workAttachmentSet;

    @Label("紧急程度")
    private String taskLevel;

    @Label("处理环节名")
    private String linkName;

    @Label("任务状态")
    private String taskStatus;

    @Label("分区code")
    private String partitionCode;


    @Label("处理人")
    private Set<String> dealPerson;

    @Label("传入人")
    private Set<String> afferent;

    @Label("处理单位")
    private Set<String> dealUnit;

    @Label("处理角色")
    private Set<String> roleId;

    @Label("处理人传入类型")
    private String dealPersonType;

    @Label("日志标识")
    protected String logId;


    @Label("积分")
    private String jifen;
}
