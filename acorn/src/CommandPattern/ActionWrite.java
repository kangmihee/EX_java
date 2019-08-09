package CommandPattern;

public class ActionWrite implements ActionListernerCommand{
	private Document doc;
	public ActionWrite(Document doc) {
		this.doc = doc;
	}
	@Override
	public void execute() {
		doc.save();
	}

}
