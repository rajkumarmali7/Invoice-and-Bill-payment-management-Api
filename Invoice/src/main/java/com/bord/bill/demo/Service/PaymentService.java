package com.bord.bill.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bord.bill.demo.Entity.Bill;
import com.bord.bill.demo.Entity.Payment;
import com.bord.bill.demo.Entity.PaymentHistory;
import com.bord.bill.demo.Exception.CustomException;
import com.bord.bill.demo.Repository.BillRepository;
import com.bord.bill.demo.Repository.PaymentHistoryRepository;
import com.bord.bill.demo.Repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	PaymentHistoryRepository paymentHistoryRepository;

	@Autowired
	BillRepository billRepository;

	
	public Payment boardPayment(Payment payment) {

		Bill bill = billRepository.findById(payment.getBillNo()).orElse(null);
		Payment payment2 = paymentRepository.findById(payment.getPaymentid()).orElse(null);

		Payment payment3 = null;
		if (payment2!=null&&(payment2.getPending() - payment.getRecivedamounts()) < 0) {
//			System.out.println("your amount is"+(payment2.getPending() - payment2.getRecivedamounts()));
			throw new CustomException("your money  is extra to panding, eg "+(payment2.getPending() - payment.getRecivedamounts()));
		} else {

			if (payment2 == null) {
				Payment paymentsave = new Payment();
				PaymentHistory paymentHistorysave = new PaymentHistory();

				paymentsave.setPaymentid(payment.getPaymentid());
				paymentsave.setBillNo(payment.getBillNo());
				paymentsave.setDate(payment.getDate());
				paymentsave.setPaymentboard(payment.getPaymentboard());
				paymentsave.setRecivedamounts(payment.getRecivedamounts());
				paymentsave.setRemarks(payment.getRemarks());
				paymentsave.setTotalrecivedamounts(payment.getRecivedamounts());
				paymentsave.setPending(bill.getAmount() - payment.getRecivedamounts());

				paymentHistorysave.setBillNo(payment.getBillNo());
				paymentHistorysave.setDate(payment.getDate());
				paymentHistorysave.setPaymentboard(payment.getPaymentboard());
				paymentHistorysave.setRecivedamounts(payment.getRecivedamounts());
				paymentHistorysave.setRemarks(payment.getRemarks());
				paymentHistorysave.setTotalrecivedamounts(payment.getRecivedamounts());
				paymentHistorysave.setPending(bill.getAmount() - payment.getRecivedamounts());

				payment3 = paymentRepository.save(paymentsave);
				paymentHistoryRepository.save(paymentHistorysave);
			} else {
				PaymentHistory paymentHistorysave = new PaymentHistory();

				Payment paymentsave = new Payment();
				paymentsave.setPaymentid(payment.getPaymentid());
				paymentsave.setBillNo(payment.getBillNo());
				paymentsave.setDate(payment.getDate());
				paymentsave.setPaymentboard(payment.getPaymentboard());
				paymentsave.setRecivedamounts(payment.getRecivedamounts());
				paymentsave.setRemarks(payment.getRemarks());
				paymentsave.setTotalrecivedamounts(payment2.getTotalrecivedamounts() + payment.getRecivedamounts());
				paymentsave.setPending(payment2.getPending() - payment.getRecivedamounts());

				paymentHistorysave.setBillNo(payment.getBillNo());
				paymentHistorysave.setDate(payment.getDate());
				paymentHistorysave.setPaymentboard(payment.getPaymentboard());
				paymentHistorysave.setRecivedamounts(payment.getRecivedamounts());
				paymentHistorysave.setRemarks(payment.getRemarks());
				paymentHistorysave.setTotalrecivedamounts(payment2.getTotalrecivedamounts() + payment.getRecivedamounts());
				paymentHistorysave.setPending(payment2.getPending() - payment.getRecivedamounts());

				payment3 = paymentRepository.save(paymentsave);
				paymentHistoryRepository.save(paymentHistorysave);
			}


		}
		
		return payment3;

	}

}
