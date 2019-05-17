package com.bsp.flowable;

import com.google.common.collect.Maps;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BspFlowableApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(BspFlowableApplication.class, args);

        RuntimeService runtimeService = app.getBean(RuntimeService.class);
        TaskService taskService = app.getBean(TaskService.class);

        // 启动流程
        Map<String, Object> map = Maps.newHashMap();
        // map.put("taskUser", "dinglixiao");
        // map.put("money", 87);
        // ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Expense", map);
        // System.out.println("提交成功.流程Id为：" + processInstance.getId());

        List<Task> tasks = taskService.createTaskQuery().taskAssignee("dinglixiao").orderByTaskCreateTime().desc().list();
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }
}
