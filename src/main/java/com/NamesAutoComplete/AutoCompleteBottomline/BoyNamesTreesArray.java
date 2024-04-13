package com.NamesAutoComplete.AutoCompleteBottomline;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BoyNamesTreesArray {
    private int _numberOfLetters = 26;
    private NameTreeNode[] _treesNamesArray;

    public BoyNamesTreesArray() {
        this._treesNamesArray = new NameTreeNode[_numberOfLetters];
    }

    public void Insert(String name) {
        String lowercasename = name.toLowerCase();
        NameTreeNode current = _treesNamesArray[lowercasename.charAt(0) - 'a'];
        if (current == null) {
            current = new NameTreeNode();
            _treesNamesArray[lowercasename.charAt(0) - 'a'] = current;
        }
        current.Insert(lowercasename.substring(1), name);
    }

    public List<String> Autocomplete(String nameprefix) {
        String lowercasenameprefix = nameprefix.toLowerCase();
        NameTreeNode current = _treesNamesArray[lowercasenameprefix.charAt(0) - 'a'];
        if (current == null) {
            return new ArrayList<>();
        }
        List<String> maycontainduplicationsresult = current.Autocomplete(lowercasenameprefix.substring(1)); 
        HashSet<String> resultset = new HashSet<>();
        for(String name : maycontainduplicationsresult)
        {
        	resultset.add(name);
        }
        return new ArrayList<>(resultset);
    }
}
