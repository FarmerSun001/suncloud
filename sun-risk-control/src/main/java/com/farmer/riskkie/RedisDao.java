package com.farmer.riskkie;


import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.StaticScriptSource;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import javax.annotation.Priority;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName:
 * @Desc:
 * @Author: Sunzhigang
 * @Date: 2019/10/11 11:35
 */
@Repository
public class RedisDao {

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    private DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();

    /**
     * 将脚本 script 添加到脚本缓存中，但并不立即执行这个脚本
     *
     * @param script
     * @return
     */
    public String scriptLoad(final String script) {

        return "init";
    }


    /**
     * 对 Lua 脚本进行求值
     *
     * @param args
     * @param <T>
     * @return
     */
    public <T> T evalsha(String script,List<String> keyList, String remMaxScore, String expire, String score, String value, String queryMinScore, String queryMaxScore) {


        // 每个键的失效时间为20秒
//        redisScript.setScriptSource(new StaticScriptSource(script));
        redisScript.setScriptText(script);
        redisScript.setResultType(Long.class);
        return (T) stringRedisTemplate.execute(redisScript, keyList, remMaxScore, expire, score, value, queryMinScore, queryMaxScore);


      /*  return (T) redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                return ((Jedis) connection.getNativeConnection()).evalsha(sha, keycount, args);
            }
        });*/
    }
}
