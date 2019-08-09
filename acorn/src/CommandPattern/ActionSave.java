package CommandPattern;
// file에 저장
public class ActionSave implements ActionListernerCommand {
	private Document doc;
	public ActionSave(Document doc) {
		this.doc = doc;
	}

	// save을 대신하는 Document 만들어줌
	@Override
	public void execute() {
		doc.save();		
	}
}
