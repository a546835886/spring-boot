package test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class ApplicationTests {
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 普通邮件发送
     * @throws Exception
     */
    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("liuyang@shenzhourong.com");
        message.setTo("546835886@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("简单邮件内容from liuyang@shenzhourong to 546835886");
        mailSender.send(message);
    }

    /**
     * 通过MimeMessageHelper来发送一封带有附件的邮件
     * @throws Exception
     */

    @Test
    public void sendAttachmentsMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("liuyang@shenzhourong.com");
        helper.setTo("546835886@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");
        FileSystemResource file1 = new FileSystemResource(
                new File("E:\\图片\\1432631768683.jpg"));
        FileSystemResource file2 = new FileSystemResource(
                new File("E:\\图片\\4.3--4.7.txt"));
        helper.addAttachment("附件-1.png", file1);
        helper.addAttachment("附件-2.txt", file2);
        mailSender.send(mimeMessage);
    }

    /**
     * 嵌入静态资源
     * 我们在邮件内容中可能希望通过嵌入图片等静态资源，让邮件获得更好的阅读体验，而不是从附件中查看具体图片，
     * 下面的测试用例演示了如何通过MimeMessageHelper实现在邮件正文中嵌入静态资源
     */

    @Test
    public void sendInlineMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("liuyang@shenzhourong.com");
        helper.setTo("546835886@qq.com");
        helper.setSubject("主题：嵌入静态资源");

        StringBuffer sb = new StringBuffer();
        sb.append("<h1>大标题-h1</h1>").append("<p style='color:#F00'>红色字</p>").append("<p style='text-align:right'>右对齐</p>");
        helper.setText(sb.toString(), true);//注意:调用setText时需要在第二个参数传入true，这样才会使用HTML格式发送邮件
//        helper.setText("<html><body><img src=\"cid:feiq\"><p><img src=\"cid:guanlan\"></body></html>",true);
//        FileSystemResource file1 = new FileSystemResource(new File("E:\\图片\\1432631768683.jpg"));
//        FileSystemResource file2 = new FileSystemResource(new File("E:\\图片\\灌篮高手.jpg"));
//        helper.addInline("feiq", file1);
//        helper.addInline("guanlan", file2);
        mailSender.send(mimeMessage);
    }

    /**
     * 模板邮件
     *
     * spring-boot-starter-freemarker
     */

    @Autowired
    private Configuration configuration;

    @Test
    public void sendTemplateMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("liuyang@shenzhourong.com");
        helper.setTo("546835886@qq.com");
        helper.setSubject("主题：模板邮件");
        Map<String, Object> model = new HashMap();
        model.put("username", "liuyang");
        Template template = configuration.getTemplate("welcome.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);

        helper.setText(html,true);
        mailSender.send(mimeMessage);
    }
}
