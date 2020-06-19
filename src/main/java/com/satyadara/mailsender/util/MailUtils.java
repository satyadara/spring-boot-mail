package com.satyadara.mailsender.util;

import org.apache.commons.text.StringSubstitutor;

import java.util.Map;

public class MailUtils {
    public static String formatMessage(String content, Map<String, Object> mapVariable) {
        return StringSubstitutor.replace(content, mapVariable);
    }
}
