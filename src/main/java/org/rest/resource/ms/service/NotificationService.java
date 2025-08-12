package org.rest.resource.ms.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

@ApplicationScoped
public class NotificationService {

    @ConfigProperty(name = "admin.mail.to")
    private String toAddress;

    @ConfigProperty(name = "admin.subject")
    private String subject;

    private final Logger log;
    private final Mailer mailer;
    private final Configuration freeMarker;

    @Inject
    public NotificationService(Logger logger, Mailer mailer, Configuration freeMarker) {
        this.log = logger;
        this.mailer = mailer;
        this.freeMarker = freeMarker;
    }

    public void sendNotification(String name) throws IOException, TemplateException {
        Map<String, Object> params = Map.of("name", name);
        Template template = freeMarker.getTemplate("greet.ftl");
        StringWriter writer = new StringWriter();
        template.process(params, writer);
        mailer.send(Mail.withHtml(toAddress, subject, writer.toString()));
        log.info("Alert sent successfully");
        writer.close();
    }
}