/**
 * 
 */
package com.menuitemcount.main;

import com.menuitemcount.service.MenuItemCount;

/**
 * @author Manjula
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if( args.length < 1){
			System.out.println("Please provide the input file");
			return;
		}

		//String filePath = "\\src\\com\\menuitemcount\\data\\inputFile.txt";
		MenuItemCount mic = new MenuItemCount();
		mic.calculateMenuItem(args[0]);

	}

}
