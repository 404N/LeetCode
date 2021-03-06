import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;



public class Test {
    /***放置创建好的beanMap*/
    private static Map<String, Object> cacheMap = new HashMap<>(2);

    public enum Type{
        //测试
        TYPE_A,
        //2
        TYPE_B,
    }

    public static void main(String[] args) {
        //假装扫描出来的对象
        Class[] classes = {A.class, B.class};
        //假装项目初始化实例化所有bean
        for (Class aClass : classes) {
            getBean(aClass);
        }//check
        System.out.println(getBean(B.class).getA() == getBean(A.class));
        System.out.println(getBean(A.class).getB() == getBean(B.class));
    }

    @SneakyThrows
    private static <T> T getBean(Class<T> beanClass) {        // 本文用类名小写 简单代替bean的命名规则
        String beanName = beanClass.getSimpleName().toLowerCase();
        // 如果已经是一个bean，则直接返回
        if (cacheMap.containsKey(beanName)) {
            return (T) cacheMap.get(beanName);
        }
        //将对象本身实例化
        Object object = new Object();
        try {
            object = beanClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // 放入缓存
        cacheMap.put(beanName, object);
        // 把所有字段当成需要注入的bean，创建并注入到当前bean中
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // 获取需要注入字段的class
            Class<?> fieldClass = field.getType();
            String fieldBeanName = fieldClass.getSimpleName().toLowerCase();
            // 如果需要注入的bean，已经在缓存Map中，那么把缓存Map中的值注入到该field即可
            // 如果缓存没有 继续创建
            try {
                field.set(object, cacheMap.containsKey(fieldBeanName) ? cacheMap.get(fieldBeanName) : getBean(fieldClass));

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }        // 属性填充完成，返回
        return (T) object;
    }

}

