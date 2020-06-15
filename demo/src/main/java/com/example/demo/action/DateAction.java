package com.example.demo.action;

import com.bstek.urule.model.ExposeAction;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DateAction class
 *
 * @author ZF
 * @date 2018/10/25
 */
@Component
public class DateAction {
    /**
     * 日期字符串 + 几小时
     * @param dateStr
     * @param addHours
     * @return
     */
    @ExposeAction("日期字符串加几小时")
    public Date dateAddHours(String dateStr, String addHours) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int hourAdd=Integer.parseInt(addHours);
        Date date =null;
        try {
            date= sdf.parse(dateStr);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.HOUR, hourAdd);
            return c.getTime();
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期字符串 + 几秒
     * @param dateStr
     * @param addSeconds
     * @return
     */
    @ExposeAction("日期字符串加几秒")
    public Date dateAddSeconds(String dateStr,String addSeconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int secondAdd=Integer.parseInt(addSeconds);
        Date date =null;
        try {
            date= sdf.parse(dateStr);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.SECOND, secondAdd);
            return c.getTime();
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }


    @ExposeAction("时间戳转Date")
    public Date toDate(Long datetime){
        if(datetime == null){
            return null;
        }
        return new Date(datetime);
    }

    @ExposeAction("Date转时间戳")
    public Long toDateLong(Date datetime){
        if(datetime == null){
            return null;
        }
        return datetime.getTime();
    }

    @ExposeAction("fixViewEnd")
    public Long fixViewEnd(Long endDate){
        Date date = new Date(endDate);
        if (date != null) {
            Calendar realEnd = Calendar.getInstance();
            realEnd.setTime(date);
            Calendar viewEnd = Calendar.getInstance();
            viewEnd.set(realEnd.get(Calendar.YEAR), realEnd.get(Calendar.MONTH), realEnd.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
            return viewEnd.getTimeInMillis();
        } else {
            return null;
        }
    }
}
