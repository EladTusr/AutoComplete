package com.NamesAutoComplete.AutoCompleteBottomline;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class BoyNameLoaderService {

	private  BoyNamesTreesArray namesArr;

    public BoyNameLoaderService(BoyNamesTreesArray arr) {
        this.namesArr = arr;
    }

    public void LoadBoyNamesFile(String boyNamesFilePath) {
        try (Stream<String> stream = Files.lines(Paths.get(boyNamesFilePath)))  {
        	stream.forEach(this::SaveBoyName);
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
    }
    
    private void SaveBoyName(String boyName)
    {
    	this.namesArr.Insert(boyName);
    }
	
}
