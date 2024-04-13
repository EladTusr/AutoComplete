package com.NamesAutoComplete.AutoCompleteBottomline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

import java.util.List;

public class BoyNameLoaderNodeAndTreeNotRealUnitTests {

    private BoyNameLoaderService boyNameLoaderService;
    private BoyNamesTreesArray boyNamesTreesArray;

    @BeforeEach
    public void setUp() {
        boyNamesTreesArray = new BoyNamesTreesArray();
        boyNameLoaderService = new BoyNameLoaderService(boyNamesTreesArray);
    }

    @Test
    public void GettingResuts_WhenAllValid_ShouldReturnAll() {
        boyNameLoaderService.LoadBoyNamesFile("src/main/resources/testnames.txt");
        List<String> autocompleteResult = boyNamesTreesArray.Autocomplete("b");
        System.out.println("Autocomplete Results: " + autocompleteResult);
        assertTrue(autocompleteResult.contains("bob"));
        assertTrue(autocompleteResult.contains("Billy"));
        assertTrue(autocompleteResult.contains("bobby"));
        assertTrue(autocompleteResult.contains("bill"));

    }
    
    @Test
    public void GettingResuts_WhenWillBeDuplication_ShouldReturnNoDuplications() {
        boyNameLoaderService.LoadBoyNamesFile("src/main/resources/testnames.txt");
        List<String> autocompleteResult = boyNamesTreesArray.Autocomplete("bob");
        System.out.println("Autocomplete Results: " + autocompleteResult);
        assertTrue(autocompleteResult.contains("bob"));
        assertTrue(autocompleteResult.contains("bobby"));

    }
    
    @Test
    public void GettingResuts_WhenStartingWithDiffrentCaseAndDuplication_ShouldReturnNoDuplicationsRIghtCase() {
        boyNameLoaderService.LoadBoyNamesFile("src/main/resources/testnames.txt");
        List<String> autocompleteResult = boyNamesTreesArray.Autocomplete("Bob");
        System.out.println("Autocomplete Results: " + autocompleteResult);
        assertTrue(autocompleteResult.contains("bob"));
        assertTrue(autocompleteResult.contains("bobby"));

    }
}
