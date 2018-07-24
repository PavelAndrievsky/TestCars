package cars.functions;

import framework.elements.Label;

import java.util.ArrayList;
import java.util.List;

public class CommonFunctions {

    public List<String> getListOfNames(List<Label> list){
        List<String> names = new ArrayList<>();
        for (Label el : list) {
            names.add(el.getText());
        }
        return names;
    }

    public List<String> getListOfEnginesOrTrans(List<Label> list){
        List<String> enginesOrTrans = new ArrayList<>();
        if(list.size() == 1){
            enginesOrTrans.add(list.get(0).getText());
            return enginesOrTrans;
        }
        for (int i=0; i < list.size() - 1; i++) {
            enginesOrTrans.add(list.get(i).getText().substring(0, list.get(i).getText().length()-1));
        }
        enginesOrTrans.add(list.get(list.size()-1).getText());
        return enginesOrTrans;
    }

    public static int generateRandDigit(int size) {
        return (int)(1 + (Math.random() * (size - 1)));
    }

}
