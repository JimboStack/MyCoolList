import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class MyCoolList<T extends Number> implements Iterable<T> {
    public Object[] data;
    public int size;

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public MyCoolList(Object[] data, int size) {
        this.data = data;
        this.size = size;
    }

    public void add(T element) {
        if (size == data.length) {
            expandCapacity();
        }
        data[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Wrong index value");
        }
        return (T) data[index];
    }

    public int size() {
        return size;
    }
    private void expandCapacity() {
        int newCapacity = data.length + 1;
        data = Arrays.copyOf(data, newCapacity);
    }
    @Override
    public Iterator<T> iterator() {
        return new MyCoolListIterator();
    }

    private class MyCoolListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            return (T) data[currentIndex++];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        MyCoolList<?> myCoolList = (MyCoolList<?>) o;
        return size == myCoolList.size && Arrays.equals(data, myCoolList.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(".");
        return sb.toString();
    }
}
