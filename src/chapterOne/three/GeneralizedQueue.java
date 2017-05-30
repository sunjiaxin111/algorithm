package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/11.
 */
public interface GeneralizedQueue<Item> {

    boolean isEmpty();

    void insert(Item x);

    Item delete(int k);
}
