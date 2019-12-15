package test;

import java.util.*;

/**
 * Created by 11981 on 2017/10/10.
 */
public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
    //序列版本号
    private static final long serialVersionUID = 8683452581122892189L;
    //默认初始容量
    private static final int DEFAULT_CAPACITY = 10;
    //所有空实例共享的空数组实例
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final Object[] EMPTY_ELEMENTDATA = {};
    //存储ArrayList元素的数组
    transient Object[] elementData;
    //ArrayList中实际数据的数量
    private int size;

    //初始化时，如果带容量，使用此构造函数
    public ArrayList(int initialCapacity){

        if (initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
        }else if(initialCapacity == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        }else{

            throw new IllegalArgumentException("Illegal Capacity " + initialCapacity);
        }
    }
    //默认的构造方法
    public ArrayList(){
        //只是简单的将空数组赋值给了elementData
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    //利用别的集合类来构造ArrayList的构造函数
    public ArrayList(Collection<? extends E> c){
        elementData = c.toArray();
        size = elementData.length;
        if (size != 0){
            //c.toArray might (incorrectly) not return Object[] (see 6260652)
            //返回的如果不是Object[]将调用Arrays.copyOf方法将其转为Object[]
            if (elementData.getClass() != Object[].class){
                elementData = Arrays.copyOf(elementData, size, Object[].class);
            }
        }else{
            this.elementData = EMPTY_ELEMENTDATA;
        }

    }


    /**将ArrayList实例的容量裁剪到list当前大小Size
     * 应用程序使用该操作降低ArrayList实例占用的存储
     * 因为清空等一些操作只改变参数而没有释放空间
     */

    public void trimToSize(){
        //来自AbstractList，用于记录操作的次数
        modCount++;
        int oldCapacity = elementData.length;
        if (size < oldCapacity){
            elementData = Arrays.copyOf(elementData, size);
        }
    }

    /**
     * 提升ArrayList实例的容量，确保它可以保存至少minCapacity的元素
     */
    public void ensureCapacity(int minCapacity){
        //如果数组当前为空，则添加元素时最小增长容量为DEFAULT_CAPACITY
        //否则，增长容量大于零即可
        int midExpend = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) ? 0 : DEFAULT_CAPACITY;
        if (minCapacity > midExpend){
            ensureExplicitCapacity(minCapacity);
        }
    }

    private void ensureCapacityIntenal(int minCapacity){
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity){
        modCount++;//list结构被改变的次数

        //当目标容量大于当前容量时才增长
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    //数组可分配的最大容量，有些虚拟机中会给数组保留头部，尝试分配更大的数组会导致内存溢出
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    //提升容量，确保它可以存储指定参数个元素
    private void grow(int minCapacity){
        int oldCapacity = elementData.length;
        //增加原来容量的一般（右移一位相当于除以2）
        //使用移位运算符效率更高
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - oldCapacity < 0)
            newCapacity = oldCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        //返回一个内容为原数组元素，大小为新容量的数组赋值给elementData
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity){
        if (minCapacity < 0)//overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 若列表中包含该元素时就返回true
     * @param o
     * @return
     */
    public boolean contains(Object o){
        return indexOf(o) >= 0;
    }

    /**
     * 通过遍历elementData数组来判断对象是否存在于list中，若存在，返回首次出现的index(0, size-1)
     * 若不存在，返回-1
     * 所以contains方法可以通过indexOf（Object）方法的返回值来判断对象是否被包含在list中
     * @param o
     * @return
     */
    public int indexOf(Object o){
        if (o == null){
            for (int i = 0; i < size; i++)
                if (elementData[i] == null)
                    return i;
        }else{
            for (int i = 0; i < size; i++)
                if (elementData[i].equals(o))
                    return i;
        }
        return -1;
    }

    /**
     * 返回的是传入对象在elementData数组中最后出现的index值，没有则是-1
     * @param o
     * @return
     */
    public int lastIndexOf(Object o){
        if (o == null){
            for (int i = size - 1; i > 0; i--)
                if (elementData[i] == null)
                    return i;
        }else{
            for (int i = size - 1; i > 0; i--)
                if (elementData[i].equals(o))
                    return i;
        }
        return -1;
    }

    /**
     * 返回ArrayList实例的浅表副本
     * @return
     */
    public Object clone(){
        try{
            //调用父类的clone方法返回一个对象的副本
            ArrayList<?> v = (ArrayList<?>) super.clone();
            //将返回对象的elementData数组的内容赋值为原对象elementData数组的内容
            v.elementData = Arrays.copyOf(elementData, size);
            //将副本的modCount设置为0
            v.modCount = 0;
            return v;

        }catch (CloneNotSupportedException e){
            throw new InternalError(e);
        }
    }
    //返回一个包含列表中所有元素的数组
    //返回的数组是一个安全的数组，即没有列表中的引用，是一个全新申请的数组
    public Object[] toArray(){
        return Arrays.copyOf(elementData, size);
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a){
        //如果传入的数组长度小于size，返回一个新的数组，大小为size，类型与原来相同
        if (a.length < size)
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        //否则，将elementData复制到传入数组，并返回传入数组
        System.arraycopy(elementData, 0, a, 0, size);
        //若传入数组长度大于size，把返回数组的第size个元素置为空
        if (a.length > size)
            a[size] = null;
        return a;

    }

    E elementData(int index){
        return (E) elementData[index];
    }

    /**
     * 返回指定位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        //范围检查
        rangeCheck(index);
        return elementData(index);
    }

    /**
     * 将列表中指定位置的元素替换为指定元素，并返回原先位置的元素
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element){
        rangeCheck(index);

        //简单的替换步骤
        //E oldValue = (E)elementData[index];
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;

    }

    //在列表尾部添加一个元素，容量的扩展将导致数组元素的复制，多次扩展将执行多次整个数组内容的复制
    //若能提前判断list的长度，调用ensureCapacity调整容量，将有效的提高运行速度
    public boolean add(E e){
        ensureCapacityIntenal(size + 1);//Increments modCount
        elementData[size++] = e;
        return true;
    }

    /**
     * 在指定位置插入元素，当前位置原元素及所有后继元素向右移动一个位置
     * @param index
     * @param element
     */

    public void add(int index, E element){
        //判断指定位置index是否超出elementData的界限
        rangeCheckForAdd(index);
        ensureCapacityIntenal(size + 1);
        //调用System.arrayCopy将elementData从index开始到size结束的size-index（长度）个元素复制到index+1至size+1的位置
        //即将从index开始的元素都往后移动一个位置，然后将index位置的值指向element。
        System.arraycopy(elementData, index, elementData, index+1, size-index);
        elementData[index] = element;
        size++;
    }

    private void rangeCheck(int index){
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * 删除指定位置的元素，将后继元素向前移动一个位置
     * @param index
     * @return
     */
    public E remove(int index){
        rangeCheck(index);
        modCount++;
        //保留要被移除的元素
        E oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            //将移除位置之后的元素向前挪动一个位置
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        //将list末尾元素置null
        elementData[--size] = null;
        //返回被移除的元素
        return oldValue;
    }

    /**
     * 删除首次出现在列表中的元素，如果不包含该元素，则不作变化
     * @param o
     * @return
     */
    public boolean remove(Object o){
        if (o == null){
            for (int i = 0; i < size; i++){
                if (elementData[i] == null)
                {
                    fastRemove(i);
                    return true;
                }
            }
        }else{
            for (int i = 0; i < size; i++){
                if (o.equals(elementData[i])){
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 跳过边界检查也不删除值的删除函数
     * @param index
     */
    private void fastRemove(int index){
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        elementData[--size] = null;//clear to let GC do its work
    }

    /**
     * 清空列表中所有元素，操作后列表为空
     */
    public void clear(){
        modCount++;
        //clear to let GC do its work
        for (int i = 0; i < size; i++){
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * 将指定集合中的所有元素都添加到列表末尾，以其迭代器返回的顺序添加
     * !!该操作在多线程情况下行为未定义，需要外部同步
     * @param c
     * @return
     */
    public boolean addAll(Collection<? extends E> c){
        //先集合C转换为数组
        Object[] a = c.toArray();
        //得到数组的长度
        int numNew = a.length;
        //将该数组复制到列表的尾部
        if (numNew > 0)
            System.arraycopy(a, 0, elementData, size, numNew);
        //size实时更新
        size += numNew;
        //只要集合c的大小不为空，即转换后数组长度不为0则返回true
        return numNew != 0;
    }

    /**
     * 将指定集合c中所有元素添加到以index开头的位置中，将当前元素及所有
     * 后继元素向后移动，新元素的顺序以迭代器返回的顺序为准
     * @param index
     * @param c
     * @return
     */
    public boolean addAll(int index, Collection<? extends E> c){
        //检查是否越界
        rangeCheckForAdd(index);
        Object[] a = c.toArray();
        int numNew = a.length;
        //Increments modCount
        ensureCapacityIntenal(size + numNew);
        int numMoved = size - index;
        //先将index开始的元素向后移动numNew（c转换为数组后的长度）个位置（也是一个复制的过程）
        //也是为后面的插入留下空间
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + numNew, numMoved);
        //将数组内容复制到elementData的index到index+numNew
        System.arraycopy(a, 0, elementData, index, numNew);
        //更新size
        size += numNew;
        return numNew != 0;
    }

    protected void removeRange(int fromIndex, int toIndex){
        modCount++;
        int numMoved = size - toIndex;
        if (numMoved > 0)
            System.arraycopy(elementData, toIndex, elementData, fromIndex, numMoved);
        //移除元素后，列表应该的容量
        int newSize = size - (toIndex - fromIndex);
        //将toIndex后的元素置为null，让垃圾收集器进行回收工作
        for (int i = newSize; i < size; i++)
            elementData[i] = null;

        size = newSize;
    }

    private void rangeCheckForAdd(int index){
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index){
        return "Index: " + index + ", Size: " + size;
    }

    public boolean removeAll(Collection<?> c){
        //当传入的参数不为null时，返回参数本身，反之抛出NullPointException异常
        Objects.requireNonNull(c);
        return batchRemove(c, false);
    }

    public boolean retainAll(Collection<?> c){
        Objects.requireNonNull(c);
        return batchRemove(c, true);
    }

    /**
     * ???
     * 批量删除
     * complement为false，则为删除列表中出现在集合c中的元素
     * complement为true，则为删除列表中未出现在集合c中的元素
     */
    private boolean batchRemove(Collection<?> c, boolean complement){
        final Object[] elementData = this.elementData;
        int r = 0, w = 0;//w代表批量删除后，还剩多少元素
        boolean modified = false;
        try{
            //高效保存两个结合公有元素的算法
            for (; r < size; r++)
                if (c.contains(elementData[r]) == complement)
                    elementData[w++] = elementData[r];
        }finally {
            if (r != size){
                System.arraycopy(elementData, r, elementData, w, size-r);
                w += size - r;
            }
            if (w != size){
                for (int i = w; i < size; i++){
                    elementData[i] = null;
                }
                modCount += size - w;
                size = w;
                modified = true;
            }
        }
        return modified;
    }
}
