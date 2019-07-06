package AdminServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

@WebServlet(name = "SendEmailServlet")
public class SendEmailServlet extends HttpServlet {
    public final String myEmailAccount = "1439095392@qq.com";
    public final String myEmailPassword = "iehmzglwmhamfibb";

    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
    // 网易126邮箱的 SMTP 服务器地址为: smtp.126.com
    public final String myEmailSMTPHost = "smtp.qq.com";
    public String receiveMailAccount;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String email=request.getParameter("email");
        System.out.println(email);
//        String email="2831164449@qq.com";
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(true);
        receiveMailAccount=email;
        // 3. 创建一封邮件
        try{
            MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount);
            // 4. 根据 Session 获取邮件传输对象
            Transport transport = session.getTransport();
            transport.connect(myEmailAccount, myEmailPassword);
            // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());
            // 7. 关闭连接
            transport.close();
            out.println("<script>alert('发送成功!');</script>");
            out.println("<script language='javascript'>window.location.href='ShenHe.jsp'</script>");
        }catch (Exception e){
            out.println("<script>alert('发送失败!');</script>");
            out.println("<script language='javascript'>window.location.href='ShenHe.jsp'</script>");
        }
    }
    public MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // Set Subject: 头字段
        message.setSubject(MimeUtility.encodeText("打折钜惠", MimeUtility.mimeCharset("gb2312"), null));
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 2. From: 发件人（昵称）
        String mailTitle="公司资产管理部";
        // 设置邮件发件人名称
        Address address = new InternetAddress(sendMail, MimeUtility.encodeText(mailTitle, MimeUtility.mimeCharset("gb2312"), null));
        // Set From: 头部头字段
        message.setFrom(address);
        // Set To: 头部头字段
        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail));// 设置邮件格式
        String str="XX用户你好, 今天全场5折, 快来抢购, 错过今天再等一年。。。";
        message.setContent(str, "text/html;charset=gbk");
        //  保存设置
        message.saveChanges();
        return message;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }
}
