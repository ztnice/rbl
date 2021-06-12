package com.cc.site.rbl.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    private static final int BASE_SIZE = 1000;

    public static <T> List<List<T>> splitList(List<T> list){

        List<List<T>> result = new ArrayList<>();

        if(list == null || list.isEmpty() || list.size() <= BASE_SIZE ){
            result.add(list);
            return result;
        }

        int size = list.size();
        int start = 0,end = BASE_SIZE;
        while (end <= size){
            result.add(list.subList(start,end));
            start = end;
            end += BASE_SIZE;
            if(end > size && start < size){
                end = size;
                result.add(list.subList(start,end));
                break;
            }
        }
        return result;
    }
}
