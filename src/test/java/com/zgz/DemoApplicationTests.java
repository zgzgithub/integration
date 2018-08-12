package com.zgz;

import com.zgz.mapper.test1.Test1;
import com.zgz.mapper.test2.Test2;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private Test1 test;
	@Autowired
	private Test2 test2;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate redisTemplate;
	@Test
	public void contextLoads() {
	}
	@Test
	public void dataSource(){
		com.zgz.pojo.Test1 test1= new com.zgz.pojo.Test1() ;
		test1.setAge(16);
		test.save(test1);
	}

	@Test
	public void test2(){
		com.zgz.pojo.Test2 test= new com.zgz.pojo.Test2() ;
		test.setName("zgz");
		test2.save(test);
	}
	@Test
	public void TestRedis1(){
		ValueOperations<String,String> operations= stringRedisTemplate.opsForValue();
		operations.set("test3","dd");
	}
	@Test
	public void TestRedis2(){
		com.zgz.pojo.Test1 test1= new com.zgz.pojo.Test1() ;
		test1.setAge(16);
		ValueOperations<String, com.zgz.pojo.Test1>  valueOperations=redisTemplate.opsForValue();
//		valueOperations.set("test4",test1);
		System.out.println(valueOperations.get("test4"));
	}


}
