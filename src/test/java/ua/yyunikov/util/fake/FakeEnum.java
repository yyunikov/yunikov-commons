package ua.yyunikov.util.fake;

/**
 * @author yyunikov
 */
public enum  FakeEnum {
    ONE(1),
    ONE_AGAIN(1),
    TWO(2),
    THREE(3);

    private final int index;

    FakeEnum(final int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }
}
