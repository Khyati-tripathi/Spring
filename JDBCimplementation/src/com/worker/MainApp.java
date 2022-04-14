package com.worker;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.worker.helpers.WorkerHelpers;
import com.worker.model.Worker;
import com.worker.services.WorkerJDBCTemplate;

public class MainApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		WorkerJDBCTemplate workerJDBCTemplate = (WorkerJDBCTemplate) context.getBean("workerJDBCTemplate");

		System.out.println(" Records Creation ");
		Worker worker1 = new Worker(101, "khyati", "k.tri@my_org.in");
		workerJDBCTemplate.add(worker1);

		System.out.println();

		System.out.println(" Displaying Worker Records ");
		List<Worker> workerList = workerJDBCTemplate.getWorkers();
		WorkerHelpers.printAllWorkers(workerList);
		Worker worker3 = workerJDBCTemplate.getWorker(2);
		System.out.println(worker3);
		context.close();
	}

}