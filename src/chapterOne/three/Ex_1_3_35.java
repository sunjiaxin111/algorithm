package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/11.
 */
public class Ex_1_3_35 {

    public static void main(String[] args) {
        RandomQueue<Card> queue = new RandomQueue<>();
        //入列总数
        int N = 0;
        for(int i = Card.DIAMOND; i <= Card.SPADE; i++) {
            for (int j = Card.THREE; j <= Card.DEUCE; j++) {
                queue.enqueue(new Card(i, j));
                N++;
            }
        }

        System.out.println(N);

        /*for(int i = 0; i < N; i++){
            System.out.println(queue.dequeue());
        }*/

        for(Card c : queue){
            System.out.println(c);
        }
    }
}

class Card {

    public static final int DIAMOND = 0; // 方块(钻石)
    public static final int CLUB = 1; // 梅花
    public static final int HEART = 2; // 红桃(红心)
    public static final int SPADE = 3; // 黑桃(花锄)
    public static final int JOKER = 4; // 王

    public final static int THREE = 0;
    public final static int FOUR = 1;
    public final static int FIVE = 2;
    public final static int SIX = 3;
    public final static int SEVEN = 4;
    public final static int EIGHT = 5;
    public final static int NINE = 6;
    public final static int TEN = 7;
    public final static int JACK = 8;// J
    public final static int QUEEN = 9;// Q
    public final static int KING = 10;// K
    public final static int ACE = 11;// A
    public final static int DEUCE = 12; // 2
    public final static int BLACK = 13; // 小王
    public final static int COLOR = 14;// 大王

    /**
     * 花色 0代表方块, 1代表梅花, 2代表红桃, 3代表黑桃,4:王
     */
    private int suit;
    /**
     * 点数 规定: 0代表3, 1代表4, 2代表5,...
     */
    private int rank;

    public Card() {
    }

    public Card(int suit, int rank) {
        // this.rank = rank;
        // this.suit = suit;
        setRank(rank);
        setSuit(suit);
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        if (suit < DIAMOND || suit > JOKER)
            throw new RuntimeException("花色超过范围!");
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if (rank < THREE || rank > COLOR) {
            throw new RuntimeException("点数超过范围!");
        }
        this.rank = rank;
    }

    private static final String[] RANK_NAMES = {"3", "4", "5", "6", "7", "8",
            "9", "10", "J", "Q", "K", "A", "2", "小王", "大王"};
    private static final String[] SUIT_NAMES = {"方块", "梅花", "红桃", "黑桃", ""};

    // 覆盖Object 类的toStirng() 方法. 实现对象的文本描述
    public String toString() {
        return SUIT_NAMES[suit] + RANK_NAMES[rank];
    }
}
