package kr.co.goodee39.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.goodee39.mapper.MapperInterface;
import kr.co.goodee39.vo.DataVO1;

@Controller
public class TestController {
	
	@Autowired
	MapperInterface mapper1;
	
	@Autowired
	DataSourceTransactionManager transactionManager;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	@GetMapping("/input_data")
	public String inputData(DataVO1 vo1) {
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String inputPro(DataVO1 vo1) {
		mapper1.insertData(vo1);
		return "input_pro";
	}
	
	@GetMapping("/read_data")
	public String readData(Model model) {
//		List<DataVO1> list = mapper1.selectDataList();
//		model.addAttribute("list",list);
		
		model.addAttribute("list",mapper1.selectDataList());
		return "read_data";
	}
	
	@GetMapping("/tx_data1")
	public String txData1(Model model) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = this.transactionManager.getTransaction(def);
		try {
			DataVO1 vo1 = new DataVO1();
			DataVO1 vo2 = new DataVO1();
			vo1.setColumn1("가가가");
			vo1.setColumn2("나나나");
			vo1.setColumn3("다다다");
			vo2.setColumn1("가가가");
			vo2.setColumn2("나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나");
			vo2.setColumn3("다다다");
			mapper1.insertData(vo1);
			mapper1.insertData(vo2);
			this.transactionManager.commit(status);
		} catch (Exception e) {
			this.transactionManager.rollback(status);
		}
		
		return "tx_data1";
	}
	
	@GetMapping("/tx_data2")
	public String txData2() {
		try {
			this.transactionTemplate.execute(
				new TransactionCallbackWithoutResult() {
					@Override
					protected void doInTransactionWithoutResult(TransactionStatus status) {
						DataVO1 vo1 = new DataVO1();
						DataVO1 vo2 = new DataVO1();
						vo1.setColumn1("가가가");
						vo1.setColumn2("나나나");
						vo1.setColumn3("다다다");
						vo2.setColumn1("가가가");
						vo2.setColumn2("나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나");
						vo2.setColumn3("다다다");
						mapper1.insertData(vo1);
						mapper1.insertData(vo2);
					}
				});
		}catch(Exception e) {
			
		}
		
		return "tx_data2";
	}
}

















