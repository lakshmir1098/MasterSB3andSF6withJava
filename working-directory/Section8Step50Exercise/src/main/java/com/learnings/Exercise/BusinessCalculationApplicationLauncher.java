package com.learnings.Exercise;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class BusinessCalculationService{
	private final DataService ds;

	@Autowired
        public BusinessCalculationService( @Qualifier("sdb") DataService ds) {
                this.ds = ds;
        }

        public  int findMax(){
		return Arrays.stream(ds.retrieveData()).max().orElse(0);
	}


}

@Configuration
@ComponentScan
public class BusinessCalculationApplicationLauncher{

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(BusinessCalculationApplicationLauncher.class);

		BusinessCalculationService bs  = context.getBean( BusinessCalculationService.class);
		System.out.println(bs.findMax());
		context.close();



	}

}
