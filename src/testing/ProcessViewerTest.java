package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gui.ProcessViewer;

class ProcessViewerTest {

	@Test
	public void constructorTest() {
		ProcessViewer no = new ProcessViewer();
		no.setUtensils("fork");
		no.setUtensils("eat fork");
	}

}
