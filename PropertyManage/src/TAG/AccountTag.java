package TAG;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AccountTag extends SimpleTagSupport{
	public void doTag() throws JspException, IOException{
	PageContext page = (PageContext) getJspContext();
	HttpSession session = page.getSession();//获得session
	String str = (String) session.getAttribute("account");
	JspWriter out = getJspContext().getOut();
	out.print(str);
	}
}
