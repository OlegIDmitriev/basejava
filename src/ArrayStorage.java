/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int MAX_CAPACITY = 10000;
    private Resume[] storage = new Resume[MAX_CAPACITY];
    private int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }

        size = 0;
    }

    void save(Resume r) {
        if (r != null) {
            storage[size++] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }

        return null;
    }

    void delete(String uuid) {
        for (int deleteIndex = 0; deleteIndex < size; deleteIndex++) {
            if (storage[deleteIndex].toString().equals(uuid)) {
                moveToLeftByOne(deleteIndex);
                return;
            }
        }
    }

    private void moveToLeftByOne(int index) {
        for (; index < size - 1; index++) {
            storage[index] = storage[index + 1];
        }
        storage[--size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (size == MAX_CAPACITY) {
            return storage;
        }

        Resume[] notNullStorage = new Resume[size];
        System.arraycopy(storage, 0, notNullStorage, 0, size);
        return notNullStorage;
    }

    int size() {
        return size;
    }
}
