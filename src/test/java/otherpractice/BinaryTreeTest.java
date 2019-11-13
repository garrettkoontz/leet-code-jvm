package otherpractice;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {

    @Test
    void buildFrom() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 50; i += 5) {
            map.put(i, "character " + Character.getName(i));
        }
        BinaryTree<Integer, String> tree = BinaryTree.buildFrom(map);
        assertEquals("character " + Character.getName(20),
                tree.findValueAtLessThanOrEqualTo(23));
    }

    @Test
    void add() {
    }

    @Test
    void findValueAtLessThanOrEqualTo() {
    }
}