package com.nuc.device.util;

import java.util.*;

/**
 * Created by guoqiang on 2015/06/02.
 */
public final class CollectionsTools {

    public static <T> ArrayList<T> createSameSize(Collection collection) {
        return new ArrayList<T>(size(collection));
    }

    public static void removeEmptyValue(Map map) {
        if (isNotEmpty(map)) {
            for (Object key : new HashSet<Object>(map.keySet())) {
                Object value = map.get(key);
                if (value == null) {
                    map.remove(key);
                } else if (value instanceof String && StringTools.isEmpty(value.toString())) {
                    map.remove(key);
                }
            }
        }
    }

    public static void removeNullValue(Map map) {
        if (isNotEmpty(map)) {
            for (Object key : new HashSet<Object>(map.keySet())) {
                if (map.get(key) == null) {
                    map.remove(key);
                }
            }
        }
    }

    public static <T, O> Set<T> getSet(FieldGetter<T, O> fieldGetter, O... arr) {
        if (isEmpty(arr))
            return new HashSet<T>(0);
        Set<T> set = new HashSet<T>(arr.length);
        for (O o : arr) {
            set.add(fieldGetter.getFiled(o));
        }
        return set;
    }

    public static <T, O> List<T> getList(List<O> arr, FieldGetter<T, O> fieldGetter) {
        if (isEmpty(arr))
            return new ArrayList<T>(0);
        List<T> list = new ArrayList<T>(arr.size());
        for (O o : arr) {
            list.add(fieldGetter.getFiled(o));
        }
        return list;
    }

    public static <T, O> Set<T> getSet(List<O> arr, FieldGetter<T, O> fieldGetter) {
        if (isEmpty(arr))
            return new HashSet<T>(0);
        Set<T> set = new HashSet<T>(arr.size());
        for (O o : arr) {
            set.add(fieldGetter.getFiled(o));
        }
        return set;
    }

    public static <T> Set<T> createSet(T... arr) {
        if (isEmpty(arr))
            return new HashSet<T>(0);
        Set<T> set = new HashSet<T>(arr.length);
        for (T t : arr) {
            set.add(t);
        }
        return set;
    }

    /**
     * 从olds中获取o的新数据n并插入到news中
     *
     * @param olds
     * @param news
     * @param fieldGetter
     * @param <N>
     * @param <O>
     */
    public static <N, O> void findAndAddNotNull(Collection<O> olds, Collection<N> news, FieldGetter<N, O> fieldGetter) {
        if (isNotEmpty(olds)) {
            for (O o : olds) {
                N n = fieldGetter.getFiled(o);
                if (n != null) {
                    news.add(n);
                }
            }
        }
    }

    /**
     * 判断是否全部符合数据要求
     *
     * @param collection
     * @param judgeable
     * @param <E>
     * @return
     */
    public static <E> boolean all(Collection<E> collection, Judgeable<E> judgeable) {
        if (isNotEmpty(collection)) {
            int index = 0;
            for (E e : collection) {
                if (!judgeable.judge(e, index++, collection)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 判断是否包含符合要求的数据
     *
     * @param collection
     * @param judgeable
     * @param <E>
     * @return
     */
    public static <E> boolean any(Collection<E> collection, Judgeable<E> judgeable) {
        if (isNotEmpty(collection)) {
            int index = 0;
            for (E e : collection) {
                if (judgeable.judge(e, index++, collection)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 找到第一个符合要求的数据返回
     *
     * @param collection
     * @param judgeable
     * @param <E>
     * @return
     */
    public static <E> E findOne(Collection<E> collection, Judgeable<E> judgeable) {
        if (isNotEmpty(collection)) {
            int index = 0;
            for (E e : collection) {
                if (judgeable.judge(e, index++, collection)) {
                    return e;
                }
            }
        }
        return null;
    }

    /**
     * 找到所有符合要求的数据
     *
     * @param collection
     * @param returnObj
     * @param judgeable
     * @param <E>
     * @return
     */
    public static <E> Collection<E> findAll(Collection<E> collection, Collection<E> returnObj, Judgeable<E> judgeable) {
        if (isNotEmpty(collection)) {
            int index = 0;
            for (E e : collection) {
                if (judgeable.judge(e, index++, collection)) {
                    returnObj.add(e);
                }
            }
        }
        return returnObj;
    }

    /**
     * 根据Collection的数据生成一个新的map
     *
     * @param collection
     * @param getter
     * @param <K>
     * @param <V>
     * @param <O>
     * @return
     */
    public static <K, V, O> Map<K, V> getMap(O[] collection, KeyAndValueGetter<K, V, O> getter) {
        if (isEmpty(collection)) {
            return new HashMap<K, V>(0);
        }
        HashMap<K, V> map = new HashMap<K, V>(collection.length);
        for (O o : collection) {
            map.put(getter.getKey(o), getter.getValue(o));
        }

        return map;
    }

    /**
     * 根据Collection的数据生成一个新的map
     *
     * @param collection
     * @param getter
     * @param <K>
     * @param <V>
     * @param <O>
     * @return
     */
    public static <K, V, O> Map<K, V> getMap(Collection<O> collection, KeyAndValueGetter<K, V, O> getter) {
        if (isEmpty(collection)) {
            return new HashMap<K, V>(0);
        }
        HashMap<K, V> map = new HashMap<K, V>(collection.size());
        for (O o : collection) {
            map.put(getter.getKey(o), getter.getValue(o));
        }

        return map;
    }

    /**
     * 翻转map,key 和 value 互换位置
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> reversal(Map<V, K> map) {
        if (isEmpty(map)) {
            return new HashMap<K, V>(0);
        }
        Map<K, V> newMap = new HashMap<K, V>(map.size());
        for (Map.Entry<V, K> entry : map.entrySet()) {
            newMap.put(entry.getValue(), entry.getKey());
        }
        return newMap;
    }

    /**
     * 根据参数创建一个map Key 是string类型
     *
     * @param objects
     * @return
     */
    public static Map<String,Object> createMapSO(Object... objects) {
        if (objects == null) {
            return new HashMap<String,Object>(0);
        }
        Map<String,Object> map = new HashMap<String,Object>((objects.length + 1) / 2);
        for (int i = 0; i < objects.length; i += 2) {
            Object key = objects[i];
            Object value = null;
            if (objects.length > i + 1) {
                value = objects[i + 1];
            }
            if(key == null){
                map.put(null, value);
            }else if(key instanceof String){
                map.put((String)key, value);
            }else{
                throw new ClassCastException(key.getClass() + " can not cast to be String");
            }
        }
        return map;
    }

    /**
     * 根据参数创建一个map
     *
     * @param objects
     * @return
     */
    public static Map createMapNoCheck(Object... objects) {
        if (objects == null) {
            return new HashMap(0);
        }
        Map map = new HashMap((objects.length + 1) / 2);
        for (int i = 0; i < objects.length; i += 2) {
            Object key = objects[i];
            Object value = null;
            if (objects.length > i + 1) {
                value = objects[i + 1];
            }
            map.put(key, value);
        }
        return map;
    }

    /**
     * 根据类型和参数创建一个map
     * 如果类型不匹配则抛出异常
     *
     * @param objects
     * @return
     */
    public static <K, V> Map<K, V> createMapCheck(Class<K> keyType, Class<V> valueType, Object... objects) {
        if (objects == null) {
            return new HashMap<K, V>();
        }
        Map<K, V> map = new HashMap<K, V>((objects.length + 1) / 2);
        for (int i = 0; i < objects.length; i += 2) {
            Object key = objects[i];
            Object value = null;
            if (objects.length > i + 1) {
                value = objects[i + 1];
            }

            if (key != null && !keyType.isAssignableFrom(key.getClass())) {
                throw new ClassCastException(key.getClass() + " can not cast to be " + keyType);
            } else if (value != null && !valueType.isAssignableFrom(value.getClass())) {
                throw new ClassCastException(value.getClass() + " can not cast to be " + valueType);
            }
            map.put((K) key, (V) value);
        }
        return map;
    }

    public static <T> void each(Collection<T> collection, Eachable<T> eachable) {
        if (isNotEmpty(collection)) {
            int index = 0;
            for (T t : collection) {
                eachable.each(t, index++, collection);
            }
        }
    }

    public static <T> List<List<T>> groupByListCount(List<T> oldList, int count) {
        if (count < 1) {
            throw new IllegalArgumentException("num < 1");
        }
        List<List<T>> result = new ArrayList<List<T>>(count);
        int size = oldList.size() / count;
        int p = oldList.size() % count;
        int idx = 0;
        for (int i = 0; i < count; i++) {
            int endIndex = idx + size;
            if (i < p) {
                endIndex++;
            }
            endIndex = Math.min(endIndex, oldList.size());
            List<T> list = oldList.subList(idx, endIndex);
            idx = endIndex;
            result.add(list);
        }
        return result;
    }

    /**
     * 分组
     *
     * @param oldList
     * @param count
     * @return
     */
    public static <T> List<List<T>> groupByElementCount(List<T> oldList, int count) {
        if (count < 1) {
            throw new IllegalArgumentException("count < 1");
        }
        List<List<T>> lists = new ArrayList<List<T>>((oldList.size() / count) + 1);
        for (int i = 0; i < oldList.size(); i += count) {
            lists.add(oldList.subList(i, Math.min(i + count, oldList.size())));
        }
        return lists;
    }

    public static <K, V> void putNotEmpty(Map<K, V> map, K field, V obj) {
        if (obj == null) {
            return;
        } else if (obj instanceof String && StringTools.isEmpty(obj.toString())) {
            return;
        }
        map.put(field, obj);
    }

    public static int size(Collection collection) {
        if (collection != null) {
            return collection.size();
        }
        return 0;
    }

    public static int size(Map map) {
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    /**
     * 键 值 获取器
     *
     * @param <K>
     * @param <V>
     * @param <O>
     */
    public static interface KeyAndValueGetter<K, V, O> {
        public K getKey(O o);

        public V getValue(O o);
    }

    public static interface Eachable<T> {
        public void each(T t, int index, Collection<T> collection);
    }

    public static interface FieldGetter<F, O> {
        public F getFiled(O o);
    }

    public static Map emptyMap() {
        return new HashMap(0);
    }

    public static List emptyList() {
        return new ArrayList(0);
    }

    public static Set emptySet() {
        return new HashSet(0);
    }

    /**
     * 判断器
     *
     * @param <E>
     */
    public static interface Judgeable<E> {
        public boolean judge(E e, int index, Collection<E> collection);
    }

    public static <O> boolean isEmpty(O[] arrays) {
        return arrays == null || arrays.length == 0;
    }

    public static <O> boolean isNotEmpty(O[] arrays) {
        return !isEmpty(arrays);
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    private CollectionsTools() {

    }
}
