package otherpractice;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Write a map implementation with a get function that lets you retrieve the value of a key at a particular time.
 * t:0 A =1 t:2 A = 2 get(A, t:1) -> 1 get(A, t:3) -> 2
 */

/**
 * Time modeled as Long.
 *
 * @param <K>
 * @param <V>
 */
public interface TimeMap<K, V> extends Map<K, V> {
    V get(K key, Long t);

    boolean containsKeyAtTime(Object key, long time);

    boolean containsValueAtTime(Object value, long time);

    @NotNull
    Set<K> keySetAtTime(long t);

    @NotNull
    Collection<V> values(long time);

    @NotNull
    Set<Entry<K, V>> entrySet(long time);

    int sizeAtTime(long t);

    boolean wasEmptyAtTime(long t);
}
