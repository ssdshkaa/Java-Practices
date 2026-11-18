package ru.mirea.work2.dates;
import java.util.*;
public class CollectionSpeed {
    private static long measure(List<Integer> list, int repeats) {
        long start = System.nanoTime();
        for (int r=0; r<repeats; r++) list.add(r);
        long add = System.nanoTime()-start; int middle=list.size()/2;
        start=System.nanoTime(); for(int r=0;r<repeats;r++) list.add(middle, r);
        long insert=System.nanoTime()-start;
        start=System.nanoTime(); for(int r=0;r<repeats;r++) list.remove(middle);
        long remove=System.nanoTime()-start;
        start=System.nanoTime(); for(int r=0;r<repeats;r++) list.contains(r);
        long search=System.nanoTime()-start;
        System.out.println(list.getClass().getSimpleName()+" add="+add+" insert="+insert+" remove="+remove+" find="+search);
        return add+insert+remove+search;
    }
    public static void main(String[] args) { for(int i=0;i<3;i++){measure(new ArrayList<>(),1000);measure(new LinkedList<>(),1000);} }
}
