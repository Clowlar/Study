package com0;


import java.util.Scanner;

public class bank {

    private user[] users = new user[5];

    private int size;


    public void initial() {
        user user1 = new user();
        user1.setCardNo("5644468465453");
        user1.setIdentity("644654566");
        user1.setUsername("张三");
        user1.setPassword("123456");
        user1.setPhone("2561515351");
        user1.setBalance(5131213);


        user user2 = new user("1513151", "15613", "李四", "5312121", "451635", 020220);

        users[0] = user1;
        users[1] = user2;
        size = 2;
        // System.out.println("用户初始化完成");

    }

    public bank() {
        initial();
    }

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入卡号");
        String cardNo = input.next();
        System.out.println("请输入密码");
        String password = input.next();
        user u = null;
        for (int i = 0; i < size; i++) {
            if (users[i].getCardNo().equals(cardNo) && users[i].getPassword().equals(password)) {
                System.out.println("登录成功");
                u = users[i];
                break;

            }
        }
        if (u != null) {
            System.out.println("进入菜单");
            showMenu(u);
        } else {
            System.out.println("登录失败");
        }

    }

    public void showMenu(user u) {
        do {
            System.out.println("1.存款 2.取款 3.转账 4.查询余额 5.修改密码 0.退出");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    save(u);

                    break;
                case 2:
                    this.withDraw(u);

                    break;
                case 3:
                    this.trans(u);

                    break;
                case 4:
                    this.query(u);

                    break;
                case 5:
                    this.modifyPassword(u);

                    break;
                case 0:


                    return;


            }


        } while (true);
    }

    public void save(user u) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入存款金额");
        double m = input.nextDouble();
        if (m > 0) {
            u.setBalance(u.getBalance() + m);
            System.out.println("当前余额" + u.getBalance());

        } else {
            System.out.println("存钱失败，请重新输入");
        }
    }

    public void withDraw(user u) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入取钱金额");
        double m = input.nextDouble();
        if (m > 0) {
            if (u.getBalance() >= m) {
                u.setBalance(u.getBalance() - m);
                System.out.println("当前余额" + u.getBalance());
            } else {
                System.out.println("余额不足");
            }

        } else {
            System.out.println("取钱失败，请重新输入");
        }
    }

    public void trans(user u) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入对方卡号");
        String cartNo = input.next();
        System.out.println("请输入转账金额");
        double m = input.nextDouble();

        user toUser = null;
        for (int i = 0; i < size; i++) {
            if (users[i].getCardNo().equals(cartNo)) {
                toUser = users[i];
                break;
            }
        }
        if (toUser != null) {
            if (u.getBalance() >= m) {
                u.setBalance(u.getBalance() - m);
                toUser.setBalance(toUser.getBalance() + m);
                System.out.println("转账成功");
            } else {
                System.out.println("余额不足");
            }
        } else {
            System.out.println("转账人不存在");
        }
    }

    public void query(user u) {
        System.out.println("卡号" + u.getCardNo() + "余额" + u.getBalance());
    }

    public void modifyPassword(user u) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入新的密码");
        String newpassword = input.next();
        if (newpassword.length() == 6) {
            u.setPassword(newpassword);
            System.out.println("当前密码为" + u.getPassword());
        } else {
            System.out.println("请输入六位数密码");
        }
    }
}
