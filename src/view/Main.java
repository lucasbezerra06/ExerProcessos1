package view;

import java.io.IOException;

import controller.RedesController;

public class Main {
	public static void main(String args[]){
		RedesController controller = new RedesController();
		System.out.println(controller.ip(System.getProperty("os.name")));
	}

}
