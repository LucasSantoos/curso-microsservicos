package com.santos.hrpayroll.services;

import com.santos.hrpayroll.entities.Payment;
import com.santos.hrpayroll.entities.Worker;
import com.santos.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		if (worker == null) {
			return null;
		}
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
