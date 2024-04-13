package com.NamesAutoComplete.AutoCompleteBottomline;

import org.springframework.boot.CommandLineRunner;

public class BoyNamesLoader implements CommandLineRunner{

	private BoyNameLoaderService svc;
	
	@Override
	public void run(String... args) throws Exception {
		String namespath = "src/main/resources/BoyNames.txt";
		svc.LoadBoyNamesFile(namespath);
		
	}

}
