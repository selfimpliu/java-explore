package com.java.ljj.explore.collections;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionMain {

    @Data
    @AllArgsConstructor
    private static class DemoBO {
        private Integer id;
        private String name;
    }

    public static void main(String[] args) {

        partitionByTest();
//        List<DemoBO> demoBOList = Lists.newArrayList();
//        for (int i = 0; i < 10; i++) {
//            DemoBO demoBO = new DemoBO(i, String.valueOf(i));
//            demoBOList.add(demoBO);
//        }
//        List<String> nameList = demoBOList.stream().map(DemoBO::getName).collect(Collectors.toList());
//        System.out.println(nameList);
    }

    public static void partitionByTest() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(e -> e != 10));
        System.out.println(map);
    }
}
