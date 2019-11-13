package otherpractice;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TimeMapTreeImpl<K, V> implements TimeMap<K, V> {

    private static long nowUTC() {
        return LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    private static class TimeMapValue<V> {
        private final BinaryTree<Long, V> tree;
        private V currentValue;

        TimeMapValue(V value) {
            this.currentValue = value;
            this.tree = new BinaryTree<>(nowUTC(), value);
        }

        TimeMapValue(long time, V value) {
            this.currentValue = value;
            this.tree = new BinaryTree<>(time, value);
        }

        void put(V value) {
            this.currentValue = value;
            this.tree.add(nowUTC(), value);
        }

        void put(long time, V value) {
            this.currentValue = value;
            this.tree.add(time, value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TimeMapValue<?> that = (TimeMapValue<?>) o;
            return Objects.equals(currentValue, that.currentValue);
        }

        @Override
        public int hashCode() {
            return Objects.hash(currentValue);
        }
    }

    private final HashMap<K, TimeMapValue<V>> internalMap = new HashMap<>();

    private int size = 0;

    public TimeMapTreeImpl() {

    }

    @Override
    public V get(K key, Long t) {
        BinaryTree<Long, V> tree = internalMap.get(key).tree;
        if (tree != null) {
            return tree.findValueAtLessThanOrEqualTo(t);
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return internalMap.size();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return internalMap.containsKey(key) && internalMap.get(key).currentValue != null;
    }

    @Override
    public boolean containsKeyAtTime(Object key, long time) {
        return internalMap.containsKey(key) && internalMap.get(key).tree.findValueAtLessThanOrEqualTo(time) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return internalMap.containsValue(new TimeMapValue<>(value));
    }

    @Override
    public boolean containsValueAtTime(Object value, long time) {
        return internalMap.entrySet().stream().anyMatch(
                e -> e.getValue().tree.findValueAtLessThanOrEqualTo(time).equals(value));
    }

    @Override
    public V get(Object key) {
        TimeMapValue<V> possibleValue = internalMap.get(key);
        if (possibleValue == null) {
            return null;
        } else {
            return possibleValue.currentValue;
        }
    }

    @Nullable
    @Override
    public V put(K key, V value) {
        TimeMapValue<V> possibleValue = internalMap.get(key);
        if (possibleValue == null) {
            internalMap.put(key, new TimeMapValue<>(value));
        } else {
            possibleValue.put(value);
        }
        size++;
        return value;
    }

    private V putAtTime(K key, V value, long time) {
        TimeMapValue<V> possibleValue = internalMap.get(key);
        if (possibleValue == null) {
            internalMap.put(key, new TimeMapValue<>(time, value));
        } else {
            possibleValue.put(time, value);
        }
        size++;
        return value;
    }

    @Override
    public V remove(Object key) {
        TimeMapValue<V> possibleValue = internalMap.get(key);
        if (possibleValue == null) {
            return null;
        } else {
            V oldValue = possibleValue.currentValue;
            size--;
            possibleValue.put(null);
            return oldValue;
        }
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> m) {
        long now = nowUTC();
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            if (!this.internalMap.containsKey(e.getKey())) size++;
            this.putAtTime(e.getKey(), e.getValue(), now);
        }
    }

    @Override
    public void clear() {
        long now = nowUTC();
        for (Map.Entry<? extends K, ? extends V> e : this.entrySet()) {
            this.putAtTime(e.getKey(), null, now);
        }
        size = 0;
    }

    @NotNull
    @Override
    public Set<K> keySet() {
        return internalMap.entrySet().stream()
                .filter(e -> e.getValue().currentValue != null)
                .map(Entry::getKey)
                .collect(Collectors.toSet());
    }

    @NotNull
    @Override
    public Set<K> keySetAtTime(long t) {
        return internalMap.entrySet().stream()
                .filter(e -> e.getValue().tree.findValueAtLessThanOrEqualTo(t) != null)
                .map(Entry::getKey)
                .collect(Collectors.toSet());
    }

    @NotNull
    @Override
    public Collection<V> values() {
        return internalMap.values().stream()
                .filter(vTimeMapValue -> vTimeMapValue.currentValue != null)
                .map(vTimeMapValue -> vTimeMapValue.currentValue)
                .collect(Collectors.toSet());
    }

    @NotNull
    @Override
    public Collection<V> values(long time) {
        return internalMap.entrySet().stream()
                .flatMap(e -> {
                    V valueAtTime = e.getValue().tree.findValueAtLessThanOrEqualTo(time);
                    if (valueAtTime == null) {
                        return Stream.empty();
                    } else {
                        return Stream.of(valueAtTime);
                    }
                })
                .collect(Collectors.toSet());
    }

    @NotNull
    @Override
    public Set<Entry<K, V>> entrySet() {
        return internalMap.entrySet().stream()
                .flatMap(e -> {
                    V currentValue = e.getValue().currentValue;
                    if (currentValue == null) {
                        return Stream.empty();
                    } else {
                        return Stream.of(new TimeMapEntry<>(e.getKey(), currentValue));
                    }
                })
                .collect(Collectors.toSet());
    }

    @NotNull
    @Override
    public Set<Entry<K, V>> entrySet(long time) {
        return internalMap.entrySet().stream()
                .flatMap(e -> {
                    V valueAtTime = e.getValue().tree.findValueAtLessThanOrEqualTo(time);
                    if (valueAtTime == null) {
                        return Stream.empty();
                    } else {
                        return Stream.of(new TimeMapEntry<>(e.getKey(), valueAtTime));
                    }
                })
                .collect(Collectors.toSet());
    }

    @Override
    public int sizeAtTime(long t) {
        return 0;
    }

    @Override
    public boolean wasEmptyAtTime(long t) {
        return false;
    }

    static class TimeMapEntry<K, V> implements Entry<K, V> {

        private final K key;
        private V value;

        TimeMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof TimeMapEntry) {
                TimeMapEntry<?, ?> e = (TimeMapEntry<?, ?>) o;
                return Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue());
            }
            return false;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }

}
