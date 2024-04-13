package com.NamesAutoComplete.AutoCompleteBottomline;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoyNamesController {
	private BoyNamesTreesArray _namesArrayTree;
	
	public BoyNamesController(BoyNamesTreesArray arr)
	{
		this._namesArrayTree = arr;
	}
	
	@GetMapping("/Autocomplete")
	public List<String> Autocomplete(String prefix)
	{
		return _namesArrayTree.Autocomplete(prefix);
	}
}
