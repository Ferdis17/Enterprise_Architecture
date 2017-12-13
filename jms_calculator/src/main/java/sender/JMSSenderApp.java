package sender;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JMSSenderApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfigsender.xml");
		JMSSender jmssender = context.getBean("jmsSender", JMSSender.class);
		Calculator calculator = new Calculator(5l, 7l);
		jmssender.send(calculator);
		context.close();
	}
}
