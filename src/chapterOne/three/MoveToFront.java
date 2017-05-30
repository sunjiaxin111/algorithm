package chapterOne.three;

/**
 * 前移编码。从标准输入读取一串字符，使用链表保存这些字符并清除重复字符。
 * 当你读取了一个从未见过的字符时，将它插入表头。
 * 当你读取了一个重复的字符时，将它从链表中删去并再次插入表头。
 * 可以用于缓存、数据压缩等许多场景。
 * Created by sunjiaxin on 2017/5/12.
 */
public class MoveToFront {

    private Node first;

    private class Node{
        private char c;
        private Node next;
    }

    /**
     * 添加字符
     * @param c
     */
    public void addChar(char c){
        Node node = new Node();
        node.c = c;

        // 当为空链表时，直接插入即可
        if(first == null){
            first = node;
            return;
        }

        // 当头节点保存的字符与所要添加的字符相同时
        if(first.c == c){
            return;
        }

        // 找到当前节点和当前节点的后一个节点
        Node temp = first;
        Node next = temp.next;

        while(next != null){
            if(next.c == c){
                temp.next = next.next;
                break;
            }
            temp = temp.next;
            next = temp.next;
        }

        // 把节点插入表头
        node.next = first;
        first = node;
    }

    public static void main(String[] args) {
        MoveToFront front = new MoveToFront();

        front.addChar('1');
        front.addChar('1');
        front.addChar('2');
        front.addChar('3');
        front.addChar('1');
        front.addChar('2');
        front.addChar('3');

        front.addChar('c');
        front.addChar('d');
        front.addChar('f');

        System.out.println();
    }
}
