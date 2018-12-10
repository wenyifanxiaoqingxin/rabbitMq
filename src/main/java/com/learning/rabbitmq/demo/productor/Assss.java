package com.learning.rabbitmq.demo.productor;

import com.learning.rabbitmq.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fx on 2018/4/2.
 */
public class Assss {

    public static void main(String[] args) {


        List<User> l = new ArrayList();

        for(int i =0;i<10;i++){
            User u =new User();
            u.setUserName("111");
            u.setPass(String.valueOf(i));
            l.add(u);
        }
        List<User> l1 = new ArrayList();
        for(User user :l){

            if("2".equals(user.getPass())){
                l1.add(user);
            }
        }

        l.removeAll(l1);

        l1.addAll(l);
        System.out.println("ssss");
    }
}
