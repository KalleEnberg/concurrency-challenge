package sven.workshop.concurrency;

import java.util.stream.IntStream;

public class TrivialDataCorruptionExample {

  private int counter = 0;

  public TrivialDataCorruptionExample() {
  }

  public void incrementCounter() {
    counter++;
  }

  public int getCounterValue() {
    return counter;
  }

  public static void main(String[] args) {
    TrivialDataCorruptionExample trivialDataCorruptionExample = new TrivialDataCorruptionExample();
    IntStream.range(0, 100000)
        .parallel()
        .forEach(ignored -> trivialDataCorruptionExample.incrementCounter());
    // TODO: 2023-02-24 Why is this not 1000 as one could expect?
    //  How can we ensure it will behave correctly? (Note: There are quite a few solutions!)
    System.out.println(trivialDataCorruptionExample.getCounterValue());
  }

}
