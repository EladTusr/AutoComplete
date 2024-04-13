package com.NamesAutoComplete.AutoCompleteBottomline;

import java.util.ArrayList;
import java.util.List;

public class NameTreeNode {
    private NameTreeNode[] _nodeChildren;
    private String _value;
    private boolean _isLeaf;
    

    public NameTreeNode() {
        this._nodeChildren = new NameTreeNode[26];
        this._value = null;
        this._isLeaf = false;
    }

    
    
    public void Insert(String name, String origname)
    {
        if (name.isEmpty()) 
        {
            _isLeaf = true;
            _value = origname;
            return;
        }
        char startingLetter = name.charAt(0);
        int arrayIndex = startingLetter - 'a';
        if (_nodeChildren[arrayIndex] == null)
        {
            _nodeChildren[arrayIndex] = new NameTreeNode();
        }
        _nodeChildren[arrayIndex].Insert(name.substring(1), origname);
    }

    public List<String> Autocomplete(String nameprefix) {
        List<String> namesResult = new ArrayList<>();
        if (_isLeaf)
        {
            namesResult.add(_value);
        }
        if (!nameprefix.isEmpty()) {
            char startingLetter = nameprefix.charAt(0);
            int arrayIndex = startingLetter - 'a';
            if (_nodeChildren[arrayIndex] != null)
            {
                List<String> autocompleteResult = _nodeChildren[arrayIndex].Autocomplete(nameprefix.substring(1));
                for (String name : autocompleteResult)
                {
                    namesResult.add(name);
                }
            }
        }
        else
        {
        	getAllWordsFromHere(namesResult);
        }
        return namesResult;
    }

    private void getAllWordsFromHere(List<String> listToFill) 
    {
        if (_isLeaf && _value != null) 
        {
            listToFill.add(_value);
        }
        for (int i = 0; i < 26; i++)
        {
            if (_nodeChildren[i] != null)
            {
                _nodeChildren[i].getAllWordsFromHere(listToFill);
            }
        }
    }
}
