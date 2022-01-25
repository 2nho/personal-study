package kr.co.goodee39.date1111;

public class SModuleAdapter implements CModule {
	
	SModule sModule;
	
	public SModuleAdapter(SModule sModule) {
		this.sModule = sModule;
	}
	
	@Override
	public void getList() {
		sModule.listUp();
	}

	@Override
	public void getItem() {
		sModule.detailItem();
	}

}
