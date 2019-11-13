package otherpractice;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

/**
 * Assumes monotonically increasing keys (like real-time timestamps) are inserted in order.
 */
public class TimeMapListImpl<K, V> implements TimeMap<K, V> {

    public TimeMapListImpl() {

    }

    private static class TimeStamped<V> {
        final long createdOnMillis;
        final V value;

        TimeStamped(V v) {
            this.createdOnMillis = nowUTC();
            this.value = v;
        }

        TimeStamped(long createdOnMillis, V v) {
            this.createdOnMillis = createdOnMillis;
            this.value = v;
        }

        public long getCreatedOnMillis() {
            return createdOnMillis;
        }

    }

    private V findAtTime(List<TimeStamped<V>> timeList, Long t) {
        return binarySearchLessThan(timeList, 0, timeList.size(), t);
    }

    private static <T> T binarySearchLessThan(List<TimeStamped<T>> timeList, int fromIndex, int toIndex, Long t) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            TimeStamped<T> midVal = timeList.get(mid);
            if (midVal.createdOnMillis < t) {
                if (timeList.size() < (mid + 1) && timeList.get(mid + 1).createdOnMillis > t) {
                    return midVal.value;
                } else {
                    low = mid + 1;
                }
            } else if (midVal.createdOnMillis > t) {
                high = mid - 1;
            } else {
                return midVal.value;
            }
        }
        return null;
    }

    private final Map<K, List<TimeStamped<V>>> internalMap = new HashMap<>();

    private static long nowUTC() {
        return LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    @Override
    public V get(K key, Long t) {
        List<TimeStamped<V>> value = internalMap.get(key);
        if (value == null) {
            return null;
        } else return findAtTime(value, t);
    }

    @Override
    public boolean containsKeyAtTime(Object key, long time) {
        return false;
    }

    @Override
    public boolean containsValueAtTime(Object value, long time) {
        return false;
    }

    @NotNull
    @Override
    public Set<K> keySetAtTime(long t) {
        return null;
    }

    @NotNull
    @Override
    public Collection<V> values(long time) {
        return null;
    }

    @NotNull
    @Override
    public Set<Entry<K, V>> entrySet(long time) {
        return null;
    }

    @Override
    public int size() {
        if (internalMap.isEmpty()) return 0;
        return (int) internalMap.values().stream().filter(x -> x.get(x.size() - 1).value != null).count();
    }

    @Override
    public int sizeAtTime(long t) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return internalMap.isEmpty() || size() == 0;
    }

    @Override
    public boolean wasEmptyAtTime(long t) {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Nullable
    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @NotNull
    @Override
    public Set<K> keySet() {
        return null;
    }

    @NotNull
    @Override
    public Collection<V> values() {
        return null;
    }

    @NotNull
    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
