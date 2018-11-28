package com.personal.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.personal.common.domain.LogDO;
import com.personal.common.domain.PageDO;
import com.personal.common.utils.Query;
@Service
public interface LogService {
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
