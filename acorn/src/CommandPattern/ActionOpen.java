package CommandPattern;

public class ActionOpen implements ActionListernerCommand{
	private Document doc;
	public ActionOpen(Document doc) {
		this.doc = doc;
	}

	// open을 대신하는 Document 만들어줌
	@Override
	public void execute() {
		doc.open();
	}
}
