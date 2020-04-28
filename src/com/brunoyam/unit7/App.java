package com.brunoyam.unit7;

import java.util.*;

/**
 * Демонстрируется сортировка коллекций, лямбды, стримы, работа с потоками ввода-вывода.
 */
public class App {

    public static void main(String[] args) {

        Collection<String> collection;
        List<String> myList = new ArrayList<>();
        Set<String> mySet = new HashSet<>();
        Queue<String> myQueue = new LinkedList();
        LinkedList<String> myLinkedList = new LinkedList();

        Deque<String> myDeque = new ArrayDeque<>();
        Map<Integer, String> myMap = new HashMap<>();

        Collection<Neighbour> neighbours = getAllNeighbours();
        Collection<Neighbour> sortedNeighbours = sortCollection(neighbours);


        Comparator<Neighbour> comparator = new Comparator<Neighbour>() {
            @Override
            public int compare(Neighbour neighbour, Neighbour t1) {
                return t1.getAge() - neighbour.getAge();
            }
        };

        Comparator<Neighbour> lambdaComparator = (neighbour, t1) -> {
            return t1.getAge() - neighbour.getAge();
        };

        List<Neighbour> neighboursList = new ArrayList<>(neighbours);
        Collections.sort(neighboursList, comparator);

        Collections.sort(neighboursList, (neighbour, t1) -> t1.getAge() - neighbour.getAge());

        for(Neighbour neighbour : neighboursList) {
            System.out.println(neighbour);
        }

        neighboursList.forEach(n -> System.out.println(n));
        neighboursList.forEach(System.out::println);

        sortCollection(myList);

        Iterator<Neighbour> neighbourIterator = neighbours.iterator();
        while (neighbourIterator.hasNext()) {
            Neighbour nextNeighbour = neighbourIterator.next();
            if(nextNeighbour.getName().equals("Ivan")) {
                neighbourIterator.remove();
            }
        }

        System.out.println("after remomving:");

        for(Neighbour neighbour : neighbours) {
            System.out.println(neighbour);
        }

        NeighbourReader neighbourReader = new NeighbourReader();
        neighbourReader.objectReadWrite();

        System.out.println("Streams here");

        Collection<Neighbour> fullNeighboursList = getAllNeighbours();

        MyPredicate predicate = new MyPredicate();

        fullNeighboursList.stream()
                .filter(predicate)
                .filter(neighbour -> neighbour.getAge() > 21)
                .filter(neighbour -> neighbour.getName().toLowerCase().equals("ivan"))
                .forEach(System.out::println);

        fullNeighboursList.stream()
                .filter(neighbour -> {
                    System.out.println("filter invokes");
                    return neighbour.getAge() > 21;
                })
                .map(neighbour -> neighbour.getName() + " " + neighbour.getSurname())
                .filter(fullName -> fullName.equals("Ivan Ivanov"))
                .forEach(System.out::println);

        Boolean ivanIvanovIsHere =
                fullNeighboursList.stream()
                        .anyMatch(
                                neighbour ->
                                        neighbour.getName().equals("Ivan") && neighbour.getSurname().equals("Ivanov"));

        System.out.println("есть иванов : " + ivanIvanovIsHere);

        Neighbour neighbour = new Neighbour("l", "l", "l", (byte) 12, "r");
        String description = neighbour.toString();

    }

    /**
     * Обобщенный (generic) метод, сортирующий переданную коллекцию используя
     * {@link java.util.Collections#sort сортировку класса Collections}.
     * @param collection коллекция.
     * @param <T> тип элементов коллекции.
     * @return отсортированная коллекция.
     */
    public static <T extends Comparable> Collection<T> sortCollection(Collection<T> collection) {
        List<T> sortedCollection = new ArrayList(collection);
        Collections.sort(sortedCollection);
        return sortedCollection;
    }

    /**
     * Возвращает коллекцию соседей содержащую только уникальные элементы.
     * @return коллекция соседей.
     */
    public static Collection getAllNeighbours() {
        Set<Neighbour> neighbours = new HashSet<>();

        NeighbourReader neighbourReader = new NeighbourReader();

        Neighbour neighbour = neighbourReader.nextNeighbour();
        while (neighbour != null) {
            neighbours.add(neighbour);
            neighbour = neighbourReader.nextNeighbour();
        }

        return neighbours;
    }

}
