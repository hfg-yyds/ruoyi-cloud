package com.ruoyi.common.redis.configure;

import java.nio.charset.StandardCharsets;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;

/**
 * Redis使用FastJson序列化
 *
 * @author ruoyi
 */
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {

    /**
     * 类对象
     */
    private final Class<T> clazz;

    /**
     * 构造器
     * @param clazz clazz
     */
    public FastJson2JsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    /**
     * 将给定的对象序列化为二进制数据。
     * @param t 要序列化的对象 可以为空
     * @return 等价的二进制数据。可以为空。
     * @throws SerializationException s
     */
    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONString(t, JSONWriter.Feature.WriteClassName).getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 从给定的二进制数据反序列化一个对象
     * @param bytes 字节对象二进制表示
     * @return 等效的对象实例。可以为空
     * @throws SerializationException s
     */
    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, StandardCharsets.UTF_8);
        return JSON.parseObject(str, clazz, JSONReader.Feature.SupportAutoType);
    }

}
