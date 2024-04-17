package org.example.indexImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertedIndex {
    private static Map<String, List<Integer>> indexMap;

    public InvertedIndex() {
        indexMap = new HashMap<>();
    }

    public void indexDocument(int docId, String document) {
        String cleanedDocument = document.replaceAll("[^\\p{L}\\p{Nd}]+", "");

        for (int i = 0; i < cleanedDocument.length() - 1; i++) {
            String token = cleanedDocument.substring(i, i + 2);
            indexMap.computeIfAbsent(token, k -> new ArrayList<>()).add(docId);
        }
    }

    public List<Integer> search(String query) {
        return indexMap.getOrDefault(query, new ArrayList<>());
    }

    public static void main(String[] args) {
        InvertedIndex index = new InvertedIndex();

        index.indexDocument(1, "사과는 과일이다.");
        index.indexDocument(2, "바나나는 열대 과일이다.");
        index.indexDocument(3, "토마토는 과일인가 채소인가?");

        System.out.println("사과 검색 결과: " + index.search("사과"));
        System.out.println("과일 검색 결과: " + index.search("과일"));
        System.out.println("채소 검색 결과: " + index.search("채소"));
    }
}