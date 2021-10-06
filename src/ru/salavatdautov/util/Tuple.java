package ru.salavatdautov.util;

/**
 * Simple tuple realization
 *
 * @param <T1> first element
 * @param <T2> second element
 */
public class Tuple<T1, T2> {
    private final T1 first;
    private final T2 second;

    /**
     * Two-piece constructor
     *
     * @param first  first element
     * @param second second element
     */
    public Tuple(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Getter
     *
     * @return first element
     */
    public T1 getFirst() {
        return first;
    }

    /**
     * Getter
     *
     * @return second element
     */
    public T2 getSecond() {
        return second;
    }
}
