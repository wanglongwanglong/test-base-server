package cn.com.tyyxtech.frame.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sirius on 2018-7-25.
 */
public class EntityUtils {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 单态
     */
    private static EntityUtils manager = new EntityUtils();
    private Map<String, Class> classMap = new HashMap<String, Class>();
    private Map<String, Method> methodMap = new HashMap<String, Method>();
    private Map<String, Field> fieldMap = new HashMap<String, Field>();
    private Map<String, Constructor> constructorMap = new HashMap<String, Constructor>();

    private EntityUtils() {
    }

    public static EntityUtils getManager() {
        return manager;
    }

    /**
     * 获取类名
     *
     * @param className
     * @return
     */
    public Class getClass(String className) {
        try {
            if (classMap.get(className) == null) {
                classMap.put(className, Class.forName(className));
            }
            return classMap.get(className);
        } catch (Exception e) {
            logger.error("获取反射类出错------EntityUtils", e);
        }
        return null;
    }

    /**
     * 获取方法名
     *
     * @param className
     * @param methodName
     * @param args
     * @return
     */
    public Method getMethod(String className, String methodName, Class<?>... args) {
        try {
            int size = 0;
            if (args != null) {
                for (Object o : args) {
                    size++;
                }
            }
            if (methodMap.get(className + "_" + methodName + "_" + size) == null) {
                methodMap.put(className + "_" + methodName + "_" + size, getClass(className).getMethod(methodName, args));
            }
            return methodMap.get(className + "_" + methodName + "_" + size);
        } catch (Exception e) {
            logger.error("获取反射类出错------EntityUtils", e);
        }
        return null;
    }

    /**
     * 获取字段名
     *
     * @param className
     * @param fieldName
     * @return
     */
    public Field getField(String className, String fieldName) {
        try {
            if (fieldMap.get(className + "_" + fieldName) == null) {
                fieldMap.put(className + "_" + fieldName, getClass(className).getDeclaredField(fieldName));
            }
            return fieldMap.get(className + "_" + fieldName);
        } catch (Exception e) {
            logger.error("获取反射类出错------EntityUtils", e);
        }
        return null;
    }


    /**
     * 获取字段名
     *
     * @param className
     * @return
     */
    public Constructor getConstructor(String className, Class<?>... args) {
        try {
            int size = 0;
            if (args != null) {
                for (Object o : args) {
                    size++;
                }
            }
            if (constructorMap.get(className + "_" + size) == null) {
                constructorMap.put(className + "_" + size, getClass(className).getConstructor(args));
            }
            return constructorMap.get(className + "_" + size);
        } catch (Exception e) {
            logger.error("获取反射类出错------EntityUtils", e);
        }
        return null;
    }

    /**
     * 填充实体
     *
     * @param instance
     * @param owner
     * @param updater
     * @param createday
     * @param updateday
     */
    public void fillCommonEntity(Object instance, String owner, String updater, Date createday, Date updateday) {
        try {
            Method setMethod = null;
            if (owner != null) {
                setMethod = this.getMethod(instance.getClass().getName(), "setOwner", String.class);
                setMethod.invoke(instance, owner);
            }
            if (updater != null) {
                setMethod = this.getMethod(instance.getClass().getName(), "setUpdater", String.class);
                setMethod.invoke(instance, updater);
            }
            if (createday != null) {
                if(instance.getClass().getMethod("getCreateday").getReturnType()==String.class){
                    setMethod = this.getMethod(instance.getClass().getName(), "setCreateday", String.class);
                    setMethod.invoke(instance, DateUtils.format(createday,DateUtils.DATE_TIME_PATTERN));
                }else {
                    setMethod = this.getMethod(instance.getClass().getName(), "setCreateday", Date.class);
                    setMethod.invoke(instance, createday);
                }
            }
            if (updateday != null) {
                if(instance.getClass().getMethod("getUpdateday").getReturnType()==String.class) {
                    setMethod = this.getMethod(instance.getClass().getName(), "setUpdateday", String.class);
                    setMethod.invoke(instance, DateUtils.format(updateday,DateUtils.DATE_TIME_PATTERN));
                }else{
                    setMethod = this.getMethod(instance.getClass().getName(), "setUpdateday", Date.class);
                    setMethod.invoke(instance, updateday);
                }
            }
        } catch (Exception e) {
            logger.error("填充实体错误------EntityUtils", e);
        }
    }


}
