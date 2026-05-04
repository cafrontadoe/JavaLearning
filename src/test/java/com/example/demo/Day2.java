package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Day2 {


  public static void main(String[] args) {
    getFirstNotDuplicatedManagement();
  }

  /**
   * it shows the first no duplicated character in the word,
   * if all every character is repeated return empty optional
   */
  private static void getFirstNotDuplicatedManagement() {

    List<String> input = new ArrayList<>(List.of("stress", "aabbcc","swiss"));

    for(String word : input) {

      System.out.println(word + ": "+ getFirstNotDuplicated(word));

    }

  }

  private static Optional<Character> getFirstNotDuplicated(String word) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (Character c : word.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (Map.Entry<Character, Integer> entry: map.entrySet()) {

      if (entry.getValue() == 1) {
        return Optional.of(entry.getKey());
      }
    }

    return Optional.empty();
  }
}
