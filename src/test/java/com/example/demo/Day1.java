package com.example.demo;

import java.util.*;

public class Day1 {

  static final class Singleton {

    private static volatile Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
      if (instance == null) {
        synchronized (Singleton.class) {
          if (instance == null) {
            instance = new Singleton();
          }
        }
      }
      return instance;
    }

  }

  /*
    return the duplicate numbers
   */
  public static void main(String[] args) {
    balanceParenthesis();
  }



  private static void balanceParenthesis(){
    List<String> listParenthesis = new ArrayList<>(List.of("(()())", "(())", ")("));

    listParenthesis
        .forEach(sequence -> {
          System.out.println(sequence + "-> "+ isSequenceBalance(sequence));
        });
  }

  private static boolean isSequenceBalance(String sequence){
    Deque<Character> deque = new ArrayDeque<>();

    for (char character : sequence.toCharArray() ){
      if (character == '(') {
        deque.add(character);
      } else if (character == ')'){
        if(deque.isEmpty()){
          return false;
        }
        deque.pop();
      }
    }
    return deque.isEmpty();
  }

  private static void groupBySize() {
    String[] input = {"sol", "luna", "mar", "cielo", "rio"};
    Map<Integer, List<String>> mapOutput = new HashMap<>();


    for(String word: input) {
      mapOutput.computeIfAbsent(word.length(), v -> new ArrayList<>()).add(word);
    }

    System.out.println(mapOutput);

  }




  private static void  duplicates() {
    int[] inputList =  {1, 2, 3, 2, 4, 5, 1, 1};
    Set<Integer> clenSet = new HashSet<>();
    Set<Integer> outputList = new HashSet<>();
    for (int i : inputList) {
      boolean added = clenSet.add(i);
      if (!added) {
        outputList.add(i);
      }
    }
    System.out.println(Arrays.toString(outputList.toArray()));
  }
}
