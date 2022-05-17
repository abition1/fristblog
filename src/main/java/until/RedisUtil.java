package until;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * redis 工具类
 * @Author Ltx
 *
 */
@Component
public class RedisUtil {
	private static RedisTemplate<String, Object> redisTemplates;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@PostConstruct
	public void initialize() {
		redisTemplates = this.redisTemplate;
	}


// ============================String=============================	

/**
	 * 普通缓存获取
	 * 
	 * @param key 键
	 * @return 值
	 */
	public Object get(String key) {
		return key == null ? null : redisTemplates.opsForValue().get(key);
	}


	public  Object getkey(String key){

		return  redisTemplates.opsForHash().get(key,"view");
	}
	/**
	 * 普通缓存放入
	 * 
	 * @param key   键
	 * @param value 值
	 * @return true成功 false失败
	 */
	public boolean set(String key, Object value) {
		try {
			redisTemplates.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	//自定义redis的set方法来去存view
	public  Long setview(String key,int value,int a){


		return 	redisTemplates.opsForHash().increment(key,value,a);


	}


	/**
	 * 普通缓存放入并设置时间
	 * 
	 * @param key   键
	 * @param value 值
	 * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
	 * @return true成功 false 失败
	 */
	public boolean set(String key, Object value, long time) {
		try {
			if (time > 0) {
				redisTemplates.opsForValue().set(key, value, time, TimeUnit.SECONDS);
			} else {
				set(key, value);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}