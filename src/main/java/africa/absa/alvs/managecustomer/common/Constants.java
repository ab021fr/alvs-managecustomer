package africa.absa.alvs.managecustomer.common;

public final class Constants {
    public static final String CAMELHTTPPATH = "CamelHttpPath";
    public static final String SOAP_ACTION = "SOAPAction";
    public static final String DIRECT_DYNAMIC_ROUTE = "direct://%s";
    public static final String LOG_URI = "log:%s?level=INFO&showExchangeId=true&showHeaders=true&showBody=true";
    public static final String DIRECT_ROUTE = "direct:%s";
    public static final String JMS = "jms:queue:%s";
    public static final String JMS_IBM_FORMAT = "JMS_IBM_Format";

    public final static String SMS_INCOMING_QUEUE_KEY = "sms.listener";
    public final static String SMS_DESTINATION_QUEUE_KEY = "sms.destination";
    public final static String SMS_SERVICE_NAME = "sendSMS";

    public static final String MAIL_INCOMING_QUEUE_KEY = "mail.listener";
    public final static String MAIL_DESTINATION_QUEUE_KEY = "mail.destination";
    public final static String MAIL_SERVICE_NAME = "sendMail";

    public static final String FAX_INCOMING_QUEUE_KEY = "fax.listener";
    public final static String FAX_DESTINATION_QUEUE_KEY = "fax.destination";
    public final static String FAX_SERVICE_NAME = "sendFax";

    public final static String ERROR_QUEUE_KEY = "audit.listener";
}
