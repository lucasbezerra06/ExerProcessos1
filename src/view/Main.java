package view;

import java.io.IOException;

import controller.RedesController;

public class Main {
	public static void main(String args[]){
		String sistema = System.getProperty("os.name"); 
		RedesController controller = new RedesController();
//		System.out.println(controller.ip(sistema));
		controller.ping(sistema);
	}

}
