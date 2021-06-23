import java.util.function.Predicate;

//@AUTHOR: GORKEM TOPRAK
//DATE: JANUARY 23, 2021 SATURDAY
//TOPIC: JAVA-8 STREAMS

class Filter<T> implements Predicate<T> {
    @Override
    public boolean test(T t) {
        return true;
    }
}