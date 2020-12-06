package app;

import model.Response;
import service.RobotService;
import service.impl.QykRobotServiceImpl;

import java.util.Scanner;

public class Main {
    private static final RobotService robotService = new QykRobotServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("你好，我是你的小助手，请帮我取个名字，然后回车唤醒我！");
        String name = scanner.nextLine();
        System.out.println("Hi，我是你的小助手 " + name + "," + "请输入你感兴趣的内容吧！");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("再见")) {
                System.out.println("感谢使用，下次再见！");
                break;
            } else {
                Response response = robotService.query(input);
                if (response.getCode() == 0) {
                    System.out.println(name + ":" + response.getContent());

                } else {
                    System.out.println(name + "对不起，没听懂，请重新输入！");

                }
            }
        }
        scanner.close();
    }
}
