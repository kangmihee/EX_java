package FacedPattern;

public class Samsung implements MobileShop{
	
	@Override
	public void modelNo() {
		System.out.println("  삼성 갤럭시9  ");	
	}

	@Override
	public void price() {
		System.out.println("  135000  ");
	}
}
