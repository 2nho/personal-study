package kr.co.goodee39.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;

import kr.co.goodee39.vo.DataVO1;

@Service
public class TestService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	DataSourceTransactionManager transactionManager;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	public void setData(DataVO1 vo1) {
		sqlSessionTemplate.insert("springsample.insertSample", vo1);
	}
	
	public void getData(Model model) {
		model.addAttribute("list", sqlSessionTemplate.selectList("springsample.selectSample"));
	}
	
	public void txData1(Model model) {
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
			sqlSessionTemplate.insert("springsample.insertSample", vo1);
			sqlSessionTemplate.insert("springsample.insertSample", vo2);
			this.transactionManager.commit(status);
		} catch (Exception e) {
			this.transactionManager.rollback(status);
		}
	}
	
	public void txData2(Model model) {
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
						sqlSessionTemplate.insert("springsample.insertSample", vo1);
						sqlSessionTemplate.insert("springsample.insertSample", vo2);
					}
				});
		}catch(Exception e) {
			
		}
	}
	
	@Transactional
	// 1. @Transactional은 public 메소드에서만 정상 작동한다.
	// 2. @Transactional 을 달아놓은 메서드가 동일한 클래스 내의 다른 메소드에 의해 호출당하면 트랜잭션은 정상 작동하지 않는다.
	public void txData3(Model model) {
		DataVO1 vo1 = new DataVO1();
		DataVO1 vo2 = new DataVO1();
		vo1.setColumn1("가가가");
		vo1.setColumn2("나나나");
		vo1.setColumn3("다다다");
		vo2.setColumn1("가가가");
		vo2.setColumn2("나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나나");
		vo2.setColumn3("다다다");
		sqlSessionTemplate.insert("springsample.insertSample", vo1);
		sqlSessionTemplate.insert("springsample.insertSample", vo2);
	}
}
