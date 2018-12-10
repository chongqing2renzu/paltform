package com.personal.banner.service;

import com.personal.banner.domain.BannerDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wb
 * @email 1992lcg@163.com
 * @date 2018-12-10 16:17:42
 */
public interface BannerService {
	
	BannerDO get(Integer id);
	
	List<BannerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BannerDO banner);
	
	int update(BannerDO banner);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
