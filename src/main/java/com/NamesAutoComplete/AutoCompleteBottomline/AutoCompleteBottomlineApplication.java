package com.NamesAutoComplete.AutoCompleteBottomline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoCompleteBottomlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoCompleteBottomlineApplication.class, args);
	}
	
	public BoyNamesTreesArray GetBoyNameTreeArray()
	{
		return new BoyNamesTreesArray();
	}
	
	public BoyNameLoaderService GetService(BoyNamesTreesArray arr)
	{
		return new BoyNameLoaderService(arr);
	}

}
