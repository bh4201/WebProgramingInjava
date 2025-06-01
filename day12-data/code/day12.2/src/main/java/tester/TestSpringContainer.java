package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.dependent.PublicSchool;

public class TestSpringContainer {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("bean-config.xml")) {

			System.out.println("SC up n running !");
			
			/*
			 * Task- call B.L method of PublicSchool bean - manageAcademics
			 * Method of o.s.beans.factory.BeanFactory
			 * <------- ApplicationContext
			 * <------- ClassPathXmlApplicationContext
			 */
			
			PublicSchool ps1 = ctx.getBean("public_school", PublicSchool.class);
			PublicSchool ps2 = ctx.getBean("public_school", PublicSchool.class);
			System.out.println(ps1==ps2);
			ps1.manageAcademics();
			ps2.manageAcademics();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
