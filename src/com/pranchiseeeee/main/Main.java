package com.pranchiseeeee.main;

import com.pranchiseeeee.view.AppUI;

import static com.pranchiseeeee.view.AppUI.inputInteger;

public class Main {

	public static void main(String[] args) {

		AppController controller = new AppController();

		while(true) {
			AppUI.startScreen();
			int selectNumber = inputInteger();
			controller.chooseSystem(selectNumber);
		}


	}

}
