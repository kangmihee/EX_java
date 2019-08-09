package CommandPattern;

// 인터페이스로 프로그램 작성
public class MenuOptions {
	private ActionListernerCommand openCommand; // 인터페이스
	private ActionListernerCommand saveCommand;
	
	public MenuOptions(ActionListernerCommand open, ActionListernerCommand save) {
		this.openCommand = open; // 행동으로 초기화
		this.saveCommand = save;	
	}
	public void ClickOpen() {
		openCommand.execute();
	}
	public void ClickSave() {
		saveCommand.execute();
	}

}
