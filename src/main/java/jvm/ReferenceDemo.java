package jvm;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 引用demo
 * @author yinyg
 * @date 2022/8/28
 */
public class ReferenceDemo {

    @Test
    public void softRefrenceDemo() {
        Integer i = 1;
        System.out.println(i);
        SoftReference<Integer> softReference = new SoftReference<>(i);
        i = null;
        System.out.println(i);
        System.out.println(softReference.get());
        i = softReference.get();
        System.out.println(i);
    }

    @Test
    public void phantomRefrenceDemo() {
        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj, referenceQueue);
        obj = null;
        System.gc();
        System.out.println(phantomReference.get());
        Reference<Object> reference = null;
        try {
            reference = (Reference<Object>) referenceQueue.remove(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(reference);
    }

}
