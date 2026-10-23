package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Failure() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 1.0);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertFalse(result);
        assertEquals(1, store.getTorpedoCount()); 
    }

    @Test
    void fire_InvalidParam_TooFew() {
        // Arrange
        TorpedoStore store = new TorpedoStore(5);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(0);
        });
    }

    @Test
    void fire_InvalidParam_TooMany() {
        // Arrange
        TorpedoStore store = new TorpedoStore(5);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(6);
        });
    }

    @Test
    void isEmpty_ReturnsFalse() {
        // Arrange
        TorpedoStore store = new TorpedoStore(2);

        // Assert
        assertFalse(store.isEmpty());
    }

    @Test
    void isEmpty_ReturnsTrue() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);
        store.fire(1);

        // Assert
        assertTrue(store.isEmpty());
    }

    @Test
    void getTorpedoCount_ReturnsCorrectCount() {
        // Arrange
        TorpedoStore store = new TorpedoStore(10);

        // Assert
        assertEquals(10, store.getTorpedoCount());
    }



}
