package com.clutterbunny.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DummyScheduler {
	
	@Scheduled(fixedDelay=60*60*1000)
	public void generateBill() {
		
	}

}
