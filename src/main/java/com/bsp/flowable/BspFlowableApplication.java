package com.bsp.flowable;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BspFlowableApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(BspFlowableApplication.class, args);

        RuntimeService runtimeService = app.getBean(RuntimeService.class);
        TaskService taskService = app.getBean(TaskService.class);

//        启动流程
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("PROCESS_1");
//        System.out.println(processInstance);
//        System.out.println(processInstance.getId());

        Task task = taskService.createTaskQuery().taskId("d610cbdc-7881-11e9-9948-acde48001122").singleResult();
        System.out.println(task);
//      通过审核
//        taskService.complete(task.getId());

    }

}
