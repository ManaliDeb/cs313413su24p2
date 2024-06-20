package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  // TODO run test and record running times for SIZE = 10, 100, 1000, 10000, ...
  // (choose in conjunction with REPS below up to an upper limit where the clock
  // running time is in the tens of seconds)
  // TODO (optional) refactor to DRY
  // which of the two lists performs better as the size increases?
  private final int[] SIZES = {10, 100, 1000, 10000, 100000};

  // TODO choose this value in such a way that you can observe an actual effect
  // for increasing problem sizes
  private final int REPS = 100000;

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<Integer>();
    linkedList = new LinkedList<Integer>();
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  private void fillList(int size){
    arrayList.clear();
    linkedList.clear();
    for(var i = 0; i < size; i++){
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @Test
  public void runTests(){
    for (int size : SIZES) {
      System.out.println("test with size " + size);

      fillList(size);

      long startTime = System.currentTimeMillis();
      testLinkedListAddRemove();
      long endTime = System.currentTimeMillis();
      System.out.println("LinkedList add/remove: " + (endTime - startTime) + " ms");

      startTime = System.currentTimeMillis();
      testArrayListAddRemove();
      endTime = System.currentTimeMillis();
      System.out.println("ArrayList add/remove: " + (endTime - startTime) + " ms");

      startTime = System.currentTimeMillis();
      testLinkedListAccess();
      endTime = System.currentTimeMillis();
      System.out.println("LinkedList access: " + (endTime - startTime) + " ms");

      startTime = System.currentTimeMillis();
      testArrayListAccess();
      endTime = System.currentTimeMillis();
      System.out.println("ArrayList access: " + (endTime - startTime) + " ms");
      System.out.println();
    }
  }

  private void testLinkedListAddRemove() {
    for (var r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
    }
  }

  private void testArrayListAddRemove() {
    for (var r = 0; r < REPS; r++) {
      arrayList.add(0, 77);
      arrayList.remove(0);
    }
  }

  private void testLinkedListAccess() {
    var sum = 0L;
    for (var r = 0; r < REPS; r++) {
      sum += linkedList.get(r % linkedList.size());
    }
  }

  private void testArrayListAccess() {
    var sum = 0L;
    for (var r = 0; r < REPS; r++) {
      sum += arrayList.get(r % arrayList.size());
    }
  }
}
