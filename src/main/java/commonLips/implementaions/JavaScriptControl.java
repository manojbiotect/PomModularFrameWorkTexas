package commonLips.implementaions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLips.contracts.IJavaScriptExecutor;

public class JavaScriptControl implements IJavaScriptExecutor {

	private WebDriver driver;

	public JavaScriptControl(WebDriver driver) {
		this.driver = driver;
	}

	private JavascriptExecutor getJsEngine() {
		JavascriptExecutor jsEngine;

		jsEngine = (JavascriptExecutor) driver;

		return jsEngine;
	}

	public void executeJavaScript(String scriptToExecute) throws Exception {

		getJsEngine().executeScript(scriptToExecute);
	}

	public void scrollDown(int x, int y) throws Exception {

		String jsCommand = String.format("window.scrollBy(%d,%d)", x, y);
		getJsEngine().executeScript(jsCommand);

	}

	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {

		return getJsEngine().executeScript(scriptToExecute).toString();

	}

}
