package com.gac.ywl.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @title Util.java
 * @package com.gac.footprint.base.utils
 * @description  {}
 * @author gacmy
 * @date 2018/6/16 0016
 *
 */
public class Util {
    /**
     * 判断对象是否为空
     *
     * @param object 当前对象
     * @return true:为空 false:不为空
     */
    public static boolean isEmpty(Object object) {
        if (object == null)
            return true;
        if (object instanceof CharSequence)
            return ((CharSequence) object).length() == 0;
        if (object instanceof Collection)
            return ((Collection<?>) object).isEmpty();
        if (object instanceof Map)
            return ((Map<?,?>) object).isEmpty();
        if (object.getClass().isArray())
            return java.lang.reflect.Array.getLength(object) == 0;
        return false;
    }

    /**
     * 判断对象是否不为空
     *
     * @param object 当前对象
     * @return true:不为空 false:为空
     */
    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }
}
