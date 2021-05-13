package com.gouxy.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

public class RData extends HashMap implements Map {

    private static final long serialVersionUID = 1L;

    Map map = null;
    HttpServletRequest request;
    public RData(HttpServletRequest request){
        this.request = request;
        // 以键值对的形式获取页面提交的参数(键为String,值为String类型数组)
        // 将request.getParameterMap()转化成可操作的普通类
        Map properties = request.getParameterMap();
        Map returnMap = new HashMap();
        // properties.entrySet() 把(key-value)作为一个整体一对一对的存放在Set集合中
        // 通过 .iterator() 迭代器将数据以（key-value）形式取出
        Iterator entries = properties.entrySet().iterator();
        // Entry 是Map声明的一个内部接口类，此接口为广泛，定义为Entry。它表示Map中的一个实体（一个key-value对），含有 getKey(),getValue()。getKey()返回条目、getValue()返回条目的值
        Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            //  instanceof 为java关键字，严格来说是一个双目运算，用来判断一个对象是否为一个类的实例
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        map = returnMap;
    }

    public RData() {
        map = new HashMap();
    }

    @Override
    public Object get(Object key) {
        Object obj = null;
        if(map.get(key) instanceof Object[]) {
            Object[] arr = (Object[])map.get(key);
            obj = request == null ? arr:(request.getParameter((String)key) == null ? arr:arr[0]);
        } else {
            obj = map.get(key);
        }
        return obj;
    }

    public String getString(Object key) {
        return (String)get(key);
    }
    
    public int getInt(Object key) {
    	return Integer.valueOf(get(key).toString());
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object put(Object key, Object value) {
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    public Set entrySet() {
        return map.entrySet();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public Set keySet() {
        return map.keySet();
    }

    @SuppressWarnings("unchecked")
    public void putAll(Map t) {
        map.putAll(t);
    }

    public int size() {
        return map.size();
    }

    public Collection values() {
        return map.values();
    }
}
