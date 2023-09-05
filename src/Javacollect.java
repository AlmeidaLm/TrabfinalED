import java.util.*;

public class Javacollect{

    static Remendo insertWord(String[] wordsArray, String word) {// fazer retornar objeto
        Remendo n = new Remendo();
        String [] novoV = new String[wordsArray.length+1];
        long startTime = System.nanoTime();
        for (int i = 0; i <= wordsArray.length; i++) {
            if(i<wordsArray.length){
                novoV[i] = wordsArray[i];
            }
            if (i == wordsArray.length) {
                novoV[i] = word;
                System.out.println("Palavra inserida: " + word);
            }
        }
        long endTime = System.nanoTime();// depois eu adiciono como pegar o tempo
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.vet = novoV;
        return n;
    }

    static Remendo searchWord(String[] wordsArray, String word) {
        Remendo n = new Remendo();
        boolean found = false;
        long startTime = System.nanoTime();
        for (String w : wordsArray) {
            if (w.equals(word)) {
                found = true;
                break;
            }
        }
        long endTime = System.nanoTime();// depois eu adiciono como pegar o tempo
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.found = found;
        System.out.println("Palavra encontrada: " + found);
        return n;
    }

    static Remendo removeWord(String[] wordsArray, String word) {// fazer retornar objeto
        int z = 0;
        for (String s : wordsArray) {
            if (s != null) {
                z++;
            }
        }
        String [] novoV = new String[z-1];
        Remendo n = new Remendo();
        boolean a =false;
        long startTime = System.nanoTime();
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(word)) {
                wordsArray[i] = null;
                System.out.println("Palavra removida: " + word);
                a = true;
                break;
            }
        }
        long endTime = System.nanoTime();
        int j = 0;
        if(a) {
            for (String s : wordsArray) {
                if (s != null) {
                    novoV[j] = s;
                    j++;
                }
            }
            // depois eu adiciono como pegar o tempo
            n.tempo = endTime - startTime;
            n.palavr = word;
            n.vet = novoV;
            return n;
        }
        System.out.println(" a palavra não existe");
        n.vet = wordsArray;// retorna normal se não existe
        return n;

    }
///^^^^^^^^^^^^^^^^^^vetor fuction ^^^^^^^^^^^^^^^^^^

    static Remendo insertWordarr(ArrayList<String> wordsList, String word) {
        ArrayList<String> novoV = new ArrayList<>(wordsList);
        long startTime = System.nanoTime();
        novoV.add(word);
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.s = novoV;
        System.out.println("Palavra " + n.palavr +" inserida");
        return n;
    }

    static Remendo searchWordarr(ArrayList<String> wordsList, String word) {
        long startTime = System.nanoTime();
        boolean found = wordsList.contains(word);
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.found =found;
        System.out.println("Palavra encontrada: " + found);
        return n;
    }

    static Remendo removeWordarr(ArrayList<String> wordsList, String word) {
        long startTime = System.nanoTime();
        boolean removed = wordsList.remove(word);
        long endTime = System.nanoTime();
        boolean found = wordsList.contains(word);
        if (removed) {
            Remendo n = new Remendo();
            n.palavr = word;
            n.s = wordsList;
            n.tempo =endTime - startTime;
            n.found =found;
            return n;
        } else {
            System.out.println("A palavra não existe");//isso fica nas assinatura da excessão
            Remendo n = new Remendo();//ElementInexit
            n.palavr = word;
            n.s = wordsList;
            n.tempo =endTime - startTime;
            n.found =found;
            return n;
        }
    }
// ^^^^^^^^^^^^Arraylist functions ^^^^^^^^^^^^^^
static Remendo insertWordLink(LinkedList<String> wordsList, String word) {
    LinkedList<String> novoV = new LinkedList<>(wordsList);
    long startTime = System.nanoTime();
    novoV.add(word);
    long endTime = System.nanoTime();
    Remendo n = new Remendo();
    n.tempo = endTime - startTime;
    n.palavr = word;
    n.link = novoV;
    System.out.println("Palavra " + n.palavr + " inserida");
    return n;
}

    static Remendo searchWordLink(LinkedList<String> wordsList, String word) {
        long startTime = System.nanoTime();
        boolean found = wordsList.contains(word);
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.found = found;
        System.out.println("Palavra encontrada: " + found);
        return n;
    }

    static Remendo removeWordLink(LinkedList<String> wordsList, String word) {
        long startTime = System.nanoTime();
        boolean removed = wordsList.remove(word);
        long endTime = System.nanoTime();
        boolean found = wordsList.contains(word);
        if (removed) {
            Remendo n = new Remendo();
            n.palavr = word;
            n.link = wordsList;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        } else {
            System.out.println("A palavra não existe"); // isso fica nas assinatura da excessão
            Remendo n = new Remendo(); // ElementInexit
            n.palavr = word;
            n.link = wordsList;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        }
    }
    //~~^^^^^^^^Linkedlist functions^^^^^^^^

    static Remendo insertWordHashSet(HashSet<String> wordsSet, String word) {
        HashSet<String> novoV = new HashSet<>(wordsSet);
        long startTime = System.nanoTime();
        novoV.add(word);
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.hasSeti = novoV;
        System.out.println("Palavra " + n.palavr + " inserida");
        return n;
    }

    static Remendo searchWordHashSet(HashSet<String> wordsSet, String word) {
        long startTime = System.nanoTime();
        boolean found = wordsSet.contains(word);
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.found = found;
        System.out.println("Palavra encontrada: " + found);
        return n;
    }

    static Remendo removeWordHashSet(HashSet<String> wordsSet, String word) {
        long startTime = System.nanoTime();
        boolean removed = wordsSet.remove(word);
        long endTime = System.nanoTime();
        boolean found = wordsSet.contains(word);
        if (removed) {
            Remendo n = new Remendo();
            n.palavr = word;
            n.hasSeti = wordsSet;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        } else {
            System.out.println("A palavra não existe");
            Remendo n = new Remendo();
            n.palavr = word;
            n.hasSeti = wordsSet;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        }
    }
    ///////////////////////////^^^^^^^^Hash functions^^^^^^^^//////////////////////////////////
    ///////VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVLinkedHashSetFunctionsVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV//////////

    static Remendo insertWordLinkedHashSet(LinkedHashSet<String> wordsSet, String word) {
        LinkedHashSet<String> novoV = new LinkedHashSet<>(wordsSet);
        long startTime = System.nanoTime();
        novoV.add(word);
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.linkHseti = novoV;
        System.out.println("Palavra " + n.palavr + " inserida");
        return n;
    }

    static Remendo searchWordLinkedHashSet(LinkedHashSet<String> wordsSet, String word) {
        long startTime = System.nanoTime();
        boolean found = wordsSet.contains(word);
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.found = found;
        System.out.println("Palavra encontrada: " + found);
        return n;
    }

    static Remendo removeWordLinkedHashSet(LinkedHashSet<String> wordsSet, String word) {
        long startTime = System.nanoTime();
        boolean removed = wordsSet.remove(word);
        long endTime = System.nanoTime();
        boolean found = wordsSet.contains(word);
        if (removed) {
            Remendo n = new Remendo();
            n.palavr = word;
            n.linkHseti = wordsSet;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        } else {
            System.out.println("A palavra não existe");
            Remendo n = new Remendo();
            n.palavr = word;
            n.linkHseti = wordsSet;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        }

    }
    ////////////////////////////////////////TreeSet//////////////////////////////////////////////////////////
    static Remendo insertWordTreeSet(TreeSet<String> wordsSet, String word) {
        TreeSet<String> novoV = new TreeSet<>(wordsSet);
        long startTime = System.nanoTime();
        novoV.add(word);
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.triiseti = novoV;
        System.out.println("Palavra " + n.palavr + " inserida");
        return n;
    }

    static Remendo searchWordTreeSet(TreeSet<String> wordsSet, String word) {
        long startTime = System.nanoTime();
        boolean found = wordsSet.contains(word);
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.found = found;
        System.out.println("Palavra encontrada: " + found);
        return n;
    }

    static Remendo removeWordTreeSet(TreeSet<String> wordsSet, String word) {
        long startTime = System.nanoTime();
        boolean removed = wordsSet.remove(word);
        long endTime = System.nanoTime();
        boolean found = wordsSet.contains(word);
        if (removed) {
            Remendo n = new Remendo();
            n.palavr = word;
            n.triiseti = wordsSet;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        } else {
            System.out.println("A palavra não existe");
            Remendo n = new Remendo();
            n.palavr = word;
            n.triiseti = wordsSet;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        }
    }
    ////////////////////////////////////////HashMap/////////////////////////////////////////////////////////
    static Remendo insertWordHashMap(HashMap<String, String> wordsMap, String word) {
        HashMap<String, String> novoV = new HashMap<>(wordsMap);
        long startTime = System.nanoTime();
        novoV.put(word, null); // Valor da palavra definido como o próprio word para fins de exemplo
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.hashimapi = novoV;
        System.out.println("Palavra " + n.palavr + " inserida");
        return n;
    }

    static Remendo searchWordHashMap(HashMap<String, String> wordsMap, String word) {
        long startTime = System.nanoTime();
        boolean found = wordsMap.containsKey(word);
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.found = found;
        System.out.println("Palavra encontrada: " + found);
        return n;
    }

    static Remendo removeWordHashMap(HashMap<String, String> wordsMap, String word) {
        long startTime = System.nanoTime();
        boolean found = false;
        if (wordsMap.containsKey(word)) {
            Remendo n = new Remendo();
            wordsMap.remove(word);
            long endTime = System.nanoTime();
            n.palavr = word;
            n.hashimapi = wordsMap;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        } else {
            System.out.println("A palavra não existe");
            long endTime = System.nanoTime();
            Remendo n = new Remendo();
            n.palavr = word;
            n.hashimapi = wordsMap;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        }
    }
    ///////////////////////////////////////^^^^^^^^^^^^^^^^^^^/////////////////////////////////////////////
    static Remendo insertWordLinkedHashMap(LinkedHashMap<String, String> wordsMap, String word) {
        LinkedHashMap<String, String> novoV = new LinkedHashMap<>(wordsMap);
        long startTime = System.nanoTime();
        novoV.put(word, null); // Valor da palavra definido como nulo para fins de exemplo
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.linkhashimapi = novoV;
        System.out.println("Palavra " + n.palavr + " inserida");
        return n;
    }

    static Remendo searchWordLinkedHashMap(LinkedHashMap<String, String> wordsMap, String word) {
        long startTime = System.nanoTime();
        boolean found = wordsMap.containsKey(word);
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.found = found;
        System.out.println("Palavra encontrada: " + found);
        return n;
    }

    static Remendo removeWordLinkedHashMap(LinkedHashMap<String, String> wordsMap, String word) {
        long startTime = System.nanoTime();
        boolean found = false;
        if (wordsMap.containsKey(word)) {
            LinkedHashMap<String, String> novoV = new LinkedHashMap<>(wordsMap);
            novoV.remove(word);
            long endTime = System.nanoTime();
            Remendo n = new Remendo();
            n.palavr = word;
            n.linkhashimapi = novoV;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        } else {
            System.out.println("A palavra não existe");
            long endTime = System.nanoTime();
            Remendo n = new Remendo();
            n.palavr = word;
            n.linkhashimapi = wordsMap;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        }
    }
    //////////////////////////////^^^^^^^^^^^^^^^^^^^^^^^linkedhashMap^^^^^^^^^^^^^^^^^^//////////////////
    static Remendo insertWordTreeMap(TreeMap<String, String> wordsMap, String word) {
        TreeMap<String, String> novoV = new TreeMap<>(wordsMap);
        long startTime = System.nanoTime();
        novoV.put(word, null); // Valor da palavra definido como nulo para fins de exemplo
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.trimapi = novoV;
        System.out.println("Palavra " + n.palavr + " inserida");
        return n;
    }

    static Remendo searchWordTreeMap(TreeMap<String, String> wordsMap, String word) {
        long startTime = System.nanoTime();
        boolean found = wordsMap.containsKey(word);
        long endTime = System.nanoTime();
        Remendo n = new Remendo();
        n.tempo = endTime - startTime;
        n.palavr = word;
        n.found = found;
        System.out.println("Palavra encontrada: " + found);
        return n;
    }

    static Remendo removeWordTreeMap(TreeMap<String, String> wordsMap, String word) {
        long startTime = System.nanoTime();
        boolean found = false;
        if (wordsMap.containsKey(word)) {
            TreeMap<String, String> novoV = new TreeMap<>(wordsMap);
            novoV.remove(word);
            long endTime = System.nanoTime();
            Remendo n = new Remendo();
            n.palavr = word;
            n.trimapi = novoV;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        } else {
            System.out.println("A palavra não existe");
            long endTime = System.nanoTime();
            Remendo n = new Remendo();
            n.palavr = word;
            n.trimapi = wordsMap;
            n.tempo = endTime - startTime;
            n.found = found;
            return n;
        }
    }
    ////////////////////////////////////  ^^^^TreeMap^^^^    /////////////////////////////

}




