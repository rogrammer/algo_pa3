/*
19050111022, FURKAN DEMİR
20050111011, İBRAHİM BAHÇA
20050111034, MERTER ÇOBAN
20050111008, SELÇUK GENÇAY
21050141038, YOUSIF HARITH SUHAIL SUHAIL
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ChainedHashMap extends AbstractHashMap {
    int a, b;
    LinkedList<Student>[] table = new LinkedList[4001];

    public ChainedHashMap(ArrayList<Student> list) {
        nodes = list;
        a = 3;
        b = 17;
        for(int i = 0; i < 4001; i++)
            table[i] = new LinkedList<Student>();
        createTable();
    }   

    @Override
    public void printStudents(int count) {
        Random rand = new Random();
        for(int i = 0; i < count; i++) {
            System.out.println(this.getNode(nodes.get(rand.nextInt(nodes.size())).ID));
        }
    }
    @Override
    public void createTable()  {
        int index;
        for(Student s : nodes) {
            index = hashCode(s.ID);
            table[index].addFirst(s);
            size++;
        }
    }

    @Override
    public int hashCode(int key) {
        return (a*key + b)/1001 % 4001;
    }

    @Override
    public Student getNode(int key) {
        int index = hashCode((int) key);
        for(Student s : table[index]) {
            if(((Student) s).ID == key)
                return s;
        }
        return null;
    }

}
