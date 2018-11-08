package com.zwx.Jedis_demo;

import com.zwx.Jedis_demo.utils.CacheUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisDemoApplicationTests {

	@Autowired
	CacheUtil cacheUtil;

	/**
	*@Auther z
	*@Date 2018-11-08 10:17
	*@Describe 字符串写入缓存，过期时间30秒，每隔3秒取一次
	*/
	@Test
	public void testCache() {
		cacheUtil.cacheNxExpire("1","1",30);
        try {
            int i=0;
            while(i != i + 1){
                Thread.sleep(3000);
                System.out.println(cacheUtil.getCacheValue("1"));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
