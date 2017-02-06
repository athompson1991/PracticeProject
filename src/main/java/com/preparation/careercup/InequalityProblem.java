package com.preparation.careercup;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by aleth on 2/6/2017.
 * https://www.careercup.com/question?id=5745616513662976
 * Q: If you were given a series of equations e.g. [A = B, B = D, C = D, F = G, E = H, H = C]
 * and then another series [A != C, D != H, ..., F != A ]
 * <p>
 * Check whether the equations combined is valid.
 * <p>
 * For the example given, your program should return 'invalid', because the first series implies that A = C, which contradicts the statement A != C in the second series.
 */
public class InequalityProblem {

    private static HashSet<String> equalities = new HashSet<>();
    private static HashSet<String> inequalities = new HashSet<>();

    private static LinkedList<Set<Character>> equalitySets = new LinkedList<>();
    private static LinkedList<Set<Character>> inequalitySets = new LinkedList<>();

    private static void readData() throws FileNotFoundException {
        File file = new File("C:/users/aleth/desktop/careercup/equality.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            equalities.add(line);
        }
        file = new File("C:/users/aleth/desktop/careercup/inequality.txt");
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            inequalities.add(scanner.nextLine());
        }
    }

    private static boolean listIsGood(LinkedList<Set<Character>> inList) {
        boolean out = true;
        for (int i = 0; i < inList.size(); i++)
            for (int j = 0; j < inList.size() & j != i; j++)
                if (intersection(inList.get(i), inList.get(j)).size() > 0)
                    out = false;
        return out;
    }

    private static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> temp = new TreeSet<>();
        for (T x : setA)
            if (setB.contains(x))
                temp.add(x);
        return temp;
    }

    private static void makeEqualitySets(HashSet<String> rawSet, LinkedList<Set<Character>> assignList) {
        Iterator<String> iterator = rawSet.iterator();
        Character first;
        Character second;
        while (iterator.hasNext()) {
            String line = iterator.next();
            first = line.charAt(0);
            second = line.charAt(3);

            boolean assigned = false;
            for (Set<Character> tempSet : assignList) {
                if (tempSet.contains(first)) {
                    tempSet.add(second);
                    assigned = true;
                }
                if (tempSet.contains(second)) {
                    tempSet.add(first);
                    assigned = true;
                }
            }
            if (!assigned) {
                HashSet<Character> tempSet = new HashSet<>();
                tempSet.add(first);
                tempSet.add(second);
                assignList.add(tempSet);
            }
        }

        while (!listIsGood(assignList)) {
            for (int i = 0; i < assignList.size(); i++) {
                Set<Character> firstSet = assignList.get(i);
                for (int j = i + 1; j < assignList.size() & j != i; j++) {
                    Set<Character> secondSet = assignList.get(j);
                    if (intersection(firstSet, secondSet).size() > 0) {
                        firstSet.addAll(secondSet);
                        assignList.remove(j);
                    }
                }
            }
        }
    }

    private static boolean isValid() {
        boolean out = true;
        for (Set<Character> equalitySet : equalitySets)
            for (Set<Character> inequalitySet : inequalitySets)
                if (intersection(equalitySet, inequalitySet).size() >= 2)
                    out = false;
        return out;
    }

    public static void main(String[] args) throws FileNotFoundException {
        readData();
        makeEqualitySets(equalities, equalitySets);
        makeEqualitySets(inequalities, inequalitySets);
        System.out.println("Equalities:      " + equalities);
        System.out.println("Equality sets:   " + equalitySets);
        System.out.println("Inequalities:    " + inequalities);
        System.out.println("Inequality sets: " + inequalitySets);
        System.out.println("Is valid:        " + isValid());
    }
}
