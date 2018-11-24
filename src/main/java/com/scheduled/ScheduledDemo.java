package com.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledDemo {


    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void fixedRate() {
        System.out.println(sdf.format(new Date()) + "  每隔一秒执行一次qqq111"+ff());
    }

    String f(){return "hello";}

    String ff(){return "=====";}

    @Scheduled(fixedDelay = 3000)
    public void fixedDelay() {
        System.out.println(sdf.format(new Date()) + "  3秒后执行");
    }

    //秒 分 时  日 月 周  https://www.cnblogs.com/javahr/p/8318728.html
    @Scheduled(cron = "*/1 * * * * *")
    public void cron() {
        System.out.println(sdf.format(new Date()) + "  cron表达式");
    }

}
