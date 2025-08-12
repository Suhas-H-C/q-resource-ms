package org.rest.resource.ms.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;

import static org.mockito.Mockito.*;

class NotificationServiceTest {

    private final Logger log = Logger.getLogger(NotificationServiceTest.class);
    private final Mailer mailer = mock(Mailer.class);
    private final Configuration marker = mock(Configuration.class);
    private final NotificationService service = new NotificationService(log, mailer, marker);
    private final ArgumentCaptor<Mail> mail = ArgumentCaptor.forClass(Mail.class);
    private final Template templateMock = mock(Template.class);

    @Test
    void should_send_notification() throws TemplateException, IOException {
        when(marker.getTemplate("greet.ftl")).thenReturn(templateMock);
        doNothing().when(mailer).send(mail.capture());
        service.sendNotification("admin");

        verify(marker).getTemplate("greet.ftl");
        verify(mailer).send(mail.getValue());
    }
}