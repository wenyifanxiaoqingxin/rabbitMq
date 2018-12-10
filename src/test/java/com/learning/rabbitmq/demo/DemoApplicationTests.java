package com.learning.rabbitmq.demo;

import com.learning.rabbitmq.demo.entity.User;
import com.learning.rabbitmq.demo.productor.FanoutSend;
import com.learning.rabbitmq.demo.productor.HelloSender;
import com.learning.rabbitmq.demo.productor.TopicSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private HelloSender helloSender;

	@Autowired
	private TopicSend topicSend;

	@Autowired
	private FanoutSend fanoutSend;

//	@Test
	public void contextLoads() {

		helloSender.send();
	}

//	@Test
	public void oneToMany(){

		for(int i=0;i<100;i++){
			helloSender.send(i);
		}
	}
//	@Test
	public void oneObject(){
		helloSender.send();
			User u = new User();
			u.setUserName("user");
			u.setPass(String.valueOf(11));
			helloSender.send(u);
//		helloSender.send();
	}
//	@Test
	public void setHelloSender() {

		topicSend.send1();
	}

	@Test
	public void setFanoutSender() {

		fanoutSend.send();
	}
}
