package com.google.tagmanager.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    private final LazyStringList list;

    /* renamed from: com.google.tagmanager.protobuf.UnmodifiableLazyStringList.1 */
    class C04601 implements ListIterator<String> {
        ListIterator<String> iter;
        final /* synthetic */ int val$index;

        C04601(int i) {
            this.val$index = i;
            this.iter = UnmodifiableLazyStringList.this.list.listIterator(this.val$index);
        }

        public boolean hasNext() {
            return this.iter.hasNext();
        }

        public String next() {
            return (String) this.iter.next();
        }

        public boolean hasPrevious() {
            return this.iter.hasPrevious();
        }

        public String previous() {
            return (String) this.iter.previous();
        }

        public int nextIndex() {
            return this.iter.nextIndex();
        }

        public int previousIndex() {
            return this.iter.previousIndex();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void set(String o) {
            throw new UnsupportedOperationException();
        }

        public void add(String o) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.tagmanager.protobuf.UnmodifiableLazyStringList.2 */
    class C04612 implements Iterator<String> {
        Iterator<String> iter;

        C04612() {
            this.iter = UnmodifiableLazyStringList.this.list.iterator();
        }

        public boolean hasNext() {
            return this.iter.hasNext();
        }

        public String next() {
            return (String) this.iter.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public UnmodifiableLazyStringList(LazyStringList list) {
        this.list = list;
    }

    public String get(int index) {
        return (String) this.list.get(index);
    }

    public int size() {
        return this.list.size();
    }

    public ByteString getByteString(int index) {
        return this.list.getByteString(index);
    }

    public void add(ByteString element) {
        throw new UnsupportedOperationException();
    }

    public void set(int index, ByteString element) {
        throw new UnsupportedOperationException();
    }

    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        throw new UnsupportedOperationException();
    }

    public byte[] getByteArray(int index) {
        return this.list.getByteArray(index);
    }

    public void add(byte[] element) {
        throw new UnsupportedOperationException();
    }

    public void set(int index, byte[] element) {
        throw new UnsupportedOperationException();
    }

    public boolean addAllByteArray(Collection<byte[]> collection) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<String> listIterator(int index) {
        return new C04601(index);
    }

    public Iterator<String> iterator() {
        return new C04612();
    }

    public List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    public void mergeFrom(LazyStringList other) {
        throw new UnsupportedOperationException();
    }

    public List<byte[]> asByteArrayList() {
        return Collections.unmodifiableList(this.list.asByteArrayList());
    }
}
